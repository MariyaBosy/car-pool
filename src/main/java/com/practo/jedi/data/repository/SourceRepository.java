package com.practo.jedi.data.repository;

import org.springframework.stereotype.Repository;

import com.practo.jedi.data.entity.Source;

@Repository
public class SourceRepository extends EntityRepositoryImpl<Source, Integer> {

  @Override
  public Class<Source> getEntityClass() {
    return Source.class;
  }

}
