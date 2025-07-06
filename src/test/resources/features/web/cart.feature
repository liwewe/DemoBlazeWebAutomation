Feature: Cart

  @web @cart
  Scenario: Cart items remain after logout and re-login
    Given user is logged in with username "linjoo" and password "123"
    And user adds item "Samsung galaxy s6" to the cart
    And alert message "Product added." should appear
    When user clicks the logout button
    And user is logged in with username "linjoo" and password "123"
    Then the item "Samsung galaxy s6" should be present in the cart

  @web @checkout
  Scenario: Checkout with empty cart
    Given user is logged in with username "linjoo" and password "123"
    And user navigates to the cart page
    And delete all item in the cart
    When user clicks the "Place Order" button
    Then Order form is open