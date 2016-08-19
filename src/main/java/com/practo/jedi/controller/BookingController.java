package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.model.BookingModel;
import com.practo.jedi.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

  @Autowired
  private BookingService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<BookingModel> list() {
    return service.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<BookingModel> create(@RequestBody BookingModel booking) {
    BookingModel m = service.create(booking);
    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public BookingModel get(@PathVariable("id") int id) {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<BookingModel> update(@PathVariable("id") int id,
      @RequestBody BookingModel booking) {
    BookingModel m = service.update(booking, id);
    ResponseEntity<BookingModel> response = new ResponseEntity<BookingModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
