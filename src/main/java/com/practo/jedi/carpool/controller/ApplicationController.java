package com.practo.jedi.carpool.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practo.jedi.carpool.data.dto.ListingFilterDto;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.BookingModel;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.model.SourceModel;
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.service.BookingService;
import com.practo.jedi.carpool.service.ListingService;
import com.practo.jedi.carpool.service.SourceService;
import com.practo.jedi.carpool.service.UserService;

@Controller
public class ApplicationController {
  private int itemsPerPage = 10;

  private static final Logger LOG = Logger.getLogger(ApplicationController.class);

  @Autowired
  private UserService userService;

  @Autowired
  private ListingService listingService;

  @Autowired
  private SourceService sourceService;

  @Autowired
  private BookingService bookingService;

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), (size > 10) ? 10 : size, source.getSort());
  }

  /**
   * Home page of the web app.
   * 
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @return Index page.
   */
  @RequestMapping("/")
  public String index(HttpSession session) {
    if (session.getAttribute("user") != null) {
      return "redirect:search";
    }
    return "index";
  }

  @RequestMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

  /**
   * Register/Login a user.
   * 
   * @param name User's name
   * @param email User's email
   * @param token Google OAuth id_token
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @return Redirect to search page after login.
   */
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(String name, String email, String token, HttpSession session) {
    UserModel user = userService.findByEmail(email);
    if (user == null) {
      user = new UserModel();
      user.setEmail(email);
      user.setName(name);
      user.setPhone("");
      try {
        user = userService.create(user);
      } catch (EntityNotFoundException err) {
        LOG.error(err);
      }
    }
    session.setAttribute("user", user);
    return "redirect:search";
  }

  /**
   * Search for listings
   * 
   * @param filters Filters to apply for the search
   * @param pageable Pagination object
   * @param model Used to send attributes to the view
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param response Required to set 401 status code
   * @return Search page
   */
  @RequestMapping("/search")
  public String search(ListingFilterDto filters, Pageable pageable, Model model,
      HttpSession session, HttpServletRequest request, HttpServletResponse response) {
    if (session.getAttribute("user") == null) {
      response.setStatus(401);
      return "index";
    }
    pageable = updatePageable(pageable, itemsPerPage);
    model.addAttribute("user", session.getAttribute("user"));
    Iterable<ListingModel> listings = listingService.filter(filters, pageable);
    Integer listingCount = ((ArrayList<ListingModel>) listingService.filter(filters, null)).size();
    model.addAttribute("listings", listings);
    model.addAttribute("listingCount", listingCount);
    model.addAttribute("pageable", pageable);
    model.addAttribute("filters", filters);
    Iterable<SourceModel> sources = sourceService.get();
    model.addAttribute("sources", sources);
    UserModel user = (UserModel) session.getAttribute("user");
    Iterable<BookingModel> bookings = bookingService.get(user.getId());
    HashMap<Integer, Boolean> isBooked = new HashMap<Integer, Boolean>();
    for (ListingModel listing : listings) {
      Boolean value = false;
      for (BookingModel booking : bookings) {
        if (booking.getListing().getId() == listing.getId()) {
          value = true;
        }
      }
      isBooked.put(listing.getId(), value);
    }
    model.addAttribute("isBooked", isBooked);
    String url = request.getRequestURL().toString() + "?"
        + (request.getQueryString() == null ? "" : request.getQueryString());
    String next =
        (request.getParameter("page") == null) ? url + "page=" + (pageable.getPageNumber() + 1)
            : url.replaceFirst("page=" + pageable.getPageNumber(),
                "page=" + (pageable.getPageNumber() + 1));
    model.addAttribute("next", next);
    String previous =
        (request.getParameter("page") == null) ? url + "page=" + (pageable.getPageNumber() - 1)
            : url.replaceFirst("page=" + pageable.getPageNumber(),
                "page=" + (pageable.getPageNumber() - 1));
    model.addAttribute("previous", previous);
    return "search";
  }

  /**
   * Form to post a new listing
   * 
   * @param model Used to send attributes to the view
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param response Required to set 401 status code
   * @return Posting page
   */
  @RequestMapping("/post")
  public String post(Model model, HttpSession session, HttpServletResponse response) {
    if (session.getAttribute("user") == null) {
      response.setStatus(401);
      return "index";
    }
    Iterable<SourceModel> sources = sourceService.get();
    model.addAttribute("sources", sources);
    return "post";
  }
}
