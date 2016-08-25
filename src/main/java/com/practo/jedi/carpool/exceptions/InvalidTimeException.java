package com.practo.jedi.carpool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidTimeException extends Exception {

  private static final long serialVersionUID = -570050669946005424L;

  public InvalidTimeException(String message) {
    super(message);
  }
}
