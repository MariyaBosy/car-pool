package com.practo.jedi.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.carpool.data.dto.ListingFilterDTO;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.service.ListingService;

@RestController
@RequestMapping("/listings")
public class ListingController {

  private int itemsPerPage = 10;

  @Autowired
  private ListingService service;

  public static Pageable updatePageable(final Pageable source, final int size) {
    return new PageRequest(source.getPageNumber(), size, source.getSort());
  }

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<ListingModel> list(Pageable pageable) {
    return service.get(updatePageable(pageable, itemsPerPage));
  }

  @RequestMapping(value = "/search", method = RequestMethod.GET)
  public Iterable<ListingModel> search(ListingFilterDTO filters, Pageable pageable) {
    return service.filter(filters, updatePageable(pageable, itemsPerPage));
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<ListingModel> create(@RequestBody ListingModel listing)
      throws EntityNotFoundException {
    System.out.println(listing);
    ListingModel m = service.create(listing);
    ResponseEntity<ListingModel> response = new ResponseEntity<ListingModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public ListingModel get(@PathVariable("id") int id) throws EntityNotFoundException {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<ListingModel> update(@PathVariable("id") int id,
      @RequestBody ListingModel listing) throws EntityNotFoundException {
    ListingModel m = service.update(listing, id);
    ResponseEntity<ListingModel> response = new ResponseEntity<ListingModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) throws EntityNotFoundException {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
