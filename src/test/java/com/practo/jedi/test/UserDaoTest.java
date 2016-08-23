package com.practo.jedi.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.practo.jedi.data.repository.SimpleUserDao;
import com.practo.jedi.run.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserDaoTest {

  @Autowired
  private SimpleUserDao userDao;



  @Test
  public void testGet() {
    userDao.getUser(1);
    System.out.println(userDao);
  }
}