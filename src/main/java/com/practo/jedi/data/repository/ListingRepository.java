package com.practo.jedi.data.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.practo.jedi.data.entity.Listing;

public interface ListingRepository
    extends PagingAndSortingRepository<Listing, Integer>, QueryDslPredicateExecutor<Listing> {
}
