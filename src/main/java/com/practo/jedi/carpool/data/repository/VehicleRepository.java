
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

  public Iterable<Vehicle> findByUserId(Integer user_id) {
    return (Iterable<Vehicle>) template.findByCriteria(
        DetachedCriteria.forClass(Vehicle.class).add(Restrictions.eq("user.id", user_id)));
  }

  public Vehicle findByUserIdAndId(Integer user_id, Integer id) throws EntityNotFoundException {
    try {
      return (Vehicle) template
          .findByCriteria(DetachedCriteria.forClass(Vehicle.class)
              .add(Restrictions.eq("user.id", user_id)).add(Restrictions.eq("id", id)), 0, 1)
          .get(0);
    } catch (IndexOutOfBoundsException e) {
      throw new EntityNotFoundException("No Vehicle found with given Id");
    }
  }


}
