package com.practo.jedi.carpool.data.repository;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

public abstract class EntityRepositoryImpl<E, I extends Serializable>
    implements EntityRepository<E, I> {

  @Autowired
  protected HibernateTemplate template;


  @Override
  public Iterable<E> findAll() {
    return template.loadAll(getEntityClass());
  }

  @Override
  public E findOne(I id) throws EntityNotFoundException {
    try {
      return (E) template
          .findByCriteria(
              DetachedCriteria.forClass(getEntityClass()).add(Restrictions.eq("id", id)), 0, 1)
          .get(0);
    } catch (IndexOutOfBoundsException err) {
      throw new EntityNotFoundException(
          "No " + getEntityClass().getSimpleName() + " found with given Id");
    }
  }

  @Override
  @Transactional
  public E save(E entity) throws EntityNotFoundException {
    try {
      template.saveOrUpdate(entity);
      return entity;
    } catch (DataAccessException err) {
      throw new EntityNotFoundException(
          "No " + getEntityClass().getSimpleName() + " found with given Id");
    }
  }

  @Override
  @Transactional
  public void delete(I id) throws EntityNotFoundException {
    template.delete(findOne(id));
  }

}
