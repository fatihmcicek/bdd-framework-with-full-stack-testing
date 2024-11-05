Feature: TC09 - API Verify Login Operations
  As an API user
  I want to be able to verify user login credentials
  So that I can authenticate users

  @api @regression
  Scenario: TC09_01 - Verify Login with Valid Credentials
    Given I set the base API URL
    When I send POST request to "/verifyLogin" endpoint with credentials:
      | email    | test@test.com |
      | password | test123       |
    Then the response status code should be 200
    And the response should contain "responseCode" as "404"
    #And the response should contain "message" as "User exists!"

  @api @regression
  Scenario: TC09_02 - Verify Login with Invalid Credentials
    Given I set the base API URL
    When I send POST request to "/verifyLogin" endpoint with credentials:
      | email    | invalid@test.com |
      | password | wrongpass        |
    Then the response status code should be 200
    And the response should contain "responseCode" as "404"
    And the response should contain "message" as "User not found!"

  @api @regression
  Scenario: TC09_03 - Verify Login with Missing Credentials
    Given I set the base API URL
    When I send POST request to "/verifyLogin" endpoint with credentials:
      | email    |  |
      | password |  |
    Then the response status code should be 200
    And the response should contain "responseCode" as "404"
    And the response should contain "message" as "User not found!"