## Aeroparker Coding Challenge

 This application was built according to the specified requirements.

 It consists of a registration form with mandatory and optional fields, which are validated before being persisted to a MySQL database.

### Setup

Running the app can be done by following these steps:

- Clone the repository to your local machine
- In application.properties, fill in the username and password matching your local mySQL server
  (the application also works with an h2 in-memory database, but requires changes to the properties configuration)
- Run AeroparkerCodingChallengeApplication.java
- Access http://localhost:8080/registration in your browser

### Technologies used

- Spring Boot with Spring Web, Spring Data JPA, MySQL and H2 dependencies
- Java 17
- Thymeleaf and Bootstrap for web templating and styling

### Program structure

- User entity mapped to a customers table
- CRUD Repository
- Service layer where simple data validation and database persistence is executed
- Controller layer with Get and Post methods to handle data and exceptions
- HTML form and success pages to display data


## Thank you!