package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.PropertyLoader;
import org.testng.Assert;


public class MainPageDefinitions extends Fixture {

    private static final String ENVIRONMENT = PropertyLoader.loadProperty("environment.url");
    private static final String LOCATION = PropertyLoader.loadProperty("location");

    /**
     Navigation
     */
    @And("^I switch to Login Page$")
    public void i_switch_To_Registration_Page() {
        ellos().mainPage.switchToRegistrationPage();
    }

    @When("^I switch to \"([^\"]*)\"$")
    public void i_switch_to(String pageURL) {
        ellos().mainPage.openPage(ENVIRONMENT + LOCATION + pageURL);
    }

    @And("^I switch to Main page$")
    public void i_switch_to_Main_page() {
        ellos().productPage.switchToMainPage();
    }

    @And("^I switch to product page \\(Standard product\\)$")
    public void i_switch_to_product_page_Standard_product() {
        ellos().mainPage.openStandardProduct();
    }

    @And("^I switch to product page \\(Fabric product\\)$")
    public void i_switch_to_product_page_Fabric_product() {
        ellos().mainPage.openFabricProduct();
    }

    @And("^I switch to product page \\(Bulky product\\)$")
    public void i_switch_to_product_page_Bulky_product() {
        ellos().mainPage.openBulkyProduct();
    }

    @And("^I switch to product page \\(Bulky product number2\\)$")
    public void i_switch_to_product_page_Bulky_product_number2() {
        ellos().mainPage.openBulkyProductNumber2();
    }

    @And("^I switch to product page \\(DropShip product\\)$")
    public void i_switch_to_product_page_DropShip_product() {
        ellos().mainPage.openDropShipProduct();
    }

    @And("^I switch to product page \\(Book product\\)$")
    public void i_switch_to_product_page_Book_product() {
        ellos().mainPage.openBookProduct();
    }

    @And("^I check that Basket is empty$")
    public void iCheckThatBasketIsEmpty() {
        if (ellos().mainPage.is_ProductsInBasket()) {
            ellos().mainPage.deleteALLProductsFromPopUpBasket();
        }

        Assert.assertTrue(ellos().mainPage.isUserLoggedIn(), "The user is logged out after the removal of the goods from the basket!");
    }


    /**
     Steps
     */
    @And("^I see that lineup images, collection texts, product names and prices are shown$")
    public void i_see_that_lineup_images_collection_texts_product_names_and_prices_are_shown() {
        Assert.assertTrue(ellos().mainPage.isLineUpProductInformationShown(), "Products in LineUp shown INCORRECT! " +
                "Some elements of products not shown! Look at log file!");
    }

    @And("^I click on lineup product$")
    public void i_click_on_lineup_product() {
        ellos().mainPage.clickOnFirstProductOnLinaUp();
    }

    @And("^I click on \"([^\"]*)\"$")
    public void I_click_on(String elementLocator) {
        ellos().web.waitForElementPresent(elementLocator);
        ellos().web.waitForElementToBeClickable(elementLocator);
        ellos().mainPage.clickOn(elementLocator);
    }

    @And("^I click on \"([^\"]*)\" and wait for element \"([^\"]*)\"$")
    public void I_click_on_And_Wait(String buttonLocator, String waitElementPresent) {
        ellos().web.clickLink(buttonLocator);
        ellos().web.waitForElementPresent(waitElementPresent);
    }

    @And("^I see that \"([^\"]*)\" is present")
    public void i_see_that_product_modal_window_is_shown(String elementLocator) {
        Assert.assertTrue(ellos().web.isElementPresent(elementLocator), elementLocator + " is NOT PRESENT!");
    }

    @And("^I check that ellos\"([^\"]*)\" is open$")
    public void iCheckThat_Ellos_IsOpen(String location) {
        ellos().mainPage.checkEllosIsOpen(location);
    }

    @And("^I refresh the page$")
    public void i_refresh_the_page() {
        ellos().web.refreshPage();
    }

    @And("^I scroll the page down$")
    public void iScrollThePageDown() {
        ellos().web.pressPageDown("Logo");
    }

    @And("^I check that I switch to MyCabinet page for Logout user$")
    public void iCheckThatISwitchToMyCabinetPageForLogoutUser() {
        ellos().loginPage.checkLoginPageShownCorrectly();
        Assert.assertTrue(ellos().loginPage.getCurrentPageURL().contains("ViewWishlist"), "Switch to MyCabinet page for Logout user was INCORRECT!");
    }

    @And("^I check that I switch to MyCabinet page and My Favorite submenu correctly$")
    public void iCheckThatISwitchToMyCabinetPageAndMyFavoriteSubmenuCorrectly() {
        ellos().mycabinetPage.checkCorrectSwitchToMyCabinet();
        ellos().mycabinetPage.checkCorrectSwitchToWishListTab();
    }

    @When("^I scroll page to Product lineup$")
    public void i_scroll_page_to_Product_lineup() {
        ellos().web.scrollPageToElement("UpperFooter_Label_LetsBeSocial");
    }

    @When("^I scroll page to Upper Footer$")
    public void i_scroll_page_to_Upper_Footer() {
        ellos().mainPage.js.scrollToElement("UpperFooter_EllosInsuranceList");
    }

    @When("^I scroll page to Footer$")
    public void i_scroll_page_to_Footer$() {
        ellos().mainPage.js.scrollToElement("Footer_CountryFlag_SE");
    }



    /**
     Verify
     */
    @Then("^I logged out from Main page$")
    public void loggedOutFromMainPage() {
        ellos().mainPage.loggedOut();
        ellos().mainPage.checkCorrectSwitchToMainPage();
    }

    @Then("^I see that title Product lineup shown correct$")
    public void i_see_that_title_shown_correct() {
        Assert.assertTrue(ellos().mainPage.isTitleProductLineUpShownCorrect(), "Title Product lineup shown INCORRECT!");
    }

    @Then("^I see that Product Modal Window was closed successfully$")
    public void i_see_that_Product_Modal_Window_was_closed_successfully() {
        Assert.assertFalse(ellos().web.isElementPresent("Productlineup_ProductModalWindow"), "Product Modal Window shown INCORRECT!");
    }

    @And("^I check that Logo is present on Main page$")
    public void iCheckThatLogoIsPresentOnMainPage() {
        ellos().mainPage.checkCorrectSwitchToMainPage();
    }

    @Then("^I see that Header and links of header are presented$")
    public void iSeeThatHeaderAndLinksOfHeaderArePresented() {
        Assert.assertTrue(ellos().web.isElementPresent("MainHeader")
                && ellos().web.isElementPresent("Header_BarContainer")
                && ellos().web.isElementPresent("Header_CustomerService_Link")
                && ellos().web.isElementPresent("Header_LendAndInsure_Link")
                && ellos().web.isElementPresent("LoginLink")
                && ellos().web.isElementPresent("Header_Favourites_Link")
                && ellos().web.isElementPresent("TillKassanPopUp_Link"));
    }

    @Then("^I see that the Hello bar and internal text are presented$")
    public void iSeeThatTheHelloBarAndInternalTextArePresented() {
        ellos().mainPage.checkHelloBar();
    }

    @Then("^I check that UpperFooter block looks correctly$")
    public void iCheckThatUpperFooterBlockLooksCorrectly() {
        ellos().mainPage.checkUpperFooterUI();
    }

    @Then("^I check that Footer block looks correctly$")
    public void iCheckThatFooterBlockLooksCorrectly() {
        ellos().mainPage.checkFooterUI();
    }

}
