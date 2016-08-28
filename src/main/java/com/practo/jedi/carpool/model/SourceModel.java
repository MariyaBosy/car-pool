package com.practo.jedi.carpool.model;

import com.practo.jedi.carpool.data.entity.Source;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

/**
 * Model for the source entity.
 * @author prashant
 *
 */
public class SourceModel implements java.io.Serializable {
  private static final long serialVersionUID = 5091525466783641440L;
  private Integer id;
  private AddressModel address;
  private String name;

  public SourceModel() {}



  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AddressModel getAddress() {
    return this.address;
  }

  public void setAddress(AddressModel address) {
    this.address = address;
  }


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get entity from model.
   * 
   * @return Entity
   */
  public Source toEntity() {
    Source source = new Source();
    if (this.getId() != null) {
      source.setId(this.getId());
    }
    source.setName(this.getName());
    if (this.getAddress() != null) {
      source.setAddress(this.getAddress().toEntity());
    }
    return source;
  }

  /**
   * Get model from entity.
   * 
   * @param entity Entity to get model from.
   * @throws EntityNotFoundException If entity does not exist.
   */
  public void fromEntity(Source entity) throws EntityNotFoundException {
    if (entity != null && entity.getIsDeleted() != true) {
      this.setId(entity.getId());
      this.setName(entity.getName());
      AddressModel address = new AddressModel();
      address.fromEntity(entity.getAddress());
      this.setAddress(address);
    } else {
      throw new EntityNotFoundException("No source found with given Id");
    }
  }



}


