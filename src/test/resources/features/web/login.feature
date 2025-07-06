Feature: Login

  @web @valid-login
  Scenario: Successful login with valid credentials
    Given user is on the login modal
    When user inputs username with "linjoo"
    And user inputs password with "123"
    And user clicks the login button
    Then user should see homepage with welcome message "Welcome linjoo"

  @web @invalid-login
  Scenario: Login with invalid credentials
    Given user is on the login modal
    When user inputs username with "linn"
    And user inputs password with "321"
    And user clicks the login button
    Then alert message "Wrong password." should appear

  @web @invalid-login
  Scenario: Login with empty username and password
    Given user is on the login modal
    When user inputs username with ""
    And user inputs password with ""
    And user clicks the login button
    Then alert message "Please fill out Username and Password." should appear

  @web @logout
  Scenario: Successful logout from an active session
    Given user is logged in with username "linjoo" and password "123"
    When user clicks the logout button
    Then user should be redirected to the homepage
    And user should be logged out