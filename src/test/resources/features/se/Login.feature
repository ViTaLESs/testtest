Feature: Login to System
        RT-132 - At Login-page and in Basket


  @Login
  Scenario: Test1 - Positive - Login page and login form UI on Login page
    Given I am at ellos_se
    And I click Login link
    And I check that I switch to Login page correctly
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I click on "CloseLoginFormButton"
    And I check that I switch to Login page correctly
    Then I switch to the main page from login

  @Login
  Scenario: Test2 - Positive - Login on Login page - existent user
    Given I am at ellos_se
    And I click Login link
    And I check that I switch to Login page correctly
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am logged in
    And I logged out

  @Login
  Scenario: Test3 - Negative - Login on Login page - non-existent user
    Given I am at ellos_se
    And I click Login link
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotest_non_existent_user@ellos.se"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am not logged in and password validation massages is present "YOUR EMAIL/PASSWORD COMBINATION IS INCORRECT"
    And I switch to the main page from login

  @Login
  Scenario: Test4 - Positive - Check case when user enter spaces before email on Login page
    Given I am at ellos_se
    And I click Login link
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "   autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    #Then I see that I am not logged in and email validation massages is present
    #And I switch to the main page
    Then I see that I am logged in
    And I logged out

  @Login
  Scenario: Test5 - Negative - Check error message when user enter wrong password on Login page
    Given I am at ellos_se
    And I click Login link
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Pass"
    And I click on button Login
    Then I see that I am not logged in and password validation massages is present "YOUR EMAIL/PASSWORD COMBINATION IS INCORRECT"
    And I switch to the main page from login

  @Login
  Scenario: Test6 - Negative - Check error message when user enter wrong email on Login page
    Given I am at ellos_se
    And I click Login link
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am not logged in and email validation massages is present
    And I switch to the main page from login

  @Login
  Scenario: Test7 - Negative - Check error message when password field is empty on Login page
    Given I am at ellos_se
    And I click Login link
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password ""
    And I click on button Login
    Then I see that I am not logged in and validation message of empty password field is present
    And I switch to the main page from login

  @Login
  Scenario: Test8 - Negative - Check error message when password and email fields are empty on Login page
    Given I am at ellos_se
    And I click Login link
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address ""
    And I write password ""
    And I click on button Login
    Then I see that validation message of empty Email AND Password fields are presents
    And I switch to the main page from login


    ### Login on Checkout page
  @Login
  Scenario: Test9 - Positive - Login page and login form UI on Checkout page
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I click on "CloseLoginFormButton"
    And I check that I switch to Login page correctly
    Then I delete product and switch to the main page from checkout

  @Login
  Scenario: Test10 - Positive - Login on Checkout page - existent user
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am logged in and stay on Checkout page
    And I can continue with the checkout process

  @Login
  Scenario: Test11 - Negative - Login on Checkout page - non-existent user
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotest_non_existent_user@ellos.se"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am not logged in and password validation massages is present "YOUR EMAIL/PASSWORD COMBINATION IS INCORRECT"

  @Login
  Scenario: Test12 - Positive - Check case when user enter Spaces before email on Checkout page
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "   autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    #Then I see that I am not logged in and email validation massages is present
    #And I delete product and switch to the main page from checkout
    Then I see that I am logged in and stay on Checkout page
    And I can continue with the checkout process

  @Login
  Scenario: Test13 - Negative - Check error message when user enter wrong password on Checkout page
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Pass"
    And I click on button Login
    Then I see that I am not logged in and password validation massages is present "YOUR EMAIL/PASSWORD COMBINATION IS INCORRECT"

  @Login
  Scenario: Test14 - Negative - Check error message when user enter wrong email on Checkout page
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am not logged in and email validation massages is present
    And I delete product and switch to the main page from checkout

  @Login
  Scenario: Test15 - Negative - Check error message when password field is empty on Checkout page
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password ""
    And I click on button Login
    Then I see that I am not logged in and validation message of empty password field is present
    And I delete product and switch to the main page from checkout

  @Login
  Scenario: Test16 - Negative - Check error message when password and email fields are empty on Checkout page
    Given I am at ellos_se
    And I add product to the Basket and go to checkout
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address ""
    And I write password ""
    And I click on button Login
    Then I see that validation message of empty Email AND Password fields are presents
    And I delete product and switch to the main page from checkout

