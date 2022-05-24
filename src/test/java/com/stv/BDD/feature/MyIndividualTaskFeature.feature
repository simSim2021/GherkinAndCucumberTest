Feature: Individual task test

  Scenario: 01. Round tour main page-basket-account page-t&c page-main page
    Given  main page is loaded
    When click on Basket
    And check Basket is empty
    And click Your account link
    And scroll down to find Terms&Conditions link
    And click Terms&Conditions link
    And check that page Terms&Conditions is loaded
    And click main page link
    And check that main page is loaded
    Then check the button Accept cookies and click button Accept cookies if exists
