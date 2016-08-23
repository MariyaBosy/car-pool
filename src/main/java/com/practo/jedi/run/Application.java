package com.practo.jedi.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ImportResource("classpath:hibernate.xml")
@ComponentScan("com.practo.jedi")
@EnableJpaRepositories("com.practo.jedi.data")
@EntityScan("com.practo.jedi.data.entity")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
