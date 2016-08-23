package com.practo.jedi.data.repository;

import org.springframework.stereotype.Repository;

import com.practo.jedi.data.entity.User;

@Repository
public class UserRepository extends EntityRepositoryImpl<User, Integer> {

  @Override
  public Class<User> getEntityClass() {
    return User.class;
  }

}
