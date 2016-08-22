package com.practo.jedi.service;

import org.springframework.data.domain.Pageable;

import com.practo.jedi.data.dto.ListingFilterDTO;
import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.ListingModel;

public interface ListingService {

  public Iterable<ListingModel> get(Pageable pageable);

  public ListingModel get(Integer id) throws EntityNotFoundException;

  public ListingModel create(ListingModel Listing);

  public ListingModel update(ListingModel Listing, Integer id);

  public void delete(Integer id);
  
  public Iterable<ListingModel> filter(ListingFilterDTO filters);

}
