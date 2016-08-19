Feature: Add products to Wishlist from Checkout page

  RT-586 - Add to wishlist - not logged in
  RT-585 - Add to wishlist - logged in


    ##### wishlist modal window on checkout Page

  @WishlistFromCheckoutPage
  Scenario: Test1 - Positive - not logged in user creates New wishlist on checkout Page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotestCustomer@ellos.se" in wishlist window on Checkout page
    And I write password "Password1" in wishlist window on Checkout page
    And I click on Login in wishlist window on Checkout page
    And I see that modal window for Add product to wishlist is shown
    #And I create a new wishlist "MyFirst_WL%100#@$&*()_FromCheckout" and save it
    #Then I see that product was save to new wishlist "MYFIRST_WL%100#@$&*()_FROMCHECKOUT" successfully
    Then I click OK button on Wishlist Modal Form
    And I switch to main page from checkout
    And I logged out from Main page

  @WishlistFromCheckoutPage
  Scenario: Test2 - Positive - logged in user add Standard product to Wishlist on checkout Page
    Given I am at ellos_se
    And I click Login link
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see that modal window for Add product to wishlist is shown
    #And I create a new wishlist "MyFirst_WL%100#@$%&*()_FromPDP" and save it
    #Then I see that product was save to new wishlist "MYFIRST_WL%100#@$%&*()_FROMPDP" successfully
    Then I click OK button on Wishlist Modal Form
    And I switch to main page from checkout
    And I logged out from Main page

  @WishlistFromCheckoutPage
  Scenario: Test3 - Negative - non-existent user try to add Standard product to wishlist on checkout Page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotest_non_existent_user@ellos.se" in wishlist window on Checkout page
    And I write password "Password1" in wishlist window on Checkout page
    And I click on Login in wishlist window on Checkout page
    Then I see that I am not logged in and password validation massages is present
    And I switch to main page from checkout

  @WishlistFromCheckoutPage
  Scenario: Test4 - Positive - logged in user check close button on Wishlist Modal on checkout Page
    Given I am at ellos_se
    And I click Login link
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see that modal window for Add product to wishlist is shown
    Then I click close button on Wishlist Modal Form
    And I switch to main page from checkout
    And I logged out from Main page

  @WishlistFromCheckoutPage
  Scenario: Test5 - Positive - register new customer and add Standard product to Wishlist on checkout Page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see wishlist modal window for log in or registration
    And I click button NewCustomer in wishlist window on Checkout page
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_RegWL"
    And last name "Laputko_RegWL"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    And I will see that I am registered from wishlist
    Then I click OK button on Wishlist Modal Form
    And I switch to main page from checkout
    And I logged out from Main page





  Scenario: Test3 - Negative - too long New Wishlist name on checkout Page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see wishlist modal window for log in or registration
    And I create a new wishlist "Wishlist1_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_" and save it
    Then I see that product was save to new wishlist "WISHLIST1_TEST1234_TEST1234_TEST123" successfully
    And I switch to main page from checkout
    And I logged out from Main page
  Scenario: Test4 - Positive - logged in user chooses existing wishlist on checkout Page
    Given I am at ellos_se
    And I click Login link
    And I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I see that I am logged in
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see that modal window for Add product to wishlist is shown
    And I save product to existing wishlist
    Then I see that product was save to existing wishlist successfully on checkout page
    And I switch to main page from checkout
    And I logged out from Main page
  Scenario: Test5 - Positive - logged in user creates New wishlist on checkout Page
    Given I am at ellos_se
    And I click Login link
    And I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I see that I am logged in
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see that modal window for Add product to wishlist is shown
    And I create a new wishlist "  Test3_MyWL_FromCheckout" and save it
    Then I see that product was save to existing wishlist successfully on checkout page
    And I switch to main page from checkout
    And I logged out from Main page
  Scenario: Test6 - Positive - register new customer and create New wishlist on checkout Page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And switch to checkout
    When On checkout Page I delete product from basket and click on button Save to wishlist
    And I see wishlist modal window for log in or registration
    And I click button NewCustomer in wishlist window on Checkout page
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_RegWL"
    And last name "Laputko_RegWL"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    And I will see that I am registered from wishlist
    And I switch to Main page from Product page
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I see that modal window for Add product to wishlist is shown
    And I create a new wishlist "  Test4_MyWL_FromCheckout" and save it
    Then I see that product was save to new wishlist successfully
    And I delete product from basket and switch to main page
    And I switch to main page from checkout
    And I logged out from Main page



# Test6 - we have some problems with wishlist pop-up in checkout page



