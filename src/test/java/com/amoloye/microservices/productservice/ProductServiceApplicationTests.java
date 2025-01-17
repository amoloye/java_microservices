package com.amoloye.microservices.productservice;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;



@Import(TestcontainersConfiguration.class)
//this makes the test environment not conflict with our main application port:8080
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ProductServiceApplicationTests {

    //initialize our test container
    //what service connection does is it automatically use the username and password configuration
    // in the application.properties file
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    //when the random port starts, localServerPort captures it and gives it the variable name port
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    //to start the mongodb testcontainers before starting the test
    static{
        mongoDBContainer.start();
    }

    @Test
    void shouldCreateProduct() {
        //request body is a new feature which takes in the new request to create the product
        String requestBody = """
                {
                "name": "iPhone 15",
                "description": "iPhone 15 is a smartphone from Apple",
                "price": 1000
                }
                """;

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/product")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("iPhone 15"))
                .body("description", Matchers.equalTo("iPhone 15 is a smartphone from Apple"))
                .body("price", Matchers.equalTo(1000));

    }

}
