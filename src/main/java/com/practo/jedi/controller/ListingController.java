package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.data.entity.Listing;
import com.practo.jedi.repository.ListingRepository;

@RestController
@RequestMapping("/Listings")
public class ListingController {

  @Autowired
  private ListingRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Listing> list() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Listing> create(@RequestBody Listing Listing) {
    Listing u = repository.save(Listing);
    ResponseEntity<Listing> response = new ResponseEntity<Listing>(u, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Listing get(@PathVariable("id") int id) {
    return repository.findOne(id);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<Listing> update(@PathVariable("id") int id, @RequestBody Listing Listing) {
    Listing u = repository.save(Listing);
    ResponseEntity<Listing> response = new ResponseEntity<Listing>(u, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    repository.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
