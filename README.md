# people-repo
The repository has the CRUD API rest service implementation

# About
This is a simple demo for building CRUD REST web services using Spring Boot+JPA+MySQL. This demo simply provides Create/Read/Update/Delete rest services for a MySQL table people. Thanks to few internet authors for providing examples regarding the same.

# Requirements
This demo is build with Java 1.8 and Maven 3.

# Running the application
The above application is a maven application and can be started just by command "mvn clean install"and then go to target folder and run the command "java -jar people-example.jar"

# About the Database
The application uses MySQL DB for running. You can feel free to use in memory DB like H2 to run the code. Simply comment the application.resources property fileand add h2 to the pom.xml like below:

 <dependency><groupId>com.h2database</groupId><artifactId>h2</artifactId></dependency>
 
# Functionalities
The application will run at http://localhost:8080. If you are using spring boot to run the application, your automatic tomcat instance will kick in and the application can be accessed directly. (http://localhost:8080/people). If you deploy the jar/war file to a server, then you can access it using the URL (http://localhost:8080/people-example/people).

1. /people - GET Gets the list of people entity
2. /people - POST Creates a new entity
3. /people/{id} - GET Gets entity by given Id
4. /people/{id} - PUT Updates the already existing entity
5. /people/{id} - DELETE Deletes the entity

# Additional notes

1. Custom error handling has been done as part of this application
2. Unit tests and component tests have been written (More tests will follow later)
3. No UI component yet (To be developed may be using bootstrap)

