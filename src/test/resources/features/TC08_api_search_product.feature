Feature: TC08 - API Search Product Operations
  As an API user
  I want to be able to search products
  So that I can find specific products

  @api @regression
  Scenario: TC08_01 - Search Product with Valid Query
    Given I set the base API URL
    When I send POST request to "/searchProduct" endpoint with search query:
      | search_product | tshirt |
    Then the response status code should be 200
    And the response should contain "responseCode" as "200"
    And the response should contain "products" array

  @api @regression
  Scenario: TC08_02 - Search Product with Empty Query
    Given I set the base API URL
    When I send POST request to "/searchProduct" endpoint with search query:
      | search_product |  |
    Then the response status code should be 200
    And the response should contain "responseCode" as "200"