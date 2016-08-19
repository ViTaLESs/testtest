package pages;

import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.WebDriverWrapper;


public class LoginPage extends Page{

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public LoginPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void fillEmailField(String inputEmail) {
        web.input("LoginEmailField", inputEmail);
    }

    public void fillPassField(String inputPass) {
        web.input("LoginPassField", inputPass);
    }

    public void clickOnSubmitButton() {
        web.clickButton("CreateAccountButton");
    }

    /**
     SwitchTo or checkCorrectSwitchTo
     */
    public void checkLoginPageShownCorrectly() {
        //web.waitForElementPresent("ShowLoginFormButton");

        Assert.assertTrue((web.isElementPresent("ShowLoginFormButton")
                && web.isElementPresent("ShowRegistrationFormButton")), "Switch to Login Page was INCORRECT!");
        log.info("Switch to Login Page was correct");
    }

    public void checkLoginFormShownCorrectly() {
        //.waitForElementPresent("LoginEmailField");

        Assert.assertTrue((web.isElementPresent("LoginEmailField")
                && web.isElementPresent("LoginPassField")
                && web.isElementPresent("LoginButton")
                && web.isElementPresent("CloseLoginFormButton")), "Login Form is not shown or shown INCORRECT!\n");
        log.info("Switch to Login Form was correct");
    }

    public void checkShortRegisterFormShownCorrectly() {
        web.waitForElementPresent("EmailAddressField");

        Assert.assertTrue((web.isElementPresent("EmailAddressField")
                && web.isElementPresent("PhoneNumberField")
                && web.isElementPresent("RegistrationPasswordField")
                && web.isElementPresent("RegistrationConfirmPasswordField")
                && web.isElementPresent("PersonalNumberField")
                && web.isElementPresent("InfoAboutFasterRegistration")
                && web.isElementPresent("ContinueButton")
                && web.isElementPresent("Checkbox_ReceiveOffersByEmail_forClick")
                && web.isElementPresent("Checkbox_ReceiveOffersBySMS_forClick")
                && web.isElementPresent("CloseRegistrationFormButton")), "Register Form is not shown or shown INCORRECT!");
        log.info("Switch to Register Form was correct");
    }

    public void checkFullRegisterFormShownCorrectly() {
        web.waitForElementPresent("EmailAddressField");

        Assert.assertTrue((web.isElementPresent("EmailAddressField")
                && web.isElementPresent("PhoneNumberField")
                && web.isElementPresent("RegistrationPasswordField")
                && web.isElementPresent("RegistrationConfirmPasswordField")
                && web.isElementPresent("PersonalNumberField")
                && web.isElementPresent("InfoAboutFasterRegistration")
                && web.isElementPresent("Checkbox_ReceiveOffersByEmail_forClick")
                && web.isElementPresent("Checkbox_ReceiveOffersBySMS_forClick")
                && web.isElementPresent("AddressLine1Field")
                && web.isElementPresent("AddSecondAddressButton")
                && web.isElementPresent("ZIPCodeField")
                && web.isElementPresent("CityField")
                && web.isElementPresent("CreateAccountButton")
                && web.isElementPresent("CloseRegistrationFormButton")), "Register Form is not shown or shown INCORRECT!");
        log.info("Switch to Register Form was correct");
    }

    public void checkPasswordValidationWhenUserLogin(String expectedErrorMessage) {
        String errorMessage = web.getElementText("WrongPasswordMessage");

        //contains cause
        Assert.assertTrue(errorMessage.contains(expectedErrorMessage),
                "INCORRECT Password Validation message - " + errorMessage + "\n"
                        + " expected - " + expectedErrorMessage);

        log.info("Password Validation message is correct - " + errorMessage);
    }

    public void checkEmailValidationWhenUserLogin() {
        Assert.assertTrue(web.isElementPresent("WrongEmailPrompt"), "Email/Password Error Messages are not present!");
        log.info("Correct Error pass message is present");
    }

    public void checkValidationEmptyPasswordField() {
        Assert.assertTrue(web.isElementPresent("WrongPasswordPrompt"), "Validation Massages Of Empty Email/Password field is not present!");
        log.info("Validation Massages Of Empty Password field is present");
    }

    public void checkValidationMassagesOfEmpty_Email_And_Password_Fields() {
        Assert.assertTrue((web.isElementPresent("WrongEmailPrompt")
                && web.isElementPresent("WrongPasswordPrompt")), "Validation Massages Of Empty Email/Password fields are not present!");
        log.info("Validation Massages Of Empty Email/Password fields are presents");
    }

    public void switchToMainPage() {
        web.clickLink("LoginPage_Logo");

        Assert.assertTrue(web.isElementPresent("Logo"), "After click on Logo pic on Login Page was INCORRECT switch to Main page!");
        log.info("Switch from Login to Main Page was correct");
    }
}
