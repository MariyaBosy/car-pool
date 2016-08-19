package com.practo.jedi.service;

import com.practo.jedi.model.BookingModel;

public interface BookingService {

  public Iterable<BookingModel> get();

  public BookingModel get(Integer id);

  public BookingModel create(BookingModel Booking);

  public BookingModel update(BookingModel Booking, Integer id);

  public void delete(Integer id);

}
