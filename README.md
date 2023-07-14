# Rent-App

The "Rent Car App" is a web application designed for managing a car rental service. It provides various features related to car management, reservations, user accounts, and administration.

Endpoints and Features:

Car Management:

/admin/cars (GET): Retrieves a list of all cars and displays them in the admin cars view.
/admin/cars/newcar (GET): Displays the form to add a new car in the admin create car view.
/admin/cars (POST): Creates a new car based on the form data submitted in the admin create car view.
/admin/cars/{carID}/edit (GET): Displays the form to edit the details of a specific car in the admin edit car view.
/admin/cars/{carID} (POST): Updates the details of a specific car based on the form data submitted in the admin edit car view.
/admin/cars/{carID}/delete (GET): Deletes a specific car from the system.
Car Reservations:

/car/{carUrl} (GET): Displays detailed information about a specific car, including the option to make a reservation.
/car/{carUrl}/reservation (GET): Displays the reservation form for a specific car.
/car/{carUrl}/reservation/makereservation (POST): Handles the submission of the reservation form, checks the availability of the car, and creates a reservation if available.
/my_reservations (GET): Displays all reservations made by the logged-in user.
/my_reservations/{userId}/delete/{reservationId} (GET): Deletes a specific reservation made by the logged-in user.

User Account Management:


/login (GET): Displays the login page.
/register (GET): Displays the registration form for creating a new user account.
/register/save (POST): Handles the submission of the registration form, validates the form data, and creates a new user account.
/admin/administration_users (GET): Retrieves a list of guest users and displays them in the admin users view.
/admin/administration_users/{userId}/delete (GET): Deletes a specific guest user from the system.
/admin/administration_users/{userId}/view (GET): Displays detailed information about a specific guest user in the admin view user page.

Tech Stack:

Java 17 - Programming language for implementing the application.
Spring Boot - Framework for building web applications.
Thymeleaf - HTML template engine for rendering views.
Hibernate - Object-Relational Mapping (ORM) tool for database interaction.
MySQL - Database for storing car and user information.
Lombok - Library for reducing boilerplate code.
H2 DB - In-memory database for testing purposes.
Open API - Specification for documenting and testing the API endpoints.
