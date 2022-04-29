Feature: World Statistics page

  Scenario: Correct title
    When I navigate to "http://localhost:3000/"
    Then I should see the title "World Statistics"

  Scenario: Correct statistics
    When I navigate to "http://localhost:3000/"
    Then I should see the world statistics:
      | TOTAL CASES |
      | NEW RECOVERED |
      | DEATHS PER MILLION |
      | NEW CASES |
      | TOTAL RECOVERED |
      | ACTIVE CASES |
      | CASE FATALITY RATE |
      | TOTAL DEATHS |