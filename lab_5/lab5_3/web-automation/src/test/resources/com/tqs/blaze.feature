
Feature: Travel Agency Web App - BlazeDemo

  Scenario: Buy one Flight From Boston to London
    When I navigate to "https://blazedemo.com/"
    And I select departure city "Boston"
    And I select destination city "London"
    And I click "Find Flights"
    Then I should be shown results of "Flights from Boston to London"
    When I click "Choose This Flight"
    And I enter my Name "Lewis Hamilton"
    And I enter my Address "123 Main Street"
    And I enter my City "Monaco"
    And I enter my State "Monaco"
    And I enter my Zip Code 44212
    And I enter my Credit Card Number 657423
    And I enter my Name on Card "Lewis Hamilton"
    And I click "Purchase Flight"
    Then The purchase should be confirmed