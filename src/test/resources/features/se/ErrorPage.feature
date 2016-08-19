Feature: Error page/Page not found
  EC-228 Error page (Technical problems)
  EC-216 Page not found - 404 page (sorry page)


  #@ErrorPage   ==> stop purchase customer?! + protected address customer
  Scenario: Test2 - stop purchase customer
    Given I am at ellos_se
    When I login as stop purchase customer
    And try to reach checkout
    Then I see correct error page
    And Layout according to agreement with customer
  #@ErrorPage   ==> protected address customer?!
  Scenario: Test3 - protected address customer
    Given I am at ellos.se/no/fi/dk
    When I login as protected address customer
    And try to reach checkout
    Then I see correct error page
    And Layout according to agreement with customer

  @ErrorPage
  Scenario: Test1 - Positive - invalid link
    Given I am at ellos_se
    When I switch to "https://istest.ellos.se/INTERSHOP/web/WFS/Ellos-EllosSE-Site/sv_SE/-/SEK/ViewProduct-Start?SKU=testtesttest"
    Then I see that error messages "Page not found" and "The page you are looking for is currently not available." are present
    And I switch to Main page

  @ErrorPage
  Scenario: Test2 - Positive - incorrect SKU - Page not found
    Given I am at ellos_se
    When I switch to "https://istest.ellos.se/INTERSHOP/web/WFS/Ellos-EllosSE-Site/sv_SE/-/SEK/ViewProduct-Start?SKU=A0004"
    Then I see that error messages "Page not found" and "The page you are looking for is currently not available." are present
    And I switch to Main page

  @ErrorPage
  Scenario: Test3 - Positive - Back to previous page
    Given I am at ellos_se
    When I switch to "https://istest.ellos.se/INTERSHOP/web/WFS/Ellos-EllosSE-Site/sv_SE/-/SEK/ViewProduct-Start?SKU=testtesttest"
    Then I see that error messages "Page not found" and "The page you are looking for is currently not available." are present
    And I press button Go to home page
    And I check that I switch to Main page correct

  @ErrorPage
  Scenario: Test4 - Positive - Go to home page
    Given I am at ellos_se
    And I switch to product page (Standard product)
    When I switch to "https://istest.ellos.se/INTERSHOP/web/WFS/Ellos-EllosSE-Site/sv_SE/-/SEK/ViewProduct-Start?SKU=testtesttest"
    Then I see that error messages "Page not found" and "The page you are looking for is currently not available." are present
    And I press button Back to previous page
    And I check that I switch to PDP correct
    And I switch to Main page from Product page





