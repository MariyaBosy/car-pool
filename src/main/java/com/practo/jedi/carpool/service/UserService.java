package com.practo.jedi.carpool.service;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.UserModel;

public interface UserService {

  public Iterable<UserModel> get();

  public UserModel get(Integer id) throws EntityNotFoundException;

  public UserModel create(UserModel user) throws EntityNotFoundException;

  public UserModel update(UserModel user, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

  public UserModel findByEmail(String email);

}
