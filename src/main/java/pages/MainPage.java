package pages;

import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

import java.util.ArrayList;
import java.util.List;


public class MainPage extends Page {

    private static final Logger LOG = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String ENVIRONMENTAL = PropertyLoader.loadProperty("environment.url");
    private static final String LOCATION = PropertyLoader.loadProperty("location");
    private static final String PRODUCT_PAGE = PropertyLoader.loadProperty("product.page");
    private static final String STANDARD_PRODUCT = PropertyLoader.loadProperty("StandardProduct");
    private static final String FABRIC_PRODUCT = PropertyLoader.loadProperty("FabricProduct");
    private static final String BULKY_PRODUCT = PropertyLoader.loadProperty("BulkyProduct");
    private static final String BULKY_PRODUCT_NUMBER_2 = PropertyLoader.loadProperty("BulkyProductNumber2");
    private static final String DROP_SHIP_PRODUCT = PropertyLoader.loadProperty("DropShipProduct");
    private static final String BOOK_PRODUCT = PropertyLoader.loadProperty("BookProduct");

    public MainPage(WebDriverWrapper driver) {
        super(driver, ENVIRONMENTAL + LOCATION);
    }

    /**
     login/logout
     */
    public void clickOnLoginLink(String locator) {
        web.waitForElementToBeClickable(locator);
        web.waitForPresenceOfElementLocated(locator);

        web.clickLink(locator);
    }

    public boolean isUserLoggedIn() {
        //old if need to change for different locations   one
        //if (web.getElement("MyEllosLink").getText().equals("MY ACCOUNT")) {

        if (!web.getElement("MyEllosLink").getAttribute("href").contains("login")) {
            LOG.info("<--- User is logged IN!");
            LOG.info("Is User Logged In - " + web.getElement("MyEllosLink").getAttribute("href").contains("login"));
            LOG.info("<--- Element - " + web.getElement("MyEllosLink").getText() + " is Present --->");
            return true;
        } else {
            LOG.info("<--- User is logout --->");
            return false;
        }
    }

    public void loggedOut() {
        web.clickButton("MyAccountLink");
        web.clickButton("LogoutLink");
    }

    /**
     open Products
     */
    public void openStandardProduct() {
        webDriverWrapper.get(ENVIRONMENTAL + LOCATION + PRODUCT_PAGE + STANDARD_PRODUCT);
    }

    public void openFabricProduct() {
        webDriverWrapper.get(ENVIRONMENTAL + LOCATION + PRODUCT_PAGE + FABRIC_PRODUCT);
    }

    public void openBulkyProduct() {
        webDriverWrapper.get(ENVIRONMENTAL + LOCATION + PRODUCT_PAGE + BULKY_PRODUCT);
    }

    public void openBulkyProductNumber2() {
        webDriverWrapper.get(ENVIRONMENTAL + LOCATION + PRODUCT_PAGE + BULKY_PRODUCT_NUMBER_2);
    }

    public void openDropShipProduct() {
        webDriverWrapper.get(ENVIRONMENTAL + LOCATION + PRODUCT_PAGE + DROP_SHIP_PRODUCT);
    }

    public void openBookProduct() {
        webDriverWrapper.get(ENVIRONMENTAL + LOCATION + PRODUCT_PAGE + BOOK_PRODUCT);
    }

    public void openGiftcard() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     SwitchTo or checkCorrectSwitchTo
     */
    public void checkCorrectSwitchToMainPage() {
        Assert.assertTrue(web.isElementPresent("Logo"), "Incorrect enter to the system!");
        LOG.info("Correct Switch To Main Page");
    }

    public void switchToRegistrationPage() {
        web.clickLink("LoginLink");

        if (web.isElementPresent("ShowRegistrationFormButton")) {
            LOG.info("Switch to Registration Page was correct");
        } else {
            LOG.error("Switch to Registration Page was INCORRECT!\n");
            Assert.fail("Switch to Registration Page was INCORRECT");
        }
    }

    public void switchToMyCabinet() {
        web.clickLink("MyEllosLink");

        if (web.isElementPresent("LogoutLink")) {
            LOG.info("Switch to My Cabinet was correct");
        } else {
            LOG.error("Switch to My Cabinet was INCORRECT!\n");
            Assert.fail("On mainPage click to MyEllos link; Switch to My Cabinet was INCORRECT!");
        }
    }

