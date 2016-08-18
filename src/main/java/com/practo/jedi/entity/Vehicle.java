package com.practo.jedi.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the vehicles database table.
 * 
 */
@Entity
@Table(name = "vehicles")
@NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int capacity;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  @Column(name = "is_deleted")
  private byte isDeleted;

  private String model;

  @Column(name = "modified_at")
  private Timestamp modifiedAt;

  @Column(name = "number_plate")
  private String numberPlate;

  // bi-directional many-to-one association to Listing
  @OneToMany(mappedBy = "vehicle")
  private List<Listing> listings;

  // bi-directional many-to-one association to User
  @ManyToOne
  private User user;

  public Vehicle() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
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

  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Timestamp getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public String getNumberPlate() {
    return this.numberPlate;
  }

  public void setNumberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
  }

  public List<Listing> getListings() {
    return this.listings;
  }

  public void setListings(List<Listing> listings) {
    this.listings = listings;
  }

  public Listing addListing(Listing listing) {
    getListings().add(listing);
    listing.setVehicle(this);

    return listing;
  }

  public Listing removeListing(Listing listing) {
    getListings().remove(listing);
    listing.setVehicle(null);

    return listing;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
