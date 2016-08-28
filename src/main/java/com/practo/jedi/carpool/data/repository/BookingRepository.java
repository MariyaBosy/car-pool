
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

  /**
   * Find all bookings of a user.
   * @param user_id Id of user
   * @return All bookings of the user
   */
  public Iterable<Booking> findByUserId(Integer user_id) {
    return (Iterable<Booking>) template.findByCriteria(
        DetachedCriteria.forClass(Booking.class).add(Restrictions.eq("user.id", user_id)));
  }

  /**
   * Find a booking by its id and the user's id.
   * @param user_id Id of the user
   * @param id Id of the booking
   * @return Booking
   * @throws EntityNotFoundException if booking does not exist.
   */
  public Booking findByUserIdAndId(Integer user_id, Integer id)
      throws EntityNotFoundException {
    try {
      return (Booking) template
          .findByCriteria(
              DetachedCriteria.forClass(Booking.class)
                  .add(Restrictions.eq("user.id", user_id)).add(Restrictions.eq("id", id)),
              0, 1)
          .get(0);
    } catch (IndexOutOfBoundsException err) {
      throw new EntityNotFoundException("No Booking found with given Id");
    }
  }


}
