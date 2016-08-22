package com.practo.jedi.model;

import com.practo.jedi.data.entity.Booking;
import com.practo.jedi.exceptions.EntityNotFoundException;

public class BookingModel implements java.io.Serializable {

  private static final long serialVersionUID = -270236333892130177L;
  private Integer id;
  private ListingModel listing;
  private UserModel user;

  public BookingModel() {}


  public BookingModel(ListingModel listing, UserModel user) {
    this.listing = listing;
    this.user = user;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ListingModel getListing() {
    return this.listing;
  }

  public void setListing(ListingModel listing) {
    this.listing = listing;
  }

  public UserModel getUser() {
    return this.user;
  }

  public void setUser(UserModel users) {
    this.user = users;
  }

  public Booking toEntity() {
    Booking booking = new Booking();
    if (this.getId() != null) {
      booking.setId(this.getId());
    }
    if (this.getListing() != null) {
      booking.setListing(this.getListing().toEntity());
    }
    if (this.getUser() != null) {
      booking.setUser(this.getUser().toEntity());
    }
    return booking;
  }

  public void fromEntity(Booking entity) throws EntityNotFoundException {
    if (entity != null && entity.getIsDeleted() != true) {
      this.setId(entity.getId());
      UserModel user = new UserModel();
      user.fromEntity(entity.getUser());
      this.setUser(user);
      ListingModel listing = new ListingModel();
      listing.fromEntity(entity.getListing());
      this.setListing(listing);
    }else {
      throw new EntityNotFoundException("No booking found with given Id");
    }
  }


  @Override
  public String toString() {
    return "BookingModel [id=" + id + ", listing=" + listing + ", user=" + user + "]";
  }

}


