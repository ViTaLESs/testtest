package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;


public class WishListDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /**
     Steps
     */
    @When("^I write Email address \"([^\"]*)\" in wishlist window on Checkout page$")
    public void fillEmailField(String email) {
        ellos().wishlist.fillLoginField(email);
    }

    @When("^I write password \"([^\"]*)\" in wishlist window on Checkout page$")
    public void fillPassField(String pass) {
        ellos().wishlist.fillPasswordField(pass);
    }

    @When("^I click on Login in wishlist window on Checkout page$")
    public void clickLoginButton() {
        ellos().wishlist.clickOnLoginButton();
    }

    @And("^I click button NewCustomer in wishlist window on Checkout page$")
    public void I_click_button_NewCustomer_in_wishlist_window_on_Checkout_page() {
        ellos().wishlist.clickOnButtonNewCustomerInWishlistWindowOnCheckoutPage();
    }

    @And("^I close wishlist modal window$")
    public void i_close_wishlist_modal_window() {
        ellos().wishlist.closeWishlistModalWindow();
    }

    @When("^I see wishlist modal window for log in or registration$")
    public void i_see_that_I_get_a_wishlist_modal_window_for_log_in_or_registration() {
        ellos().wishlist.checkThat_LoginRegistration_OnWishListShown();
    }

    @When("^On product page I click on button Add to wishlist$")
    public void on_product_page_I_click_on_button() {
        ellos().productPage.clickOnButtonAddProductToWishList();
    }

    @When("^I click on button Login on wishlist modal window$")
    public void i_click_on_button_Login_on_wishlist_modal_window() {
        ellos().wishlist.clickOnLoginButtonOnWishlist();
    }

    @When("^I see that modal window for Add product to wishlist is shown$")
    public void i_see_that_modal_window_for_Add_product_to_wishlist_is_shown() {
        ellos().wishlist.checkThatModalWindowForAddProductToWishlistIsShown();
    }

    @When("^I create a new wishlist \"([^\"]*)\" and save it$")
    public void i_create_a_new_wishlist_and_save_it(String wishlistName) {
        ellos().wishlist.createNewWishlistAndSave(wishlistName);
    }

    @When("^I save product to existing wishlist$")
    public void i_save_product_to_existing_wishlist() {
        ellos().wishlist.saveProductToExistingWishlist("FirstWishlistRadioButton");
    }

    @When("^I will see that I am registered from wishlist$")
    public void i_will_see_that_I_am_registered_from_wishlist() {
        ellos().mycabinetPage.checkCorrectSwitchToMyCabinet();
        ellos().mycabinetPage.checkCorrectSwitchToMainPage();
    }


    /**
     Verify
     */
    @Then("^I see that product was save to new wishlist \"([^\"]*)\" successfully$")
    public void i_see_that_product_was_save_to_new_wishlist_successfully(String wishlistName) {
        ellos().wishlist.checkNewWishlistName(wishlistName);
    }

    @Then("^I see that product was save to existing wishlist successfully$")
    public void i_see_that_product_was_save_to_existing_wishlist_successfully() {
        ellos().wishlist.checkThatProductWasSaveToExistingOrNewWishlistSuccessfully("ProductName");
    }

    @Then("^I see that product was save to new wishlist successfully$")
    public void i_see_that_product_was_save_to_new_wishlist_successfully() {
        ellos().wishlist.checkThatProductWasSaveToExistingOrNewWishlistSuccessfully("ProductName");
    }

    @Then("^I see that product was save to existing wishlist successfully on checkout page$")
    public void i_see_that_product_was_save_to_new_wishlist_successfully_on_checkout_page() {
        ellos().wishlist.checkThatProductWasSaveToExistingOrNewWishlistSuccessfully("Checkout_ProductName");
    }

    @Then("^I click OK button on Wishlist Modal Form$")
    public void I_click_OK_button_on_Wishlist_Modal_Form() {
        ellos().wishlist.click_OK_ButtonOnWishlistModalForm();
    }

    @Then("^I click close button on Wishlist Modal Form$")
    public void I_click_close_button_on_Wishlist_Modal_Form() {
        ellos().wishlist.click_Close_ButtonOnWishlistModalForm();
    }


    //NEW

    @And("^I switch to the main page from myCabinet$")
    public void iSwitchToTheMainPageFromMyCabinet() {
        ellos().mycabinetPage.switchToMainPageFromMyCabinet();
    }
}
