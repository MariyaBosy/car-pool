package com.practo.jedi.carpool.data.repository;

import java.math.BigDecimal;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.practo.jedi.carpool.data.entity.Address;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

@Repository
public class AddressRepository extends EntityRepositoryImpl<Address, Integer> {

  @Override
  public Class<Address> getEntityClass() {
    return Address.class;
  }

  /**
   * Find an address by its latitude and longitude.
   * @param latitude Latitude of the address
   * @param longitude Longitude of the address
   * @return Address
   * @throws EntityNotFoundException If address not found
   */
  public Address findByLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude)
      throws EntityNotFoundException {
    try {
      return (Address) template.findByCriteria(DetachedCriteria.forClass(Address.class)
          .add(Restrictions.eq("latitude", latitude)).add(Restrictions.eq("longitude", longitude)),
          0, 1).get(0);
    } catch (IndexOutOfBoundsException err) {
      throw new EntityNotFoundException("No Address found with given Id");
    }
  }

}
