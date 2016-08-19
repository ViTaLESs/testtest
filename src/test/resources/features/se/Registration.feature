Feature: Registration new users from Registration page
  RT-192 BP04.02.01 - SE - Registration Validation



  @Registration
  Scenario: Test1 - Positive - Registration form UI
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I write personal number "197501187541"
    And I press button Continue
    And I am checking that the full Registration form shown correctly
    And I click on "CloseRegistrationFormButton"
    And I check that I switch to Login page correctly
    Then I switch to the main page from login

  @Registration
  Scenario: Test2 - Positive - Registration page - Checking checkboxes for receive offers by email and sms
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
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
    Then I switch to the main page from registration page

  @Registration
  Scenario: Test3 - Positive - Registration page - Registration with civic number
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I write personal number "197501187541"
    And I press button Continue
    Then I see that I am registered with First Name "Sofia", Last Name "Larsson", Street "Ri********* 4*", ZipCode "79***", City "Su******"
    And for every field which filled correctly I get a OK-sign
    And I press button CreateAccount
    And I check that I switch to MyCabinet correct and registration was successful
    And I logout and switch to main page correct

  @Registration
  Scenario: Test4 - Positive - Registration page - Registration without civic number
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And first name "Vitalii_Reg"
    And last name "Laputko_Reg"
    And address line1 "Testgatan 30"
    And zip code "50433"
    And city "Borås"
    And for every field which filled correctly I get a OK-sign
    And I press button CreateAccount
    And I check that I switch to MyCabinet correct and registration was successful
    And I logout and switch to main page correct

  @Registration
  Scenario: Test5 - Positive - Registration page - Registration without civic number and no selected checkboxes for receive offers by email and sms
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
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
    And for every field which filled correctly I get a OK-sign
    And I press button CreateAccount
    And I check that I switch to MyCabinet correct and registration was successful
    And I logout and switch to main page correct

  @Registration
  Scenario: Test6 - Negative - Registration page - incorrect civic number
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    When I write personal number "1980010533TESTTEST"
    And I press button Continue
    Then I will see warning that it is incorrect filling personal number field "Personnumret stämmer inte." and I am not registered

  @Registration
  Scenario: Test7 - Negative - Registration page - incorrect email
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@@blabla"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    Then I will see warning that it is incorrect filling required field and I am not registered
    And I switch to the main page from registration page


# must be present warning about mask
# must be shown on the message Passwords do not match
  @Registration
  Scenario: Test8 - Negative - Registration page - short password
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Pass"
    And confirm password "Password1"
    And I press button Continue
    Then I will see warning about incorrect password mask "Lösenord måste bestå av minst 8 tecken, innehålla både stora och små bokstäver och minst en siffra."
    And I will see warning that passwords do not match
    And I am on registration page and not registered
    And I switch to the main page from registration page

# must be present warning about mask
# must NOT be shown on the message Passwords do not match!
  @Registration
  Scenario: Test9 - Negative - Registration page - only lowercase and uppercase value without digit
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password"
    And confirm password "Password"
    And I press button Continue
    Then I will see warning about incorrect password mask "Lösenord måste bestå av minst 8 tecken, innehålla både stora och små bokstäver och minst en siffra."
    And I will NOT see warning that passwords do not match
    And I am on registration page and not registered
    And I switch to the main page from registration page

# must be shown on the message Passwords do not match(looks like fixed)
  @Registration
  Scenario: Test10 - Negative - Registration page - incorrect confirmation password
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Pass"
    And I press button Continue
    And I will see warning that passwords do not match
    And I am on registration page and not registered
    And I switch to the main page from registration page

  @Registration
  Scenario: Test11 - Negative - Registration page - incorrect phone number
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "093TEST"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    Then I will see warning that it is incorrect filling phone field
    And I switch to the main page from registration page

  @Registration
  Scenario: Test12 - Positive - Registration page - long first and last name - 100 char
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
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
    Then I logout and switch to main page correct


  @Registration
  Scenario: Test13 - Negative - Registration page - too long first name - 101 char
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
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
    Then I will see warning that first name are too long and I am not registered

  @Registration
  Scenario: Test14 - Negative - Registration page - too long last name - 101 char
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
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
    Then I will see warning that last name are too long and I am not registered

  @Registration111
  Scenario: Test15 - Negative - Registration page - too long address line1
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
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
    Then I will see warning that address line1 too long "Adressen får max vara 36 tecken" and I am not registered

  @Registration1
  Scenario: Test16 - Negative - Registration page - too long address line2
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
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
    Then I will see warning that address line2 too long "c/o adressen får max vara 36 tecken" and I am not registered

  @Registration
  Scenario: Test17 - Negative - Registration page - too long zip code and city
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
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
    Then I will see warning that zip code and city too long "Max antal tecken är 36" and I am not registered

  @Registration
  Scenario: Test18 - Negative - Registration page - incorrect zip code
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
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

  @Registration
  Scenario: Test19 - Negative - Registration page - unfilled required fields
    Given I am at ellos_se
    And I switch to Login Page
    And I click on "ShowRegistrationFormButton"
    And I am checking that the short Registration form shown correctly
    And I write email address "Removeme@ellos.se"
    And phone number "0933333339900"
    And password "Password1"
    And confirm password "Password1"
    And I press button Continue
    And I leave all required fields empty
    And click on "CreateAccountButton"
    Then I will see warning, All unfilled required fields is marked in red and I am not registered


