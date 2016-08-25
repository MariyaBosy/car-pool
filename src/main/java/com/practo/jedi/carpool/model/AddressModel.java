package com.practo.jedi.carpool.model;

import java.math.BigDecimal;

import com.practo.jedi.carpool.data.entity.Address;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

public class AddressModel implements java.io.Serializable {

  private static final long serialVersionUID = 1074652890790783712L;
  private Integer id;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String formattedAddress;

  public AddressModel() {}


  public AddressModel(BigDecimal latitude, BigDecimal longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public AddressModel(BigDecimal latitude, BigDecimal longitude, String formattedAddress) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.formattedAddress = formattedAddress;
  }


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public BigDecimal getLatitude() {
    return this.latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }


  public BigDecimal getLongitude() {
    return this.longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }


  public String getFormattedAddress() {
    return this.formattedAddress;
  }

  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }

  public Address toEntity() {
    Address address = new Address();
    if (this.getId() != null) {
      address.setId(this.getId());
    }
    address.setLatitude(this.getLatitude());
    address.setLongitude(this.getLongitude());
    address.setFormattedAddress(this.getFormattedAddress());
    return address;
  }

  public void fromEntity(Address entity) throws EntityNotFoundException {
    if (entity != null && entity.getIsDeleted() != true) {
      this.setId(entity.getId());
      this.setLatitude(entity.getLatitude());
      this.setLongitude(entity.getLongitude());
      this.setFormattedAddress(entity.getFormattedAddress());
    } else {
      throw new EntityNotFoundException("No address found with given Id");
    }
  }


  @Override
  public String toString() {
    return formattedAddress;
  }

}


