package com.practo.jedi.entity;

import java.io.Serializable;
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
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  private String email;

  @Column(name = "is_deleted")
  private byte isDeleted;

  @Column(name = "modified_at")
  private Timestamp modifiedAt;

  private String name;

  private String phone;

  // bi-directional many-to-one association to Booking
  @OneToMany(mappedBy = "user")
  private List<Booking> bookings;

  // bi-directional many-to-one association to Listing
  @OneToMany(mappedBy = "user")
  private List<Listing> listings;

  // bi-directional many-to-one association to Vehicle
  @OneToMany(mappedBy = "user")
  private List<Vehicle> vehicles;

  public User() {}

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public byte getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(byte isDeleted) {
    this.isDeleted = isDeleted;
  }

  public Timestamp getModifiedAt() {
    return this.modifiedAt;
  }

  public void setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<Booking> getBookings() {
    return this.bookings;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  public Booking addBooking(Booking booking) {
    getBookings().add(booking);
    booking.setUser(this);

    return booking;
  }

  public Booking removeBooking(Booking booking) {
    getBookings().remove(booking);
    booking.setUser(null);

    return booking;
  }

  public List<Listing> getListings() {
    return this.listings;
  }

  public void setListings(List<Listing> listings) {
    this.listings = listings;
  }

  public Listing addListing(Listing listing) {
    getListings().add(listing);
    listing.setUser(this);

    return listing;
  }

  public Listing removeListing(Listing listing) {
    getListings().remove(listing);
    listing.setUser(null);

    return listing;
  }

  public List<Vehicle> getVehicles() {
    return this.vehicles;
  }

  public void setVehicles(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public Vehicle addVehicle(Vehicle vehicle) {
    getVehicles().add(vehicle);
    vehicle.setUser(this);

    return vehicle;
  }

  public Vehicle removeVehicle(Vehicle vehicle) {
    getVehicles().remove(vehicle);
    vehicle.setUser(null);

    return vehicle;
  }

}
