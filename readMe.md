# Falcon Airlines Booking System

## Overview
This project implements an Airline Booking System for Falcon Airlines using Java and MySQL. The application allows passengers to book flights, view existing reservations, and cancel bookings while storing all airline data in a MySQL database.

The system demonstrates how a Java application can securely connect to a remote database server and perform full CRUD (Create, Read, Update, Delete) operations using JDBC.

---

## Project Objective
To create a Java-based application that interacts with a MySQL database to manage airline-related data such as airports, flight schedules, passengers, and bookings through a menu-driven interface.

---

## System Description
The program connects to a specified MySQL server using credentials provided at runtime. Once connected, users interact with the system through menus that allow database creation, table management, and passenger booking operations.

The system supports two primary modes of interaction:
- Employee operations (database and table management)
- Passenger operations (booking management)

---

## Important Configuration Notes
- The ONLY class that should be modified to change database connection details is `Main.java`
- Database connection parameters are passed into a `ConnectionHandler` object inside `Main`
- DO NOT modify any other classes
- The program will prompt for the MySQL server password at runtime
- All menu selections are INTEGER-SENSITIVE — only integers should be used when selecting menu options

---

## Database Requirements
- The passenger menu automatically connects to a database named:
  
  Falcon_Airlines

- This database MUST exist for passenger operations to function correctly
- If the database does not exist, it must be created using the employee menu before continuing

---

## Features
- Secure MySQL server connection using JDBC
- Full CRUD operations on airline data
- Employee menu for database and table creation
- Passenger menu for booking management
- Menu-driven user interface
- Modular database access design

---

## Core Database Functions

create_connection()
Establishes a connection to the MySQL server using JDBC credentials supplied in Main.java.

create_table()
Allows creation of airline-related tables using complete MySQL CREATE TABLE queries.

insert_booking()
Adds a new booking record to the Falcon_Airlines database.

view_booking()
Displays booking information for a passenger.

delete_booking()
Deletes an existing booking, allowing passengers to cancel reservations.

---

## User Menus

Employee Menu:
- Create databases
- Create tables using custom MySQL queries
- Inspect database structure

Passenger Menu:
- Book a flight
- View reservation
- Cancel reservation

Passenger operations automatically target the Falcon_Airlines database.

---

## How to Install and Run

### Prerequisites
- Java Development Kit (JDK 19 or newer)
- MySQL Server
- MySQL Connector/J (mysql-connector-j-9.1.0 or higher)

### Steps
1. Download and install MySQL Connector/J and add it to your project classpath

2. Ensure a MySQL server is running and accessible

3. Open `Main.java` and configure:
   - Server URL
   - Username
   - (Optional) default database name

4. Compile the program:
   javac *.java

5. Run the program:
   java Main

6. Enter the MySQL server password when prompted

---

## Technologies Used
- Java
- MySQL
- JDBC
- SQL
- MySQL Connector/J


