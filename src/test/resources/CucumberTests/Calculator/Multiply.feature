Feature: Test multiplying

  Scenario Outline: Multiplying different numbers with zero for result 0
    Given Calculator is started
    When I multiply <num1> and <num2>
    Then result is 0
    Examples:
      | num1 | num2 |
      | 0    | 7    |
      | 0    | 0    |
      | -6   | 0    |