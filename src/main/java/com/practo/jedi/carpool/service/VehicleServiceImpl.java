package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.entity.Vehicle;
import com.practo.jedi.carpool.data.repository.VehicleRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.model.VehicleModel;

@Service
public class VehicleServiceImpl implements VehicleService {

  private static final Logger LOG = Logger.getLogger(VehicleServiceImpl.class);


  @Autowired
  private VehicleRepository repository;

  @Override
  public Iterable<VehicleModel> get(Integer user_id) {
    Iterable<Vehicle> entities = repository.findByUserId(user_id);
    ArrayList<VehicleModel> models = new ArrayList<VehicleModel>();
    for (Vehicle entity : entities) {
      VehicleModel model = new VehicleModel();
      try {
        model.fromEntity(entity);
        models.add(model);
      } catch (EntityNotFoundException err) {
        LOG.error(err);
      }

    }
    return models;
  }

  @Override
  public VehicleModel get(Integer user_id, Integer id) throws EntityNotFoundException {
    Vehicle entity = repository.findByUserIdAndId(user_id, id);
    VehicleModel model = new VehicleModel();
    model.fromEntity(entity);
    return model;
  }

  @Override
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
      LOG.error(err);
    }
    return vehicle;
  }

  @Override
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
      LOG.error(err);
    }
    return vehicle;
  }

  @Override
  public void delete(Integer user_id, Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

}
