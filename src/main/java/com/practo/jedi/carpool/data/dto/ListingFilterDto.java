package com.practo.jedi.carpool.data.dto;

import java.util.Date;

import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.util.Modifier;

/**
 * DTO for the listings filters.
 * @author prashant
 *
 */
public class ListingFilterDto {

  Integer source;
  Integer seatsAvailable;
  AddressModel destination;
  Date departureTime;

  Modifier seatsAvailableModifier;
  Modifier departureTimeModifier;

  public Integer getSource() {
    return source;
  }

  public void setSource(int source) {
    this.source = source;
  }

  public Integer getSeatsAvailable() {
    return seatsAvailable;
  }

  public void setSeatsAvailable(Integer seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  public AddressModel getDestination() {
    return destination;
  }

  public void setDestination(AddressModel destination) {
    this.destination = destination;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  public Modifier getSeatsAvailableModifier() {
    return seatsAvailableModifier;
  }

  /**
   * Set seats available modifier.
   * @param seatsAvailableModifier The modifier to be set
   */
  public void setSeatsAvailableModifier(String seatsAvailableModifier) {
    try {
      this.seatsAvailableModifier = Modifier.valueOf(seatsAvailableModifier);
    } catch (IllegalArgumentException err) {
      this.seatsAvailableModifier = null;
    }
  }

  public Modifier getDepartureTimeModifier() {
    return departureTimeModifier;
  }

  /**
   * Set departure time modifier.
   * @param departureTimeModifier The modifier to be set
   */
  public void setDepartureTimeModifier(String departureTimeModifier) {
    try {
      this.departureTimeModifier = Modifier.valueOf(departureTimeModifier);
    } catch (IllegalArgumentException err) {
      this.departureTimeModifier = null;
    }
  }

}
