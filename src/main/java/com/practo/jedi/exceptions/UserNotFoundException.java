package com.practo.jedi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No user found with given Id")
public class UserNotFoundException extends Exception {

  private static final long serialVersionUID = -570050669946005424L;

}
