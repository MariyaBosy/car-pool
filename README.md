[![Travis-ci Build Status](https://travis-ci.org/pbaisla/car-pool.svg?branch=master)](https://travis-ci.org/pbaisla/car-pool)

# car-pool

A webapp for making it easier to car pool. Built with Spring boot.

## Usage

### Requirements

1. Java 8
2. Maven
3. MySQL

### How to run

1. Fill in your database details and other credentials in `application.properties`
2. Run `mvn clean install` to create a WAR
3. Place the created WAR file in tomcat's webapps directory

## Information

### API Documentation

The API documentation can be found [here on Apiary](http://docs.jedicarpool.apiary.io).

### ER Diagram

![ER Diagram](https://github.com/pbaisla/car-pool/blob/master/docs/car_pool_er_diag.png?raw=true)

For more information see [the wiki](https://github.com/pbaisla/car-pool/wiki).
