Feature: Test summing

  @Calc
  Scenario Outline: Summing different numbers with zero for result <result>
    Given Calculator is started
    When I add <num1> and <num2>
    Then result is <result>
    Examples:
      | num1 | num2 | result |
      | 0    | 7    | 7      |
      | 0    | 0    | 0      |
      | -6   | 0    | -6     |

  @Calc
  Scenario Outline: Summing different positive and negative numbers for result <result>
    Given Calculator is started
    When I add <num1> and <num2>
    Then result is <result>
    Examples:
      | num1 | num2 | result |
      | 3    | 7    | 10      |
      | 234  | -34  | 200      |
      | -6   | -30  | -36     |
