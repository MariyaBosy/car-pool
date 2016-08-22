package com.practo.jedi.service;

import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.AddressModel;

public interface AddressService {

  public Iterable<AddressModel> get();

  public AddressModel get(Integer id) throws EntityNotFoundException;

  public AddressModel create(AddressModel Address);

  public AddressModel update(AddressModel Address, Integer id);

  public void delete(Integer id);

}
