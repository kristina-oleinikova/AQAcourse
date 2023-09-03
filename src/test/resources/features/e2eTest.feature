Feature: Successful shopping an item

  Scenario: Successful e2e scenario
    Given open login page
    When user enters username standard_user and password secret_sauce
    * user clicks login button
    * user ads item to basket
    * user clicks shopping button
    * user clicks checkout button
    * user enters firstName Kris lastName Oleinikova and zipCode 0000
    * user clicks continue button
    * user clicks finish button
    Then CheckoutComplete page is displayed
