Feature: calculator features of calculator-service
  Background:
    Given calculator-service app is started
    And a mongodb is started

  @test_calculator_add
  Scenario: entry point of add words
    Given that I want to add 2 and 3
    When I submit the request
    Then I get the result 5
