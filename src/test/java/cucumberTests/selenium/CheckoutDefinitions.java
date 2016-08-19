package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;


public class CheckoutDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    @Given("^I see that I am registered and entered to the system correct$")
    public void i_see_that_I_am_registered_and_entered_to_the_system_correct() {
        ellos().mycabinetPage.checkCorrectSwitchToMyCabinet();
    }


    /**
     * Steps
     */
    @And("^I confirm orders$")
    public void i_confirm_orders() {
        ellos().checkoutPage.pressConfirmOrderButton();
    }

    @When("^I switch to main page from checkout$")
    public void i_switch_to_main_page() {
        ellos().checkoutPage.switchToMainPage();
    }

    @When("^On checkout Page I delete product from basket and click on button Save to wishlist$")
    public void on_checkout_Page_I_delete_product_from_basket_and_click_on_button_Add_to_wishlist() {
        ellos().checkoutPage.deleteProductOnCheckoutPage();
        ellos().checkoutPage.pressButtonSaveToWishlist();
    }

    @And("^I choose payment method \"([^\"]*)\", with civic - \"([^\"]*)\"$")
    public void I_choose_payment_method_with_civic_(String paymentType, String civicNumber) {
        ellos().checkoutPage.choosePaymentMethod_KONTO_or_FAKTURA(paymentType, civicNumber);
    }

    @And("^I choose payment method \"([^\"]*)\"$")
    public void I_choose_payment_method_CreditCard(String paymentType) {
        ellos().checkoutPage.choosePaymentMethod_COD_or_CreditCard(paymentType);
    }

    @And("^I choose delivery method \"([^\"]*)\"$")
    public void I_choose_delivery_method(String delivery_method) {
        ellos().checkoutPage.chooseDeliveryMethod(delivery_method);
    }

    @And("^I check that Login shown correctly on checkout page$")
    public void iCheckThatLoginShownCorrectlyOnCheckoutPage() {
        ellos().checkoutPage.checkLoginShownCorrectlyOnCheckoutPage();
    }

    @Then("^I delete all products from checkout and switch to main page$")
    public void i_delete_all_products_from_checkout_and_switch_to_main_page() {
        ellos().checkoutPage.deleteAllProductsFromCheckout();
        ellos().checkoutPage.switchToMainPage();
        ellos().mainPage.switchToMyCabinet();
        ellos().mycabinetPage.logout();
    }

    @Then("^I see that the order was created successfully$")
    public void I_see_that_the_order_was_created_successfully() {
        ellos().checkoutPage.checkOrderInfo();
    }

    @And("^I fill credit card details and complete the order$")
    public void iFillCreditCardDetailsAndCompleteTheOrder() {
        ellos().checkoutPage.fillCreditCardDetailsAndCompleteTheOrder();
    }

}
