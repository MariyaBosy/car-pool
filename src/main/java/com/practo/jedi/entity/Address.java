package com.practo.jedi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the addresses database table.
 * 
 */
@Entity
@Table(name = "addresses")
@NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a")
public class Address implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "administrative_area_level_1")
  private String administrativeAreaLevel1;

  @Column(name = "administrative_area_level_2")
  private String administrativeAreaLevel2;

  private String country;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  @Column(name = "is_deleted")
  private byte isDeleted;

  private BigDecimal latitude;

  private BigDecimal longitude;

  @Column(name = "modified_at")
  private Timestamp modifiedAt;

  private String neighborhood;

  @Column(name = "postal_code")
  private String postalCode;

  private String route;

  @Column(name = "street_number")
  private String streetNumber;

  private String sublocality;

  // bi-directional many-to-one association to Listing
  @OneToMany(mappedBy = "address")
  private List<Listing> listings;

  // bi-directional many-to-one association to Source
  @OneToMany(mappedBy = "address")
  private List<Source> sources;

  public Address() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAdministrativeAreaLevel1() {
    return this.administrativeAreaLevel1;
  }

  public void setAdministrativeAreaLevel1(String administrativeAreaLevel1) {
    this.administrativeAreaLevel1 = administrativeAreaLevel1;
  }

  public String getAdministrativeAreaLevel2() {
    return this.administrativeAreaLevel2;
  }

  public void setAdministrativeAreaLevel2(String administrativeAreaLevel2) {
    this.administrativeAreaLevel2 = administrativeAreaLevel2;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Timestamp getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Timestamp getDeletedAt() {
    return this.deletedAt;
  }

  public void setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
  }

  public byte getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(byte isDeleted) {
    this.isDeleted = isDeleted;
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

  public Timestamp getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public String getNeighborhood() {
    return this.neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getPostalCode() {
    return this.postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getRoute() {
    return this.route;
  }

  public void setRoute(String route) {
    this.route = route;
  }

  public String getStreetNumber() {
    return this.streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getSublocality() {
    return this.sublocality;
  }

  public void setSublocality(String sublocality) {
    this.sublocality = sublocality;
  }

  public List<Listing> getListings() {
    return this.listings;
  }

  public void setListings(List<Listing> listings) {
    this.listings = listings;
  }

  public Listing addListing(Listing listing) {
    getListings().add(listing);
    listing.setAddress(this);

    return listing;
  }

  public Listing removeListing(Listing listing) {
    getListings().remove(listing);
    listing.setAddress(null);

    return listing;
  }

  public List<Source> getSources() {
    return this.sources;
  }

  public void setSources(List<Source> sources) {
    this.sources = sources;
  }

  public Source addSource(Source source) {
    getSources().add(source);
    source.setAddress(this);

    return source;
  }

  public Source removeSource(Source source) {
    getSources().remove(source);
    source.setAddress(null);

    return source;
  }

}
