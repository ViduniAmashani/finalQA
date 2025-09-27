package com.example.book_management.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

 class BookApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080; // default Spring Boot port
    }

    @Test
    void testGetBooksWithAuth() {
        given()
                .auth().basic("admin", "admin123") // username & password from SecurityConfig
                .when()
                .get("/books")
                .then()
                .statusCode(200);
    }
}
