package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;


public class MinicartDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /**
     * Steps
     */
    @And("^on mini card I click on go to checkout button$")
    public void on_mini_card_I_click_on_go_to_checkout_button() {
        ellos().productPage.switchToCheckoutPage();
    }

    @And("^I delete product from basket and switch to main page$")
    public void i_delete_product_from_basket_and_switch_to_main_page() {
        ellos().mainPage.deleteProductFromPopUpBasket();
    }

    @And("^I delete products from basket and switch to main page$")
    public void i_delete_All_products_from_basket_and_switch_to_main_page() {
        ellos().mainPage.deleteALLProductsFromPopUpBasket();
    }

    @And("^I press button to increase the product on the mini cart$")
    public void I_press_button_to_increase_the_product_on_the_mini_cart() {
        ellos().productPage.pressButtonToIncreaseTheProductOnTheMinicart();
    }

    @And("^I press button to decrease the product on the mini cart$")
    public void I_press_button_to_decrease_the_product_on_the_mini_cart() {
        ellos().productPage.pressButtonToDecreaseTheProductOnTheMinicart();
    }

    @And("^I set \"([^\"]*)\" in first product quantity field on the mini cart$")
    public void I_set_in_first_product_quantity_field_on_the_mini_cart(String value) {
        ellos().productPage.setFirstProductQuantityFieldOnTheMinicart(value);
    }

    @When("^On mini cart I click on button Add to wishlist$")
    public void on_mini_cart_I_click_on_button_Add_to_wishlist() {
        ellos().productPage.openMinicartAndClickAddToWishlist();
    }

    @When("^I open mini cart$")
    public void I_open_mini_cart() {
        ellos().productPage.openMiniCart();
    }



    /**
     * Verify
     */
    @Then("^I see that all elements on minicart are are presents$")
    public void I_see_that_all_elements_on_minicart_are_are_presents() {
        ellos().productPage.openMiniCart();
    }


}
