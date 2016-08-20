package com.practo.jedi.model;

import java.math.BigDecimal;

import com.practo.jedi.data.entity.Address;

public class AddressModel implements java.io.Serializable {

  private static final long serialVersionUID = 1074652890790783712L;
  private Integer id;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String streetNumber;
  private String route;
  private String neighborhood;
  private String sublocality;
  private String administrativeAreaLevel2;
  private String administrativeAreaLevel1;
  private String country;
  private String postalCode;

  public AddressModel() {}


  public AddressModel(BigDecimal latitude, BigDecimal longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public AddressModel(BigDecimal latitude, BigDecimal longitude, String streetNumber, String route,
      String neighborhood, String sublocality, String administrativeAreaLevel2,
      String administrativeAreaLevel1, String country, String postalCode) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.streetNumber = streetNumber;
    this.route = route;
    this.neighborhood = neighborhood;
    this.sublocality = sublocality;
    this.administrativeAreaLevel2 = administrativeAreaLevel2;
    this.administrativeAreaLevel1 = administrativeAreaLevel1;
    this.country = country;
    this.postalCode = postalCode;
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


  public String getStreetNumber() {
    return this.streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }


  public String getRoute() {
    return this.route;
  }

  public void setRoute(String route) {
    this.route = route;
  }


  public String getNeighborhood() {
    return this.neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }


  public String getSublocality() {
    return this.sublocality;
  }

  public void setSublocality(String sublocality) {
    this.sublocality = sublocality;
  }


  public String getAdministrativeAreaLevel2() {
    return this.administrativeAreaLevel2;
  }

  public void setAdministrativeAreaLevel2(String administrativeAreaLevel2) {
    this.administrativeAreaLevel2 = administrativeAreaLevel2;
  }


  public String getAdministrativeAreaLevel1() {
    return this.administrativeAreaLevel1;
  }

  public void setAdministrativeAreaLevel1(String administrativeAreaLevel1) {
    this.administrativeAreaLevel1 = administrativeAreaLevel1;
  }


  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  public String getPostalCode() {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }


  public Address toEntity() {
    Address address = new Address();
    if (this.getId() != null) {
      address.setId(this.getId());
    }
    address.setLatitude(this.getLatitude());
    address.setLongitude(this.getLongitude());
    address.setStreetNumber(this.getStreetNumber());
    address.setRoute(this.getRoute());
    address.setNeighborhood(this.getNeighborhood());
    address.setSublocality(this.getSublocality());
    address.setAdministrativeAreaLevel1(this.getAdministrativeAreaLevel1());
    address.setAdministrativeAreaLevel2(this.getAdministrativeAreaLevel2());
    address.setCountry(this.getCountry());
    address.setPostalCode(this.getPostalCode());
    return address;
  }

  public void fromEntity(Address entity) {
    if (entity != null) {
      this.setId(entity.getId());
      this.setLatitude(entity.getLatitude());
      this.setLongitude(entity.getLongitude());
      this.setStreetNumber(entity.getStreetNumber());
      this.setRoute(entity.getRoute());
      this.setNeighborhood(entity.getNeighborhood());
      this.setSublocality(entity.getSublocality());
      this.setAdministrativeAreaLevel1(entity.getAdministrativeAreaLevel1());
      this.setAdministrativeAreaLevel2(entity.getAdministrativeAreaLevel2());
      this.setCountry(entity.getCountry());
      this.setPostalCode(entity.getPostalCode());
    }
  }


  @Override
  public String toString() {
    return "AddressModel [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude
        + ", streetNumber=" + streetNumber + ", route=" + route + ", neighborhood=" + neighborhood
        + ", sublocality=" + sublocality + ", administrativeAreaLevel2=" + administrativeAreaLevel2
        + ", administrativeAreaLevel1=" + administrativeAreaLevel1 + ", country=" + country
        + ", postalCode=" + postalCode + "]";
  }

}


