package com.practo.jedi.carpool.data.dto;

import java.util.Calendar;
import java.util.Date;

import com.practo.jedi.carpool.exceptions.InvalidTimeException;
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

  public void setDepartureTime(String departureTime) throws InvalidTimeException {
    this.departureTime = new Date();
    String[] time = departureTime.split(":");
    Calendar cal = Calendar.getInstance();
    try {
      cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
      cal.set(Calendar.MINUTE, Integer.parseInt(time[1]));
    } catch (NumberFormatException e) {
      throw new InvalidTimeException(departureTime + " is not a valid time.");
    }
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    this.departureTime = cal.getTime();
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

  @Override
  public String toString() {
    return "ListingFilterDTO [source=" + source + ", seatsAvailable=" + seatsAvailable
        + ", destination=" + destination + ", departureTime=" + departureTime
        + ", seatsAvailableModifier=" + seatsAvailableModifier + ", departureTimeModifier="
        + departureTimeModifier + "]";
  }
}
