package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.entity.User;
import com.practo.jedi.data.repository.UserRepository;
import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.UserModel;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository repository;

  public UserRepository getRepository() {
    return repository;
  }

  public Iterable<UserModel> get() {
    Iterable<User> entities = repository.findAll();
    ArrayList<UserModel> models = new ArrayList<UserModel>();
    for (User entity : entities) {
      UserModel model = new UserModel();
      try {
        model.fromEntity(entity);
        models.add(model);

      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }
    }
    return models;
  }

  public UserModel get(Integer id) throws EntityNotFoundException {
    User entity = repository.findOne(id);
    UserModel model = new UserModel();
    model.fromEntity(entity);
    return model;
  }

  public UserModel create(UserModel user) throws EntityNotFoundException {
    User entity = user.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    try {
      user.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return user;
  }

  public UserModel update(UserModel user, Integer id) throws EntityNotFoundException {
    user.setId(id);
    User entity = user.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      user.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return user;
  }

  public void delete(Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

}
