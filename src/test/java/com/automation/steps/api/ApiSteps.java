package com.automation.steps.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.Map;

public class ApiSteps {
    private Response response;

    @When("I send POST request to {string} endpoint with search query:")
    public void i_send_post_request_with_search_query(String endpoint, DataTable dataTable) {
        Map<String, String> searchData = dataTable.asMap(String.class, String.class);
        response = RestAssured.given()
                .formParam("search_product", searchData.get("search_product"))
                .when()
                .post(endpoint);
    }

    @When("I send POST request to {string} endpoint with credentials:")
    public void i_send_post_request_with_credentials(String endpoint, DataTable dataTable) {
        Map<String, String> credentials = dataTable.asMap(String.class, String.class);
        response = RestAssured.given()
                .formParam("email", credentials.get("email"))
                .formParam("password", credentials.get("password"))
                .when()
                .post(endpoint);
    }

    @When("I send POST request to {string} endpoint with user data:")
    public void i_send_post_request_with_user_data(String endpoint, DataTable dataTable) {
        Map<String, String> userData = dataTable.asMap(String.class, String.class);
        response = RestAssured.given()
                .formParams(userData)
                .when()
                .post(endpoint);
    }

    @Given("I set the base API URL")
    public void i_set_the_base_api_url() {
        RestAssured.baseURI = "https://automationexercise.com/api";
    }

    @When("I send GET request to {string} endpoint")
    public void i_send_get_request_to_endpoint(String endpoint) {
        response = RestAssured.given()
                .when()
                .get(endpoint);
    }

    @When("I send POST request to {string} endpoint")
    public void i_send_post_request_to_endpoint(String endpoint) {
        response = RestAssured.given()
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int expectedStatusCode) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode,
                "Status code is not as expected");
    }

    @Then("the response should contain {string} as {string}")
    public void the_response_should_contain_as(String field, String expectedValue) {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        Assert.assertEquals(jsonResponse.get(field).toString(), expectedValue,
                field + " value is not as expected");
    }

    @Then("the response should contain {string} array")
    public void the_response_should_contain_array(String arrayField) {
        JSONObject jsonResponse = new JSONObject(response.getBody().asString());
        Assert.assertTrue(jsonResponse.has(arrayField) &&
                        jsonResponse.getJSONArray(arrayField).length() > 0,
                arrayField + " array is not present or empty");
    }
}