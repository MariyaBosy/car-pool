package com.practo.jedi.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the bookings database table.
 * 
 */
@Entity
@Table(name = "bookings")
@NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b")
public class Booking implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "created_at")
  private Timestamp createdAt;

  @Column(name = "deleted_at")
  private Timestamp deletedAt;

  @Column(name = "is_deleted")
  private byte isDeleted;

  @Column(name = "modified_at")
  private Timestamp modifiedAt;

  // bi-directional many-to-one association to Listing
  @ManyToOne
  private Listing listing;

  // bi-directional many-to-one association to User
  @ManyToOne
  private User user;

  public Booking() {}

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

  public Listing getListing() {
    return this.listing;
  }

  public void setListing(Listing listing) {
    this.listing = listing;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

}
