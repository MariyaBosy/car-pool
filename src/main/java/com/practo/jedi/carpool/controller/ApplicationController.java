package com.practo.jedi.carpool.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practo.jedi.carpool.data.dto.ListingFilterDTO;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.model.SourceModel;
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.service.ListingService;
import com.practo.jedi.carpool.service.SourceService;
import com.practo.jedi.carpool.service.UserService;

@Controller
public class ApplicationController {
  private int itemsPerPage = 10;

  @Autowired
  private UserService userService;

  @Autowired
  private ListingService listingService;

  @Autowired
  private SourceService sourceService;

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }

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

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(String name, String email, String token, HttpSession session) {
    System.out.println(name);
    System.out.println(email);
    System.out.println(token);
    UserModel user = userService.findByEmail(email);
    if (user == null) {
      user = new UserModel();
      user.setEmail(email);
      user.setName(name);
      user.setPhone("");
      try {
        System.out.println(user);
        user = userService.create(user);
      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }
    }
    session.setAttribute("user", user);
    return "redirect:search";
  }

  @RequestMapping("/search")
  public String search(ListingFilterDTO filters, Pageable pageable, Model model,
      HttpSession session, HttpServletResponse response) {
    if (session.getAttribute("user") == null) {
      response.setStatus(401);
      return "index";
    }
    Iterable<ListingModel> listings =
        listingService.filter(filters, updatePageable(pageable, itemsPerPage));
    model.addAttribute("listings", listings);
    Iterable<SourceModel> sources = sourceService.get();
    model.addAttribute("sources", sources);
    return "search";
  }

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
