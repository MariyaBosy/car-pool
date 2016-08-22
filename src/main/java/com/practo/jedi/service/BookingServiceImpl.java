package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.entity.Booking;
import com.practo.jedi.data.repository.BookingRepository;
import com.practo.jedi.exceptions.EntityNotFoundException;
import com.practo.jedi.model.BookingModel;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  private BookingRepository repository;

  public BookingRepository getRepository() {
    return repository;
  }

  public Iterable<BookingModel> get(Integer listing_id) {
    Iterable<Booking> entities = repository.findByListingId(listing_id);
    ArrayList<BookingModel> models = new ArrayList<BookingModel>();
    for (Booking entity : entities) {
      BookingModel model = new BookingModel();
      try {
        model.fromEntity(entity);
        models.add(model);
      } catch (EntityNotFoundException e) {
        e.printStackTrace();
      }

    }
    return models;
  }

  public BookingModel get(Integer listing_id, Integer id) throws EntityNotFoundException {
    Booking entity = repository.findByListingIdAndId(listing_id, id);
    BookingModel model = new BookingModel();
    model.fromEntity(entity);
    return model;
  }

  public BookingModel create(Integer listing_id, BookingModel booking) {
    Booking entity = booking.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    try {
      booking.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return booking;
  }

  public BookingModel update(Integer listing_id, BookingModel booking, Integer id) {
    booking.setId(id);
    Booking entity = booking.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      booking.fromEntity(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
    }
    return booking;
  }

  public void delete(Integer listing_id, Integer id) {
    Booking entity = repository.findByListingIdAndId(listing_id, id);
    entity.setIsDeleted(true);
    entity.setDeletedAt(new Date());
    entity = repository.save(entity);
  }

}
