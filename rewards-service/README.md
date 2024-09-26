# Reward Service for Charter



## Technologies used:
* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6  is the default JPA implementation)
* H2 in-memory database
* Maven
* Java 17
* JUnit 5

## How to run it
```
$ git clone https://github.com/tapaskp/rewards.git

$ cd rewards-service (Where pom.xml is present)

$ run mvn clean package

$ ./mvnw spring-boot:run

			## OR run via eclipse/STS
			

$ import the project into STS

$ Right click on project Run As -> Maven clean

$ Right click on project Run As -> Maven install

$ Right click on project Run As -> Spring boot app
`````
## Database 
	Once the application is run,open url http://localhost:8080/h2-console
	Insert the data shared in data.sql file under resource directory
	Note::userName =sa ,password =password
## EndPoint
	Open Postman and put below url
	http://localhost:8080/api/rewards/1/3/total

## Swagger Implementation
	Add below dependency in pom.xml

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
			<version>2.0.3</version>
		</dependency>

	Swagger Url :: http://localhost:8080/swagger-ui/index.html
	
## Future development
	Create Customer service
	Authentication/Authorization
	User Input Validation
	
