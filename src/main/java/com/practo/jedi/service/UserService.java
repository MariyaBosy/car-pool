package com.practo.jedi.service;

import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.UserModel;

public interface UserService {

  public Iterable<UserModel> get();

  public UserModel get(Integer id) throws EntityNotFoundException;

  public UserModel create(UserModel user) throws EntityNotFoundException;

  public UserModel update(UserModel user, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

}
