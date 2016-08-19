package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.model.VehicleModel;
import com.practo.jedi.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

  @Autowired
  private VehicleService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<VehicleModel> list() {
    return service.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<VehicleModel> create(@RequestBody VehicleModel vehicle) {
    VehicleModel m = service.create(vehicle);
    ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public VehicleModel get(@PathVariable("id") int id) {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<VehicleModel> update(@PathVariable("id") int id,
      @RequestBody VehicleModel vehicle) {
    VehicleModel m = service.update(vehicle, id);
    ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
