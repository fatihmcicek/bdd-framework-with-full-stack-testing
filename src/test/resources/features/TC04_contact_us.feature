Feature: TC04 - Contact Us Form
  As a user
  I want to be able to contact customer service
  So that I can submit my inquiries

  @regression
  Scenario: TC04_01 - Submit Contact Us form successfully
    Given I am on the home page
    When I click on Contact Us button
    Then I should see "GET IN TOUCH" text
    When I enter contact name "John Doe"
    And I enter contact email "test@example.com"
    And I enter contact subject "General Inquiry"
    And I enter contact message "This is a test message. Testing the contact form functionality. Thank you for your attention."
    And I click Submit button on contact form
    And I click OK on popup
    Then I should see success message "Success! Your details have been submitted successfully."
