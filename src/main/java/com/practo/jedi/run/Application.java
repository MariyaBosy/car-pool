package com.practo.jedi.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.practo.jedi.controller")
@EnableJpaRepositories("com.practo.jedi.repository")
@EntityScan("com.practo.jedi.data.entity")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
