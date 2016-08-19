package com.practo.jedi.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.jedi.data.entity.Listing;

public interface ListingRepository extends CrudRepository<Listing, Integer> {

}
