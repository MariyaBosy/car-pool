package com.practo.jedi.carpool.data.repository;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.practo.jedi.carpool.data.dto.ListingFilterDTO;
import com.practo.jedi.carpool.data.entity.Listing;
import com.practo.jedi.carpool.util.Modifier;

@Repository
public class ListingRepository extends EntityRepositoryImpl<Listing, Integer> {

  @Override
  public Class<Listing> getEntityClass() {
    return Listing.class;
  }

  public Iterable<Listing> findAll(Pageable pageable) {
    return (Iterable<Listing>) template.findByCriteria(DetachedCriteria.forClass(Listing.class),
        pageable.getOffset(), pageable.getPageSize());
  }


  public Iterable<Listing> findAll(ListingFilterDTO filters, Pageable pageable) {
    DetachedCriteria criteria = DetachedCriteria.forClass(Listing.class);
    if (filters.getSource() != null) {
      criteria = criteria.add(Restrictions.eq("source.id", filters.getSource()));
    }
    if (filters.getSeatsAvailable() != null && filters.getSeatsAvailableModifier() != null) {
      if (filters.getSeatsAvailableModifier() == Modifier.EQ) {
        criteria = criteria.add(Restrictions.eq("seatsAvailable", filters.getSeatsAvailable()));
      } else if (filters.getSeatsAvailableModifier() == Modifier.GOE) {
        criteria = criteria.add(Restrictions.ge("seatsAvailable", filters.getSeatsAvailable()));
      } else if (filters.getSeatsAvailableModifier() == Modifier.LOE) {
        criteria = criteria.add(Restrictions.le("seatsAvailable", filters.getSeatsAvailable()));
      } else if (filters.getSeatsAvailableModifier() == Modifier.GT) {
        criteria = criteria.add(Restrictions.gt("seatsAvailable", filters.getSeatsAvailable()));
      } else {
        criteria = criteria.add(Restrictions.lt("seatsAvailable", filters.getSeatsAvailable()));
      }
    }
    if (filters.getDepartureTime() != null && filters.getDepartureTimeModifier() != null) {
      if (filters.getDepartureTimeModifier() == Modifier.EQ) {
        criteria = criteria.add(Restrictions.eq("departureTime", filters.getDepartureTime()));
      } else if (filters.getDepartureTimeModifier() == Modifier.GOE) {
        criteria = criteria.add(Restrictions.ge("departureTime", filters.getDepartureTime()));
      } else if (filters.getDepartureTimeModifier() == Modifier.LOE) {
        criteria = criteria.add(Restrictions.le("departureTime", filters.getDepartureTime()));
      } else if (filters.getDepartureTimeModifier() == Modifier.GT) {
        criteria = criteria.add(Restrictions.gt("departureTime", filters.getDepartureTime()));
      } else {
        criteria = criteria.add(Restrictions.lt("departureTime", filters.getDepartureTime()));
      }
    }
    return (Iterable<Listing>) template.findByCriteria(criteria, pageable.getOffset(),
        pageable.getPageSize());
  }
}
