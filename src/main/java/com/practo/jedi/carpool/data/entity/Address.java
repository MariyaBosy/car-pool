package com.practo.jedi.carpool.data.entity;


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

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Where;

/**
 * Addresses
 */
@Entity
@Table(name = "addresses")
@SQLUpdate(
    sql = "UPDATE addresses SET deleted_at=?, formatted_address=?, is_deleted=?, latitude=?, longitude=?, modified_at=CURRENT_TIMESTAMP where id=? and is_deleted <> true")
@SQLDelete(
    sql = "UPDATE addresses SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted <> true")
public class Address implements java.io.Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 1074652890790783712L;
  private Integer id;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private String formattedAddress;
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;
  private Set<Listing> listings = new HashSet<Listing>(0);
  private Set<Source> sources = new HashSet<Source>(0);

  public Address() {}


  public Address(BigDecimal latitude, BigDecimal longitude, Date createdAt, Date modifiedAt,
      boolean isDeleted) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.isDeleted = isDeleted;
  }

  public Address(BigDecimal latitude, BigDecimal longitude, String formattedAddress, Date createdAt,
      Date modifiedAt, Date deletedAt, boolean isDeleted, Set<Listing> listings,
      Set<Source> sources) {
    this.latitude = latitude;
    this.longitude = longitude;
    this.formattedAddress = formattedAddress;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deletedAt = deletedAt;
    this.isDeleted = isDeleted;
    this.listings = listings;
    this.sources = sources;
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


  @Column(name = "formatted_address", length = 200)
  public String getFormattedAddress() {
    return this.formattedAddress;
  }

  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }


  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19, updatable = false)
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
  public boolean getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  public Set<Listing> getListings() {
    return this.listings;
  }

  public void setListings(Set<Listing> listings) {
    this.listings = listings;
  }


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
  public Set<Source> getSources() {
    return this.sources;
  }

  public void setSources(Set<Source> sources) {
    this.sources = sources;
  }

}


