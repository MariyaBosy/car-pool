package com.practo.jedi.carpool.controller;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.BookingModel;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.service.BookingService;
import com.practo.jedi.carpool.service.ListingService;
import com.practo.jedi.carpool.util.MailService;

/**
 * Controller for the bookings resource.
 * 
 * @author prashant
 *
 */
@RestController
@RequestMapping("/users/{user_id}/bookings")
public class BookingController {

  @Autowired
  private MailService mailSender;

  @Autowired
  private BookingService service;

  @Autowired
  private ListingService listingService;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<BookingModel> list(@PathVariable("user_id") int user_id, HttpSession session,
      HttpServletResponse servletResponse) throws IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    return service.get(user_id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<BookingModel> create(@PathVariable("user_id") int user_id,
      @RequestBody BookingModel booking, HttpSession session, HttpServletResponse servletResponse)
      throws EntityNotFoundException, MessagingException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    BookingModel m = service.create(user_id, booking);
    UserModel user = (UserModel) session.getAttribute("user");
    ListingModel listing = listingService.get(m.getListing().getId());
    UserModel owner = listing.getUser();
    mailSender.send(owner.getEmail(), user.getName() + " will pool with you",
        user.getName() + " will pool with you from " + listing.getSource().getName() + " to "
            + listing.getAddress() + " at " + listing.getDepartureTime()
            + ".<br>You may contact them at " + user.getEmail() + ".");
    mailSender.send(user.getEmail(), "You will pool with " + owner.getName(),
        "You will pool with " + owner.getName() + " from " + listing.getSource().getName() + " to "
            + listing.getAddress() + " at " + listing.getDepartureTime()
            + ".<br>You may contact them at " + owner.getEmail() + ".");

    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public BookingModel get(@PathVariable("user_id") int user_id, @PathVariable("id") int id,
      HttpSession session, HttpServletResponse servletResponse)
      throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    return service.get(user_id, id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<BookingModel> update(@PathVariable("user_id") int user_id,
      @PathVariable("id") int id, @RequestBody BookingModel booking, HttpSession session,
      HttpServletResponse servletResponse) throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    BookingModel m = service.update(user_id, booking, id);
    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("user_id") int user_id,
      @PathVariable("id") int id, HttpSession session, HttpServletResponse servletResponse)
      throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    service.delete(user_id, id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
