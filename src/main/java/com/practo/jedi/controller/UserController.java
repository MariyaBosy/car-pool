package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.exceptions.UserNotFoundException;
import com.practo.jedi.model.UserModel;
import com.practo.jedi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<UserModel> list() throws UserNotFoundException {
    return service.get();
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<UserModel> create(@RequestBody UserModel user) {
    UserModel m = service.create(user);
    ResponseEntity<UserModel> response = new ResponseEntity<UserModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public UserModel get(@PathVariable("id") int id) throws UserNotFoundException {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<UserModel> update(@PathVariable("id") int id, @RequestBody UserModel user) {
    UserModel m = service.update(user, id);
    ResponseEntity<UserModel> response = new ResponseEntity<UserModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
