package com.practo.jedi.carpool.service;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.VehicleModel;

public interface VehicleService {

  public Iterable<VehicleModel> get(Integer user_id);

  public VehicleModel get(Integer user_id, Integer id) throws EntityNotFoundException;

  public VehicleModel create(Integer user_id, VehicleModel Vehicle) throws EntityNotFoundException;

  public VehicleModel update(Integer user_id, VehicleModel Vehicle, Integer id) throws EntityNotFoundException;

  public void delete(Integer user_id, Integer id) throws EntityNotFoundException;

}
