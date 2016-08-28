
package com.practo.jedi.carpool.data.repository;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.practo.jedi.carpool.data.entity.Vehicle;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

@Repository
public class VehicleRepository extends EntityRepositoryImpl<Vehicle, Integer> {

  @Override
  public Class<Vehicle> getEntityClass() {
    return Vehicle.class;
  }
  
  /**
   * Find all vehicles of a user.
   * @param user_id Id of user
   * @return All vehicles of the user
   */
  public Iterable<Vehicle> findByUserId(Integer user_id) {
    return (Iterable<Vehicle>) template.findByCriteria(
        DetachedCriteria.forClass(Vehicle.class).add(Restrictions.eq("user.id", user_id)));
  }

  /**
   * Find a vehicle by its id and the user's id.
   * @param user_id Id of the user
   * @param id Id of the vehicle
   * @return Vehicle
   * @throws EntityNotFoundException if vehicle does not exist.
   */
  public Vehicle findByUserIdAndId(Integer user_id, Integer id) throws EntityNotFoundException {
    try {
      return (Vehicle) template
          .findByCriteria(DetachedCriteria.forClass(Vehicle.class)
              .add(Restrictions.eq("user.id", user_id)).add(Restrictions.eq("id", id)), 0, 1)
          .get(0);
    } catch (IndexOutOfBoundsException err) {
      throw new EntityNotFoundException("No Vehicle found with given Id");
    }
  }


}
