package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.dto.ListingFilterDTO;
import com.practo.jedi.carpool.data.entity.Listing;
import com.practo.jedi.carpool.data.repository.ListingRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.util.Haversine;

@Service
public class ListingServiceImpl implements ListingService {

  @Autowired
  private ListingRepository repository;

  public ListingRepository getRepository() {
    return repository;
  }

  public Iterable<ListingModel> get(Pageable pageable) {
    Iterable<Listing> entities = repository.findAll(pageable);
    ArrayList<ListingModel> models = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      ListingModel model = new ListingModel();
      try {
        model.fromEntity(entity);
        models.add(model);
      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }

    }
    return models;
  }

  public ListingModel get(Integer id) throws EntityNotFoundException {
    Listing entity = repository.findOne(id);
    ListingModel model = new ListingModel();
    model.fromEntity(entity);
    return model;
  }

  public ListingModel create(ListingModel listing) throws EntityNotFoundException {
    Listing entity = listing.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    try {
      listing.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return listing;
  }

  public ListingModel update(ListingModel listing, Integer id) throws EntityNotFoundException {
    listing.setId(id);
    Listing entity = listing.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      listing.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return listing;
  }

  public void delete(Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

  public Iterable<ListingModel> filter(ListingFilterDTO filters, Pageable pageable) {
    // public Iterable<ListingModel> filter(Pageable pageable) {
    Iterable<Listing> entities = repository.findAll(filters, pageable);
    ArrayList<ListingModel> models = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      // Apply destination filter
      AddressModel destination = filters.getDestination();
      ListingModel model = new ListingModel();
      try {
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
      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }
      try {
        model.fromEntity(entity);
      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }
      models.add(model);

    }
    return models;
  }

}
