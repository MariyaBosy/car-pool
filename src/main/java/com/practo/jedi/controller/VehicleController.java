package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.data.entity.Vehicle;
import com.practo.jedi.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

  @Autowired
  private VehicleRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Vehicle> list() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Vehicle> create(@RequestBody Vehicle Vehicle) {
    Vehicle u = repository.save(Vehicle);
    ResponseEntity<Vehicle> response = new ResponseEntity<Vehicle>(u, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Vehicle get(@PathVariable("id") int id) {
    return repository.findOne(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Vehicle> update(@PathVariable("id") int id, @RequestBody Vehicle Vehicle) {
    Vehicle u = repository.save(Vehicle);
    ResponseEntity<Vehicle> response = new ResponseEntity<Vehicle>(u, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    repository.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
