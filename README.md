# The-Blue-Basil-Restaurant App

To use this application, no external setup is required. Simply visit the live site here.


## Overview (Frontend/UI) ##
Language: Html, CSS, JavaScript
Technologies: Bootstrap, Flex,Thymeleaf

## Views ##

#### Homepage ####
![home](https://user-images.githubusercontent.com/88412294/177206275-fbdd1fbf-50b7-4487-8985-3cc59a436330.png)

#### Reservation Page ####
![res](https://user-images.githubusercontent.com/88412294/177206286-e3546097-9dcf-47c7-b437-ed402def43b8.png)

#### Reservation List ####
![res-list](https://user-images.githubusercontent.com/88412294/177206305-fe9c0ee1-703e-455e-9001-6f41fbb48f37.png)

#### Login ####
![login ](https://user-images.githubusercontent.com/88412294/177206316-89258bbd-470d-4db1-ba02-f33f845f0dae.png) <br/>

## Overview (Backend) ##
Language: Java 11 (Maven)
Technologies Used:Java, Spring Boot Framework, Spring Boot Web, Spring Boot Security, Spring Data JPA with Hibernate, MariaDB, Thymeleaf , Project Lombok, SQL, Junit 

## Models ##
![Screenshot 2022-07-01 161718](https://user-images.githubusercontent.com/88412294/177205611-b6026c30-07be-4528-88a6-7a5fffc322d5.png)
### DB Data ###
![Items](https://user-images.githubusercontent.com/88412294/177205686-f13f6b4a-21ef-43b9-a552-f00b20b8c703.png)

![users](https://user-images.githubusercontent.com/88412294/177205691-25b9b884-b584-4300-93ba-a987b85a464f.png)

![reservation](https://user-images.githubusercontent.com/88412294/177205699-75c7082e-3a87-4c03-a428-34b3467b378b.png)


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

## Project Management ##

![Screenshot 2022-07-04 114531](https://user-images.githubusercontent.com/88412294/177205882-095b2640-c888-4959-8e05-d2236fd040c4.png)
![Screenshot 2022-07-04 114451](https://user-images.githubusercontent.com/88412294/177205889-b13120bf-1827-4dde-ba2c-902bf29bb8e0.png)
![Screenshot 2022-07-04 114427](https://user-images.githubusercontent.com/88412294/177205899-b5b83261-1b70-4e96-8028-635e93aad2d4.png)
![Screenshot 2022-07-04 114334](https://user-images.githubusercontent.com/88412294/177205906-53854531-6b95-4362-aa2f-2cc93fba6c92.png)
