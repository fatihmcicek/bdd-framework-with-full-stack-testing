Feature: TC05 - Test Cases Page
  As a user
  I want to access test cases page
  So that I can view available test cases

  @regression
  Scenario: TC05_01 - Navigate to Test Cases page
    Given I am on the home page
    When I click on Test Cases button
    Then I should be navigated to test cases page
    And I should see " TEST CASES" text