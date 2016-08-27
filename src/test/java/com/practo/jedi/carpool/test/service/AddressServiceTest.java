package com.practo.jedi.carpool.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.run.Application;
import com.practo.jedi.carpool.service.AddressService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AddressServiceTest {

  @Autowired
  private AddressService service;

  @Test
  public void testGet() throws EntityNotFoundException {
    // Get All
    ArrayList<AddressModel> addresss = (ArrayList<AddressModel>) service.get();
    assertEquals(3, addresss.size());
    assertEquals("Jedi Temple, Coruscant", addresss.get(0).getFormattedAddress());
    assertEquals("Podracing Arena, Tatooine", addresss.get(1).getFormattedAddress());
    assertEquals("Rebel Base, Yavin 4", addresss.get(2).getFormattedAddress());
    
    // Get One
    AddressModel address = service.get(1);
    assertNotNull(address);
    assertEquals("Jedi Temple, Coruscant", address.getFormattedAddress());
    assertEquals(new BigDecimal("1.11000000"), address.getLatitude());
    assertEquals(new BigDecimal("2.22000000"), address.getLongitude());
  }

  @Test
  public void testCreate() throws EntityNotFoundException {
    AddressModel address = new AddressModel();
    address.setLatitude(new BigDecimal("1.23000000"));
    address.setLongitude(new BigDecimal("-1.23000000"));
    address.setFormattedAddress("Rebel Base, Hoth");;
    address = service.create(address);
    AddressModel dbAddress = service.get(4);
    assertNotNull(dbAddress);
    assertEquals(new BigDecimal("1.23000000"), dbAddress.getLatitude());
    assertEquals(new BigDecimal("-1.23000000"), dbAddress.getLongitude());
    assertEquals("Rebel Base, Hoth", dbAddress.getFormattedAddress());
  }

  @Test
  public void testUpdate() throws EntityNotFoundException {
    AddressModel address = service.get(2);
    address.setFormattedAddress("Mos Eisley Cantina");

    service.update(address, 2);

    AddressModel dbAddress = service.get(2);
    assertNotNull(dbAddress);
    assertEquals("Mos Eisley Cantina", dbAddress.getFormattedAddress());
  }

  @Test(expected = EntityNotFoundException.class)
  public void testDelete() throws EntityNotFoundException {
    service.delete(3);
    AddressModel address = service.get(3);
    assertNull(address);
  }
}
