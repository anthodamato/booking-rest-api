# Booking Rest Api
Simple endpoint to book a vaccine.  
The database is Apache Derby. It's not used as an in memory db.  

Java 17  
Maven v3.9.6  
Spring Boot v3  

### Database setup
##### Pull Apache Derby image
docker pull az82/docker-derby:10.16

##### Run Apache Derby container
docker run -d -p 1527:1527 --name derby -t az82/docker-derby:10.16

### Build
mvn clean package -Dmaven.test.skip

### Run tests
mvn test
