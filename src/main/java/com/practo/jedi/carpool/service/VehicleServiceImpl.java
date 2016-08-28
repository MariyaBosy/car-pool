package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.entity.Vehicle;
import com.practo.jedi.carpool.data.repository.VehicleRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.model.VehicleModel;

@Service
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  private VehicleRepository repository;

  public VehicleRepository getRepository() {
    return repository;
  }

  public Iterable<VehicleModel> get(Integer user_id) {
    Iterable<Vehicle> entities = repository.findByUserId(user_id);
    ArrayList<VehicleModel> models = new ArrayList<VehicleModel>();
    for (Vehicle entity : entities) {
      VehicleModel model = new VehicleModel();
      try {
        model.fromEntity(entity);
        models.add(model);
      } catch (EntityNotFoundException err) {
        err.printStackTrace();
      }

    }
    return models;
  }

  public VehicleModel get(Integer user_id, Integer id) throws EntityNotFoundException {
    Vehicle entity = repository.findByUserIdAndId(user_id, id);
    VehicleModel model = new VehicleModel();
    model.fromEntity(entity);
    return model;
  }

  public VehicleModel create(Integer user_id, VehicleModel vehicle) throws EntityNotFoundException {
    UserModel user = new UserModel();
    user.setId(user_id);
    vehicle.setUser(user);
    Vehicle entity = vehicle.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    try {
      vehicle.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
    }
    return vehicle;
  }

  public VehicleModel update(Integer user_id, VehicleModel vehicle, Integer id)
      throws EntityNotFoundException {
    UserModel user = new UserModel();
    user.setId(user_id);
    vehicle.setUser(user);
    vehicle.setId(id);
    Vehicle entity = vehicle.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      vehicle.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      err.printStackTrace();
    }
    return vehicle;
  }

  public void delete(Integer user_id, Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

}
