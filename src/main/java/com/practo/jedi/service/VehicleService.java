package com.practo.jedi.service;

import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.VehicleModel;

public interface VehicleService {

  public Iterable<VehicleModel> get(Integer user_id);

  public VehicleModel get(Integer user_id, Integer id) throws EntityNotFoundException;

  public VehicleModel create(Integer user_id, VehicleModel Vehicle);

  public VehicleModel update(Integer user_id, VehicleModel Vehicle, Integer id);

  public void delete(Integer user_id, Integer id);

}
