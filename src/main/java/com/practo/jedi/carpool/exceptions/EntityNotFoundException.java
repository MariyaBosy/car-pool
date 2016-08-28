package com.practo.jedi.carpool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown whenever an entity that does not exist is accessed.
 * 
 * @author prashant
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

  private static final long serialVersionUID = -570050669946005424L;

  public EntityNotFoundException(String message) {
    super(message);
  }
}
