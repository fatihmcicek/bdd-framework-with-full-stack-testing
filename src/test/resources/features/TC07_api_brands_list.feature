Feature: TC07 - API Brands List Operations
  As an API user
  I want to be able to get brands list
  So that I can use this data in my application

  @api @regression
  Scenario: TC07_01 - Get All Brands List
    Given I set the base API URL
    When I send GET request to "/brandsList" endpoint
    Then the response status code should be 200
    And the response should contain "responseCode" as "200"
    And the response should contain "brands" array

  @api @regression
  Scenario: TC07_02 - Post to Brands List
    Given I set the base API URL
    When I send POST request to "/brandsList" endpoint
    Then the response status code should be 200
    And the response should contain "responseCode" as "405"
    And the response should contain "message" as "This request method is not supported."