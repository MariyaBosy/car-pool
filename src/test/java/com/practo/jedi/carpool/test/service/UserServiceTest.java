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
import com.practo.jedi.carpool.model.UserModel;
import com.practo.jedi.carpool.run.Application;
import com.practo.jedi.carpool.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

  @Autowired
  private UserService service;

  @Test
  public void testGet() throws EntityNotFoundException {
    // Get All
    ArrayList<UserModel> users = (ArrayList<UserModel>) service.get();
    assertEquals(users.size(), 2);
    assertEquals("Obi-wan Kenobi", users.get(0).getName());
    assertEquals("Anakin Skywalker", users.get(1).getName());
  
    // Get One
    UserModel user = service.get(1);
    assertNotNull(user);
    assertEquals("Obi-wan Kenobi", user.getName());
    assertEquals("ben@jedi.org", user.getEmail());
    assertEquals("1111111111", user.getPhone());
  }
  
  @Test
  public void testFindByEmail() {
    UserModel user = service.findByEmail("ben@jedi.org");
    assertNotNull(user);
    assertEquals("Obi-wan Kenobi", user.getName());
    assertEquals("ben@jedi.org", user.getEmail());
  }

  @Test
  public void testCreate() throws EntityNotFoundException {
    UserModel user = new UserModel();
    user.setName("Luke");
    user.setEmail("luke@rebellion.org");
    user.setPhone("1234567890");
    user = service.create(user);
    UserModel dbUser = service.get(3);
    assertNotNull(dbUser);
    assertEquals("Luke", dbUser.getName());
    assertEquals("luke@rebellion.org", dbUser.getEmail());
    assertEquals("1234567890", dbUser.getPhone());
  }

  @Test
  public void testUpdate() throws EntityNotFoundException {
    UserModel user = service.get(2);
    user.setName("Darth Vader");
    user.setEmail("vader@sith.net");

    service.update(user, 2);

    UserModel dbUser = service.get(2);
    assertNotNull(dbUser);
    assertEquals("Darth Vader", dbUser.getName());
    assertEquals("vader@sith.net", dbUser.getEmail());
  }

  @Test(expected = EntityNotFoundException.class)
  public void testDelete() throws EntityNotFoundException {
    service.delete(1);
    UserModel user = service.get(1);
    assertNull(user);
  }
}
