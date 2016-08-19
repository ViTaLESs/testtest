Feature: Registration new users on Checkout page
  RT-192 BP04.02.01 - SE - Registration Validation

  #Removeme@ellos.se


  @RegistrationOnCheckout
  Scenario: Test1 - Positive - Registration in Checkout - Registration form UI
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I write personal number "197501187541"
    And I press button Continue
    And I am checking that the full Registration form shown correctly
    And I click on "CloseRegistrationFormButton"
    And I check that Login shown correctly on checkout page
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test2 - Positive - Registration in Checkout - Checking checkboxes for receive offers by email and sms
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I write personal number "197501187541"
    And I press button Continue
    And I am checking that the full Registration form shown correctly
    And Checking that checkbox "Checkbox_ReceiveOffersByEmail" selected
    And Checking that checkbox "Checkbox_ReceiveOffersBySMS" selected
    And I click on "Checkbox_ReceiveOffersByEmail_forClick"
    And I click on "Checkbox_ReceiveOffersBySMS_forClick"
    And Checking that checkbox "Checkbox_ReceiveOffersByEmail" DEselected
    And Checking that checkbox "Checkbox_ReceiveOffersBySMS" DEselected
    And I click on "Checkbox_ReceiveOffersByEmail_forClick"
    And I click on "Checkbox_ReceiveOffersBySMS_forClick"
    And Checking that checkbox "Checkbox_ReceiveOffersByEmail" selected
    And Checking that checkbox "Checkbox_ReceiveOffersBySMS" selected
    And I delete product from checkout and switch to main page


  @RegistrationOnCheckout
  Scenario: Test3 - Positive - Registration in Checkout - Registration with civic number
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I write personal number "197501187541"
    And I press button Continue
    Then I will see that I am on Checkout page with First Name "Sofia", Last Name "Larsson", Street "Ri********* 4*", ZipCode "79***", City "Su******"
    And for every field on Checkout page which filled correctly I get a OK-sign
    And I press confirm registration button
    And I will see that I am on Checkout page and I am registered
    And I delete product from checkout and switch to main page and logout

  @RegistrationOnCheckout
  Scenario: Test4 - Positive - Registration in Checkout - Registration without civic number
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And for every field on Checkout page which filled correctly I get a OK-sign
    And click on "CreateAccountButton"
    Then I will see that I am on Checkout page and I am registered
    And I delete product from checkout and switch to main page and logout

  @RegistrationOnCheckout
  Scenario: Test5 - Positive - Registration in Checkout - Registration without civic number and no selected checkboxes for receive offers by email and sms
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And I am checking that the full Registration form shown correctly
    And I click on "Checkbox_ReceiveOffersByEmail_forClick"
    And Checking that checkbox "Checkbox_ReceiveOffersByEmail" DEselected
    And I click on "Checkbox_ReceiveOffersBySMS_forClick"
    And Checking that checkbox "Checkbox_ReceiveOffersBySMS" DEselected
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And for every field on Checkout page which filled correctly I get a OK-sign
    And click on "CreateAccountButton"
    Then I will see that I am on Checkout page and I am registered
    And I delete product from checkout and switch to main page and logout


  @RegistrationOnCheckout
  Scenario: Test6 - Negative - Registration in Checkout - incorrect civic number
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I write personal number "1980010533TESTTEST"
    And I press button Continue
    Then I will see warning that it is incorrect filling personal number field "Incorrect format of civic number" and I am not registered
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test7 - Negative - Registration in Checkout - incorrect email
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@blabla"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    Then I will see warning that it is incorrect filling required field and I am not registered
    And I delete product from checkout and switch to main page

# must be present warning about mask
# must be shown on the message Passwords do not match
  @RegistrationOnCheckout
  Scenario: Test8 - Negative - Registration in Checkout - short password
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Pass"
    And confirm password "Password1"
    And I press button Continue
    Then I will see warning about incorrect password mask "Password must be at least 8 characters long, contain both uppercase and lowercase characters and at least one digit."
    And I will see warning that passwords do not match
    And I delete product from checkout and switch to main page

# must be present warning about mask
# must NOT be shown on the message Passwords do not match!
  @RegistrationOnCheckout
  Scenario: Test9 - Negative - Registration in Checkout - only lowercase and uppercase value without digit
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password"
    And confirm password "Password"
    And I press button Continue
    Then I will see warning about incorrect password mask "Password must be at least 8 characters long, contain both uppercase and lowercase characters and at least one digit."
    And I will NOT see warning that passwords do not match
    And I delete product from checkout and switch to main page

# must be shown on the message Passwords do not match
  @RegistrationOnCheckout
  Scenario: Test10 - Negative - Registration in Checkout - incorrect confirmation password
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Pass"
    And I press button Continue
    And I will see warning that passwords do not match
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test11 - Negative - Registration in Checkout - incorrect phone number
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "093TEST"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    Then I will see warning that it is incorrect filling phone field

  @RegistrationOnCheckout
  Scenario: Test12 - Positive - Registration in Checkout - long first and last name/100 char
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "firstName_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_"
    And last name "lastName1_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    Then I will see that I am on Checkout page and I am registered
    And I delete product from checkout and switch to main page and logout

  @RegistrationOnCheckout
  Scenario: Test13 - Negative - Registration in Checkout - too long first name - 101 char
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "firstName_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_1"
    And last name "lastName1_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    Then I will see warning that first name are too long and I am not registered on Checkout page
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test14 - Negative - Registration in Checkout - too long last name - 101 char
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "firstName_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_"
    And last name "lastName1_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_Test1234_1"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    Then I will see warning that last name are too long and I am not registered on Checkout page
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test15 - Negative - Registration in Checkout - too long address line1
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And address line1 "Test12345678Test12345678Test123456789"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    Then I will see warning that address line1 too long "Address1 can be 36 characters" and I am not registered
    And I delete product from checkout and switch to main page


  @RegistrationOnCheckout
  Scenario: Test16 - Negative - Registration in Checkout - too long address line2
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And click on address line2 button
    And address line1 "Test123"
    And address line2 "Test12345678Test12345678Test123456789"
    And zip code "50433"
    And city "Borås"
    And click on "CreateAccountButton"
    Then I will see warning that address line2 too long "Address2 can be 36 characters" and I am not registered
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test17 - Negative - Registration in Checkout - too long zipcode and city
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Test1234567890Test1234567890Test"
    And click on "CreateAccountButton"
    Then I will see warning that zip code and city too long "City can be 36 characters" and I am not registered
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test18 - Negative - Registration in Checkout - incorrect zip code
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And address line1 "Testgatan 30"
    And zip code "123Tes"
    And city "Borås"
    And click on "CreateAccountButton"
    Then I will see warning that it is incorrect zip code and I am not registered
    And I delete product from checkout and switch to main page

  @RegistrationOnCheckout
  Scenario: Test19 - Negative - Registration in Checkout - unfilled required fields
    Given I am at ellos_se
    And I switch to product page (Standard product)
    And I add product to the Basket
    And switch to checkout
    And I register a new customer
    When I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And I leave all required fields empty
    And click on "CreateAccountButton"
    Then I will see warning on Checkout page, All unfilled required fields is marked in red and I am not registered
    And I delete product from checkout and switch to main page



