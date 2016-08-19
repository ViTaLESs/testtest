Feature: Color selection on PDP
  RT-722 BP04.02.03 - PDP - size selection


    ###
    #   Color on Standard PDP
  ###
  @PDP+
  @Color
  Scenario: Test1 - Positive - Checking the color change and addition to the cart for Standard product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "36"
    And I see that size "36" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test2 - Positive - Checking switch between product colors
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    And On product page I choose color "Vit/korallrödrandig"
    And I see that color "Vit/korallrödrandig" was selected correctly
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And On product page I choose color "Blå/vit randig"
    And I see that color "Blå/vit randig" was selected correctly
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test3 - Positive - Checking switch between product sizes and colors
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Blå/vit randig"
    And I see that color "Blå/vit randig" was selected correctly
    Then I check that size "36" is Out of stock and size is disabled
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    And I selected size "40"
    And I see that size "40" was selected correctly with label "1 Kvar i lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+1111
  @Color1111
  Scenario: Test4 - Positive - Checking the unavailable color
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I see that color "Rosa/marinrandig" is disabled
    Then I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test5 - Positive - Checking transition to another color without button 'Expand More Colors'
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "36"
    And I see that size "36" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test6 - Positive - Checking add product to cart without selecting a color - default color
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "36"
    And I see that size "36" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page



    ###
    #   Color on Fabric PDP
  ###
  @PDP+
  @Color
  Scenario: Test7 - Positive - Checking the color change and addition to the cart for Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Beige"
    And I see that color "Beige" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "4" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test8 - Positive - Checking switch between product colors for Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Beige"
    And I see that color "Beige" was selected correctly
    And I see that label is "I lager" for Fabric product
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And On product page I choose color "Julröd"
    And I see that color "Julröd" was selected correctly
    And I see that label is "Få antal kvar" for Fabric product
    And On product page I choose color "Mellangrå"
    And I see that color "Mellangrå" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "10" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test9 - Positive - Checking add product to cart without selecting a color for Fabric product - default color
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And I see that color "Mellangrå" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "1" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page


    ###
    #   Color on Balky PDP
  ###
  @PDP+
  @Color
  Scenario: Test10 - Positive - Checking that the color is In stock and add to the cart - Balky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And I see that color "Vit" was selected correctly
    And I see that label is "I lager" for Bulky product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Color
  Scenario: Test11 - Positive - Checking switch between product colors for Balky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And I see that color "Vit" was selected correctly
    And I see that label is "I lager" for Bulky product
    And On product page I choose color "Svart"
    And I see that label is "I lager" for Bulky product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

   # AAAAAAAAAAAAAAAAAAAAAAA  Bulky product number2)
  @PDP+(haven'tnow)
  @Color(haven'tnow)
  Scenario: Test12 - Positive - Checking that the color is Few in stock and add to the cart - Balky product
    Given I am at ellos_se
    And I switch to product page (Bulky product number2)
    And I check that I switch to PDP correct
    And I see that color "Vit" was selected correctly
    And On product page I choose color "Mellangrå"
    And I see that label is "Few in stock" for Bulky product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page









