package com.practo.jedi.carpool.controller;

import java.io.IOException;

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


/**
 * Controller for the addresses resource.
 * @author prashant
 *
 */
@RestController
@RequestMapping("/addresses")
public class AddressController {

  @Autowired
  private AddressService service;

  /**
   * Get all addresses.
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param servletResponse Response object. Required to send error response.
   * @return List of AddressModel {@link AddressModel} of all the addresses.
   * @throws IOException (optional)
   */
  @RequestMapping(method = RequestMethod.GET)
  public Iterable<AddressModel> list(HttpSession session, HttpServletResponse servletResponse)
      throws IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    return service.get();
  }

  /** Create a new address.
   * @param address Address to be created
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param servletResponse Response object. Required to send error response.
   * @return The address created with 201 status code.
   * @throws EntityNotFoundException If the creation fails.
   * @throws IOException (optional)
   */
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<AddressModel> create(@RequestBody AddressModel address, HttpSession session,
      HttpServletResponse servletResponse) throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    AddressModel m = service.create(address);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(m, HttpStatus.CREATED);
    return response;
  }

  /** Get an address by its id.
   * @param id Id of the address
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param servletResponse Response object. Required to send error response.
   * @return The address.
   * @throws EntityNotFoundException If the address does not exist.
   * @throws IOException (optional)
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public AddressModel get(@PathVariable("id") int id, HttpSession session,
      HttpServletResponse servletResponse) throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    return service.get(id);
  }

  /** Update an address
   * @param id Id of the address
   * @param address Address to be updated
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param servletResponse Response object. Required to send error response.
   * @return The updated address.
   * @throws EntityNotFoundException If the creation fails.
   * @throws IOException (optional)
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public ResponseEntity<AddressModel> update(@PathVariable("id") int id,
      @RequestBody AddressModel address, HttpSession session, HttpServletResponse servletResponse)
      throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    AddressModel m = service.update(address, id);
    ResponseEntity<AddressModel> response = new ResponseEntity<AddressModel>(m, HttpStatus.OK);
    return response;
  }


  /** Delete an address
   * @param id Id of the address
   * @param session HttpSession for the request. Required to check that the user is authenticated.
   * @param servletResponse Response object. Required to send error response.
   * @return Empty response with 204 status code.
   * @throws EntityNotFoundException If the creation fails.
   * @throws IOException (optional)
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<Boolean> delete(@PathVariable("id") int id, HttpSession session,
      HttpServletResponse servletResponse) throws EntityNotFoundException, IOException {
    if (session.getAttribute("user") == null) {
      servletResponse.sendError(HttpStatus.UNAUTHORIZED.value(),
          "You must login to access this page.");
      return null;
    }
    service.delete(id);
    ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
    return response;
  }

}
