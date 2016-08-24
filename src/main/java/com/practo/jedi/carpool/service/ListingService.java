package com.practo.jedi.carpool.service;

import org.springframework.data.domain.Pageable;

import com.practo.jedi.carpool.data.dto.ListingFilterDTO;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.ListingModel;

public interface ListingService {

  public Iterable<ListingModel> get(Pageable pageable);

  public ListingModel get(Integer id) throws EntityNotFoundException;

  public ListingModel create(ListingModel Listing) throws EntityNotFoundException;

  public ListingModel update(ListingModel Listing, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

  public Iterable<ListingModel> filter(ListingFilterDTO filters, Pageable pageable);

}
