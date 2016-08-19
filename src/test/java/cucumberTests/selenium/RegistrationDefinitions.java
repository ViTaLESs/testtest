package cucumberTests.selenium;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;


public class RegistrationDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /**
     Buttons
     */
    @And("^I press button Continue$")
    public void pressButtonContinue() {
        ellos().registrationPage.pressButtonContinue();
    }

    @And("^I press button CreateAccount$")
    public void pressButtonCreateAccount$() {
        ellos().registrationPage.pressButtonCreateAccount();
        ellos().mycabinetPage.checkCorrectSwitchToMyCabinet();
    }

    @When("^click on \"([^\"]*)\"$")
    public void click_on(String buttonLocator) {
        ellos().registrationPage.confirmRegistration(buttonLocator);
    }

    @When("^click on address line2 button$")
    public void click_on_address_line2_button() {
        ellos().registrationPage.clickOn_AddSecondAddressButton();
    }


    /**
     Fields
     */
    @And("^I write email address \"([^\"]*)\"$")
    public void email_address(String email) {
        ellos().registrationPage.fillEmailAddress(email);
    }

    @And("^phone number \"([^\"]*)\"$")
    public void phone_number(String number) {
        ellos().registrationPage.fillPhoneNumberField(number);
    }

    @And("^password \"([^\"]*)\"$")
    public void password(String pass) {
        ellos().registrationPage.fillPasswordField(pass);
    }

    @And("^confirm password \"([^\"]*)\"$")
    public void confirm_password(String pass) {
        ellos().registrationPage.fillConfirmPasswordField(pass);
    }

    @And("^I write personal number \"([^\"]*)\"$")
    public void i_write_personal_number(String civicNumberValue) {
        ellos().registrationPage.fillPersonalNumber(civicNumberValue);
    }

    @And("^for every field which filled correctly I get a OK-sign$")
    public void for_every_field_which_filled_correctly_I_get_a_OK_sign() {
        ellos().registrationPage.checkPresentSignsForCorrectlyFilledFields("LoginTitle");
    }

    @And("^Checking that checkbox \"([^\"]*)\" selected$")
    public void checkingTheCheckboxSelected (String checkbox) {
        Assert.assertTrue(ellos().web.isElementSelected(checkbox), "Checkbox - " + checkbox + " is NOT SELECTED!");
    }

    @And("^Checking that checkbox \"([^\"]*)\" DEselected$")
    public void checkingThatCheckboxDESelected(String checkbox) {
        Assert.assertFalse(ellos().web.isElementSelected(checkbox), "Checkbox - " + checkbox + " is SELECTED!");
    }

    @When("^first name \"([^\"]*)\"$")
    public void first_name(String name) {
        ellos().registrationPage.fillFirstName(name);
    }

    @When("^last name \"([^\"]*)\"$")
    public void last_name(String lastName) {
        ellos().registrationPage.fillLastName(lastName);
    }

    @When("^address line1 \"([^\"]*)\"$")
    public void address_line1(String address) {
        ellos().registrationPage.fillAddressLine1(address);
    }

    @When("^address line2 \"([^\"]*)\"$")
    public void address_line2(String address) {
        ellos().registrationPage.fillAddressLine2(address);
    }

    @When("^zip code \"([^\"]*)\"$")
    public void zip_code(String zipCode) {
        ellos().registrationPage.fillZipCode(zipCode);
    }

    @When("^city \"([^\"]*)\"$")
    public void city(String city) {
        ellos().registrationPage.fillCityField(city);
    }

    @When("^I leave all required fields empty$")
    public void i_leave_all_required_fields_empty() {
        ellos().registrationPage.leaveAllRequiredFieldsEmpty();
    }


    /**
     Verify
     */
    @Then("^I logout and switch to main page correct$")
    public void i_logout_and_switch_to_main_page_correct() {
        ellos().mycabinetPage.logout();
        ellos().mycabinetPage.checkCorrectSwitchToMainPage();
    }

    @Then("^I check that I switch to MyCabinet correct and registration was successful$")
    public void i_check_switch_to_MyCabinet_and_successful_registration() {
        ellos().mycabinetPage.checkCorrectSwitchToMyCabinet();

        //TODO finish registration checking
    }


    @Then("^I switch to the main page from registration page$")
    public void i_click_LogoLink() {
        ellos().registrationPage.switchToMainPage();
    }

    @Then("^I see that I am registered with First Name \"([^\"]*)\", Last Name \"([^\"]*)\", Street \"([^\"]*)\", ZipCode \"([^\"]*)\", City \"([^\"]*)\"$")
    public void i_see_that_I_am_registered_with_First_Name_Last_Name_Address_Adress(String firstName, String lastName, String street, String zipCode, String city) {
        ellos().registrationPage.checkRegistrationWithCivicNumber(firstName, lastName, street, zipCode, city);
    }

    @Then("^I will see warning that it is incorrect filling personal number field \"([^\"]*)\" and I am not registered$")
    public void i_will_see_warning_that_it_is_incorrect_filling_personal_number_field_and_I_am_not_registered(String errorMessage) {
        ellos().registrationPage.checkIncorrectPersonalNumber(errorMessage);
    }

    @Then("^I will see warning that it is incorrect filling required field and I am not registered$")
    public void i_will_see_warning_that_it_is_incorrect_filling_required_field_and_I_am_not_registered() {
        ellos().registrationPage.verificationOfError();
    }

    @Then("^I will see warning about incorrect password mask \"([^\"]*)\"$")
    public void i_will_see_warning_about_incorrect_password_mask(String errorMessage) {
        ellos().registrationPage.checkPasswordMaskErrorPresent(errorMessage);
    }

    @Then("^I will see warning that passwords do not match$")
    public void i_will_see_warning_that_passwords_do_not_match() {
        Assert.assertTrue(ellos().web.isElementPresent("ConfirmPassword_PassDoNotMatch_ErrorMessage"), "ConfirmPassword_PassDoNotMatch_ErrorMessage is INCORRECT!");
}

    @Then("^I will NOT see warning that passwords do not match$")
    public void i_will_NOT_see_warning_that_passwords_do_not_match() {
        Assert.assertFalse(ellos().web.isElementPresent("ConfirmPassword_PassDoNotMatch_ErrorMessage"), "ConfirmPassword_PassDoNotMatch_ErrorMessage is Present!\n" +
                "PassDoNotMatch_ErrorMessage - " + ellos().web.getElementText("ConfirmPassword_PassDoNotMatch_ErrorMessage"));
    }

    @Then("^I am on registration page and not registered$")
    public void i_am_on_registration_page_and_not_registered() {
        Assert.assertTrue(ellos().web.isElementPresent("ContinueButton") && ellos().web.isElementPresent("EmailAddressField"), "It was expected that I would be on the registration page and not registered");
    }

    @Then("^I will see warning that it is incorrect filling phone field$")
    public void i_will_see_warning_that_it_is_incorrect_filling_phone_field() {
        ellos().registrationPage.verificationOfErrorByErrorLocator("FirstErrorMessage");
    }

    @Then("^I will see warning that first name are too long and I am not registered$")
    public void first_name_are_too_long() {
        ellos().registrationPage.verificationOfErrorByErrorLocator("FirstNameErrorMessage");
    }

    @Then("^I will see warning that last name are too long and I am not registered$")
    public void last_name_are_too_long() {
        ellos().registrationPage.verificationOfErrorByErrorLocator("LastNameErrorMessage");
    }


