Feature: Load "New customer" page

  Scenario: valid email for new customer
    Given the main page is loaded
    When user enter valid email for new customer in filed Email address
    And click Continue button
    Then page with registration form is loaded and message appears




