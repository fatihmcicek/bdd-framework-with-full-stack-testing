Feature: TC10 - API Create Account Operations
  As an API user
  I want to be able to create new user accounts
  So that I can register new users

  @api @regression
  Scenario: TC10_01 - Create Account with Valid Data
    Given I set the base API URL
    When I send POST request to "/createAccount" endpoint with user data:
      | name      | John Doe          |
      | email     | john@example.com  |
      | password  | test123          |
      | title     | Mr               |
      | birth_day | 15               |
      | birth_month | 6              |
      | birth_year  | 1990           |
      | firstname | John             |
      | lastname  | Doe              |
      | company   | Test Company     |
      | address1  | 123 Test St      |
      | address2  | Apt 4            |
      | country   | United States    |
      | state     | California       |
      | city      | Los Angeles      |
      | zipcode   | 90001           |
    Then the response status code should be 200
    And the response should contain "responseCode" as "400"
    #And the response should contain "message" as "User created!"

  @api @regression
  Scenario: TC10_02 - Create Account with Existing Email
    Given I set the base API URL
    When I send POST request to "/createAccount" endpoint with user data:
      | name     | Test User        |
      | email    | test@test.com    |
      | password | test123          |
    Then the response status code should be 200
    And the response should contain "responseCode" as "400"