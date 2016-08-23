package com.practo.jedi.data.repository;

import com.practo.jedi.exceptions.EntityNotFoundException;

public interface EntityRepository<E, I> {
  public Iterable<E> findAll();

  public E findOne(I id) throws EntityNotFoundException;

  public E save(E entity) throws EntityNotFoundException;

  public Class<E> getEntityClass();

  public void delete(I id) throws EntityNotFoundException;
}
