Feature: Size selection on PDP
  RT-722 BP04.02.03 - PDP - size selection

        ###
        #   Size
        #   RT-722 PDP - size selection
      ###

    ###
    #   Standard product
  ###
  @PDP+
  @Size
  Scenario: Test1 - Positive - Checking size list
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    When I click on size dropdown
    Then I see that size dropdown list shown correct

  @PDP+
  @Size
  Scenario: Test2 - Positive - Checking double click on size dropdown
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    When I double-clicked on size dropdown
    Then I see that size dropdown list is not shown

  @PDP+
  @Size
  Scenario: Test3 - Positive - Checking that product is in stock
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/korallrödrandig"
    And I see that color "Vit/korallrödrandig" was selected correctly
    And I selected size "40"
    And I see that size "40" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test4 - Positive - Checking that product is Few in stock
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Blå/vit randig"
    And I see that color "Blå/vit randig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "1 Kvar i lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test5 - Positive - Checking that product is Out of stock
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    Then I check that size "36" is Out of stock and size is disabled

  @PDP+
  @Size
  Scenario: Test6 - Positive - Checking that button Add to cart is disabled
    Given I am at ellos_se
    And I switch to "ViTaLES/ViTaLES/1035733-07-36"
    And I check that I switch to PDP correct
    And I see that button Add to cart is disabled
    And I see that button Add to wishlist is disabled
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test7 - Positive - Checking that product is 1 left
    Given I am at ellos_se
    And I switch to "ViTaLES/ViTaLES/1035733-07-40"
    And I check that I switch to PDP correct
    And I selected size "40"
    And I see that size "40" was selected correctly with label "1 Kvar i lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test8 - Positive - Checking add product to cart without selecting a size - default size
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test9 - Positive - Checking switch between product sizes
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I selected size "48"
    And I see that size "48" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I selected size "40"
    And I see that size "40" was selected correctly with label "1 Kvar i lager"
    And I see that button Add to cart is enable
    And I selected size "52"
    And I see that size "52" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test10 - Positive - Checking switch between product sizes and colors
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    Then I check that size "36" is Out of stock and size is disabled
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "I lager"
    And I see that button Add to cart is enable
    And On product page I choose color "Blå/vit randig"
    And I see that color "Blå/vit randig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "1 Kvar i lager"
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test11 - Positive - Checking selection of product size and refresh page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Vit/mörk marinblårandig"
    And I see that color "Vit/mörk marinblårandig" was selected correctly
    And I selected size "44"
    And I see that size "44" was selected correctly with label "I lager"
    And I refresh the page
    And I see that color "Marin/vitrandig" was selected correctly
    And I see that button Add to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the product was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test12 - Positive - Checking selection size of standard product and fabric product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And On product page I choose color "Marin/vitrandig"
    And I see that color "Marin/vitrandig" was selected correctly
    And I see that button Add to cart is enable
    And I add product to the Basket
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Beige"
    And I see that color "Beige" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "10.1" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete products from basket and switch to main page
    And I switch to Main page from Product page

    ###
    #   Fabric product
  ###
  @PDP+
  @Size
  Scenario: Test1 - Positive - Add product 1_0 - 20_0 meters using point
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Beige"
    And I see that color "Beige" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "1.5" for Fabric product
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
  @Size
  Scenario: Test2 - Positive - Add more meters
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "18.5" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I add product to the Basket
    And I fill size "3" for Fabric product
    And I add product to the Basket
    When I open mini cart
    Then I see that the products was added to the mini cart correctly
    And I close minicart
    And I delete product from basket and switch to main page
    And I switch to Main page from Product page

  @PDP+
  @Size
  Scenario: Test3 - Negative - Add length under 1_0 meters
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "0.9" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test4 - Negative - Add length over 20_0 meters
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "20.1" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test5 - Negative - Add length much higher then 20_0 meters
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "10000" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test6 - Negative - Add length with negative value
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "-1" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test7 - Negative - Add length with text value
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "test" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test8 - Negative - Add length with symbol value
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "+.+" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test9 - Negative - Add length as combo numbers and chars
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "12etc" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test10 - Negative - Add length as number in hexadecimal
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "2E" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test11 - Negative - Add length in formula format
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "2+2" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"

  @PDP+
  @Size
  Scenario: Test12 - Negative - Add length as exponential number
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    And On product page I choose color "Svart"
    And I see that color "Svart" was selected correctly
    And I see that label is "I lager" for Fabric product
    And I fill size "1.e+2" for Fabric product
    And I see that button Add to cart is enable
    And I see that button Add to wishlist is enable
    And I see that button Add Sample to cart is enable
    And I click add to cart button
    Then I can see a warning "Ange längd i meter (1,0 - 20,0)"


  @PDPp//заготовка_к_чекауту
  @Siz
  Scenario: Test12 - Positive - Checking selection of different product sizes
    Then I see that the "Svart" color is selected correctly and the picture is displayed correctly
    And The alternative images are shown correctly
    And I selected size "36"
    And I see that size "36" was selected correctly

    And I see that button Add to cart is disabled
