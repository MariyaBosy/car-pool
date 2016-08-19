package com.practo.jedi.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.jedi.data.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Integer> {

}
