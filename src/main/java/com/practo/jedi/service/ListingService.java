package com.practo.jedi.service;

import com.practo.jedi.data.dto.ListingFilterDTO;
import com.practo.jedi.model.ListingModel;

public interface ListingService {

  public Iterable<ListingModel> get();

  public ListingModel get(Integer id);

  public ListingModel create(ListingModel Listing);

  public ListingModel update(ListingModel Listing, Integer id);

  public void delete(Integer id);
  
  public Iterable<ListingModel> filter(ListingFilterDTO filters);

}
