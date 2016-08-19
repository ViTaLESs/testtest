Feature: Main page / Home page

  EC-212 Product lineup
  RT-1188 Product lineup
  RT-1207 Testing Hello bar - connection to Amplience

  @MainPage
  Scenario: Test1 - Main page - Logo
    Given I am at ellos_se
    And I check that I switch to Main page correct
    And I click on "Logo"
    And I check that Logo is present on Main page

  @MainPage
  Scenario: Test2 - Main page - Main-header
    Given I am at ellos_se
    Then I see that Header and links of header are presented

  @MainPage
  Scenario: Test3 - Main page - Main-header - Customer services link
    Given I am at ellos_se
    And I click on "Header_CustomerService_Link"
    And I check that I switch to HelpDesk page correctly

  @MainPage
  Scenario: Test4 - Main page - Main-header - Lend And Insure link
    Given I am at ellos_se
    And I click on "Header_LendAndInsure_Link"
    And I check that I switch to Lend And Insure page correctly

  @MainPage
  Scenario: Test5 - Main page - Main-header - My Favorite link for Logout user
    Given I am at ellos_se
    And I click on "Header_Favourites_Link"
    And I check that I switch to MyCabinet page for Logout user

  @MainPage
  Scenario: Test6 - Main page - Main-header - My Favorite link for Login user
    Given I am at ellos_se
    And I click Login link
    And I check that I switch to Login page correctly
    And I click on "ShowLoginFormButton"
    And I am checking that the Login form shown correctly
    When I write Email address "autotestCustomer@ellos.se"
    And I write password "Password1"
    And I click on button Login
    Then I see that I am logged in
    And I switch to the main page from myCabinet
    And I click on "Header_Favourites_Link"
    And I check that I switch to MyCabinet page and My Favorite submenu correctly
    And I logged out

  @MainPage
  Scenario: Test7 - Main page - Hello bar
    Given I am at ellos_se
    And I scroll the page down
    Then I see that the Hello bar and internal text are presented

  @MainPage
  Scenario: Test8 - Main page - Upper footer UI
    Given I am at ellos_se
    And I scroll page to Upper Footer
    Then I check that UpperFooter block looks correctly

  @MainPage
  Scenario: Test9 - Main page - Footer UI
    Given I am at ellos_se
    And I scroll page to Footer
    Then I check that Footer block looks correctly

  @MainPage
  Scenario: Test10 - Main page - Footer Country Flag - SE
    Given I am at ellos_se
    And I scroll page to Footer
    And I click on "Footer_CountryFlag_SE"
    Then I check that ellos"se" is open

  @MainPage
  Scenario: Test11 - Main page - Footer Country Flag - NO
    Given I am at ellos_se
    And I scroll page to Footer
    And I click on "Footer_CountryFlag_NO"
    Then I check that ellos"no" is open

  @MainPage
  Scenario: Test12 - Main page - Footer Country Flag - DK
    Given I am at ellos_se
    And I scroll page to Footer
    And I click on "Footer_CountryFlag_DK"
    Then I check that ellos"dk" is open

  @MainPage
  Scenario: Test13 - Main page - Footer Country Flag - FI
    Given I am at ellos_se
    And I scroll page to Footer
    And I click on "Footer_CountryFlag_FI"
    Then I check that ellos"fi" is open



  @ProductLineup
  Scenario: Test1 - Product lineup layout
    Given I am at ellos_se
    When I scroll page to Product lineup
    Then I see that title Product lineup shown correct
    And I see that lineup images, collection texts, product names and prices are shown
    #And I see that "Productlineup_NextSlideArrow" is present

  @ProductLineup
  Scenario: Test2 - Product lineup layout - check slick-next and slick-previous
    Given I am at ellos_se
    When I scroll page to Product lineup
    And I see that "Productlineup_NextSlideArrow" is present
    And I click on "Productlineup_NextSlideArrow" and wait for element "Productlineup_PrevSlideArrow"
    And I see that "Productlineup_PrevSlideArrow" is present
    And I click on "Productlineup_PrevSlideArrow" and wait for element "Productlineup_NextSlideArrow"
    And I see that lineup images, collection texts, product names and prices are shown
    And I see that "Productlineup_NextSlideArrow" is present

  @ProductLineup
  Scenario: Test3 - Product lineup layout - check that product modal window shown correct from Product lineup
    Given I am at ellos_se
    When I scroll page to Product lineup
    And I click on "Productlineup_FirstProductImg" and wait for element "Productlineup_ProductModalWindow"
    Then I see that "Productlineup_ProductModalWindow" is present
    And I click on "Productlineup_ProductModalWindowCloseButton"
    And I see that Product Modal Window was closed successfully
