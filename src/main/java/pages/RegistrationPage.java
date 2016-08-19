package pages;

import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.WebDriverWrapper;

import java.util.LinkedList;
import java.util.List;


public class RegistrationPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public RegistrationPage(WebDriverWrapper driver) {
        super(driver);
    }


    public void pressButtonContinue() {
        web.clickLink("ContinueButton");
    }

    public void pressButtonCreateAccount() {
        web.waitForElementPresent("CreateAccountButton");
        web.clickButton("CreateAccountButton");
    }

    public void fillPersonalNumber(String civicNumberValue) {
        web.waitForPresenceOfElementLocated("PersonalNumberField");
        web.waitForElementToBeClickable("PersonalNumberField");

        web.input("PersonalNumberField", civicNumberValue);
        log.info("Fill PersonalNumberField - " + civicNumberValue);
    }

    public void fillFirstName(String name) {
        web.input("FirstNameField", name);
        log.info("Fill FirstNameField - " + name);
    }

    public void fillLastName(String lastName) {
        web.input("LastNameField", lastName);
        log.info("Fill LastNameField - " + lastName);
    }

    public void fillAddressLine1(String address) {
        web.input("AddressLine1Field", address);
        log.info("Fill AddressLine1Field - " + address);
    }

    public void fillAddressLine2(String address) {
        web.input("AddressLine2Field", address);
        log.info("Fill AddressLine2Field - " + address);
    }

    public void fillZipCode(String zipCode) {
        web.input("ZIPCodeField", zipCode);
        log.info("Fill ZIPCodeField - " + zipCode);
    }

    public void fillCityField(String city) {
        web.input("CityField", city);
        log.info("Fill CityField - " + city);
    }

    public void fillEmailAddress(String email) {
        web.waitForPresenceOfElementLocated("EmailAddressField");
        web.waitForElementToBeClickable("EmailAddressField");
        web.input("EmailAddressField", web.generateRandomEmail(email));
    }

    public void fillPhoneNumberField(String number) {
        web.input("PhoneNumberField", number);
    }

    public void fillPasswordField(String pass) {
        web.input("RegistrationPasswordField", pass);
    }

    public void fillConfirmPasswordField(String confirmPass) {
        web.input("RegistrationConfirmPasswordField", confirmPass);
    }

    public void confirmRegistration(String buttonLocator) {
        web.clickButton(buttonLocator);
    }

    //TODO horribly written
    public void checkRegistrationWithCivicNumber(String firstName, String lastName, String street, String zipCode, String city) {
        sleep(3000);

        if (js.getFieldValue("FirstNameField").equals(firstName)
                && js.getFieldValue("LastNameField").equals(lastName)
                && js.getFieldValue("AddressLine1Field").equals(street)
                && js.getFieldValue("ZIPCodeField").equals(zipCode)
                && js.getFieldValue("CityField").equals(city)) {
            log.info("In Registration form fields are automatically filled with correct values");
        } else {
            log.error("In Registration form fields were automatically filled with INCORRECT VALUES!\n" +
                    "FirstNameField - " + js.getFieldValue("FirstNameField").equals(firstName) + "\n" +
                    "LastNameField - " + js.getFieldValue("LastNameField").equals(lastName) + "\n" +
                    "AddressLine1Field - " + js.getFieldValue("AddressLine1Field").equals(street) + "\n" +
                    "ZIPCodeField - " + js.getFieldValue("ZIPCodeField").equals(zipCode) + "\n" +
                    "CityField - " + js.getFieldValue("CityField").equals(city) + "\n");
            Assert.fail("In Registration form fields were automatically filled with INCORRECT VALUES!\n" +
                    "FirstNameField - " + js.getFieldValue("FirstNameField").equals(firstName) + "\n" +
                    "LastNameField - " + js.getFieldValue("LastNameField").equals(lastName) + "\n" +
                    "AddressLine1Field - " + js.getFieldValue("AddressLine1Field").equals(street) + "\n" +
                    "ZIPCodeField - " + js.getFieldValue("ZIPCodeField").equals(zipCode) + "\n" +
                    "CityField - " + js.getFieldValue("CityField").equals(city) + "\n");
        }
    }

    public void checkPresentSignsForCorrectlyFilledFields(String clickOnTitleLocator) {
        sleep(5000);

        List<WebElement> list = new LinkedList<WebElement>();

        //TODO not sure that we need this waits cause we have already sleep(5000);
        web.waitForPresenceOfElementLocated(clickOnTitleLocator);
        web.waitForElementToBeClickable(clickOnTitleLocator);
        web.clickLink(clickOnTitleLocator);

        list.addAll(web.getElements("IconsCorrectlyFilledFields"));

        // must be 9 cause civic not fill for Scenario: Registration without civic number
        if(list.size() == 9) {
            log.info("Signs in Correctly Filled Fields works correct");
            log.info("The number of icon-success - " + list.size());
        } else if ((list.size()) < 9) {
            log.error("Signs in Correctly Filled Fields works INCORRECT! ");
            Assert.fail("The number of messages should be 9, but in fact - " + list.size() + "!\n");
        }
    }

    public void verificationOfError() {
        web.waitForElementPresent("ErrorMessage");

        Assert.assertTrue(web.isElementPresent("ErrorMessage"), "Warning that it is incorrect filling required field IS NOT PRESENT!");
        log.info("Warning that it is incorrect filling required field is present - " +
                web.getElement("ErrorMessage").getAttribute("data-parsley-error-message"));
    }

    public void verificationOfError(String errorMessage) {
        Assert.assertTrue((web.isElementPresent("FieldValueErrorMessage")
                && web.getElementText("FieldValueErrorMessage").equals(errorMessage)),

                "INCORRECT error message - '" + errorMessage + "' - when user input incorrect info in registration form!\n" +
                "In fact error text is - " +  web.getElementText("FieldValueErrorMessage"));

        log.info("Error message is correct - " + errorMessage);
    }

    public void checkTooLongFirstNameErrorIsPresentOnCheckout() {
        Assert.assertTrue(web.isElementPresent("FirstNameErrorMessage"), "First Name Error Is NOT PRESENT!" + "\n" +
                "is FirstNameErrorMessage present - " + web.isElementPresent("FirstNameErrorMessage") + "\n");
        log.info("First Name Error Is Present correctly");
    }

    public void checkTooLongLastNameErrorIsPresentOnCheckout() {
        Assert.assertTrue(web.isElementPresent("LastNameErrorMessage"), "Last Name Error Is NOT Present!" + "\n" +
                "is LastNameErrorMessage present - " + web.isElementPresent("LastNameErrorMessage") + "\n");

        log.info("Last Name Error Is Present correctly");
    }

    public void checkToLong_Address1_ErrorIsPresent(String errorMessage) {
        verificationOfError(errorMessage);
    }

    public void clickOn_AddSecondAddressButton() {
        web.clickButton("AddSecondAddressButton");

        Assert.assertTrue(web.isElementPresent("AddressLine2Field") && !web.isElementPresent("AddSecondAddressButton"),
                "Add Second Address Button in field address line1 IS NOT PRESENT!\n");
    }

    public void checkTooLong_Address2_ErrorIsPresent(String errorMessage) {
        verificationOfError(errorMessage);
    }

    public void checkIncorrectZipCode() {
        Assert.assertTrue(web.isElementPresent("FieldValueErrorMessageForZipCode"), "Error Message For Zip Code is NOT PRESENT!");
        log.info("Error Message For Zip Code is present!");
    }

    public void checkTooLong_ZipCode(String errorMessage) {
        Assert.assertTrue((web.isElementPresent("FieldValueErrorMessage")
                        && web.getElementText("FieldValueErrorMessage").contains(errorMessage)),

                "INCORRECT error message!\n" +
                        "expect - '" + errorMessage + "' - when user input incorrect ZipCode!\n" +
                        "In fact error text is - " +  web.getElementText("FieldValueErrorMessage"));

        log.info("ZipCode field Error message is correct - " + errorMessage);
    }

    public void checkPresentSignsForINCORRECTLYFilledFields() {
        List<WebElement> list = new LinkedList<WebElement>();

        list.addAll(web.getElements("ErrorMessage"));

        if(list.size() == 8) {
            log.info("Signs in Correctly Filled Fields works correct");
        } else if (list.size() < 8) {
            log.error("Signs in Correctly Filled Fields works INCORRECT! " +
                    "The number of messages should be 8, but in fact - " + list.size() + "!\n");
        }
    }

    public void leaveAllRequiredFieldsEmpty() {
        web.input("EmailAddressField", "");
        web.input("RegistrationPasswordField", "");
        web.input("RegistrationConfirmPasswordField", "");
        web.input("PhoneNumberField", "");
        web.input("FirstNameField", "");
        web.input("LastNameField", "");
        web.input("AddressLine1Field", "");
        web.input("ZIPCodeField", "");
        web.input("CityField", "");
    }

    public void switchToMainPage() {
        web.clickLink("RegistrationLogo");

        Assert.assertTrue(web.isElementPresent("Logo"), "Switch from Registration page to Main page was INCORRECT!");
        log.info("Switch from Registration page to Main page was correct");
    }

    //"Incorrect format of civic number"
    public void checkIncorrectPersonalNumber(String errorLocator) {
        Assert.assertTrue((web.isElementPresent("ErrorMessage" )
                && web.getElement("ErrorMessage").getAttribute("data-parsley-error-message").equals(errorLocator)),

                "ErrorMessage is INCORRECT - " + web.getElement("ErrorMessage").getAttribute("data-parsley-error-message" + " !"));

        log.info("Error about Incorrect civic number is present");
        log.info("ErrorMessage is correct - " + web.getElement("ErrorMessage").getAttribute("data-parsley-error-message"));
    }

    public void verificationOfErrorByErrorLocator(String errorLocator) {
        Assert.assertTrue(web.isElementPresent(errorLocator), "Error message IS NOT PRESENT!\n");
        log.info("Error message is present");
    }

    public void checkPasswordMaskErrorPresent(String errorMessage) {
        Assert.assertTrue((web.isElementPresent("Password_Mask_ErrorMessage")
                && web.getElementText("Password_Mask_ErrorMessage").equals(errorMessage)),

                "Password_Mask_ErrorMessage is INCORRECT!\n" +
                        "is Present Password_Mask_ErrorMessage - " + web.isElementPresent("Password_Mask_ErrorMessage") + "\n" +
                        "is error text correct - " + web.getElementText("Password_Mask_ErrorMessage").equals(errorMessage));


        log.info("Password_Mask_ErrorMessage is correct");
    }

}
