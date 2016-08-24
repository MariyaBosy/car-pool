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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * Users
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@SQLDelete(sql = "UPDATE users SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted <> true")
public class User implements java.io.Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 3483837657919043932L;
  private Integer id;
  private String name;
  private String email;
  private String phone;
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;
  private Set<Booking> bookings = new HashSet<Booking>(0);
  private Set<Listing> listings = new HashSet<Listing>(0);
  private Set<Vehicle> vehicles = new HashSet<Vehicle>(0);

  public User() {}


  public User(String name, String email, String phone, Date createdAt, Date modifiedAt,
      boolean isDeleted) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.isDeleted = isDeleted;
  }

  public User(String name, String email, String phone, Date createdAt, Date modifiedAt,
      Date deletedAt, boolean isDeleted, Set<Booking> bookings, Set<Listing> listings,
      Set<Vehicle> vehicles) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deletedAt = deletedAt;
    this.isDeleted = isDeleted;
    this.bookings = bookings;
    this.listings = listings;
    this.vehicles = vehicles;
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


  @Column(name = "name", nullable = false, length = 50)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Column(name = "email", unique = true, nullable = false, length = 50)
  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Column(name = "phone", nullable = false, length = 10)
  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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


  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  public Set<Booking> getBookings() {
    return this.bookings;
  }

  public void setBookings(Set<Booking> bookings) {
    this.bookings = bookings;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  public Set<Listing> getListings() {
    return this.listings;
  }

  public void setListings(Set<Listing> listings) {
    this.listings = listings;
  }

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  public Set<Vehicle> getVehicles() {
    return this.vehicles;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone
        + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + ", deletedAt=" + deletedAt
        + ", isDeleted=" + isDeleted + ", bookings=" + bookings + ", listings=" + listings
        + ", vehicles=" + vehicles + "]";
  }


  public void setVehicles(Set<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

}
