package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class SizeDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    /**
     Size
     */

    @And("^I selected size \"([^\"]*)\"$")
    public void i_selected_size(String sizeNumber) {
        ellos().productPage.selectSize(sizeNumber);
    }

    @And("^I fill size \"([^\"]*)\" for Fabric product$")
    public void I_fill_size_for_Fabric_product(String inputValue) {
        ellos().productPage.specifyLengthForFabricProduct(inputValue);
    }

    @And("^I see that Fabric length filled correctly I get a OK-sign$")
    public void Is_Fabric_length_filled_correctly() {
        ellos().productPage.check_SignOK_ForLengthFabricProduct();
    }

   /*
    * Not flexible; useless; not use
    */
    @And("^I see that the product is in stock$")
    public void i_see_that_the_product_is_in_stock() {
        Assert.assertTrue(ellos().productPage.isLabelInStockPresentOnSelectedSize("In stock"), "In stock label is INCORRECT!");
    }

    @And("^I see that the product is Out of stock$")
    public void i_see_that_the_product_is_Out_of_stock() {
        Assert.assertTrue(ellos().productPage.isLabelInStockPresentOnSelectedSize("Sold out"), "Out of stock label is INCORRECT!");
    }

    @And("^I see that the product is Few in stock$")
    public void i_see_that_the_product_is_Few_in_stock() {
        Assert.assertTrue(ellos().productPage.isLabelInStockPresentOnSelectedSize("Few in stock"), "Few in stock label is INCORRECT!");
    }



    @And("^I see that size \"([^\"]*)\" was selected correctly with label \"([^\"]*)\"$")
    public void i_see_that_size_was_selected_correctly(String brandSizeValue, String stockLabelValue) {
        ellos().productPage.checkChangingSize(brandSizeValue, stockLabelValue);
    }

    @And("^I see that label is \"([^\"]*)\" for Fabric product$")
    public void I_see_that_label_is_for_Fabric_product(String lableValue) {
        ellos().productPage.checkingFabricProductLabel(lableValue);
    }

    @And("^I see that label is \"([^\"]*)\" for Bulky product$")
    public void I_see_that_label_is_for_Bulky_product(String lableValue) {
        ellos().productPage.checkingFabricProductLabel(lableValue);
    }

    @And("^I close minicart$")
    public void I_close_minicart() {
        ellos().productPage.closeTheMinicart();
    }

    @When("^I click on size dropdown$")
    public void i_click_on_size_dropdown() {
        ellos().productPage.clickOnSizeDropDown();
    }

    @When("^I double-clicked on size dropdown$")
    public void i_double_clicked_on_size_dropdown() {
        ellos().productPage.double_clickOnSizeDropDown();
    }




    /**
     Verify
     */
    @Then("^I see that size dropdown list shown correct$")
    public void i_see_that_size_dropdown_list_shown_correct() {
        Assert.assertTrue(ellos().productPage.isSizeListShownCorrect(), "ListOfProductSize shown INCORRECT!");
    }

    @Then("^I see that size dropdown list is not shown$")
    public void i_see_that_size_dropdown_list_is_not_shown() {
        Assert.assertFalse(ellos().web.isElementPresent("ListOfProductSize"), "ListOfProductSize shown INCORRECT after double click!");
    }

    @Then("^I check that size \"([^\"]*)\" is Out of stock and size is disabled$")
    public void i_see_that_size_is_Out_of_stock_and_size_is_disabled(String brandSizeValue) {
        ellos().productPage.checkThatSizeIsOutOfStock(brandSizeValue);
    }


}
