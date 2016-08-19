package pages;

import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class WishlistModalWindow extends Page{

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public WishlistModalWindow(WebDriverWrapper driver) {
        super(driver);
    }


    public void checkThat_LoginRegistration_OnWishListShown() {
        sleep(3000);
        web.waitForElementPresent("WishlistModalWindow");

        if (web.isElementPresent("NewOrExistingCustomerTitle") && web.isElementPresent("NewOrExistingCustomerForm")) {
            log.info("Wishlist modal window for log in and registration is shown");
        } else {
            log.error("Wishlist modal window for log in and registration is NOT SHOWN!\n");
            Assert.fail("Wishlist Modal Window for log in and registration is not shown or shown incorrect!" + "\n" +
                    "is Title Present - " + web.isElementPresent("NewOrExistingCustomerTitle") + "\n" +
                    "is Login Form Present - " + web.isElementPresent("NewOrExistingCustomerForm"));
        }
    }

    public void clickOnLoginButtonOnWishlist() {
        web.clickButton("WishlistLoginButton");
    }

    public void checkThatModalWindowForAddProductToWishlistIsShown() {
        sleep(3000);

        Assert.assertTrue(web.isElementPresent("WishlistModalForm")
                && web.isElementPresent("WishlistModalForm_MyFavoriteLink")
                && web.getElementText("WishlistModalForm_Text").contains(web.getElementText("ProductName")));
        log.info("Modal window for add product to Existing Wishlist is shown");
    }

    public void createNewWishlistAndSave(String wishlistName) {
        if (web.isElementPresent("WishlistNameField")) {
            web.input("WishlistNameField", wishlistName);
            web.clickButton("WishlistSaveButton");
        } else {
            web.clickLink("NewWishlistRadioButton");
            web.input("WishlistNameField", wishlistName);
            web.clickButton("WishlistSaveButton");
        }
    }

    public void checkNewWishlistName(String wishlistName) {
        web.waitForElementPresent("CreatedWishlistName");

        if (web.getElementText("CreatedWishlistName").equals(wishlistName)) {
            log.info("New wishlist name - " + web.getElementText("CreatedWishlistName"));
            log.info("Product was save to new wishlist successfully");

            web.clickButton("ConfirmNewWishList_OK_Button");
        } else {
            Assert.fail("INCORRECT New wishlist name - " + web.getElementText("CreatedWishlistName") + "\n" +
                    "Expected - " + wishlistName);
        }
    }

    public void saveProductToExistingWishlist(String existingWishlistLocator) {
        web.clickButton(existingWishlistLocator);
        web.clickButton("WishlistSaveButton");
    }

    public void checkThatProductWasSaveToExistingOrNewWishlistSuccessfully(String productNameLocator) {
        sleep(2000);

        if (web.isElementPresent("AddProductToExistingWishlist_Title")
                && web.getElementText("AddProductToWishlistDescription").contains(web.getElementText(productNameLocator))
                && web.isElementPresent("ConfirmNewWishList_OK_Button")) {

            log.info("Product was save to existing wishlist successfully");
            web.clickButton("ConfirmNewWishList_OK_Button");
        } else {
            log.error("Product was save to existing wishlist INCORRECT!");
            Assert.fail("is Title Present - " + web.isElementPresent("AddProductToExistingWishlist_Title") + "\n" +
                    "is Product Description correct - " + web.getElementText("AddProductToWishlistDescription").contains(web.getElementText(productNameLocator)) + "\n" +
                    "is Confirm Button Present - " + web.isElementPresent("ConfirmNewWishList_OK_Button"));
        }
    }

    public void closeWishlistModalWindow() {
        web.waitForElementPresent("WishlistCloseButton");
        web.waitForElementToBeClickable("WishlistCloseButton");
        web.clickButton("WishlistCloseButton");
    }

    public void fillLoginField(String inputEmail) {
        web.input("WishlistOnCheckoutPage_LoginField", inputEmail);
        log.info("Fill LogginEmailField - " + inputEmail);
    }

    public void fillPasswordField(String inputPass) {
        web.input("WishlistOnCheckoutPage_PasswordField", inputPass);
        log.info("Fill LogginPassField - " + inputPass);
    }

    public void clickOnLoginButton() {
        web.clickButton("WishlistOnCheckoutPage_LoginButton");
        log.info("Click on loginSubmitButton");
    }

    public void clickOnButtonNewCustomerInWishlistWindowOnCheckoutPage() {
        web.clickLink("WishlistOnCheckoutPage_NewCustomerButton");
        log.info("Click on button +NewCustomer In Wishlist Window On Checkout Page");
    }

    public void click_OK_ButtonOnWishlistModalForm() {
        web.waitForElementPresent("WishlistModalForm_OK_Button");
        web.waitForElementToBeClickable("WishlistModalForm_OK_Button");
        web.clickButton("WishlistModalForm_OK_Button");
    }

    public void click_Close_ButtonOnWishlistModalForm() {
        web.waitForElementPresent("WishlistModalForm_Close_Button");
        web.waitForElementToBeClickable("WishlistModalForm_Close_Button");
        web.clickButton("WishlistModalForm_Close_Button");
    }
}
