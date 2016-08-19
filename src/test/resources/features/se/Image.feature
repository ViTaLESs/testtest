Feature: Product image on PDP
  RT-721 - Product image handling
  RT-722 - PDP - size selection (image part)
  OMG-2012 PDP - All product images from PIM in Intershop - UI =>  RT -(not ready yet) - according images on PDP

  @Image
  Scenario: Test1 - Positive - UI
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    And I check that All colors are represented in the form of rings
    When On product page I click on product image
    Then Image Container that holds slides, product image and image top-bar are shown
    And The product image is shown on the center of the container
    And The product image has the same color which was selected on color panel
    And Image Container top-bar contains zoom, full screen, close icons
    And I close image
    And I switch to Main page from Product page

  @Image
  Scenario: Test2 - Negative - close Image Container using ESCAPE
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I click on product image
    Then Image Container that holds slides, product image and image top-bar are shown
    And I close image using ESCAPE
    And I switch to Main page from Product page

  @Image
  @Color
  Scenario: Test3 - Positive - Checking transition to another color
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I choose color "Vit/korallrödrandig"
    Then I see that the "Vit/korallrödrandig" color is selected correctly and the picture is displayed correctly
    And I switch to Main page from Product page

  @Image
  @Color
  Scenario: Test4 - Positive - Check that Alternative images are shown
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I choose color "Vit/mörk marinblårandig"
    Then I see that the "Vit/mörk marinblårandig" color is selected correctly and the picture is displayed correctly
    And The alternative images are shown correctly
    And I switch to Main page from Product page

  @Image
  @Color
  Scenario: Test5 - Positive - Check that Alternative images are shown; more than 4 images
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I choose color "Blå/vit randig"
    Then I see that the "Blå/vit randig" color is selected correctly and the picture is displayed correctly
    And The alternative images are shown correctly
    And I see that I can slide down to see the rest of the images
    And I switch to Main page from Product page

  @Image
  @Color
  Scenario: Test6 - Positive - Checking of Alternative images when user change colors
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I choose color "Vit/mörk marinblårandig"
    And On product page I choose color "Marin/vitrandig"
    Then I see that the "Marin/vitrandig" color is selected correctly and the picture is displayed correctly
    And The alternative images are shown correctly
    And I switch to Main page from Product page

  @Image
  @Color
  Scenario: Test7 - Positive - Checking of Alternative images - Big image changed
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I choose color "Vit/korallrödrandig"
    Then I see that the "Vit/korallrödrandig" color is selected correctly and the picture is displayed correctly
    And I click on one of the alternative images
    And I will see that the big image is changed to the alternative image
    And I switch to Main page from Product page

  @Image
  Scenario: Test8 - Positive - Image Container; leaf through the right
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I click on product image
    And I leaf through the right to see the next image
    And I close image

  @Image
  Scenario: Test9 - Positive - Image Container; leaf through the left
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I choose color "Vit/korallrödrandig"
    And On product page I click on product image
    And I leaf through the left to see the next image
    And I close image

    #Unstable, weak server, locally - pass
  @Image
  Scenario: Test10 - Positive - zoom by button
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I click on product image
    Then I check that zoom button works correct
    And I close image
    And I switch to Main page from Product page

    #Unstable, weak server, locally - pass
  @Image
  Scenario: Test11 - Positive - zoom by click
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I click on product image
    Then I check that zoom by click works correct
    And I close image
    And I switch to Main page from Product page

  @Image
  Scenario: Test12 - Negative - close Image Container in zoom regime
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I click on product image
    Then I click on zoom button
    And I close image
    And I switch to Main page from Product page

  @Image
  Scenario: Test13 - Positive - full screen
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    When On product page I click on product image
    Then I check that full screen works correct
    And I close image
    And I switch to Main page from Product page

