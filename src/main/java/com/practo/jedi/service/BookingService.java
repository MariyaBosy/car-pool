package com.practo.jedi.service;

import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.BookingModel;

public interface BookingService {

  public Iterable<BookingModel> get(Integer listing_id);

  public BookingModel get(Integer listing_id, Integer id) throws EntityNotFoundException;

  public BookingModel create(Integer listing_id, BookingModel Booking);

  public BookingModel update(Integer listing_id, BookingModel Booking, Integer id);

  public void delete(Integer listing_id, Integer id);

}
