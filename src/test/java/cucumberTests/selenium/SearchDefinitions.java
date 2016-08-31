package cucumberTests.selenium;

import cucumber.api.java.en.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.*;

/**
 * Created by lavi on 4/15/2016.
 */
public class SearchDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    /**
     Steps
     */
    @And("^I click Search in the menu$")
    public void i_click_Search_in_the_menu() {
        ellos().mainPage.clickOnMenuSearchButton();
    }

    @And("^I will see that a search-field is shown$")
    public void i_will_see_that_a_search_field_is_shown() {
        Assert.assertTrue(ellos().web.isElementPresent("SearchInputField"), "The SearchInputField is NOT present!");
    }

    @And("^The search-button is present$")
    public void the_search_button_is_present() {
        Assert.assertTrue(ellos().web.isElementPresent("SmallSearchButton"), "The SmallSearchButton is NOT present!");
    }

    @And("^I see that the rest of the page content is darker$")
    public void i_see_that_the_rest_of_the_page_content_is_darker() {
        Assert.assertTrue(ellos().web.isElementPresent("SearchBackground"), "The SearchBackground is NOT present!");
    }

    @And("^I click on darker area$")
    public void i_click_on_darker_area() {
        ellos().mainPage.clickOnSearchBackground();
    }

    @And("^I press Esc$")
    public void i_press_Esc() {
        ellos().web.pressESCAPEKey("SearchInputField");
    }

    @And("^I press Enter$")
    public void i_press_Enter() {
        ellos().web.pressEnterKey("SearchInputField");
    }

    @And("^I press Small Search Button$")
    public void i_press_SmallSearchButton() {
        ellos().mainPage.clickOnSmallSearchButton();
    }

    @And("^I click on Search in the menu again$")
    public void i_click_on_Search_in_the_menu_again() {
        ellos().mainPage.clickOnMenuSearchButton();
    }

    @When("^In search-field I type \"([^\"]*)\"$")
    public void in_search_field_I_type(String inputData) {
        ellos().mainPage.typeInSearchField(inputData);
    }

    @When("^In search-field I type brand \"([^\"]*)\"$")
    public void in_search_field_I_type_brand(String inputData) {
        ellos().mainPage.typeInSearchField(inputData);
    }

    /**
     Verify
     */
    @Then("^I will see that the search field is hidden$")
    public void i_will_see_that_the_search_field_is_hidden() {
        Assert.assertFalse(ellos().web.isElementPresent("SearchInputField"), "The SearchInputField is still present!" +
                        "After close search field!");
    }

    @Then("^I will see a list with relevant products is shown$")
    public void i_will_see_a_list_with_relevant_products_is_shown() {
        Assert.assertTrue(ellos().web.isElementPresent("ProductsInTheSearchResult"),
                "Search result - list with relevant products is NOT shown!");
    }

    @Then("^I will see a list with brand relevant products is shown$")
    public void i_will_see_a_list_with_brand_relevant_products_is_shown() {
        Assert.assertTrue(ellos().web.isElementPresent("ProductsInTheSearchResult"),
                "Search result - list with BRAND relevant products is NOT shown!");
    }

    @Then("^I will see empty list with a message that the search did not find the goods$")
    public void i_will_see_empty_list_with_a_message_that_the_search_did_not_find_the_goods() {
        Assert.assertTrue(ellos().mainPage.isNoProductsFound(), "NoProductsFoundMessage is NOT shown!");
    }

    @Then("^I will see that drop-down display the options to complete the text for search$")
    public void i_will_see_that_drop_down_display_the_options_to_complete_the_text_for_search() {
        Assert.assertTrue(ellos().mainPage.isAutoCompletePresent(), "AutoComplete works INCORRECT!");
    }

    @Then("^I will see that drop-down don't display the options to complete the text for search$")
    public void i_will_see_that_drop_down_don_t_display_the_options_to_complete_the_text_for_search() {
        Assert.assertTrue(!ellos().web.isElementPresent("AutocompleteElements"), "AutoComplete works INCORRECT!");
    }


}



