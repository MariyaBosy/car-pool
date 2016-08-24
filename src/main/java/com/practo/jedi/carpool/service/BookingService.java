package com.practo.jedi.carpool.service;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.BookingModel;

public interface BookingService {

  public Iterable<BookingModel> get(Integer listing_id);

  public BookingModel get(Integer listing_id, Integer id) throws EntityNotFoundException;

  public BookingModel create(Integer listing_id, BookingModel Booking) throws EntityNotFoundException;

  public BookingModel update(Integer listing_id, BookingModel Booking, Integer id) throws EntityNotFoundException;

  public void delete(Integer listing_id, Integer id) throws EntityNotFoundException;

}
