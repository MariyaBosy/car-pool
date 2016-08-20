package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.data.dto.ListingFilterDTO;
import com.practo.jedi.model.ListingModel;
import com.practo.jedi.service.ListingService;

@RestController
@RequestMapping("/listings")
public class ListingController {

  @Autowired
  private ListingService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<ListingModel> list() {
    return service.get();
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public Iterable<ListingModel> search(ListingFilterDTO filters) {
    System.out.println(filters);
    return service.filter(filters);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<ListingModel> create(@RequestBody ListingModel listing) {
    ListingModel m = service.create(listing);
    ResponseEntity<ListingModel> response = new ResponseEntity<ListingModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ListingModel get(@PathVariable("id") int id) {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<ListingModel> update(@PathVariable("id") int id,
      @RequestBody ListingModel listing) {
    ListingModel m = service.update(listing, id);
    ResponseEntity<ListingModel> response = new ResponseEntity<ListingModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
