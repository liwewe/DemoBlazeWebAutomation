Feature: User API

  @api @get-user @positive
  Scenario: Get a user by valid ID
    Given prepare URL for "GET_USER"
    And provide user id "60d0fe4f5311236168a109cf"
    When send GET request
    Then validate status code is 200
    And validate response json with JSONSchema "GetUserByIdSchema.json"

  @api @create-user @positive
  Scenario: Create new user with valid data
    Given prepare URL for "CREATE_USER"
    And provide user first name "Linjoo" and last name "Joo" and random email
    When send POST request
    Then validate status code is 200
    And validate response body contains the same user data

  @api @update-user @positive
  Scenario: Create and update a user successfully
    Given a new user is created
    When the user is updated with new data
    And send PUT request
    Then validate status code is 200
    And validate response body contains the updated data

  @api @delete-user @positive
  Scenario: Create and delete a user successfully
    Given a new user is created
    When the user is deleted
    Then validate status code is 200

  @api @delete-user @negative
  Scenario: Delete user with invalid ID
    Given prepare URL for "GET_USER"
    And provide user id "xx"
    When send DELETE request
    Then validate status code is 400
