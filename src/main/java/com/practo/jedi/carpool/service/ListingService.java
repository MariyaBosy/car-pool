package com.practo.jedi.carpool.service;

import org.springframework.data.domain.Pageable;

import com.practo.jedi.carpool.data.dto.ListingFilterDto;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.ListingModel;

public interface ListingService {

  public Iterable<ListingModel> get(Pageable pageable);

  public ListingModel get(Integer id) throws EntityNotFoundException;

  public ListingModel create(ListingModel listing) throws EntityNotFoundException;

  public ListingModel update(ListingModel listing, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

  public Iterable<ListingModel> filter(ListingFilterDto filters, Pageable pageable);
  
}
