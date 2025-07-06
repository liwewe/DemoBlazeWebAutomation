Feature: User API

  @api @get-user @positive
  Scenario: Get a user by valid ID
    Given prepare URL for "GET_USER"
    And provide user id "60d0fe4f5311236168a109cf"
    When send GET request
    Then validate status code is 200
    And validate response body contain user details
    #And validate response json with JSONSchema "GetUserByIdSchema.json"
