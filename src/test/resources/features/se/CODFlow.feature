Feature: COD flow

#PKT == Normal
#PKX == Express24
#HEM == Home delivery ==> not available for this kind of delivery
#BRV == Letter parcel

  @CODFlow
  Scenario: Test1 - Positive - COD/Normal flow
    Given I am at ellos_se
    And I click Login link
    And I check that I switch to Login page correctly
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I see that I am logged in (for flow)
    And I switch to the main page from myCabinet
    And I check that Basket is empty
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "36"
    And I see that size "36" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    And on mini card I click on go to checkout button
    And I choose payment method "COD"
    And I choose delivery method "PKT"
    And I confirm orders
    Then I see that the order was created successfully

  @CODFlow
  Scenario: Test2 - Positive - COD/Express24 flow
    Given I am at ellos_se
    And I click Login link
    And I check that I switch to Login page correctly
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I see that I am logged in (for flow)
    And I switch to the main page from myCabinet
    And I check that Basket is empty
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "36"
    And I see that size "36" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    And on mini card I click on go to checkout button
    And I choose payment method "COD"
    And I choose delivery method "PKX"
    And I confirm orders
    Then I see that the order was created successfully

