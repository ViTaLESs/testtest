Feature: Search for products and brands

  EC-226 - Text search for products - dropdown feature - product suggestions

  @Search
  Scenario: Test1 - Positive - close search - click on darker area
    Given I am at ellos_se
    And I click Search in the menu
    And I will see that a search-field is shown
    And The search-button is present
    And I see that the rest of the page content is darker
    And I click on darker area
    Then I will see that the search field is hidden

  @Search
  Scenario: Test2 - Positive - close search - press "Esc"
    Given I am at ellos_se
    And I click Search in the menu
    And I will see that a search-field is shown
    And The search-button is present
    And I see that the rest of the page content is darker
    And I press Esc
    Then I will see that the search field is hidden

  @Search
  Scenario: Test3 - Positive - close search - click on Search in the menu again
    Given I am at ellos_se
    And I click Search in the menu
    And I will see that a search-field is shown
    And The search-button is present
    And I see that the rest of the page content is darker
    And I click on Search in the menu again
    Then I will see that the search field is hidden

  @Search
  Scenario: Test4 - Positive - Search product
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "T-shirts"
    And I press Enter
    Then I will see a list with relevant products is shown

  @Search
  Scenario: Test5 - Positive - Search brand
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type brand "Adidas"
    And I press Enter
    Then I will see a list with brand relevant products is shown

  @Search
  Scenario: Test6 - Positive - Search by Standard product number
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "1035733"
    And I press Enter
    Then I will see a list with relevant products is shown

  @Search
  Scenario: Test7 - Positive - Search by Bulky product number
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "1048931"
    And I press Enter
    Then I will see a list with relevant products is shown

  @Search
  Scenario: Test8 - Positive - Search by Fabric product number
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "1077230"
    And I press Enter
    Then I will see a list with relevant products is shown

  @Search
  Scenario: Test9 - Positive - Search by DropShip product number
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "1018922"
    And I press Enter
    Then I will see a list with relevant products is shown

  @Search
  Scenario: Test10 - Positive - Search by Book product number
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "1022782"
    And I press Enter
    Then I will see a list with relevant products is shown

  @Search
  Scenario: Test11 - Negative - Search Product
    Given I am at ellos_se
    And I click Search in the menu
    When In search-field I type "Test"
    And I press Enter
    Then I will see empty list with a message that the search did not find the goods

  @Search
  Scenario: Test12 - Positive - Search auto-complete
    Given I am at ellos_se
    And I click Search in the menu
    And I will see that a search-field is shown
    When In search-field I type "Jea"
    Then I will see that drop-down display the options to complete the text for search

  @Search
  Scenario: Test13 - Negative - Search auto-complete
    Given I am at ellos_se
    And I click Search in the menu
    And I will see that a search-field is shown
    When In search-field I type "!@#"
    Then I will see that drop-down don't display the options to complete the text for search