    public void checkEllosIsOpen(String location) {
        sleep(3000);
        LOG.info("Current url - " + getCurrentPageURL());

        Assert.assertTrue(getCurrentPageURL().contains("ellos." + location),
                "Switch to ellos_" + location + " was Incorrect After click on Footer_CountryFlag_" + location + "!\n" +
        "Current url - " + getCurrentPageURL());
        LOG.info("Ellos " + location + " Is Open");
    }

    public void checkHelloBar() {
        Assert.assertTrue(web.isElementPresent("HelloBarContainer")
                && web.getElementText("HelloBarText") != null, "Hello bar looks INCORRECTLY!");
        LOG.info("Hello bar looks correctly!");

        web.refreshPage();
    }

    public void checkUpperFooterUI() {
        Assert.assertTrue(web.isElementPresent("UpperFooter_Block")
                && web.isElementPresent("UpperFooter_Label_LetsBeSocial")
                && web.isElementPresent("UpperFooter_Newsletter_InputField")
                && web.isElementPresent("UpperFooter_Newsletter_Button")
                && web.isElementPresent("UpperFooter_SocialList")
                && web.isElementPresent("UpperFooter_LogosList")
                && web.isElementPresent("UpperFooter_ConsumerLendingList")
                && web.isElementPresent("UpperFooter_EllosInsuranceList"),
                "UpperFooterUI looks INCORRECTLY!");
        LOG.info("UpperFooterUI looks correctly!");

        web.refreshPage();
    }

    public void checkFooterUI() {
        Assert.assertTrue(web.isElementPresent("Footer_NavigationBlock")
                        && web.isElementPresent("Footer_NavigationAboutText")
                        && web.isElementPresent("Footer_CountriesFlagsList")
                        && web.isElementPresent("Footer_CountryFlag_SE")
                        && web.isElementPresent("Footer_CountryFlag_NO")
                        && web.isElementPresent("Footer_CountryFlag_FI")
                        && web.isElementPresent("Footer_CountryFlag_DK")
                        && web.isElementPresent("Footer_FriendsList")
                        && web.isElementPresent("Footer_JotexLink")
                        && web.isElementPresent("Footer_StayhardLink")
                        && web.isElementPresent("Footer_ContactsText"),
                "FooterUI looks INCORRECTLY!");
        LOG.info("FooterUI looks correctly!");

        web.refreshPage();
    }


    /**
     Products
     */
    public boolean is_ProductsInBasket() {
        if (web.isElementPresent("TillKassanPopUp_Link") && !web.getElementText("TillKassanPopUp_BasketContains").contains("( 0 )")) {
            LOG.error("<--- Basket is NOT Empty!!! --->");
            LOG.error("<--- Basket is NOT Empty!!! --->");
            LOG.error("<--- Basket is NOT Empty!!! --->");
            LOG.error("<--- User has products in basket! \n " +
                    "Element - " + web.getElementText("TillKassanPopUp_Link") + " is Present --->\n");
            return true;
        } else {
            LOG.info("<--- Basket is Empty --->");
            return false;
        }
    }

    public void deleteProductFromPopUpBasket() {
        web.clickButton("TillKassanPopUp_Link");
        web.waitForElementPresent("TillKassanPopUp_QuantityOfFirstProduct_inputField");
        web.inputAndClickEnter("TillKassanPopUp_QuantityOfFirstProduct_inputField", "0");

        web.waitForElementPresent("TillKassanPopUp_CloseButton");
        web.waitForElementToBeClickable("TillKassanPopUp_CloseButton");
        web.clickButton("TillKassanPopUp_CloseButton");
        web.refreshPage();

        web.waitForElementToBeClickable("TillKassanPopUp_Link");
        web.clickButton("TillKassanPopUp_Link");

        if (web.isElementPresent("TillKassan_cartIsEmptyMessage")) {
            LOG.info("Products was delete from basket on main page popUp");

            web.refreshPage();
        } else {
            Assert.fail("TillKassan_cartIsEmptyMessage is NOT present!");
        }
    }

