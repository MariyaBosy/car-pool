package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.data.entity.Address;
import com.practo.jedi.repository.AddressRepository;

@RestController
@RequestMapping("/Addresss")
public class AddressController {

  @Autowired
  private AddressRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Address> list() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Address> create(@RequestBody Address Address) {
    Address u = repository.save(Address);
    ResponseEntity<Address> response = new ResponseEntity<Address>(u, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Address get(@PathVariable("id") int id) {
    return repository.findOne(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Address> update(@PathVariable("id") int id, @RequestBody Address Address) {
    Address u = repository.save(Address);
    ResponseEntity<Address> response = new ResponseEntity<Address>(u, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    repository.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
