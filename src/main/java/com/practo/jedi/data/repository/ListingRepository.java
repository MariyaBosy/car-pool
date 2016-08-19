package com.practo.jedi.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.jedi.data.entity.Listing;

public interface ListingRepository extends CrudRepository<Listing, Integer> {

}
