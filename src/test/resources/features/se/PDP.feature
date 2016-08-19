Feature: Product Detail Page
  OMG-2005 PDP - Intershop UI
  RT-145 BP03.04.04 – Add product to cart from the PDP
  RT-250 BP03.04.04 - SKU selection
  RT-830 BP03.04.04 - PDP - Intershop UI
  RT-380 BP03.04.04 - PDP - measured fabrics

  RT-203 BP03.04.04 - Monthly payment shows when shopping - PDP, mini cart and check out
    ###
    #   PDP
    #   RT-145 – Add product to cart from the PDP
  ###

  #TODO:
  #Scenario: Test4 - Positive - Add Electronic product to cart from the PDP
  #Scenario: Test5 - Positive - Add StandardDistributionGroup product to cart from the PDP
  #Scenario: Test6 - Positive - Add Gift card to cart from the PDP

    ###
    #   Standard product
  ###
  @PDP+
  @PDP
  Scenario: Test1 - Positive - Add Standard product to cart from the PDP
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page
    And I switch to Main page

  @PDP+
  @PDP
  Scenario: Test2 - Positive - Double-click the button Add to cart for the Standard product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/korallrödrandig"
    And I see that color "Vit/korallrödrandig" was selected correctly
    And I selected size "36"
    And I see that size "36" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    When I double-clicked on button Add to cart
    When I open mini cart
    Then I see that "2" products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

    ###
    #   Fabric product
  ###
  @PDP+
  @PDP
  Scenario: Test3 - Positive - Add Fabric product to cart from the PDP
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
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @PDP
  Scenario: Test4 - Positive - Double-click the button Add to cart for the Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Dimblå"
    And I see that color "Dimblå" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "4" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    When I double-clicked on button Add to cart
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

    ###
    #   Balky product
  ###
  @PDP+
  @PDP
  Scenario: Test5 - Positive - Add Bulky product to cart from the PDP
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @PDP
  Scenario: Test6 - Positive - Double-click the button Add to cart for the Bulky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    When I double-clicked on button Add to cart
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page



      ###
    #   PDP UI
    #   RT-830 - PDP - Intershop UI
    #
    #   UI of Standard PDP
  ###
  @PDP+
  @PDP
  Scenario: Test_UI_01 - Positive - link Read more - Standard product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When I click on the link Read more
    Then The screen switches to the block Product description of the product which is below

  @PDP+
  @PDP
  Scenario: Test_UI_02 - Positive - Checking of product attributes - Standard product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for Standard product

  @PDP+
  @PDP
  Scenario: Test_UI_03 - Positive - Checking of product tabs section - Standard product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When I click on the link Read more
    Then The screen switches to the block Product description of the product which is below
    And I am checking all product tab and blocks with info

    ###
    #   UI of Fabric PDP
  ###
  @PDP+
  @PDP
  Scenario: Test_UI_04 - Positive - link Read more - Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    When I click on the link Read more
    Then The screen switches to the block Product description of the product which is below

  @PDP+
  @PDP
  Scenario: Test_UI_05 - Positive - Checking of product attributes - Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for Fabric product

  @PDP+
  @PDP
  Scenario: Test_UI_06 - Positive - Checking of product tabs section - Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    When I click on the link Read more
    Then The screen switches to the block Product description of the product which is below
    And I am checking all product tab and blocks with info

    ###
    #   UI of Balky PDP
  ###
  @PDP+
  @PDP
  Scenario: Test_UI_07 - Positive - link Read more - Bulky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    When I click on the link Read more
    Then The screen switches to the block Product description of the product which is below

  @PDP+
  @PDP
  Scenario: Test_UI_08 - Positive - Checking of product attributes - Bulky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents

  @PDP+
  @PDP
  Scenario: Test_UI_09 - Positive - Checking of product tabs section - Bulky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    When I click on the link Read more
    Then The screen switches to the block Product description of the product which is below
    And I am checking all product tab and blocks with info



#///////////////??????????????????

    #RT-203 Monthly payment shows when shopping - PDP, mini cart and check out

  Scenario: Test_UI_03 - Positive - Checking of Monthly Payment on PDP
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presenFFFFFFFFFFFFFts for Standard product

  Scenario: 1 - Positive - Monthly payment on product - 12 months
    Given I am at ellos.se/no/fi/dk
    When I hover over product (XXX) on the PDP
    Then I will see a box where the monthly payment, total credit amount
    And the effective annual interest rate is shown

  Scenario: 2 - Positive - Monthly payment in mini cart
    Given I have added an iPhone to the mini cart
    When I look at the mini cart
    Then I can see that the monthly payment is shown on the product

  Scenario: 3 - Positive - Monthly payment in check out
    Given I logged in as annaandersson@ellos.se
    And I have a product (XX) in my basket
    When I a go to the check out
    Then I can see that the monthly payment....







