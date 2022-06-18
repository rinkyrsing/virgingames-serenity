Feature: Testing defaultGameFrequency and startTime values on the Virgingames api

  Scenario: check value of 'defaultGameFrequency' should always be '300000'
    When User sends a GET request
    And User must get back a valid status code 200
    Then  User should verify 'defaultGameFrequency' value should be '300000'

    Scenario: verify startTime should always be a future timestamp
      When User sends a GET request
      And User must get back a valid status code 200
      Then User should verify all startTime is future timestamp


