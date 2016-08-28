package com.practo.jedi.carpool.service;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.SourceModel;

public interface SourceService {

  public Iterable<SourceModel> get();

  public SourceModel get(Integer id) throws EntityNotFoundException;

  public SourceModel create(SourceModel source) throws EntityNotFoundException;

  public SourceModel update(SourceModel source, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

}
