Feature: TC03 - Login User with incorrect email and password
  As a user
  I want to see appropriate error message
  When I try to login with incorrect credentials

  @regression
  Scenario: TC03 - Login with invalid credentials
    Given I am on the home page
    When I click on Signup Login button
    Then I should see "Login to your account" text
    When I enter login email "invalid@example.com"
    And I enter login password "wrongpassword"
    And I click login button
    Then I should see error message "Your email or password is incorrect!"