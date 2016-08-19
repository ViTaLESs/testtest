Feature: Mini cart functional
  RT-691 BP04.02.03 - mini cart functional UI


  @Mini_cart_____is_needed??
    @NEED!
    @AndNeedForEmpty_and_for_fullBasket!!!!
  Scenario: Test0 - Positive - minicart UI
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    Then I see that all elements on minicart are are presents
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

    ###
    #   Standard product
  ###
  @Mini_cart
  Scenario: Test1 - Positive - increase quantity of Standard product in minicart - increase button
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I press button to increase the product on the mini cart
    Then I see that "2" products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test2 - Positive - decrease quantity of Standard product in minicart - decrease button
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When I double-clicked on button Add to cart
    When I open mini cart
    And I press button to decrease the product on the mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test3 - Positive - increase quantity of Standard product in minicart - input field
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I set "2" in first product quantity field on the mini cart
    Then I see that "2" products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test4 - Positive - decrease quantity of Standard product in minicart - input field
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When I double-clicked on button Add to cart
    When I open mini cart
    And I set "1" in first product quantity field on the mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page



    ###
    #   Fabric product
  ###
  @Mini_cart
  Scenario: Test5 - Positive - increase quantity of Fabric product in minicart - increase button
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "4" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    And I press button to increase the product on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test6 - Positive - decrease quantity of Fabric product in minicart - decrease button
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "4" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    And I press button to decrease the product on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test7 - Positive - increase quantity of Fabric product in minicart - input field
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Mellangrå"
    And I see that color "Mellangrå" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "4" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    And I set "10" in first product quantity field on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test8 - Positive - decrease quantity of Fabric product in minicart - input field
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Mellangrå"
    And I see that color "Mellangrå" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "4" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    And I set "1" in first product quantity field on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page



    ###
    #   Balky product
  ###
  @Mini_cart
  Scenario: Test9 - Positive - increase quantity of Bulky product in minicart - increase button
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    And I press button to increase the product on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test10 - Positive - decrease quantity of Bulky product in minicart - decrease button
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    When I double-clicked on button Add to cart
    When I open mini cart
    And I press button to decrease the product on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test11 - Positive - increase quantity of Bulky product in minicart - input field
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    And I set "2" in first product quantity field on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @Mini_cart
  Scenario: Test12 - Positive - decrease quantity of Bulky product in minicart - input field
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    And I set "1" in first product quantity field on the mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page




  @Mini_cartAAA
  Scenario: Test2 - Positive - combo of products

  @Mini_cartAAA
  Scenario: Test2 - Positive - more than 7 products - scroll is shown



  @Mini_cartAAA
  Scenario: Test5 - Positive - remove a product in minicart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    And I switch to product page (Fabric  product)
    And I check that I switch to PDP correct
    And I add two meters of fabric product to the Basket
    When I open mini cart
    And I delete first product on the mini cart
    Then I see that the amount is correct on the mini cart
    And I see that the total price is correct on the mini cart
    And I delete all products from basket and switch to main page

  @Mini_cartAAA
  Scenario: Test6 - Positive - Add promotion code field in minicart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "Family1"
    And I press button ADD in discount field
    Then I can see that the promotion code field is added to the mini cart
    And I see that the price is updated

  @Mini_cartAAA
  Scenario: Test7 - Negative - Add incorrect promotion code in minicart

  @Mini_cartAAA
  Scenario: Test7 - Negative - Add promotion code in minicart (empty field)
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "_empty_"
    And I press button ADD in discount field
    Then I get a error message telling me to enter a valid promotion code

  @Mini_cartAAA
  Scenario: Test8 - Positive - Remove promotion code from minicart
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "Family1"
    And I press button ADD in discount field
    And I click the remove promotion button
    Then I can see that the promotion is removed from the mini cart
    And I see that the price is updated

  @Mini_cartAAA
  Scenario: Test9 - Positive - Product and promotions still in minicart after login
    Given I am at ellos_se
    And I'm NOT logged in
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "Family1"
    And I press button ADD in discount field
    And I am logged in as "sara.andersson30@ellos.se", password "Password1"
    And I click on mini cart link
    Then I can see that my products and active promotions are still in my mini cart
    And I see that the price is updated

  @Mini_cartAAA
  Scenario: Test10 - Positive - Product and promotions still in minicart after logout and login again
    Given I am at ellos_se
    And I am logged in as "sara.andersson30@ellos.se", password "Password1"
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "Family1"
    And I press button ADD in discount field
    And I logout
    And I am logged in as "sara.andersson30@ellos.se", password "Password1"
    And I click on mini cart link
    Then I can see that my products and active promotions are still in my mini cart
    And I see that the price is updated

  @Mini_cartAAA
  Scenario: Test11 - Positive - Product and promotions still in minicart after close and reopen browser
    Given I am at ellos_se
    And I am logged in as "sara.andersson30@ellos.se", password "Password1"
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "Family1"
    And I press button ADD in discount field
    And I close and reopen my browser
    And I click on mini cart link
    Then I can see that my products and active promotions are still in my mini cart
    And I see that the price is updated

  @Mini_cartAAA
  Scenario: Test12 - Positive - Product and promotions still in cart when going to checkout
    Given I am at ellos_se
    And I am logged in as "sara.andersson30@ellos.se", password "Password1"
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I add product to the Basket
    When I open mini cart
    And I click on Add discount button
    And I add discount code "Family1"
    And I press button ADD in discount field
    And switch to checkout
    Then I can see that my products and active promotions are also shown in my cart on the checkout page



