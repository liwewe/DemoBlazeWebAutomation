Feature: Tag API

  @api @get-tag @positive
  Scenario: Get list of tag
    Given prepare URL for "GET_TAG" to tag endpoint
    When send GET request to tag endpoint
    Then validate status code is 200 to tag endpoint
    And validate data field exists and contains string items