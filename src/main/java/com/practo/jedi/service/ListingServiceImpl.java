package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.dto.ListingFilterDTO;
import com.practo.jedi.data.entity.Listing;
import com.practo.jedi.data.repository.ListingRepository;
import com.practo.jedi.model.AddressModel;
import com.practo.jedi.model.ListingModel;
import com.practo.jedi.util.Haversine;

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
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    listing.fromEntity(entity);
    return listing;
  }

  public ListingModel update(ListingModel listing, Integer id) {
    listing.setId(id);
    Listing entity = listing.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    listing.fromEntity(entity);
    return listing;
  }

  public void delete(Integer id) {
    Listing entity = repository.findOne(id);
    entity.setIsDeleted(true);
    entity.setDeletedAt(new Date());
    entity = repository.save(entity);
  }

  public Iterable<ListingModel> filter(ListingFilterDTO filters) {
    Iterable<Listing> entities = repository.findAll(filters.toPredicate());
    ArrayList<ListingModel> models = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      // Apply destination filter
      AddressModel destination = filters.getDestination();
      ListingModel model = new ListingModel();
      model.fromEntity(entity);
      if (destination != null) {
        if (Haversine.haversine(destination.getLatitude().doubleValue(),
            destination.getLongitude().doubleValue(),
            model.getAddress().getLatitude().doubleValue(),
            model.getAddress().getLongitude().doubleValue()) < 1) {
          models.add(model);
        }
      } else {
        models.add(model);
      }
    }
    return models;
  }

}
