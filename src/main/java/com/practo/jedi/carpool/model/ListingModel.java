package com.practo.jedi.carpool.model;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.practo.jedi.carpool.data.entity.Listing;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

/**
 * Model for the listing entity.
 * @author prashant
 *
 */
public class ListingModel implements java.io.Serializable {

  private static final long serialVersionUID = 132705768230565793L;
  private Integer id;

  @NotNull(message = "The destination address is required")
  private AddressModel address;

  @NotNull(message = "The source address is required")
  private SourceModel source;

  private UserModel user;

  @NotNull(message = "A vehicle is required")
  private VehicleModel vehicle;

  @NotNull(message = "The departure time is required")
  @Future(message = "The departure time must be in the future")
  private Date departureTime;

  @NotNull(message = "The number of available seats is required")
  @Min(value = 1, message = "There must be at least one available seat")
  private Integer seatsAvailable;

  public ListingModel() {}



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


  public Integer getSeatsAvailable() {
    return this.seatsAvailable;
  }

  public void setSeatsAvailable(Integer seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  /**
   * Get entity from model.
   * 
   * @return Entity
   */
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

  /**
   * Get model from entity.
   * 
   * @param entity Entity to get model from.
   * @throws EntityNotFoundException If entity does not exist.
   */
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


}


