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


@Entity
@Table(name = "sources")
@SQLDelete(
    sql = "UPDATE sources SET is_deleted = true, deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Where(clause = "is_deleted <> true")
public class Source implements java.io.Serializable {


  private static final long serialVersionUID = 5091525466783641440L;
  private Integer id;
  private Address address;
  private String name;
  private Date createdAt;
  private Date modifiedAt;
  private Date deletedAt;
  private boolean isDeleted;
  private Set<Listing> listings = new HashSet<Listing>(0);

  public Source() {}


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
  @JoinColumn(name = "address_id", nullable = false)
  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }


  @Column(name = "name", nullable = false, length = 45)
  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
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
  @Column(name = "modified_at", length = 19)
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

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "source")
  public Set<Listing> getListings() {
    return this.listings;
  }

  public void setListings(Set<Listing> listings) {
    this.listings = listings;
  }


}
