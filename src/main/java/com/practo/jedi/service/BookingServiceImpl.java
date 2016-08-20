package com.practo.jedi.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.data.entity.Booking;
import com.practo.jedi.data.repository.BookingRepository;
import com.practo.jedi.model.BookingModel;

@Service
public class BookingServiceImpl implements BookingService {

  @Autowired
  private BookingRepository repository;

  public BookingRepository getRepository() {
    return repository;
  }

  public Iterable<BookingModel> get() {
    Iterable<Booking> entities = repository.findAll();
    ArrayList<BookingModel> models = new ArrayList<BookingModel>();
    for (Booking entity : entities) {
      BookingModel model = new BookingModel();
      model.fromEntity(entity);
      models.add(model);
    }
    return models;
  }

  public BookingModel get(Integer id) {
    Booking entity = repository.findOne(id);
    BookingModel model = new BookingModel();
    model.fromEntity(entity);
    return model;
  }

  public BookingModel create(BookingModel booking) {
    Booking entity = booking.toEntity();
    entity.setCreatedAt(new Date());
    entity = repository.save(entity);
    booking.fromEntity(entity);
    return booking;
  }

  public BookingModel update(BookingModel booking, Integer id) {
    booking.setId(id);
    Booking entity = booking.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    booking.fromEntity(entity);
    return booking;
  }

  public void delete(Integer id) {
    Booking entity = repository.findOne(id);
    entity.setIsDeleted(true);
    entity.setDeletedAt(new Date());
    entity = repository.save(entity);
  }

}
