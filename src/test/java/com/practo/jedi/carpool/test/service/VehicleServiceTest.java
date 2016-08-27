package com.practo.jedi.carpool.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.jedi.carpool.exceptions.EntityNotFoundException;
import com.practo.jedi.carpool.model.VehicleModel;
import com.practo.jedi.carpool.run.Application;
import com.practo.jedi.carpool.service.VehicleService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class VehicleServiceTest {

  @Autowired
  private VehicleService service;

  @Test
  public void testGet() throws EntityNotFoundException {
    // Get All
    ArrayList<VehicleModel> vehicles = (ArrayList<VehicleModel>) service.get(1);
    assertEquals(2, vehicles.size());
    assertEquals(new Integer(1), vehicles.get(0).getUser().getId());
    assertEquals("X-Wing", vehicles.get(0).getModel());
    assertEquals("OB1KOB", vehicles.get(0).getNumberPlate());
    assertEquals(new Integer(1), vehicles.get(1).getUser().getId());
    assertEquals("Y-Wing", vehicles.get(1).getModel());
    assertEquals("BENKOB", vehicles.get(1).getNumberPlate());

    // Get One
    VehicleModel vehicle = service.get(1, 1);
    assertNotNull(vehicle);
    assertEquals(new Integer(1), vehicle.getUser().getId());
    assertEquals("X-Wing", vehicle.getModel());
    assertEquals("OB1KOB", vehicle.getNumberPlate());
    assertEquals(4, vehicle.getCapacity());
  }

  @Test
  public void testCreate() throws EntityNotFoundException {
    VehicleModel vehicle = new VehicleModel();
    vehicle.setModel("Death Star");
    vehicle.setNumberPlate("DTHSTR");
    vehicle.setCapacity(100000);
    vehicle = service.create(2, vehicle);

    VehicleModel dbVehicle = service.get(2, 4);
    assertNotNull(dbVehicle);
    assertEquals("Death Star", dbVehicle.getModel());
    assertEquals("DTHSTR", dbVehicle.getNumberPlate());
    assertEquals(100000, dbVehicle.getCapacity());
    assertEquals(new Integer(2), dbVehicle.getUser().getId());
  }

  @Test
  public void testUpdate() throws EntityNotFoundException {
    VehicleModel vehicle = service.get(2, 2);
    vehicle.setCapacity(2);
    service.update(vehicle.getUser().getId(), vehicle, 2);

    VehicleModel dbVehicle = service.get(2, 2);
    assertNotNull(dbVehicle);
    assertEquals(2, dbVehicle.getCapacity());
  }

  @Test(expected = EntityNotFoundException.class)
  public void testDelete() throws EntityNotFoundException {
    service.delete(1, 3);
    VehicleModel vehicle = service.get(1, 3);
    assertNull(vehicle);
  }
}
