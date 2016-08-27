package com.practo.jedi.carpool.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.BookingModel;
import com.practo.jedi.carpool.model.ListingModel;
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.run.Application;
import com.practo.jedi.carpool.service.BookingService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class BookingServiceTest {

  @Autowired
  private BookingService service;

  @Test
  public void testGet() throws EntityNotFoundException {
    BookingModel booking = service.get(1, 1);
    assertNotNull(booking);
    assertEquals(new Integer(1), booking.getUser().getId());
    assertEquals(new Integer(1), booking.getListing().getId());
  }

  @Test
  public void testCreate() throws EntityNotFoundException {
    BookingModel booking = new BookingModel();
    ListingModel listing = new ListingModel();
    listing.setId(1);
    booking.setListing(listing);
    booking = service.create(2, booking);

    BookingModel dbBooking = service.get(2, 4);
    assertNotNull(dbBooking);
    assertEquals(new Integer(2), dbBooking.getUser().getId());
    assertEquals(new Integer(1), dbBooking.getListing().getId());
    }

  @Test
  public void testUpdate() throws EntityNotFoundException {
    BookingModel booking = service.get(2, 2);
    ListingModel listing = new ListingModel();
    listing.setId(1);
    booking.setListing(listing );
    service.update(booking.getUser().getId(), booking, 2);

    BookingModel dbBooking = service.get(2, 2);
    assertNotNull(dbBooking);
    assertEquals(new Integer(1), dbBooking.getListing().getId());
  }

  @Test(expected = EntityNotFoundException.class)
  public void testDelete() throws EntityNotFoundException {
    service.delete(1, 3);
    BookingModel booking = service.get(1, 3);
    assertNull(booking);
  }
}
