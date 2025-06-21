Feature: Login

  @valid-login
  Scenario: Successful login with valid credentials
    Given user is on the login modal
    When user inputs username with "linjoo"
    And user inputs password with "123"
    And user clicks the login button
    Then user should see homepage with welcome message "Welcome linjoo"

  @invalid-login
  Scenario: Login with invalid credentials
    Given user is on the login modal
    When user inputs username with "linn"
    And user inputs password with "321"
    And user clicks the login button
    Then alert message "Wrong password." should appear

  @invalid-login
  Scenario: Login with empty username and password
    Given user is on the login modal
    When user inputs username with ""
    And user inputs password with ""
    And user clicks the login button
    Then alert message "Please fill out Username and Password." should appear