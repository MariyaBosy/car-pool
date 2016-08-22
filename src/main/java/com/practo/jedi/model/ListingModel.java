package com.practo.jedi.model;

import java.util.Date;

import com.practo.jedi.data.entity.Listing;
import com.practo.jedi.exceptions.EntityNotFoundException;

public class ListingModel implements java.io.Serializable {

  private static final long serialVersionUID = 132705768230565793L;
  private Integer id;
  private AddressModel address;
  private SourceModel source;
  private UserModel user;
  private VehicleModel vehicle;
  private Date departureTime;
  private int seatsAvailable;

  public ListingModel() {}


  public ListingModel(AddressModel address, SourceModel source, UserModel user,
      VehicleModel vehicle, Date departureTime, int seatsAvailable) {
    this.address = address;
    this.source = source;
    this.user = user;
    this.vehicle = vehicle;
    this.departureTime = departureTime;
    this.seatsAvailable = seatsAvailable;
  }


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AddressModel getAddress() {
    return this.address;
  }

  public void setAddress(AddressModel address) {
    this.address = address;
  }

  public SourceModel getSource() {
    return this.source;
  }

  public void setSource(SourceModel source) {
    this.source = source;
  }

  public UserModel getUser() {
    return this.user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public VehicleModel getVehicle() {
    return this.vehicle;
  }

  public void setVehicle(VehicleModel vehicle) {
    this.vehicle = vehicle;
  }

  public Date getDepartureTime() {
    return this.departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }


  public int getSeatsAvailable() {
    return this.seatsAvailable;
  }

  public void setSeatsAvailable(int seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  public Listing toEntity() {
    Listing listing = new Listing();
    if (this.getId() != null) {
      listing.setId(this.getId());
    }
    if (this.getAddress() != null) {
      listing.setAddress(this.getAddress().toEntity());
    }
    if (this.getSource() != null) {
      listing.setSource(this.getSource().toEntity());
    }
    if (this.getUser() != null) {
      listing.setUser(this.getUser().toEntity());
    }
    if (this.getVehicle() != null) {
      listing.setVehicle(this.getVehicle().toEntity());
    }
    listing.setDepartureTime(this.getDepartureTime());
    listing.setSeatsAvailable(this.getSeatsAvailable());
    return listing;
  }

  public void fromEntity(Listing entity) throws EntityNotFoundException {
    if (entity != null && entity.getIsDeleted() != true) {
      this.setId(entity.getId());
      AddressModel address = new AddressModel();
      address.fromEntity(entity.getAddress());
      this.setAddress(address);
      SourceModel source = new SourceModel();
      source.fromEntity(entity.getSource());
      this.setSource(source);
      UserModel user = new UserModel();
      user.fromEntity(entity.getUser());
      this.setUser(user);
      VehicleModel vehicle = new VehicleModel();
      vehicle.fromEntity(entity.getVehicle());
      this.setVehicle(vehicle);
      this.setDepartureTime(entity.getDepartureTime());
      this.setSeatsAvailable(entity.getSeatsAvailable());
    } else {
      throw new EntityNotFoundException("No listing found with given Id");
    }
  }


  @Override
  public String toString() {
    return "ListingModel [id=" + id + ", address=" + address + ", source=" + source + ", user="
        + user + ", vehicle=" + vehicle + ", departureTime=" + departureTime + ", seatsAvailable="
        + seatsAvailable + "]";
  }


}


