package com.practo.jedi.carpool.data.entity;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.Where;

/**
 * Bookings
 */
@Entity
@Table(name = "bookings")
@SQLUpdate(
    sql = "UPDATE bookings SET deleted_at=?, is_deleted=?, listing_id=?, modified_at=CURRENT_TIMESTAMP, user_id=? where id=? and is_deleted <> true")
@SQLDelete(
    sql = "UPDATE bookings SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted <> true")
public class Booking implements java.io.Serializable {


  /**
  * 
  */
  private static final long serialVersionUID = -270236333892130177L;
  private Integer id;
  private Listing listing;
  private User user;
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;

  public Booking() {}


  public Booking(Listing listing, User user, Date createdAt, Date modifiedAt, boolean isDeleted) {
    this.listing = listing;
    this.user = user;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.isDeleted = isDeleted;
  }

  public Booking(Listing listing, User user, Date createdAt, Date modifiedAt, Date deletedAt,
      boolean isDeleted) {
    this.listing = listing;
    this.user = user;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deletedAt = deletedAt;
    this.isDeleted = isDeleted;
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
  @JoinColumn(name = "listing_id", nullable = false)
  public Listing getListing() {
    return this.listing;
  }

  public void setListing(Listing listing) {
    this.listing = listing;
  }

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
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


  @Override
  public String toString() {
    return "Booking [id=" + id + ", listing=" + listing + ", user=" + user + ", createdAt="
        + createdAt + ", modifiedAt=" + modifiedAt + ", deletedAt=" + deletedAt + ", isDeleted="
        + isDeleted + "]";
  }

}
