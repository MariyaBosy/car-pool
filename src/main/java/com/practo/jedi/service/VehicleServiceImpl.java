package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.entity.Vehicle;
import com.practo.jedi.data.repository.VehicleRepository;
import com.practo.jedi.model.VehicleModel;

@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  private VehicleRepository repository;

  public VehicleRepository getRepository() {
    return repository;
  }

  public Iterable<VehicleModel> get() {
    Iterable<Vehicle> entities = repository.findAll();
    ArrayList<VehicleModel> models = new ArrayList<VehicleModel>();
    for (Vehicle entity : entities) {
      VehicleModel model = new VehicleModel();
      model.fromEntity(entity);
      models.add(model);
    }
    return models;
  }

  public VehicleModel get(Integer id) {
    Vehicle entity = repository.findOne(id);
    VehicleModel model = new VehicleModel();
    model.fromEntity(entity);
    return model;
  }

  public VehicleModel create(VehicleModel vehicle) {
    Vehicle entity = vehicle.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    vehicle.fromEntity(entity);
    return vehicle;
  }

  public VehicleModel update(VehicleModel vehicle, Integer id) {
    vehicle.setId(id);
    Vehicle entity = vehicle.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    vehicle.fromEntity(entity);
    return vehicle;
  }

  public void delete(Integer id) {
    Vehicle entity = repository.findOne(id);
    entity.setIsDeleted(true);
    entity.setDeletedAt(new Date());
    entity = repository.save(entity);
  }

}
