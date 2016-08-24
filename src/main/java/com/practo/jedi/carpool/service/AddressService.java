package com.practo.jedi.carpool.service;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.AddressModel;

public interface AddressService {

  public Iterable<AddressModel> get();

  public AddressModel get(Integer id) throws EntityNotFoundException;

  public AddressModel create(AddressModel Address) throws EntityNotFoundException;

  public AddressModel update(AddressModel Address, Integer id) throws EntityNotFoundException;

  public void delete(Integer id) throws EntityNotFoundException;

}
