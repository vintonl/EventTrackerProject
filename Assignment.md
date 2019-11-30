## Event Tracker

### Overview

'Event Tracker' is a broad term for anything that keeps track of information over time. Examples of these applications are 'Mint' (financial tracking) and 'MyFitnessPal' (diet and exercise tracker). These are very involved applications with a huge feature set.

You are embarking on a weekend project that you may or may not come back to afterwards, thus we would caution you to limit your scope significantly. Examples of limited scope would be 'Gas Tracker' (keep track of your fill ups and total mileage to determine dollar/gallon in your car) or 'Timesheet' (track time in and time out to calculate total hours at some rate of pay).  

### Learning Objectives

* Create a JPA Project
  * Create a Java entity class POJO that models your database table.
  * Map your POJO using JPA.

* Configure a Spring Boot app to publish a REST API.
  * Use Spring REST annotations.
  * Use Spring Data JPA to perform all CRUD operations.
  * Send and receive JSON.

### Where to start?

1. Create a new STS workspace for your project.
   1. Initialize your workspace with `git`.
   1. Associate your workspace with a Github repo named **EventTrackerProject**.
1. Use MySQL Workbench to create a database schema with a single table.
   * Be sure to create a _appusername_@localhost account with a password for your database.
   * Include some initial sample data.
1. Create a Gradle Project for your JPA entity and tests.
1. Create a Spring Boot project for your REST API controller(s), service, and Spring Data JPA repository.
1. Create controller logic to perform the basic CRUD operations of a REST API.
   * Test these routes using *Postman*
1. Deploy your project to your EC2 instance, and link to it from your portfolio web site.

### Goal

Your objective for this project should be to do as much as you can. That is not to say as many features, but as much as you actually understand.

Do not move onto the next step until you actually know what you just did and feel comfortable with what is happening. If you reach a point and are confused about what you are doing, or what you have done, ask questions, look for resources, or start over on that piece to ensure that you are comfortable with it.  

Make sure to commit and push once you have an MVP with full CRUD operations working.

##### Stretch Goals
* JUnit tests for your repository, service, and controller layers.
* Supplemental tables, mappings, and controller routes for nested CRUD.

#### Grading

This is a graded project.  You are expected to have your project completed by noon on Monday.  

Your project must be pushed to a Github repo named **EventTrackerProject**.

You must include a _README.md_ that describes your program and how to access it on AWS.  This must document your REST route URIs and HTTP methods, and what they do.

You must also deploy your app to your AWS server.

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

  * A new event object implements full CRUD.  
  * All interactions with the database are done so RESTfully.  

If the project does work with all of the above test conditions, you will be given a *1* for this week's project.

If the project does not work with the above test conditions, you will be given a *0* for this week's project.

If you get a zero on the project, you can upgrade to a score of *.5* if you turn in a working project by the start of class the following Monday morning AND notify an instructor that you wish to get partial credit.
