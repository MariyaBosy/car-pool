[![Travis-ci Build Status](https://travis-ci.org/pbaisla/car-pool.svg?branch=master)](https://travis-ci.org/pbaisla/car-pool)

# car-pool

A webapp for making it easier to car pool.
Users can post vacant seats in their cars travelling to a particular location.
Users can also search and filter listings and book seats in cars.

## Information

### Project Plans

The project plan can be found [here](https://docs.google.com/a/practo.com/spreadsheets/d/1ZWKIENGZQZYOi_ZfI0HVAXg2QmgcdGLZjFezdxuLZCA/).

### Requirements

The requirements for the application can be found [in the wiki, here](https://github.com/pbaisla/car-pool/wiki/Requirements)

### API Documentation

The API documentation can be found [here on Apiary](http://docs.jedicarpool.apiary.io).

### ER Diagram

![ER Diagram](https://github.com/pbaisla/car-pool/blob/master/docs/car_pool_er_diag.png?raw=true)

### Tools and Tech

1. Java 8
2. Maven
3. Spring Boot MVC Framework
4. MySQL (Production DB)
5. Hibernate
6. HSQLdb (Test DB)
7. [New Relic](https://rpm.newrelic.com/accounts/1410232/applications/31693240)
8. [Travis CI](https://travis-ci.org/pbaisla/car-pool)
9. [AWS EC2](http://ec2-52-66-60-159.ap-south-1.compute.amazonaws.com/car-pool/)
10. [JaCoCo](http://ec2-52-66-60-159.ap-south-1.compute.amazonaws.com/car-pool/jacoco/index.html) For code average analysis
11. [JavaDoc](http://ec2-52-66-60-159.ap-south-1.compute.amazonaws.com/car-pool/doc/index.html) Code documentation
12. [Apiary](http://docs.jedicarpool.apiary.io/)
13. Checkstyle
14. Codeformatter

## Usage

### Requirements

1. Java 8
2. Maven
3. MySQL

### How to run

1. Fill in your database details and other credentials in `application.properties`
2. Run `mvn clean install` to create a WAR
3. Place the created WAR file in tomcat's webapps directory

For more information see [the wiki](https://github.com/pbaisla/car-pool/wiki).
