package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.BookingModel;
import com.practo.jedi.service.BookingService;

@RestController
@RequestMapping("/listings/{listing_id}/bookings")
public class BookingController {

  @Autowired
  private BookingService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<BookingModel> list(@PathVariable("listing_id") int listing_id) {
    return service.get(listing_id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<BookingModel> create(@PathVariable("listing_id") int listing_id,
      @RequestBody BookingModel booking) throws EntityNotFoundException {
    BookingModel m = service.create(listing_id, booking);
    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public BookingModel get(@PathVariable("listing_id") int listing_id, @PathVariable("id") int id) throws EntityNotFoundException {
    return service.get(listing_id, id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<BookingModel> update(@PathVariable("listing_id") int listing_id,
      @PathVariable("id") int id, @RequestBody BookingModel booking) throws EntityNotFoundException {
    BookingModel m = service.update(listing_id, booking, id);
    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("listing_id") int listing_id,
      @PathVariable("id") int id) throws EntityNotFoundException {
    service.delete(listing_id, id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
