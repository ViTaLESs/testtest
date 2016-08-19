package cucumberTests.selenium;

import cucumber.api.java.en.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.PropertyLoader;


public class LoginStepsDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private final String environment = PropertyLoader.loadProperty("environment.url");
    private final String location = PropertyLoader.loadProperty("location");


    @Given("^I go to google$")
    public void I_go_to_google() {
        ellos().mainPage.openPage("https://google.com");
        ellos().mainPage.isOpenPage("GLogo");
    }

    @Given("^I sout$")
    public void I_sout() throws Throwable {
        log.info("NewTest");
        log.info("NewTest");
        log.info("NewTest");
        log.info("NewTest");
    }

    /**
     Preconditions
     */
    @Given("^I am at ellos_se$")
    public void i_am_at_ellos_se() {
        //TODO logo debug or something
        if (!ellos().mainPage.getCurrentPageURL().equals(environment + location)) {
            ellos().mainPage.openPage();
            ellos().mainPage.isOpenPage("Logo");
        }

        //TODO Include this block only because /OMG-2335
        if (ellos().mainPage.isUserLoggedIn()) {
            ellos().mainPage.switchToMyCabinet();
            ellos().mycabinetPage.logout();
        }

        if (ellos().mainPage.is_ProductsInBasket()) {
            // cause https://ellosgroup.atlassian.net/wiki/pages/viewpage.action?pageId=77529099 scenario 2
            //ellos().mainPage.deleteProductFromPopUpBasket();
            ellos().mainPage.deleteALLProductsFromPopUpBasket();
        }
    }

    //TODO looks like ass
    @Given("^I click on button Login$")
    public void clickOnLoginButton$() {
        ellos().mainPage.clickOnLoginLink("LoginButton");
    }

    //TODO looks like ass
    @Given("^I click Login link$")
    public void clickOnLoginLink() {
        ellos().mainPage.clickOnLoginLink("LoginLink");
        ellos().loginPage.checkLoginPageShownCorrectly();
    }


    /**
     Steps
     */
    @And("^I add product to the Basket and go to checkout$")
    public void goToCheckout() {
        ellos().mainPage.openStandardProduct();

        ellos().productPage.addProductToBasketAndCheckIt();
        ellos().productPage.switchToCheckoutPage();
    }

    @And("^I see that I am logged in \\(for flow\\)$")
    public void I_see_that_I_am_logged_in_for_flow() {
        Assert.assertTrue(ellos().web.isElementPresent("LogoutLink"), "Incorrect work system with fake login/pass");
    }

    @And("^I check that I switch to Login page correctly$")
    public void iCheckThatISwitchToLoginPageCorrectly() {
        ellos().loginPage.checkLoginPageShownCorrectly();
    }

    @And("^I am checking that the Login form shown correctly$")
    public void iAmCheckingThatTheLoginFormShownCorrectly() {
        ellos().loginPage.checkLoginFormShownCorrectly();
    }

    @And("^I am checking that the short Registration form shown correctly$")
    public void iAmCheckingThatTheShortRegistrationFormShownCorrectly() {
        ellos().loginPage.checkShortRegisterFormShownCorrectly();
    }

    @And("^I am checking that the full Registration form shown correctly$")
    public void iAmCheckingThatTheFullRegistrationFormShownCorrectly() {
        ellos().loginPage.checkFullRegisterFormShownCorrectly();
    }

    @When("^I write Email address \"([^\"]*)\"$")
    public void fillEmailField(String email) {
        ellos().loginPage.fillEmailField(email);
    }

    @When("^I write password \"([^\"]*)\"$")
    public void fillPassField(String pass) {
        ellos().loginPage.fillPassField(pass);
    }

    @When("^I click on CreateAccountButton$")
    public void clickLoginButton() {
        ellos().loginPage.clickOnSubmitButton();
    }


    /**
     Verify
     */
    @Then("^I see that I am logged in$")
    public void checkCorrectLogIn() {
        Assert.assertTrue(ellos().web.isElementPresent("LogoutLink"), "Incorrect work system with fake login/pass");
    }

    @Then("^I logged out$")
    public void loggedOut() {
        ellos().mycabinetPage.logout();
    }

    @Then("^I see that I am not logged in and password validation massages is present \"([^\"]*)\"$")
    public void checkPasswordValidationWhenUserLogin(String errorMessage) {
        ellos().loginPage.checkPasswordValidationWhenUserLogin(errorMessage);
        ellos().loginPage.checkLoginFormShownCorrectly();
    }

    @Then("^I see that I am not logged in and email validation massages is present$")
    public void checkEmailValidationWhenUserLogin() {
        ellos().loginPage.checkEmailValidationWhenUserLogin();
    }

    @Then("^I see that I am not logged in and validation message of empty password field is present$")
    public void checkValidationMessageOfEmptyPassword() {
        ellos().loginPage.checkValidationEmptyPasswordField();
    }

    @Then("^I see that validation message of empty Email AND Password fields are presents$")
    public void validation_massages_for_empty_EmailPassword_fields_are_presents() {
        ellos().loginPage.checkValidationMassagesOfEmpty_Email_And_Password_Fields();
    }

    @Then("^I switch to the main page from login$")
    public void back_to_the_main_page() {
        ellos().loginPage.switchToMainPage();
    }

    @Then("^I see that I am logged in and stay on Checkout page$")
    public void loggedIn_CheckoutPage() {
        ellos().checkoutPage.checkCorrectLoginOnCheckoutPage();
    }

    @Then("^I can continue with the checkout process$")
    public void continueWithCheckoutProcess() {
        ellos().checkoutPage.deleteProductOnCheckoutPage();
        ellos().checkoutPage.switchToMainPage();
        ellos().mainPage.switchToMyCabinet();
        ellos().mycabinetPage.logout();
    }

    @Then("^I delete product and switch to the main page from checkout$")
    public void switch_to_the_main_page_from_checkout() {
        ellos().checkoutPage.deleteProductOnCheckoutPage();
        ellos().checkoutPage.switchToMainPage();
    }

}
