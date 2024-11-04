Feature: TC02 - Login Functionality and User Session Management
  As a user
  I want to be able to login with my credentials
  And manage my session securely

  Background: Register a new user
    Given I am on the home page
    When I click on Signup Login button
    Then I should see "New User Signup!" text
    When I enter name "John Doe"
    And I enter email address for registration
    And I click Signup button
    Then I should see "ENTER ACCOUNT INFORMATION" text
    When I fill account details
      | Field         | Value     |
      | Title         | Mr        |
      | Password      | Test123!  |
      | Day of birth  | 15        |
      | Month of birth| April     |
      | Year of birth | 1990      |
    And I select newsletter subscription
    And I select special offers
    And I fill address details
      | Field         | Value            |
      | First name    | John             |
      | Last name     | Doe              |
      | Company       | Test Company     |
      | Address       | 123 Test Street  |
      | Address2      | Apt 4            |
      | Country       | United States    |
      | State         | California       |
      | City          | Los Angeles      |
      | Zipcode       | 90001           |
      | Mobile number | +1234567890      |
    And I click Create Account button
    Then I should see "ACCOUNT CREATED!" text
    When I click Continue button
    And I click logout button

  @regression @smoke
  Scenario: TC02_01 - Login with valid credentials
    When I click on Signup Login button
    Then I should see "Login to your account" text
    When I enter login email from registered credentials
    And I enter login password from registered credentials
    And I click login button
    Then I should see "Logged in as" text
    And I should see username "John Doe" displayed

  @regression
  Scenario: TC02_02 - Login with invalid credentials
    When I click on Signup Login button
    Then I should see "Login to your account" text
    When I enter login email "invalid@example.com"
    And I enter login password "wrongpassword"
    And I click login button
    Then I should see error message "Your email or password is incorrect!"

  @regression
  Scenario: TC02_03 - Logout functionality
    When I click on Signup Login button
    Then I should see "Login to your account" text
    When I enter login email from registered credentials
    And I enter login password from registered credentials
    And I click login button
    Then I should see "Logged in as" text
    When I click logout button
    Then I should be navigated to login page

  @cleanup
  Scenario: Cleanup - Delete registered user
    When I click on Signup Login button
    Then I should see "Login to your account" text
    When I enter login email from registered credentials
    And I enter login password from registered credentials
    And I click login button
    And I click Delete Account button
    Then I should see "ACCOUNT DELETED!" text