package com.practo.jedi.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practo.jedi.data.entity.Vehicle;;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
