package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.dto.ListingFilterDto;
import com.practo.jedi.carpool.data.entity.Address;
import com.practo.jedi.carpool.data.entity.Listing;
import com.practo.jedi.carpool.data.entity.Vehicle;
import com.practo.jedi.carpool.data.repository.AddressRepository;
import com.practo.jedi.carpool.data.repository.ListingRepository;
import com.practo.jedi.carpool.data.repository.VehicleRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.util.Haversine;

@Service
public class ListingServiceImpl implements ListingService {

  @Autowired
  private ListingRepository listingRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private VehicleRepository vehicleRepository;


  @Override
  public Iterable<ListingModel> get(Pageable pageable) {
    Iterable<Listing> entities = listingRepository.findAll(pageable);
    ArrayList<ListingModel> models = new ArrayList<ListingModel>();
    for (Listing entity : entities) {
      ListingModel model = new ListingModel();
      try {
        model.fromEntity(entity);
        models.add(model);
      } catch (EntityNotFoundException err) {
        err.printStackTrace();
      }

    }
    return models;
  }


  @Override
  public ListingModel get(Integer id) throws EntityNotFoundException {
    Listing entity = listingRepository.findOne(id);
    ListingModel model = new ListingModel();
    model.fromEntity(entity);
    return model;
  }


  @Override
  public ListingModel create(ListingModel listing) throws EntityNotFoundException {
    Listing entity = listing.toEntity();
    Address addressEntity = entity.getAddress();
    try {
      addressEntity = addressRepository.findByLatitudeAndLongitude(addressEntity.getLatitude(),
          addressEntity.getLongitude());
    } catch (EntityNotFoundException err) {
      addressEntity.setCreatedAt(new Date());
      addressEntity = addressRepository.save(entity.getAddress());
    }
    entity.setAddress(addressEntity);
    if (entity.getVehicle().getId() == null) {
      Vehicle vehicleEntity = entity.getVehicle();
      vehicleEntity.setCreatedAt(new Date());
      vehicleEntity = vehicleRepository.save(vehicleEntity);
      entity.setVehicle(vehicleEntity);
    }
    entity.setCreatedAt(new Date());
    entity = listingRepository.save(entity);
    try {
      listing.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
    }
    return listing;
  }


  @Override
  public ListingModel update(ListingModel listing, Integer id) throws EntityNotFoundException {
    listing.setId(id);
    Listing entity = listing.toEntity();
    Address addressEntity = entity.getAddress();
    try {
      addressEntity = addressRepository.findByLatitudeAndLongitude(addressEntity.getLatitude(),
          addressEntity.getLongitude());
    } catch (EntityNotFoundException err) {
      addressEntity.setCreatedAt(new Date());
      addressEntity = addressRepository.save(entity.getAddress());
    }
    entity.setAddress(addressEntity);
    if (entity.getVehicle().getId() == null) {
      Vehicle vehicleEntity = entity.getVehicle();
      vehicleEntity.setCreatedAt(new Date());
      vehicleEntity = vehicleRepository.save(vehicleEntity);
      entity.setVehicle(vehicleEntity);
    }
    entity.setModifiedAt(new Date());
    entity = listingRepository.save(entity);
    try {
      listing.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
    }
    return listing;
  }

  @Override
  public void delete(Integer id) throws EntityNotFoundException {
    listingRepository.delete(id);
  }


  @Override
  public Iterable<ListingModel> filter(ListingFilterDto filters, Pageable pageable) {
    Iterable<Listing> entities = listingRepository.findAll(filters, pageable);
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
      } catch (EntityNotFoundException err) {
        err.printStackTrace();
      }

    }
    return models;
  }

}
