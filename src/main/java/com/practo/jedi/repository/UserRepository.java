package com.practo.jedi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practo.jedi.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
