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
import com.practo.jedi.model.AddressModel;
import com.practo.jedi.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

  @Autowired
  private AddressService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<AddressModel> list() {
    return service.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<AddressModel> create(@RequestBody AddressModel address) {
    AddressModel m = service.create(address);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public AddressModel get(@PathVariable("id") int id) throws EntityNotFoundException {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<AddressModel> update(@PathVariable("id") int id,
      @RequestBody AddressModel address) {
    AddressModel m = service.update(address, id);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
