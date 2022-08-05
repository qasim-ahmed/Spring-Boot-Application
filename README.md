# Spring-Boot-Application

The Spring Boot Application uses MySQL as the underlying database and data access has been done using JPA. The REST API end points have been tested locally and are fully functional.
Below are the steps to dockerize the application.

1. Pull the mysql image from docker hub
2. Run the command docker run -d -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=employees mysql
3. There is a docker file present in root directory of project. 
4. Run this command in root directory docker build -t springbootapp .
5. Run the command docker network create app-network
6. Finally run the command docker run -p 9090:8080 --name appcontainer --net app-network -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=root -e MYSQL_PORT=3306 springbootapp




