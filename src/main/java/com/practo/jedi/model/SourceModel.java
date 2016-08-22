package com.practo.jedi.model;

import com.practo.jedi.data.entity.Source;
import com.practo.jedi.exceptions.EntityNotFoundException;

public class SourceModel implements java.io.Serializable {
  private static final long serialVersionUID = 5091525466783641440L;
  private Integer id;
  private AddressModel address;
  private String name;

  public SourceModel() {}


  public SourceModel(AddressModel address, String name) {
    this.address = address;
    this.name = name;
  }


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


  @Override
  public String toString() {
    return "SourceModel [id=" + id + ", address=" + address + ", name=" + name + "]";
  }


}


