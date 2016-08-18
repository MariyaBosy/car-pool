package com.practo.jedi.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the listings database table.
 * 
 */
@Entity
@Table(name = "listings")
@NamedQuery(name = "Listing.findAll", query = "SELECT l FROM Listing l")
public class Listing implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  @Column(name = "departure_time")
  private Timestamp departureTime;

  @Column(name = "is_deleted")
  private byte isDeleted;

  @Column(name = "modified_at")
  private Timestamp modifiedAt;

  @Column(name = "seats_available")
  private int seatsAvailable;

  // bi-directional many-to-one association to Booking
  @OneToMany(mappedBy = "listing")
  private List<Booking> bookings;

  // bi-directional many-to-one association to Address
  @ManyToOne
  @JoinColumn(name = "destination_address_id")
  private Address address;

  // bi-directional many-to-one association to Source
  @ManyToOne
  private Source source;

  // bi-directional many-to-one association to User
  @ManyToOne
  private User user;

  // bi-directional many-to-one association to Vehicle
  @ManyToOne
  @JoinColumn(name = "car_id")
  private Vehicle vehicle;

  public Listing() {}

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

  public Timestamp getDepartureTime() {
    return this.departureTime;
  }

  public void setDepartureTime(Timestamp departureTime) {
    this.departureTime = departureTime;
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

  public int getSeatsAvailable() {
    return this.seatsAvailable;
  }

  public void setSeatsAvailable(int seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  public List<Booking> getBookings() {
    return this.bookings;
  }

  public void setBookings(List<Booking> bookings) {
    this.bookings = bookings;
  }

  public Booking addBooking(Booking booking) {
    getBookings().add(booking);
    booking.setListing(this);

    return booking;
  }

  public Booking removeBooking(Booking booking) {
    getBookings().remove(booking);
    booking.setListing(null);

    return booking;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Source getSource() {
    return this.source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

}
