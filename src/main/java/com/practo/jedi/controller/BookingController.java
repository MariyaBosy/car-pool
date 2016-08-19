package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.data.entity.Booking;
import com.practo.jedi.repository.BookingRepository;

@RestController
@RequestMapping("/Bookings")
public class BookingController {

  @Autowired
  private BookingRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Booking> list() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Booking> create(@RequestBody Booking Booking) {
    Booking u = repository.save(Booking);
    ResponseEntity<Booking> response = new ResponseEntity<Booking>(u, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Booking get(@PathVariable("id") int id) {
    return repository.findOne(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Booking> update(@PathVariable("id") int id, @RequestBody Booking Booking) {
    Booking u = repository.save(Booking);
    ResponseEntity<Booking> response = new ResponseEntity<Booking>(u, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    repository.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
