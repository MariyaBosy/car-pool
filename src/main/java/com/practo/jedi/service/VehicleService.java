package com.practo.jedi.service;

import com.practo.jedi.model.VehicleModel;

public interface VehicleService {

  public Iterable<VehicleModel> get();

  public VehicleModel get(Integer id);

  public VehicleModel create(VehicleModel Vehicle);

  public VehicleModel update(VehicleModel Vehicle, Integer id);

  public void delete(Integer id);

}
