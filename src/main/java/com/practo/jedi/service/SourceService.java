package com.practo.jedi.service;

import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.SourceModel;

public interface SourceService {

  public Iterable<SourceModel> get();

  public SourceModel get(Integer id) throws EntityNotFoundException;

  public SourceModel create(SourceModel Source) throws EntityNotFoundException;

  public SourceModel update(SourceModel Source, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

}
