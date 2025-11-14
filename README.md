# Booking Rest Api
Simple endpoint to book a vaccine.  
The database is Apache Derby. It's not used as an in memory db.  

Java 21  
Maven v3.9.6  
Spring Boot v3  

### Database setup
##### Create Docker network
docker network create derby-network  

##### Pull Apache Derby image
docker pull az82/docker-derby:10.16  

##### Run Apache Derby container
docker run -d -p 1527:1527 --name derby --network derby-network -t az82/docker-derby:10.16

### Build
mvn clean package -Dmaven.test.skip

docker build -t adamato/vaccine-booking .  
docker run -d -p 8080:8080 --name vaccine-booking --network derby-network adamato/vaccine-booking  


### Run tests
mvn test -Dspring.profiles.active=test  

### Run locally  
mvn spring-boot:run -Dspring-boot.run.profiles=local  
