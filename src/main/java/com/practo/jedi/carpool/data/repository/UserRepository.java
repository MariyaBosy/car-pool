package com.practo.jedi.carpool.data.repository;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.practo.jedi.carpool.data.entity.User;

@Repository
public class UserRepository extends EntityRepositoryImpl<User, Integer> {

  @Override
  public Class<User> getEntityClass() {
    return User.class;
  }

  public User findByEmail(String email) {
    ArrayList<User> users =  (ArrayList<User>) template
        .findByCriteria(DetachedCriteria.forClass(User.class).add(Restrictions.eq("email", email)));
    try {
      return users.get(0);
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }

}
