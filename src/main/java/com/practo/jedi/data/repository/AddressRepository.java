package com.practo.jedi.data.repository;

import org.springframework.stereotype.Repository;

import com.practo.jedi.data.entity.Address;

@Repository
public class AddressRepository extends EntityRepositoryImpl<Address, Integer> {

  @Override
  public Class<Address> getEntityClass() {
    return Address.class;
  }

}
