Feature: ip stat features of calculator-service
  Background:
    Given calculator-service app is started
    And a mongodb is started

  @test_calculator_add
  Scenario: entry point of stat works
    Given that I create a request on stat
    When I submit the request
    Then I get stat result
