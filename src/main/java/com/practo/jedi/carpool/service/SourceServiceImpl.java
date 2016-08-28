package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.entity.Source;
import com.practo.jedi.carpool.data.repository.SourceRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.SourceModel;

@Service
public class SourceServiceImpl implements SourceService {

  @Autowired
  private SourceRepository repository;


  @Override
  public Iterable<SourceModel> get() {
    Iterable<Source> entities = repository.findAll();
    ArrayList<SourceModel> models = new ArrayList<SourceModel>();
    for (Source entity : entities) {
      SourceModel model = new SourceModel();
      try {
        model.fromEntity(entity);
        models.add(model);

      } catch (EntityNotFoundException err) {
        err.printStackTrace();
      }
    }
    return models;
  }


  @Override
  public SourceModel get(Integer id) throws EntityNotFoundException {
    Source entity = repository.findOne(id);
    SourceModel model = new SourceModel();
    model.fromEntity(entity);
    return model;
  }



  @Override
  public SourceModel create(SourceModel source) throws EntityNotFoundException {
    Source entity = source.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    try {
      source.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
    }
    return source;
  }


  @Override
  public SourceModel update(SourceModel source, Integer id) throws EntityNotFoundException {
    source.setId(id);
    Source entity = source.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      source.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
    }
    return source;
  }

  public void delete(Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

}
