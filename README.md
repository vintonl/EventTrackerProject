# Beverage Tracker

## JPA Full Stack Midterm Project

### Week 12 Project at Skill Distillery - November 30, 2019

Built by:
* [Vinton Lee](https://github.com/vintonl)

This was a weekend project to exceed the minimum viable product for our Event Tracker [assignment](https://github.com/vintonl/EventTrackerProject/blob/master/Assignment.md).

### Overview:

This program is designed to be a full stack website application that creates, reads, updates and deletes user and recipe data from a database we built using MySQL Workbench and connecting with using Java Database Connectivity.

### How to run:

Access the REST API by the following route:

### Routes

| Return Type    | Route                 | Functionality            |
|----------------|-----------------------|--------------------------|
| `List<Beverage>` |`GET api/beverages`| Get all beverages   |
| `Beverage`       |`GET api/beverages/{id}`| Get one beverage by id |
| `Beverage`       |`PUT api/beverages/{id}`| Update a beverage by id|
| `Void`       |`DELETE api/beverages/{id}`| Delete a beverage by id|
| `List<Beverage>` |`GET api/beverages/caffeinated`| Get all beverages   |
| `List<Beverage>` |`GET api/beverages/name/{keyword}`| Get all beverages by keyword search of name   |
| `List<Beverage>` |`GET api/beverages/date/{date}`| Get all beverages by date (yyyy-MM-dd)   |
| `List<User>` |`GET api/users`| Get all users   |

### Technologies used:

Java, Java Persistence API, REST API, Spring Boot, Gradle, MySQL Workbench, Postman, JSON, Apache, Tomcat, AWS, Atom, Git, and GitHub.

### Topics implemented:

Spring REST annotations.

Spring Data JPA to perform all CRUD operations.

Send and receive JSON.

Tomcat 8 on AWS EC2 Instance.

Object-Relational Mapping (ORM).

Relational Database: SQL Database creation using MySQL Workbench.

Object-Oriented Programming in Java: Abstraction, Polymorphism, Inheritance, and Encapsulation.

Test Driven Development using JUNIT Juniper.

### Lessons learned:

This project helped me better grasp the capabilities of REST API by allowing me to better learn how to:
* Create a JPA Project
  * Create a Java entity class POJO that models your database table.
  * Map your POJO using JPA.

* Configure a Spring Boot app to publish a REST API.
  * Use Spring REST annotations.
  * Use Spring Data JPA to perform all CRUD operations.
  * Send and receive JSON.