//////







//////


//"Address1 can be 36 characters"
    @Then("^I will see warning that address line1 too long \"([^\"]*)\" and I am not registered$")
    public void address_line1_are_more_than_36_chars(String errorMessage) {
        ellos().registrationPage.checkToLong_Address1_ErrorIsPresent(errorMessage);
        Assert.assertTrue(ellos().web.isElementPresent(""));
    }

    @Then("^I will see warning that address line2 too long \"([^\"]*)\" and I am not registered$")
    public void address_line2_are_more_than_36_chars(String errorMessage) {
        ellos().registrationPage.checkTooLong_Address2_ErrorIsPresent(errorMessage);
    }

    //Expected message "Zipcode + \" \" + City can be 36 characters"
    //But parameter is "City can be 36 characters" cause problems in the screening gerkine
    @Then("^I will see warning that zip code and city too long \"([^\"]*)\" and I am not registered$")
    public void zip_code_and_city_are_more_than_36_chars(String errorMessage) {
        ellos().registrationPage.checkTooLong_ZipCode(errorMessage);
    }

    @Then("^I will see warning that it is incorrect zip code and I am not registered$")
    public void incorrect_zipcode() {
        ellos().registrationPage.checkIncorrectZipCode();
    }

    @Then("^I will see warning, All unfilled required fields is marked in red and I am not registered$")
    public void i_will_see_warning_All_unfilled_required_fields_is_marked_in_red_and_I_am_not_registered() {
        ellos().registrationPage.checkPresentSignsForINCORRECTLYFilledFields();
        ellos().web.clickLink("MyEllosLink");
        ellos().registrationPage.switchToMainPage();
    }




    /**
    *
    *   Registration In Basket Definitions
    *
     */
    @Given("^switch to checkout$")
    public void switch_to_checkout() {
        ellos().productPage.switchToCheckoutPage();
    }

    @Given("^I register a new customer$")
    public void i_register_a_new_customer() {
        ellos().checkoutPage.deployFormRegistrationNewCustomer();
    }

    @And("^for every field on Checkout page which filled correctly I get a OK-sign$")
    public void for_every_field_on_Checkout_which_filled_correctly_I_get_a_OK_sign() {
        ellos().registrationPage.checkPresentSignsForCorrectlyFilledFields("CheckoutTitle");
    }



    /**
     Verify
     */
    @Then("^I will see that I am on Checkout page and I am registered$")
    public void I_am_on_Checkout_page_and_I_am_registered() {
        ellos().checkoutPage.checkCorrectLoginOnCheckoutPage();
    }

    @Then("^I press confirm registration button$")
    public void i_press_confirm_registration_button() {
        ellos().checkoutPage.pressConfirmRegistrationButton();
    }

    @Then("^I will see that I am on Checkout page with First Name \"([^\"]*)\", Last Name \"([^\"]*)\", Street \"([^\"]*)\", ZipCode \"([^\"]*)\", City \"([^\"]*)\"$")
    public void i_will_see_that_I_am_on_Checkout_page_with_First_Name_Last_Name_Address_Address(String firstName, String lastName, String street, String zipCode, String city) {
        ellos().registrationPage.checkRegistrationWithCivicNumber(firstName, lastName, street, zipCode, city);
    }

    @Then("^I will see warning that first name are too long and I am not registered on Checkout page$")
    public void checkTooLongFirstNameError() {
        ellos().registrationPage.checkTooLongFirstNameErrorIsPresentOnCheckout();
    }

    @Then("^I will see warning that last name are too long and I am not registered on Checkout page$")
    public void checkTooLongLastNameError() {
        ellos().registrationPage.checkTooLongLastNameErrorIsPresentOnCheckout();
    }

    @Then("^I will see warning on Checkout page, All unfilled required fields is marked in red and I am not registered$")
    public void i_will_see_warning_on_Checkout_page_All_unfilled_required_fields_is_marked_in_red_and_I_am_not_registered() {
        ellos().registrationPage.checkPresentSignsForINCORRECTLYFilledFields();
    }

    @Then("^I delete product from checkout and switch to main page and logout$")
    public void i_delete_product_from_checkout_and_switch_to_main_page_and_logout() {
        ellos().checkoutPage.deleteProductOnCheckoutPage();
        ellos().checkoutPage.switchToMainPage();
        ellos().mainPage.switchToMyCabinet();
        ellos().mycabinetPage.logout();
    }

    @Then("^I delete product from checkout and switch to main page$")
    public void i_delete_product_from_checkout_and_switch_to_main_page() {
        ellos().checkoutPage.deleteProductOnCheckoutPage();
        ellos().checkoutPage.switchToMainPage();
    }

}
