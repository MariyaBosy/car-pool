package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.data.entity.Source;
import com.practo.jedi.repository.SourceRepository;

@RestController
@RequestMapping("/Sources")
public class SourceController {

  @Autowired
  private SourceRepository repository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Source> list() {
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Source> create(@RequestBody Source Source) {
    Source u = repository.save(Source);
    ResponseEntity<Source> response = new ResponseEntity<Source>(u, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Source get(@PathVariable("id") int id) {
    return repository.findOne(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<Source> update(@PathVariable("id") int id, @RequestBody Source Source) {
    Source u = repository.save(Source);
    ResponseEntity<Source> response = new ResponseEntity<Source>(u, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    repository.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
