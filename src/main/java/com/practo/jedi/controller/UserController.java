package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.entity.User;
import com.practo.jedi.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<User> index() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<User> create(@RequestBody User user) {
    User u = repository.save(user);
    ResponseEntity<User> response = new ResponseEntity<User>(u, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public User show(@PathVariable("id") int id) {
    return repository.findOne(id);
  }

  @RequestMapping(method = RequestMethod.PUT)
  public ResponseEntity<User> update(@RequestBody User user) {
    User u = repository.save(user);
    ResponseEntity<User> response = new ResponseEntity<User>(u, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    repository.delete(id);;
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}