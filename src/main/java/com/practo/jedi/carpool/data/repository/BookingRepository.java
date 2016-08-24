
package com.practo.jedi.carpool.data.repository;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.practo.jedi.carpool.data.entity.Booking;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

@Repository
public class BookingRepository extends EntityRepositoryImpl<Booking, Integer> {

  @Override
  public Class<Booking> getEntityClass() {
    return Booking.class;
  }

  public Iterable<Booking> findByListingId(Integer listing_id) {
    return (Iterable<Booking>) template.findByCriteria(
        DetachedCriteria.forClass(Booking.class).add(Restrictions.eq("listing.id", listing_id)));
  }

  public Booking findByListingIdAndId(Integer listing_id, Integer id)
      throws EntityNotFoundException {
    try {
      return (Booking) template
          .findByCriteria(
              DetachedCriteria.forClass(Booking.class)
                  .add(Restrictions.eq("listing.id", listing_id)).add(Restrictions.eq("id", id)),
              0, 1)
          .get(0);
    } catch (IndexOutOfBoundsException e) {
      throw new EntityNotFoundException("No Vehicle found with given Id");
    }
  }


}
