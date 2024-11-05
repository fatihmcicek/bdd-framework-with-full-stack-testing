package com.automation.api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    private final String baseUrl = "https://automationexercise.com/api";
    private RequestSpecification request;

    public ApiClient() {
        request = RestAssured.given()
                .baseUri(baseUrl)
                .contentType("application/json");
    }

    public Response get(String endpoint) {
        return request.get(endpoint);
    }

    public Response post(String endpoint, Object body) {
        return request.body(body).post(endpoint);
    }

    public Response put(String endpoint, Object body) {
        return request.body(body).put(endpoint);
    }

    public Response delete(String endpoint) {
        return request.delete(endpoint);
    }
}