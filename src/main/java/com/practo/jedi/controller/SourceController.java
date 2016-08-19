package com.practo.jedi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.model.SourceModel;
import com.practo.jedi.service.SourceService;

@RestController
@RequestMapping("/sources")
public class SourceController {

  @Autowired
  private SourceService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<SourceModel> list() {
    return service.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<SourceModel> create(@RequestBody SourceModel source) {
    SourceModel m = service.create(source);
    ResponseEntity<SourceModel> response = new ResponseEntity<SourceModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public SourceModel get(@PathVariable("id") int id) {
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<SourceModel> update(@PathVariable("id") int id,
      @RequestBody SourceModel source) {
    SourceModel m = service.update(source, id);
    ResponseEntity<SourceModel> response = new ResponseEntity<SourceModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
