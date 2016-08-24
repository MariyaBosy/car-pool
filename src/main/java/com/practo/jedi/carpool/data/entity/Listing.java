package com.practo.jedi.carpool.data.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Listings
 */
@Entity
@Table(name = "listings")
@SQLDelete(
    sql = "UPDATE listings SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted <> true")
public class Listing implements java.io.Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 132705768230565793L;
  private Integer id;
  private Address address;
  private Source source;
  private User user;
  private Vehicle vehicle;
  private Date departureTime;
  private int seatsAvailable;
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;
  private Set<Booking> bookings = new HashSet<Booking>(0);

  public Listing() {}


  public Listing(Address address, Source source, User user, Vehicle vehicle, Date departureTime,
      int seatsAvailable, Date createdAt, Date modifiedAt, boolean isDeleted) {
    this.address = address;
    this.source = source;
    this.user = user;
    this.vehicle = vehicle;
    this.departureTime = departureTime;
    this.seatsAvailable = seatsAvailable;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.isDeleted = isDeleted;
  }

  public Listing(Address address, Source source, User user, Vehicle vehicle, Date departureTime,
      int seatsAvailable, Date createdAt, Date modifiedAt, Date deletedAt, boolean isDeleted,
      Set<Booking> bookings) {
    this.address = address;
    this.source = source;
    this.user = user;
    this.vehicle = vehicle;
    this.departureTime = departureTime;
    this.seatsAvailable = seatsAvailable;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deletedAt = deletedAt;
    this.isDeleted = isDeleted;
    this.bookings = bookings;
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

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "destination_address_id", nullable = false)
  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "source_id", nullable = false)
  public Source getSource() {
    return this.source;
  }

  public void setSource(Source source) {
    this.source = source;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "car_id", nullable = false)
  public Vehicle getVehicle() {
    return this.vehicle;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "departure_time", nullable = false, length = 19)
  public Date getDepartureTime() {
    return this.departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }


  @Column(name = "seats_available", nullable = false)
  public int getSeatsAvailable() {
    return this.seatsAvailable;
  }

  public void setSeatsAvailable(int seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
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
  public boolean getIsDeleted() {
    return this.isDeleted;
  }

  public void setIsDeleted(boolean isDeleted) {
    this.isDeleted = isDeleted;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "listing")
  public Set<Booking> getBookings() {
    return this.bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

}
