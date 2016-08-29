package com.practo.jedi.carpool.service;

import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practo.jedi.carpool.data.entity.Booking;
import com.practo.jedi.carpool.data.entity.Listing;
import com.practo.jedi.carpool.data.repository.BookingRepository;
import com.practo.jedi.carpool.data.repository.ListingRepository;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.BookingModel;
import com.practo.jedi.carpool.model.UserModel;

@Service
public class BookingServiceImpl implements BookingService {
  private static final Logger LOG = Logger.getLogger(BookingServiceImpl.class);

  @Autowired
  private BookingRepository repository;

  @Autowired
  private ListingRepository listingRepository;


  @Override
  public Iterable<BookingModel> get(Integer user_id) {
    Iterable<Booking> entities = repository.findByUserId(user_id);
    ArrayList<BookingModel> models = new ArrayList<BookingModel>();
    for (Booking entity : entities) {
      BookingModel model = new BookingModel();
      try {
        model.fromEntity(entity);
        models.add(model);
      } catch (EntityNotFoundException err) {
        LOG.error(err);
      }

    }
    return models;
  }


  @Override
  public BookingModel get(Integer user_id, Integer id) throws EntityNotFoundException {
    Booking entity = repository.findByUserIdAndId(user_id, id);
    BookingModel model = new BookingModel();
    model.fromEntity(entity);
    return model;
  }



  @Override
  public BookingModel create(Integer user_id, BookingModel booking) throws EntityNotFoundException {
    UserModel user = new UserModel();
    user.setId(user_id);
    booking.setUser(user);
    Listing listing = listingRepository.findOne(booking.getListing().getId());
    int seats = listing.getSeatsAvailable();
    if (seats > 0) {
      listing.setSeatsAvailable(seats - 1);
      listing.setModifiedAt(new Date());
      listingRepository.save(listing);
      Booking entity = booking.toEntity();
      entity.setCreatedAt(new Date());
      entity = repository.save(entity);
      try {
        booking.fromEntity(entity);
      } catch (EntityNotFoundException err) {
        LOG.error(err);
      }
      return booking;
    }
    LOG.error("Tried to book with 0 seats available");
    return null;
  }


  @Override
  public BookingModel update(Integer user_id, BookingModel booking, Integer id)
      throws EntityNotFoundException {
    UserModel user = new UserModel();
    user.setId(user_id);
    booking.setUser(user);
    booking.setId(id);
    Booking entity = booking.toEntity();
    entity.setModifiedAt(new Date());
    entity = repository.save(entity);
    try {
      booking.fromEntity(entity);
    } catch (EntityNotFoundException err) {
      LOG.error(err);
    }
    return booking;
  }


  @Override
  public void delete(Integer user_id, Integer id) throws EntityNotFoundException {
    repository.delete(id);
  }

}
