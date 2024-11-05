Feature: TC06 - API Product List Operations
  As an API user
  I want to be able to get product list
  So that I can use this data in my application

  @api @regression
  Scenario: TC06_01 - Get All Products List
    Given I set the base API URL
    When I send GET request to "/productsList" endpoint
    Then the response status code should be 200
    And the response should contain "responseCode" as "200"
    And the response should contain "products" array

  @api @regression
  Scenario: TC06_02 - Post to All Products List
    Given I set the base API URL
    When I send POST request to "/productsList" endpoint
    Then the response status code should be 200
    And the response should contain "responseCode" as "405"
    And the response should contain "message" as "This request method is not supported."