    //brown magic
    public void deleteALLProductsFromPopUpBasket(){
        web.clickButton("TillKassanPopUp_Link");
        web.waitForElementPresent("TillKassanPopUp_QuantityOfFirstProduct_inputField");

        List<WebElement> list = new ArrayList<WebElement>();

        list.addAll(web.getElements("TillKassanPopUp_QuantityOfFirstProduct_inputField"));

        for (int i = 0; i < list.size(); i++) {
            web.waitForElementPresent("TillKassanPopUp_QuantityOfFirstProduct_inputField");
            web.inputAndClickEnter("TillKassanPopUp_QuantityOfFirstProduct_inputField", "0");

            web.waitForElementPresent("TillKassanPopUp_CloseButton");
            web.waitForElementToBeClickable("TillKassanPopUp_CloseButton");
            web.clickButton("TillKassanPopUp_CloseButton");
            web.refreshPage();
            web.clickButton("TillKassanPopUp_Link");
        }

        web.waitForElementPresent("TillKassan_cartIsEmptyMessage");

        if (web.isElementPresent("TillKassan_cartIsEmptyMessage")) {
            LOG.info("Products was delete from basket on main page popUp");
            web.refreshPage();

        } else {
            LOG.error("TillKassan_cartIsEmptyMessage is present text - " + web.getElement("TillKassanPopUp_Link").getText() + "\n");
            Assert.fail("TillKassan_cartIsEmptyMessage is NOT present!");
        }
    }

    /**
     Search
     */
    public void clickOnMenuSearchButton() {
        web.waitForElementPresent("NavigationMenu_SearchButton");
        web.waitForElementToBeClickable("NavigationMenu_SearchButton");
        web.clickButton("NavigationMenu_SearchButton");
    }

    public void clickOnSearchBackground() {
        web.clickButton("SearchBackground");
    }

    public void clickOnSmallSearchButton() {
        web.clickButton("SmallSearchButton");
    }

    public void typeInSearchField(String inputData) {
        web.input("SearchInputField", inputData);
    }

    public boolean isNoProductsFound() {
        if (web.isElementPresent("NoProductsFoundMessage")) {
            LOG.info("NoProductsFoundMessage is shown");
            return true;
        } else {
            LOG.info("NoProductsFoundMessage is NOT shown!\n");
            return false;
        }
    }

    public boolean isAutoCompletePresent() {
        web.waitForElementPresent("Autocomplete_DropDown");

        if (web.isElementPresent("Autocomplete_DropDown")
                && web.isElementPresent("AutocompleteElements")) {
            LOG.info("AutoComplete works correct");
            return true;
        } else {
            return false;
        }
    }

    //lineup images, collection texts, product names and prices are shown
    public boolean isLineUpProductInformationShown() {
        //web.waitForElementPresent("Productlineup_ShownProductsImages");

        if (web.isAllElementsPresent("Productlineup_ShownProductsImages")
                //&& web.isAllElementsPresent("Productlineup_ShownProductsCollectionTexts")
                && web.isAllElementsPresent("Productlineup_ShownProductsNames")
                && web.isAllElementsPresent("Productlineup_ShownProductsPriceTexts")) {

            LOG.info("Products in LineUp shown correct");
            return true;
        } else {
            LOG.error("Products in LineUp shown INCORRECT!\n" +
                    "Productlineup_ProductsImages - " + web.isAllElementsPresent("Productlineup_ShownProductsImages") + "\n" +
                    "Productlineup_ProductsCollectionTexts - " + web.isAllElementsPresent("Productlineup_ShownProductsCollectionTexts") + "\n" +
                    "Productlineup_ProductsNames - " + web.isAllElementsPresent("Productlineup_ShownProductsNames") + "\n" +
                    "Productlineup_ProductsPriceTexts - " + web.isAllElementsPresent("Productlineup_ShownProductsPriceTexts") + "\n");
            return false;
        }
    }

    public void clickOnArrowOnProductLineUp(String arrowLocator) {
        web.clickLink(arrowLocator);
    }

    public boolean isTitleProductLineUpShownCorrect() {
        if (web.getElementText("ProductlineupTitle").equals("Höstens denim")) {
            LOG.info("Product lineup title shown correct - " + web.getElementText("ProductlineupTitle"));
            return true;
        } else {
            LOG.error("Product lineup title shown INCORRECT!" +
                    "Product lineup title - " + web.getElementText("ProductlineupTitle"));
            return false;
        }
    }

    public void clickOnFirstProductOnLinaUp() {
        Assert.fail();
    }

    public void clickOn(String elementLocator) {
        web.clickButton(elementLocator);
    }

}
