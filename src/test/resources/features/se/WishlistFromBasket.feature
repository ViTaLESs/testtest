Feature: Add products to Wishlist from Basket

  RT-586 - Add to wishlist - not logged in
  RT-585 - Add to wishlist - logged in


    ##### wishlist modal window on mini cart

  @WishlistFromBasket
  Scenario: Test1 - Positive - not logged in user add Standard product to Wishlist on mini cart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login on wishlist modal window
    And I see that modal window for Add product to wishlist is shown
    #And I create a new wishlist "MyFirst_WL%100#@$%&*()_FromPDP" and save it
    #Then I see that product was save to new wishlist "MYFIRST_WL%100#@$%&*()_FROMPDP" successfully
    Then I click OK button on Wishlist Modal Form
    And I delete product from basket and switch to main page
    And I logged out from Main page

  @WishlistFromBasket
  Scenario: Test2 - Positive - logged in user add Standard product to Wishlist on mini cart
    Given I am at ellos_se
    And I click Login link
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see that modal window for Add product to wishlist is shown
    Then I click OK button on Wishlist Modal Form
    And I delete product from basket and switch to main page
    And I logged out from Main page

  @WishlistFromBasket
  Scenario: Test3 - Negative - non-existent user try to add Standard product to wishlist on mini cart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotest_non_existent_user@ellos.se"
    And I write password "Password1"
    And I click on button Login on wishlist modal window
    Then I see that I am not logged in and password validation massages is present
    And I switch to the main page from login

  @WishlistFromBasket
  Scenario: Test4 - Positive - logged in user check close button on Wishlist Modal on mini cart
    Given I am at ellos_se
    And I click Login link
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see that modal window for Add product to wishlist is shown
    Then I click close button on Wishlist Modal Form
    And I delete product from basket and switch to main page
    And I logged out from Main page

  @WishlistFromBasket
  Scenario: Test5 - Positive - register new customer and add Standard product to Wishlist on mini cart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see wishlist modal window for log in or registration
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
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
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see that modal window for Add product to wishlist is shown
    Then I click OK button on Wishlist Modal Form
    And I delete product from basket and switch to main page
    And I logged out from Main page



  Scenario: Test3 - Negative - too long New Wishlist name from mini cart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login on wishlist modal window
    And I see that modal window for Add product to wishlist is shown
    And I create a new wishlist "Wishlist1_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_" and save it
    Then I see that product was save to new wishlist "WISHLIST1_TEST1234_TEST1234_TEST123" successfully
    And I switch to Main page from Product page
    And I logged out from Main page
  Scenario: Test4 - Positive - not logged in user chooses existing wishlist from mini cart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login on wishlist modal window
    And I see that modal window for Add product to wishlist is shown
    And I save product to existing wishlist
    Then I see that product was save to existing wishlist successfully
    And I delete product from basket and switch to main page
    And I logged out from Main page
  Scenario: Test5 - Positive - not logged in user creates New wishlist from mini cart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When On mini cart I click on button Add to wishlist
    And I see wishlist modal window for log in or registration
    And I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    And I see that modal window for Add product to wishlist is shown
    And I create a new wishlist "  Test3_MyWL_FromPDP" and save it
    Then I see that product was save to new wishlist successfully
    And I delete product from basket and switch to main page
    And I logged out from Main page


