package com.practo.jedi.carpool.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.service.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {

  @Autowired
  private AddressService service;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<AddressModel> list(HttpSession session, HttpServletResponse servletResponse) {
    if (session.getAttribute("user") == null) {
      servletResponse.setStatus(401);
      return null;
    }
    return service.get();
  }

  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<AddressModel> create(@RequestBody AddressModel address, HttpSession session, HttpServletResponse servletResponse) throws EntityNotFoundException {
    if (session.getAttribute("user") == null) {
      servletResponse.setStatus(401);
      return null;
    }
    AddressModel m = service.create(address);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(m, HttpStatus.CREATED);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public AddressModel get(@PathVariable("id") int id, HttpSession session, HttpServletResponse servletResponse) throws EntityNotFoundException {
    if (session.getAttribute("user") == null) {
      servletResponse.setStatus(401);
      return null;
    }
    return service.get(id);
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<AddressModel> update(@PathVariable("id") int id,
      @RequestBody AddressModel address, HttpSession session, HttpServletResponse servletResponse) throws EntityNotFoundException {
    if (session.getAttribute("user") == null) {
      servletResponse.setStatus(401);
      return null;
    }
    AddressModel m = service.update(address, id);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(m, HttpStatus.OK);
    return response;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpSession session, HttpServletResponse servletResponse) throws EntityNotFoundException {
    if (session.getAttribute("user") == null) {
      servletResponse.setStatus(401);
      return null;
    }
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
