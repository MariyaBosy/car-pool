package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.entity.Address;
import com.practo.jedi.carpool.data.repository.AddressRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.AddressModel;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private AddressRepository repository;

  public AddressRepository getRepository() {
    return repository;
  }

  public Iterable<AddressModel> get() {
    Iterable<Address> entities = repository.findAll();
    ArrayList<AddressModel> models = new ArrayList<AddressModel>();
    for (Address entity : entities) {
      AddressModel model = new AddressModel();
      try {
        model.fromEntity(entity);
        models.add(model);

      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }
    }
    return models;
  }

  public AddressModel get(Integer id) throws EntityNotFoundException {
    Address entity = repository.findOne(id);
    AddressModel model = new AddressModel();
    model.fromEntity(entity);
    return model;
  }


  public AddressModel create(AddressModel address) throws EntityNotFoundException {
    Address entity = address.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    try {
      address.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return address;
  }

  public AddressModel update(AddressModel address, Integer id) throws EntityNotFoundException {
    address.setId(id);
    Address entity = address.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      address.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return address;
  }

  public void delete(Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

}
