Feature: Checkout page
  RT-397  BP04.02.03 - Checkout UI

  #Background:
   # Given I am at ellos_se
   # And I click Login link
   # When I write Email address "autotestCustomer@ellos.se"
   # And I write password "Password1"
   # And I click on button Login
   # Then I see that I am logged in


  @Checkout
  Scenario: Test1 - Positive - Checkout UI
    Given I am at ellos_se
    And I click Login link
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am logged in

    And I switch to product page (Standard product)
    And I add product to the Basket
    And I keep the product information and switched to checkout and check that product info is correct

    Then I will see that I am on Checkout page and I am registered

    And I see that the options for delivery and payment are in chooseable boxes



