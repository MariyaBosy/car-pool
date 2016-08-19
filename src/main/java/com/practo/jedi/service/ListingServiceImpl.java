package com.practo.jedi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.entity.Listing;
import com.practo.jedi.data.repository.ListingRepository;
import com.practo.jedi.model.ListingModel;

@Service
public class ListingServiceImpl implements ListingService {

  @Autowired
  private ListingRepository repository;

  public ListingRepository getRepository() {
    return repository;
  }

  public Iterable<ListingModel> get() {
    Iterable<Listing> entities = repository.findAll();
    ArrayList<ListingModel> models = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      ListingModel model = new ListingModel();
      model.fromEntity(entity);
      models.add(model);
    }
    return models;
  }

  public ListingModel get(Integer id) {
    Listing entity = repository.findOne(id);
    ListingModel model = new ListingModel();
    model.fromEntity(entity);
    return model;
  }

  public ListingModel create(ListingModel listing) {
    Listing entity = listing.toEntity();
    entity = repository.save(entity);
    listing.fromEntity(entity);
    return listing;
  }

  public ListingModel update(ListingModel listing, Integer id) {
    listing.setId(id);
    Listing entity = listing.toEntity();
    entity = repository.save(entity);
    listing.fromEntity(entity);
    return listing;
  }

  public void delete(Integer id) {
    Listing entity = repository.findOne(id);
    entity.setIsDeleted(true);
    entity = repository.save(entity);
  }

}
