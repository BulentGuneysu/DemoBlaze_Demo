Feature: The user should be able to place order from the website

  @purchase
  Scenario: Placing a successful order
    Given The user is on the login page
    When The user enters with "bulent" and "255435" credentials
    And The user adds "Samsung galaxy s7" from "Phones"
    And The user adds "Sony vaio i5" from "Laptops"
    And The user adds "MacBook air" from "Laptops"
    And The user adds "Apple monitor 24" from "Monitors"
    And The user removes "Sony vaio i5" from cart
    And The user places order and captures and log amount
    Then  The user verifies purchase amount equals 1900








