package com.practo.jedi.service;

import com.practo.jedi.model.UserModel;

public interface UserService {

  public Iterable<UserModel> get();

  public UserModel get(Integer id);

  public UserModel create(UserModel user);

  public UserModel update(UserModel user, Integer id);

  public void delete(Integer id);

}
