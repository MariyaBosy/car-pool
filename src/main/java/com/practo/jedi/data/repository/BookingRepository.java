package com.practo.jedi.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.practo.jedi.data.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
