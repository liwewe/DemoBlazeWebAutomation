Feature: Signup

  @invalid-signup
  Scenario: Signup with empty username and password
    Given user is on signup modal
    When user input username text box with ""
    And user input password text box with ""
    And user click signup button
    Then popup message "Please fill out Username and Password." appears

  @invalid-signup
  Scenario: Signup with existing username
    Given user is on signup modal
    When user input username text box with "linjoo"
    And user input password text box with "123"
    And user click signup button
    Then popup message "This user already exist." appears

  @invalid-signup
  Scenario: Signup with valid username but empty password
    Given user is on signup modal
    When user input username text box with "linjoo131134"
    And user input password text box with ""
    And user click signup button
    Then popup message "Please fill out Username and Password." appears

  @invalid-signup
  Scenario: Signup with empty username but valid password
    Given user is on signup modal
    When user input username text box with ""
    And user input password text box with "123"
    And user click signup button
    Then popup message "Please fill out Username and Password." appears