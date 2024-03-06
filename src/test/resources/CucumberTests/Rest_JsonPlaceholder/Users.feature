Feature: Test users

  //@User
  Scenario Outline: Getting user with id should result with proper username and email
    Given I set base url
    And I set request specification
    When I get user with id <id>
    Then I receive correct username: <username>
    And I receive correct email: <email>
    Examples:
      | id   | username          | email |
      | 1    | Bret              | Sincere@april.biz          |
      | 2    | Antonette         | Shanna@melissa.tv          |
      | 3    | Samantha          | Nathan@yesenia.net         |
      | 4    | Karianne          | Julianne.OConner@kory.org  |
      | 5    | Kamren            | Lucio_Hettinger@annie.ca   |
      | 6    | Leopoldo_Corkery  | Karley_Dach@jasper.info    |
      | 7    | Elwyn.Skiles      | Telly.Hoeger@billy.biz     |
      | 8    | Maxime_Nienow     | Sherwood@rosamond.me       |
      | 9    | Delphine          | Chaim_McDermott@dana.io    |
      | 10   | Moriah.Stanton    | Rey.Padberg@karina.biz     |


  @User
  Scenario: Post new user should success
    Given I set base url
    And I set request specification
    And I prepare correct body input
    When I post new user with correct body
    Then I receive response code 201 with expected body
