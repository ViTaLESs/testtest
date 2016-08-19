package pages;

import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PropertyLoader;


public class CheckoutPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public CheckoutPage(WebDriverWrapper driver) {
        super(driver);
    }


    public void pressButtonSaveToWishlist() {
        web.clickButton("SaveToWishlist_Button");
    }

    public void deleteProductOnCheckoutPage() {
        web.inputAndClickEnter("NumberOfProductsInputField", "0");
        web.waitForElementPresent("RestoreButton");

        if (web.getElement("RestoreButton").isDisplayed()) {
            log.info("Correct delete Product from card");
        } else {
            log.error("INCORRECT delete Product from card!\n");
        }
    }

    public void switchToMainPage() {
        sleep(3000);
        web.clickLink("CheckoutLogo");
    }

    public void checkCorrectLoginOnCheckoutPage() {
        if (web.isElementPresent("ConfirmOrderButton")) {
            log.info("I login to the system correct");
        } else {
            log.error("INCORRECT Login from Checkout page!\n");
            Assert.fail();
        }
    }

    public void deployFormRegistrationNewCustomer() {
        web.clickButton("NewCustomerButton");

        web.waitForElementPresent("EmailAddressField");
        if (web.isElementPresent("EmailAddressField")) {
            log.info("Deployment registration form was correct");
        } else {
            log.error("Deployment registration form was INCORRECT!\n");
            Assert.fail("Deployment registration form was INCORRECT after press NewCustomerButton!");
        }
    }

    public void pressConfirmRegistrationButton() {
        web.waitForElementToBeClickable("ConfirmRegistrationButton");
        web.waitForPresenceOfElementLocated("ConfirmRegistrationButton");

        web.clickButton("ConfirmRegistrationButton");
        sleep(5000);
    }

    public void pressConfirmOrderButton() {
        web.clickButton("ConfirmOrderButton");
        sleep(5000);
    }

    public void increaseTheNumberOfProducts(String quantity) {
        web.clickLink("NumberOfProductsInputField");
        web.input("NumberOfProductsInputField", quantity);
        web.clickLink("CheckoutTitle");

        if (web.getElement("NumberOfProductsInputField").getAttribute("value").equals(quantity)) {
            log.info("Credit card has been selected correctly - " + String.valueOf(quantity));
        } else {
            log.error("Credit card has been selected INCORRECTLY! \n");
        }
    }

    public void deleteAllProductsFromCheckout() {
        web.clickLink("NumberOfProductsInputField");
        web.input("NumberOfProductsInputField", "0");
        web.clickLink("CheckoutTitle");


        if (web.isElementPresent("RestoreButton")) {
            log.info("All products was delete successfully");
        } else {
            log.error("All products WAS NOT delete! \n" +
                    "Left -> " + web.getElement("NumberOfProductsInputField").getText() + " products!");
        }
    }

    public boolean isProductInfoCorrectOnCheckoutPage() {
        return false;
    }

    public void choosePaymentMethod_KONTO_or_FAKTURA(String payment_method, String civicNumber) {
        if (web.isElementPresent("ChangePaymentMethodButton")) {
            web.clickButton("ChangePaymentMethodButton");
        }

        js.scrollToElement("ActivePaymentBlock");

        if (web.getElementAttribute("ActivePaymentBlock", "id").contains(payment_method)) {
            web.input("ActiveBlock_CivicNumberInputField", civicNumber);
            webDriverWrapper.findElement(By.cssSelector("button[id$='" + payment_method + "']")).click();
            log.info("I choose payment method - " + payment_method);
        } else {
            webDriverWrapper.findElement(By.cssSelector("a[id$='" + payment_method + "']")).click();
            web.waitForElementPresent("ActiveBlock_CivicNumberInputField");
            web.input("ActiveBlock_CivicNumberInputField", civicNumber);
            webDriverWrapper.findElement(By.cssSelector("button[id$='" + payment_method + "']")).click();
            log.info("I choose payment method - " + payment_method);
        }
    }

    public void choosePaymentMethod_COD_or_CreditCard(String payment_method) {
        if (web.isElementPresent("ChangePaymentMethodButton")) {
            web.clickButton("ChangePaymentMethodButton");
        }

        if (web.getElementAttribute("ActivePaymentBlock", "id").contains(payment_method)) {
            webDriverWrapper.findElement(By.cssSelector("button[id$='" + payment_method + "']")).click();
            log.info("I choose payment method - " + payment_method);
        } else {
            webDriverWrapper.findElement(By.cssSelector("a[id$='" + payment_method + "']")).click();

            WebDriverWait wait = new WebDriverWait(webDriverWrapper, 30);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[id$='" + payment_method + "']")));

            webDriverWrapper.findElement(By.cssSelector("button[id$='" + payment_method + "']")).click();
            log.info("I choose payment method - " + payment_method);
        }
    }

    public void chooseDeliveryMethod(String delivery_method) {
        sleep(2000);

        if (web.isElementPresent("ChangeDeliveryMethodButton")) {
            web.clickButton("ChangeDeliveryMethodButton");
        }

        web.waitForElementPresent("ActiveDeliveryBlock");

        if (web.getElementAttribute("ActiveDeliveryBlock", "data-delivery-id").equals(delivery_method)) {
            webDriverWrapper.findElement(By.cssSelector("button[id$='" + delivery_method + "']")).click();
            log.info("I choose delivery method - " + delivery_method);
        } else {
            webDriverWrapper.findElement(By.cssSelector("a[id$='" + delivery_method + "']")).click();
            web.waitForElementPresent("ActiveDeliveryBlock");
            webDriverWrapper.findElement(By.cssSelector("button[id$='" + delivery_method + "']")).click();
            log.info("I choose delivery method - " + delivery_method);
        }

        sleep(3000);
    }

    //TODO need to improve
    public void checkOrderInfo() {
        web.waitForElementPresent("OrderInfo");

        Assert.assertTrue(web.isElementPresent("OrderInfo"));
    }

    public void checkLoginShownCorrectlyOnCheckoutPage() {
        //web.waitForElementPresent("ShowLoginFormButton");

        Assert.assertTrue((web.isElementPresent("ShowLoginFormButton")
                && web.isElementPresent("ShowRegistrationFormButton")), "Switch to Login Page was INCORRECT!");
        log.info("Switch to Login Page was correct");
    }

    public void fillCreditCardDetailsAndCompleteTheOrder() {
        web.waitForElementPresent("CardNumber");

        web.input("CardNumber", PropertyLoader.loadProperty("visa.number"));
        web.input("ExpiryMonth", PropertyLoader.loadProperty("mm"));
        web.input("ExpiryYear", PropertyLoader.loadProperty("yy"));
        web.input("SecurityCode", PropertyLoader.loadProperty("cvc.number"));

        web.clickButton("CompleteButton");

    }


}
