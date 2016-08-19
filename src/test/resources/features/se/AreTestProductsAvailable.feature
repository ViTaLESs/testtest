Feature: Are Test Products Available?

  @AreTestProductsAvailable?
  Scenario: 1 - Positive - Is product available - Standard product
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for Standard product

  @AreTestProductsAvailable?
  Scenario: 2 - Positive - Is product available - Bulky product
    Given I am at ellos_se
    And I switch to product page (Bulky product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for Bulky product

  @AreTestProductsAvailable?
  Scenario: 3 - Positive - Is product available - Fabric product
    Given I am at ellos_se
    And I switch to product page (Fabric product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for Fabric product

  @AreTestProductsAvailable?
  Scenario: 4 - Positive - Is product available - DropShip product
    Given I am at ellos_se
    And I switch to product page (DropShip product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for DropShip product

  @AreTestProductsAvailable?
  Scenario: 5 - Positive - Is product available - Book product
    Given I am at ellos_se
    And I switch to product page (Book product)
    And I check that I switch to PDP correct
    Then I see that all product attributes are presents for Book product
