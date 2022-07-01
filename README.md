# The-Blue-Basil-Restaurant App

To use this application, no external setup is required. Simply visit the live site here.


## Overview (Frontend/UI) ##
Language: Html, CSS, JavaScript
Technologies: Bootstrap, Flex  Netlify Deployment,Thymeleaf

## Views ##

#### Homepage ####
#### Reservation Page ####
#### Reservation List ####
#### Login ####
#### Delete ####
#### Update ####






## Overview (Backend) ##
Language: Java 11 (Maven)
Technologies Used:Java, Spring Boot Framework, Spring Boot Web, Spring Boot Security, Spring Data JPA with Hibernate, MariaDB, Thymeleaf , Project Lombok, SQL, Junit 

## Models ##
![Screenshot 2022-06-28 150019](https://user-images.githubusercontent.com/88412294/176333571-6033412d-909b-41e1-b657-cdbff0e2cb2a.png)

## Architectural Design Choice ##
This app utilizes Springboot Model-View-Controller (MVC) design pattern. A description of how each concept is explained as follows.


#### Models ####
The model classes serves as the model portion of MVC design as it contains all the properties for a given model, allowing it to be interacted with directly by the controller
#### Views ####
The Frontend represents the View portion of MVC as it handles how to display the data received from the controller and is able to send requests for new data.
#### Controllers ####
Each model has a respective controller  which allows the models communicate changes to the view. In this case, it stores all the CRUD functionality of the app.

#### OOP Aspect ####
The principles of object-oriented programming was utilized in the development of this application several . The model/classes utilizes encapsulation as all its attributes are declared as private variables to prevent their values from being directly accessed except with through getter and setter methods(instantiated with Lombok).
The controllers utilizes inheritance as the controller class extends from a JpaRepository to have access to its built-in CRUD methods that can be reused through the app. 



