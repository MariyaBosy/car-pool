package com.practo.jedi.data.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Addresses
 */
@Entity
@Table(name = "addresses")
public class Address implements java.io.Serializable {


  /**
   * 
   */
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
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;
  private Set<Listing> listingses = new HashSet<Listing>(0);
  private Set<Source> sourceses = new HashSet<Source>(0);

  public Address() {}


  public Address(BigDecimal latitude, BigDecimal longitude, Date createdAt, Date modifiedAt,
      boolean isDeleted) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.isDeleted = isDeleted;
  }

  public Address(BigDecimal latitude, BigDecimal longitude, String streetNumber, String route,
      String neighborhood, String sublocality, String administrativeAreaLevel2,
      String administrativeAreaLevel1, String country, String postalCode, Date createdAt,
      Date modifiedAt, Date deletedAt, boolean isDeleted, Set<Listing> listingses,
      Set<Source> sourceses) {
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
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deletedAt = deletedAt;
    this.isDeleted = isDeleted;
    this.listingses = listingses;
    this.sourceses = sourceses;
  }

  @Id
  @GeneratedValue(strategy = IDENTITY)


  @Column(name = "id", unique = true, nullable = false)
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Column(name = "latitude", nullable = false, precision = 10, scale = 8)
  public BigDecimal getLatitude() {
    return this.latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }


  @Column(name = "longitude", nullable = false, precision = 11, scale = 8)
  public BigDecimal getLongitude() {
    return this.longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }


  @Column(name = "street_number", length = 20)
  public String getStreetNumber() {
    return this.streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }


  @Column(name = "route", length = 45)
  public String getRoute() {
    return this.route;
  }

  public void setRoute(String route) {
    this.route = route;
  }


  @Column(name = "neighborhood", length = 45)
  public String getNeighborhood() {
    return this.neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }


  @Column(name = "sublocality", length = 45)
  public String getSublocality() {
    return this.sublocality;
  }

  public void setSublocality(String sublocality) {
    this.sublocality = sublocality;
  }


  @Column(name = "administrative_area_level_2", length = 45)
  public String getAdministrativeAreaLevel2() {
    return this.administrativeAreaLevel2;
  }

  public void setAdministrativeAreaLevel2(String administrativeAreaLevel2) {
    this.administrativeAreaLevel2 = administrativeAreaLevel2;
  }


  @Column(name = "administrative_area_level_1", length = 45)
  public String getAdministrativeAreaLevel1() {
    return this.administrativeAreaLevel1;
  }

  public void setAdministrativeAreaLevel1(String administrativeAreaLevel1) {
    this.administrativeAreaLevel1 = administrativeAreaLevel1;
  }


  @Column(name = "country", length = 45)
  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Column(name = "postal_code", length = 20)
  public String getPostalCode() {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "modified_at", nullable = false, length = 19)
  public Date getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Date modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "deleted_at", length = 19)
  public Date getDeletedAt() {
    return this.deletedAt;
  }

  public void setDeletedAt(Date deletedAt) {
    this.deletedAt = deletedAt;
  }


  @Column(name = "is_deleted", nullable = false)
  public boolean isIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "addresses")
  public Set<Listing> getListingses() {
    return this.listingses;
  }

  public void setListingses(Set<Listing> listingses) {
    this.listingses = listingses;
  }


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "addresses")
  public Set<Source> getSourceses() {
    return this.sourceses;
  }

  public void setSourceses(Set<Source> sourceses) {
    this.sourceses = sourceses;
  }



}


