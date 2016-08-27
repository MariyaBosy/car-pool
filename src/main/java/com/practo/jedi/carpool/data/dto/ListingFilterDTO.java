package com.practo.jedi.carpool.data.dto;

import java.util.Date;

import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.util.Modifier;

public class ListingFilterDTO {

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

  public void setSeatsAvailableModifier(String seatsAvailableModifier) {
    try {
      this.seatsAvailableModifier = Modifier.valueOf(seatsAvailableModifier);
    } catch (IllegalArgumentException e) {
      this.seatsAvailableModifier = null;
    }
  }

  public Modifier getDepartureTimeModifier() {
    return departureTimeModifier;
  }

  public void setDepartureTimeModifier(String departureTimeModifier) {
    try {
      this.departureTimeModifier = Modifier.valueOf(departureTimeModifier);
    } catch (IllegalArgumentException e) {
      this.departureTimeModifier = null;
    }
  }

}
