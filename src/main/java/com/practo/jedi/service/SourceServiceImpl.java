package com.practo.jedi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.entity.Source;
import com.practo.jedi.data.repository.SourceRepository;
import com.practo.jedi.model.SourceModel;

@Service
public class SourceServiceImpl implements SourceService {

  @Autowired
  private SourceRepository repository;

  public SourceRepository getRepository() {
    return repository;
  }

  public Iterable<SourceModel> get() {
    Iterable<Source> entities = repository.findAll();
    ArrayList<SourceModel> models = new ArrayList<SourceModel>();
    for (Source entity : entities) {
      SourceModel model = new SourceModel();
      model.fromEntity(entity);
      models.add(model);
    }
    return models;
  }

  public SourceModel get(Integer id) {
    Source entity = repository.findOne(id);
    SourceModel model = new SourceModel();
    model.fromEntity(entity);
    return model;
  }

  public SourceModel create(SourceModel source) {
    Source entity = source.toEntity();
    entity = repository.save(entity);
    source.fromEntity(entity);
    return source;
  }

  public SourceModel update(SourceModel source, Integer id) {
    source.setId(id);
    Source entity = source.toEntity();
    entity = repository.save(entity);
    source.fromEntity(entity);
    return source;
  }

  public void delete(Integer id) {
    Source entity = repository.findOne(id);
    entity.setIsDeleted(true);
    entity = repository.save(entity);
  }

}
