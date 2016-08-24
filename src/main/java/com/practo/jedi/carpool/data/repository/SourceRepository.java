package com.practo.jedi.carpool.data.repository;

import org.springframework.stereotype.Repository;

import com.practo.jedi.carpool.data.entity.Source;

@Repository
public class SourceRepository extends EntityRepositoryImpl<Source, Integer> {

  @Override
  public Class<Source> getEntityClass() {
    return Source.class;
  }

}
