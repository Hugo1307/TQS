Feature: Country Statistics page

  Scenario: Correct title
    When I navigate to country statistics at "http://localhost:3000/country"
    Then I should see the country statistics title "Country Statistics"

  Scenario: Select a country
    When I navigate to country statistics at "http://localhost:3000/country"
    And I select the country "Portugal"
    Then I should see the country statistic "COUNTRY" with value "Portugal"

  Scenario: Country contains statistics
    When I navigate to country statistics at "http://localhost:3000/country"
    And I select the country "Portugal"
    Then I should see the following country statistics:
    | COUNTRY |
    | NEW DEATHS |
    | RANK |
    | TOTAL TESTS |
    | POPULATION |
    | TOTAL RECOVERED |
    | INFECTION RISK |
    | DEATHS PER MILLION |
    | TOTAL CASES |
    | NEW RECOVERED |
    | CASE FATALITY RATE |
    | TESTS PER MILLION |
    | NEW CASES |
    | ACTIVE CASES |
    | TEST PERCENTAGE |
    | CASES PER MILLION |
    | TOTAL DEATHS |