package com.practo.jedi.data.repository;

import java.io.Serializable;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.practo.jedi.exceptions.EntityNotFoundException;

public abstract class EntityRepositoryImpl<E, I extends Serializable>
    implements EntityRepository<E, I> {

  @Autowired
  protected HibernateTemplate template;


  public Iterable<E> findAll() {
    return template.loadAll(getEntityClass());
  }

  public E findOne(I id) throws EntityNotFoundException {
    try {
      return (E) template
          .findByCriteria(
              DetachedCriteria.forClass(getEntityClass()).add(Restrictions.eq("id", id)), 0, 1)
          .get(0);
    } catch (IndexOutOfBoundsException e) {
      throw new EntityNotFoundException(
          "No " + getEntityClass().getSimpleName() + " found with given Id");
    }
  }

  @Transactional
  public E save(E entity) throws EntityNotFoundException {
    try {
      template.saveOrUpdate(entity);
      return entity;
    } catch (HibernateOptimisticLockingFailureException e) {
      throw new EntityNotFoundException(
          "No " + getEntityClass().getSimpleName() + " found with given Id");
    }
  }

  @Transactional
  public void delete(I id) throws EntityNotFoundException {
    template.delete(findOne(id));
  }

}
