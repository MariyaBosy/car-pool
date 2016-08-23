package com.practo.jedi.data.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.practo.jedi.data.entity.User;


@Repository
public class SimpleUserDao {

  @Autowired
  private HibernateTemplate template;


  @Transactional
  public User getUser(int id) {
    return template.load(User.class, id);
  }

  @Transactional
  public Iterable<User> list() {
    // DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
    // Criteria criteria2 =
    // criteria.getExecutableCriteria(template.getSessionFactory().getCurrentSession());
    // criteria2.setMaxResults(10);
    // criteria2.setFirstResult(0);
    // return (List<UserEntity>) template.findByCriteria(criteria);
    return null;
  }

}
