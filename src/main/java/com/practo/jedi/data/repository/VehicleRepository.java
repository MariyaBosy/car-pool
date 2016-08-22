package com.practo.jedi.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practo.jedi.data.entity.Vehicle;;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {
  public Iterable<Vehicle> findByUserId(Integer user_id);
  public Vehicle findByUserIdAndId(Integer user_id, Integer id);
}
