package com.practo.jedi.carpool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.VehicleModel;
import com.practo.jedi.carpool.service.VehicleService;

@RestController
@RequestMapping("users/{user_id}/vehicles")
public class VehicleController {

  @Autowired
  private VehicleService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<VehicleModel> list(@PathVariable("user_id") int user_id) {
    return service.get(user_id);
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<VehicleModel> create(@PathVariable("user_id") int user_id, @RequestBody VehicleModel vehicle) throws EntityNotFoundException {
    VehicleModel m = service.create(user_id, vehicle);
    ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public VehicleModel get(@PathVariable("user_id") int user_id, @PathVariable("id") int id) throws EntityNotFoundException {
    return service.get(user_id, id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<VehicleModel> update(@PathVariable("user_id") int user_id, @PathVariable("id") int id,
      @RequestBody VehicleModel vehicle) throws EntityNotFoundException {
    VehicleModel m = service.update(user_id, vehicle, id);
    ResponseEntity<VehicleModel> response = new ResponseEntity<VehicleModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("user_id") int user_id, @PathVariable("id") int id) throws EntityNotFoundException {
    service.delete(user_id, id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
