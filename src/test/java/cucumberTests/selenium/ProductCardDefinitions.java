package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class ProductCardDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /**
     PDP
     */
    @And("^I add product to the Basket$")
    public void i_add_product_to_the_Basket() {
        ellos().productPage.addProductToBasketAndCheckIt();
    }

    @And("^I see that button Add to cart is enable$")
    public void i_see_that_button_Add_to_cart_is_enable() {
        Assert.assertTrue(ellos().web.isElementEnabled("AddProductToBasketButton"), "Add to cart is NOT enable!");
    }

    @And("^I see that button Add to cart is disabled$")
    public void i_see_that_button_Add_to_cart_is_disabled() {
        Assert.assertFalse(ellos().web.isElementEnabled("AddProductToBasketButton_Disabled"), "Add to cart is NOT disabled!");
    }

    @And("^I see that button Add to wishlist is enable$")
    public void I_see_that_button_Add_to_wishlist_is_enable() {
        Assert.assertTrue(ellos().web.isElementEnabled("AddProductToWishListButton"), "Add to cart is NOT enable!");
    }

    @And("^I see that button Add to wishlist is disabled$")
    public void I_see_that_button_Add_to_wishlist_is_disabled() {
        Assert.assertFalse(ellos().web.isElementEnabled("AddProductToWishListButton_Disabled"), "Add to cart is NOT disabled!");
    }

    @And("^I see that button Add Sample to cart is enable$")
    public void I_see_that_button_Add_Sample_to_cart_is_enable() {
        Assert.assertTrue(ellos().web.isElementEnabled("AddSampleToCartButton"), "Add sample to cart is NOT enable!");
    }

    @And("^I see that button Add Sample to cart is disabled$")
    public void I_see_that_button_Add_Sample_to_cart_is_disabled() {
        Assert.assertFalse(ellos().web.isElementEnabled("AddSampleToCartButton_Disabled"), "Add sample to cart is NOT disabled!");
    }

    @And("^I switch to Main page from Product page$")
    public void i_click_LogoLink_on_product_page() {
        ellos().productPage.switchToMainPage();
    }

    @And("^I am checking all product tab and blocks with info$")
    public void I_am_checking_all_product_tab_and_blocks_with_info() {
        ellos().productPage.checkingProductTabAndBlocks();
    }

    @And("^I click add to cart button$")
    public void I_click_add_to_cart_button() throws Throwable {
        ellos().web.clickButton("AddProductToBasketButton");
    }

    @And("^I keep the product information and switched to checkout and check that product info is correct$")
    public void I_keep_the_product_information_and_switched_to_checkout() {
        //ellos.productPage.keepProductInfoOnProductPage();
        ellos().productPage.switchToCheckoutPage();

        Assert.assertTrue(ellos().checkoutPage.isProductInfoCorrectOnCheckoutPage());
    }

    @When("^I click on the link Read more$")
    public void I_click_on_the_link_Read_more() {
        ellos().web.clickButton("ReadMoreLink");
    }

    @When("^I double-clicked on button Add to cart$")
    public void i_double_clicked_on_button_Add_to_cart() {
        ellos().productPage.double_clickOnButtonAddToCart();
    }



    /**
     Verify
     */
    @Then("^I see that the product was added to the mini cart correctly$")
    public void i_see_that_the_product_was_added_to_the_mini_cart_correctly() {
        ellos().productPage.checkingTheCorrectnessOfAddProductToMiniCart("1");
    }

    @Then("^I see that \"([^\"]*)\" products was added to the mini cart correctly$")
    public void i_see_that_the_products_was_added_to_the_mini_cart_correctly(String quantityOfProducts) {
        ellos().productPage.checkingTheCorrectnessOfAddProductToMiniCart(quantityOfProducts);
    }

    @Then("^I see that the products was added to the mini cart correctly$")
    public void i_see_that_the_products_was_added_to_the_mini_cart_correctly() {
        ellos().productPage.validationAddedItemsToMiniCart();
    }

    @Then("^The screen switches to the block Product description of the product which is below$")
    public void The_screen_switches_to_the_block_of_the_product_which_is_below() {
        Assert.assertTrue(ellos().web.isElementPresent("ProductDescription_ActiveBlock"), "ProductDescription_ActiveBlock is not present!");
    }

    @Then("^I see that all product attributes are presents for Standard product$")
    public void I_see_that_all_product_attributes_are_present_for_Standard_product() {
        Assert.assertTrue(ellos().productPage.isAllIProductAttributesPresent_StandardProduct(), "Some product attributes are not shown for Standard product!");
    }

    @Then("^I see that all product attributes are presents for Fabric product$")
    public void I_see_that_all_product_attributes_are_present_for_Fabric_product() {
        Assert.assertTrue(ellos().productPage.isAllIProductAttributesPresent_FabricProduct(), "Some product attributes are not shown for Fabric product!");
    }

    @Then("^I see that all product attributes are presents for Bulky product$")
    public void I_see_that_all_product_attributes_are_presents_for_Bulky_product() {
        Assert.assertTrue(ellos().productPage.isAllIProductAttributesPresent(), "Some product attributes are not shown!");
    }

    @Then("^I see that all product attributes are presents$")
    public void I_see_that_all_product_attributes_are_present() {
        Assert.assertTrue(ellos().productPage.isAllIProductAttributesPresent(), "Some product attributes are not shown!");
    }

    @Then("^I can see a warning \"([^\"]*)\"$")
    public void I_can_see_a_warning(String errorMessage) {
        Assert.assertTrue(ellos().productPage.isFabricSizeErrorPresent(errorMessage), "FabricSizeError is incorrect!");
    }


}
