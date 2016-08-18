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
 * The persistent class for the sources database table.
 * 
 */
@Entity
@Table(name = "sources")
@NamedQuery(name = "Source.findAll", query = "SELECT s FROM Source s")
public class Source implements Serializable {
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

  private String name;

  // bi-directional many-to-one association to Listing
  @OneToMany(mappedBy = "source")
  private List<Listing> listings;

  // bi-directional many-to-one association to Address
  @ManyToOne
  private Address address;

  public Source() {}

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

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Listing> getListings() {
    return this.listings;
  }

  public void setListings(List<Listing> listings) {
    this.listings = listings;
  }

  public Listing addListing(Listing listing) {
    getListings().add(listing);
    listing.setSource(this);

    return listing;
  }

  public Listing removeListing(Listing listing) {
    getListings().remove(listing);
    listing.setSource(null);

    return listing;
  }

  public Address getAddress() {
    return this.address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

}
