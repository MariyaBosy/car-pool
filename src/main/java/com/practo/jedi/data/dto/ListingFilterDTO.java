package com.practo.jedi.data.dto;

import java.util.Date;

import com.practo.jedi.data.entity.QListing;
import com.practo.jedi.model.AddressModel;
import com.practo.jedi.model.SourceModel;
import com.practo.jedi.util.Modifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

public class ListingFilterDTO {

  SourceModel source;
  Integer seatsAvailable;
  AddressModel destination;
  Date departureTime;

  Modifier seatsAvailableModifier;
  Modifier departureTimeModifier;

  public SourceModel getSource() {
    return source;
  }

  public void setSource(int source) {
    this.source = new SourceModel();
    this.source.setId(source);
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

  public void setDepartureTime(Long departureTime) {
    this.departureTime = new Date(departureTime);
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

  public Predicate toPredicate() {
    BooleanExpression predicate = QListing.listing.isDeleted.eq(false);
    if (source != null) {
      predicate = predicate.and(sourcePredicate());
    }
    if (seatsAvailable != null && seatsAvailableModifier != null) {
      predicate = predicate.and(seatsAvailablePredicate());
    }
    if (departureTime != null && departureTimeModifier != null) {
      predicate = predicate.and(departureTimePredicate());
    }

    return predicate;
  }

  private BooleanExpression sourcePredicate() {
    return QListing.listing.source.eq(source.toEntity());
  }

  private BooleanExpression seatsAvailablePredicate() {
    if (seatsAvailableModifier == Modifier.EQ) {
      return QListing.listing.seatsAvailable.eq(seatsAvailable);
    } else if (seatsAvailableModifier == Modifier.GOE) {
      return QListing.listing.seatsAvailable.goe(seatsAvailable);
    } else if (seatsAvailableModifier == Modifier.LOE) {
      return QListing.listing.seatsAvailable.loe(seatsAvailable);
    } else if (seatsAvailableModifier == Modifier.GT) {
      return QListing.listing.seatsAvailable.gt(seatsAvailable);
    } else {
      return QListing.listing.seatsAvailable.lt(seatsAvailable);
    }
  }

  private BooleanExpression departureTimePredicate() {
    if (departureTimeModifier == Modifier.EQ) {
      return QListing.listing.departureTime.eq(departureTime);
    } else if (departureTimeModifier == Modifier.GOE) {
      return QListing.listing.departureTime.goe(departureTime);
    } else if (departureTimeModifier == Modifier.LOE) {
      return QListing.listing.departureTime.loe(departureTime);
    } else if (departureTimeModifier == Modifier.GT) {
      return QListing.listing.departureTime.gt(departureTime);
    } else {
      return QListing.listing.departureTime.lt(departureTime);
    }
  }
}
