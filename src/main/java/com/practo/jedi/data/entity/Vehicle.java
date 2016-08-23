package com.practo.jedi.data.entity;


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
 * Vehicles
 */
@Entity
@Table(name = "vehicles")
@SQLDelete(
    sql = "UPDATE vehicles SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted <> true")
public class Vehicle implements java.io.Serializable {


  /**
   * 
   */
  private static final long serialVersionUID = 2642296086463840850L;
  private Integer id;
  private User user;
  private int capacity;
  private String model;
  private String numberPlate;
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;
  private Set<Listing> listings = new HashSet<Listing>(0);

  public Vehicle() {}


  public Vehicle(User user, int capacity, String model, String numberPlate, Date createdAt,
      Date modifiedAt, boolean isDeleted) {
    this.user = user;
    this.capacity = capacity;
    this.model = model;
    this.numberPlate = numberPlate;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.isDeleted = isDeleted;
  }

  public Vehicle(User user, int capacity, String model, String numberPlate, Date createdAt,
      Date modifiedAt, Date deletedAt, boolean isDeleted, Set<Listing> listings) {
    this.user = user;
    this.capacity = capacity;
    this.model = model;
    this.numberPlate = numberPlate;
    this.createdAt = createdAt;
    this.modifiedAt = modifiedAt;
    this.deletedAt = deletedAt;
    this.isDeleted = isDeleted;
    this.listings = listings;
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
  @JoinColumn(name = "user_id", nullable = false)
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }


  @Column(name = "capacity", nullable = false)
  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }


  @Column(name = "model", nullable = false, length = 45)
  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  @Column(name = "number_plate", nullable = false, length = 45)
  public String getNumberPlate() {
    return this.numberPlate;
  }

  public void setNumberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
  public Set<Listing> getListings() {
    return this.listings;
  }

  public void setListings(Set<Listing> listings) {
    this.listings = listings;
  }

}
