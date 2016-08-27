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
import com.practo.jedi.carpool.model.AddressModel;
import com.practo.jedi.carpool.model.SourceModel;
import com.practo.jedi.carpool.run.Application;
import com.practo.jedi.carpool.service.SourceService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SourceServiceTest {

  @Autowired
  private SourceService service;

  @Test
  public void testGet() throws EntityNotFoundException {
    SourceModel source = service.get(1);
    assertNotNull(source);
    assertEquals("Coruscant", source.getName());
    assertEquals(new Integer(1), source.getAddress().getId());
  }

  @Test
  public void testCreate() throws EntityNotFoundException {
    AddressModel address = new AddressModel();
    address.setId(2);
    SourceModel source = new SourceModel();
    source.setName("Yavin 5");
    source.setAddress(address);

    source = service.create(source);
    SourceModel dbSource = service.get(4);
    assertNotNull(dbSource);
    assertEquals("Yavin 5", dbSource.getName());
    assertEquals(new Integer(2), dbSource.getAddress().getId());
  }

  @Test
  public void testUpdate() throws EntityNotFoundException {
    SourceModel source = service.get(2);
    source.setName("Twin suns planet");

    service.update(source, 2);

    SourceModel dbSource = service.get(2);
    assertNotNull(dbSource);
    assertEquals("Twin suns planet", dbSource.getName());
  }

  @Test(expected = EntityNotFoundException.class)
  public void testDelete() throws EntityNotFoundException {
    service.delete(3);
    SourceModel source = service.get(3);
    assertNull(source);
  }
}
