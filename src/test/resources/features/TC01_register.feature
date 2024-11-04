Feature: TC01 - New User Registration
  As a visitor
  I want to register to the website
  So that I can have my own account

  @regression @smoke
  Scenario: TC01_01 - Successful user registration
    Given I am on the home page
    When I click on Signup Login button
    Then I should see "New User Signup!" text
    When I enter name "John Doe"
    And I enter email address for registration
    And I click Signup button
    Then I should see "ENTER ACCOUNT INFORMATION" text
    When I fill account details
      | Field          | Value    |
      | Title          | Mr       |
      | Password       | Test123! |
      | Day of birth   | 15       |
      | Month of birth | April    |
      | Year of birth  | 1990     |
    And I select newsletter subscription
    And I select special offers
    And I fill address details
      | Field         | Value           |
      | First name    | John            |
      | Last name     | Doe             |
      | Company       | Test Company    |
      | Address       | 123 Test Street |
      | Address2      | Apt 4           |
      | Country       | United States   |
      | State         | California      |
      | City          | Los Angeles     |
      | Zipcode       | 90001           |
      | Mobile number | +1234567890     |
    And I click Create Account button
    Then I should see "ACCOUNT CREATED!" text
    When I click Continue button
    Then I should see "Logged in as John Doe" text
    And I click Delete Account button
    Then I should see "ACCOUNT DELETED!" text