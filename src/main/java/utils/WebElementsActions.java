package utils;

import exception.NoElementFound;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;


public class WebElementsActions {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String EXPLICIT_WAIT = PropertyLoader.loadProperty("selenium.explicit.timeout");

    private static WebDriverWait waitForElement;
    private WebDriverWrapper driver;
    private Random random;


    public WebElementsActions(WebDriverWrapper driver) {
        this.driver = driver;
        waitForElement = new WebDriverWait(driver, Long.parseLong(EXPLICIT_WAIT));
        random = new Random();
    }

    //TODO
    public JavascriptExecutor jsInit() {
        return driver.jsInit();
    }

    public WebElement getElement(String elementLocator) {
        return driver.findElement(UIMappingSingleton.ui(elementLocator));
    }

    public List<WebElement> getElements(String elementsLocator) {
        return driver.findElements(UIMappingSingleton.ui(elementsLocator));
    }

    public String getElementText(String elementsLocator) {
        log.info(elementsLocator + " contain text ==> " + driver.findElement(UIMappingSingleton.ui(elementsLocator)).getText());

        return driver.findElement(UIMappingSingleton.ui(elementsLocator)).getText();
    }

    public String getElementAttribute(String elementsLocator, String attribute) {
        log.info(elementsLocator + " element attribute contains ==> " + driver.findElement(UIMappingSingleton.ui(elementsLocator)).getAttribute(attribute));

        return driver.findElement(UIMappingSingleton.ui(elementsLocator)).getAttribute(attribute);
    }

    /**
     * Click a button
     */
    public void clickButton(String buttonLocator) {
        driver.findElement(UIMappingSingleton.ui(buttonLocator)).click();
        log.info("Click on button " + buttonLocator);
    }

    /**
     * Insert value into text input HTML field
     */
    public void input(String inputLocator, String inputData) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * Insert value into text input HTML field without Clean
     */
    public void inputWithoutClean(String inputLocator, String inputData) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
    }

    /**
     * Insert value into text input HTML field and Click ENTER for Field which used "Value" in the xpath expression
     */
    public void inputAndClickEnter(String inputLocator, String inputData) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).clear();
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(inputData);
        log.info("Input in " + inputLocator + ", value - " + inputData);
        pressEnterKey(inputLocator);
    }

    /**
     * Select value from drop down list
     */
    public void selectFromList(String listLocator, String listValue) {
        new Select(driver.findElement(UIMappingSingleton.ui(listLocator))).selectByValue(listValue);
    }

    /**
     * Select/deselect the checkbox, the second parameter should be "Y" or "N"
     */
    public void selectCheckbox(String checkboxLocator, String isSet) throws NoElementFound {
        if (driver.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() & isSet.equals("N")) {
            driver.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
        if (!driver.findElement(UIMappingSingleton.ui(checkboxLocator)).isSelected() & isSet.equals("Y")) {
            driver.findElement(UIMappingSingleton.ui(checkboxLocator)).click();
        }
    }

    /**
     * Click link
     */
    public void clickLink(String linkLocator) {
        driver.findElement(UIMappingSingleton.ui(linkLocator)).click();
        log.info("Click on link - " + linkLocator);
    }

    /**
     * Method is used to check that element is present on page.
     */
    public boolean isElementPresent(String elementLocator) {
        List<WebElement> list = driver.findElements(UIMappingSingleton.ui(elementLocator));

        if (list.size() == 0) {
            log.warn("Element _" + elementLocator + "_ is NOT Present in DOM!");
            return false;
        }

        if (list.get(0).isDisplayed()) {
            log.info("Element _" + elementLocator + "_ is Present");
            return true;
        } else {
            log.warn("Element _" + elementLocator + "_ is NOT Present!");
            return false;
        }
    }

    public boolean isAllElementsPresent(String elementLocator) {
        waitForElementPresent(elementLocator);

        List<WebElement> list = new ArrayList<>();
        list.addAll(driver.findElements(UIMappingSingleton.ui(elementLocator)));

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).isDisplayed()) {
                log.warn("Element _" + list.get(i) + "_ is NOT Present!" + " [Element position (" + i + ")]");
                return false;
            }
        }

        log.info("Total quantity of " + elementLocator + " - " + list.size());
        return true;
    }

    public boolean isElementSelected(String elementLocator) {
        if (getElement(elementLocator).isSelected()) {
            log.info(elementLocator + " is selected");
            return true;
        } else {
            log.warn(elementLocator + " is not selected");
            return false;
        }
    }

    public boolean isElementEnabled(String elementLocator) {
        if (getElement(elementLocator).isEnabled()) {
            log.info(elementLocator + " is Enabled");
            return true;
        } else {
            log.warn(elementLocator + " is not Enabled!");
            return false;
        }
    }

    public boolean isElementEnabled(WebElement elementLocator) {
        if (elementLocator.isEnabled()) {
            log.info(elementLocator + " is Enabled");
            return true;
        } else {
            log.warn(elementLocator + " is not Enabled!");
            return false;
        }
    }

    /**
     * Wait the text in the element value specified time
     */
    public void waitTextPresent(WebElement elementLocator, String text) {
        log.trace("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions.textToBePresentInElement(elementLocator, text));
    }

    /**
     * Wait the text in the element (value tag!) specified time
     */
    public void waitTextPresentInElementValue(String elementLocator, int timeoutInS, String text) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInS);

        log.trace("*Start TO* Wait For Text Present In Element _" + elementLocator + "_ Value");

        wait.until(ExpectedConditions.textToBePresentInElementValue(UIMappingSingleton.ui(elementLocator), text));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator); is that it expects the appearance of an element.
     */
    public void waitForElementPresent(String elementLocator) {
        log.trace("*Start TO* Wait For Element _" + elementLocator + "_ Present");
        waitForElement.until(ExpectedConditions.visibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    public void waitForElementDisappear(String elementLocator) {
        log.trace("*Start TO* Wait For Element _" + elementLocator + "_ Disappear");
        waitForElement.until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(UIMappingSingleton.ui(elementLocator))));
    }

    //It did not work in July 2016
    public void waitForElementSelectionState(String elementLocator, boolean selected) {
        log.trace("*Start TO* Wait For Element _" + elementLocator + "_ Selection State");
        waitForElement.until(ExpectedConditions.not(ExpectedConditions.elementSelectionStateToBe(UIMappingSingleton.ui(elementLocator), selected)));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a
     * page. This does not necessarily mean that the element is visible.
     *
     * @param elementLocator used to find the element
     */
    public void waitForPresenceOfElementLocated(String elementLocator) {
        log.trace("*Start TO* Wait For Presence Of Element Located _" + elementLocator + "_");
        waitForElement.until(ExpectedConditions.presenceOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param elementLocator used to find the element
     */
    public void waitForElementToBeClickable(String elementLocator) {
        log.trace("*Start TO* Wait For Element _" + elementLocator + "_ To Be Clickable");
        waitForElement.until(ExpectedConditions.elementToBeClickable(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * An expectation for checking that an element is becomes invisible, but stay on the DOM.
     */
    public void waitForInvisibilityOfElement(String elementLocator) {
        log.trace("*Start TO* Wait For Invisibility Of Element _" + elementLocator + "_ ");
        waitForElement.until(ExpectedConditions.invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * Wait for invisibility Of Element on page specified time
     */
    public void waitForElementNotVisible(String elementLocator, int timeoutInS) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInS);

        log.trace("*Start TO* Wait For Element Not Visible _" + elementLocator + "_");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * Wait for invisibility Of Element on page
     */
    public void waitForElementNotVisible(String elementLocator) {
        log.trace("*Start TO* Wait For Element Not Visible _" + elementLocator + "_");
        waitForElement.until(ExpectedConditions.invisibilityOfElementLocated(UIMappingSingleton.ui(elementLocator)));
    }

    /**
     * This method is used to wait for getting response from all Ajax requests
     */
    public boolean waitForAjaxResponse(int timeoutSeconds) throws InterruptedException {
        //TODO js executor
        if (driver instanceof JavascriptExecutor) {
            JavascriptExecutor jsDriver = (JavascriptExecutor) driver;

            for (int i = 0; i < timeoutSeconds; i++) {
                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");
                if (numberOfConnections != null) {
                    log.debug("Number of active jQuery Ajax calls is <" + numberOfConnections + ">");

                    if (numberOfConnections == 0)
                        break;
                }
                // stay(1);
            }
            return false;
        } else {
            log.info("WebElementsActions Driver: <" + driver + "> cann't execute JavaScript");
            return false;
        }
    }

    /**
     * This method is used to agree messages on pop-up windows
     */
    public boolean isAlertPresent() {
        boolean alertPresence = false;
        try {
            Alert alert = driver.switchTo().alert();
            alertPresence = true;
            alert.accept();
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
            return alertPresence;
        }
        return alertPresence;
    }

    /**
     * This method is used to get text from pop-up windows
     */
    public String getAlertText() {
        String alertText;
        try {
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info("Alert text: " + alertText);
        } catch (NoAlertPresentException ex) {
            alertText = "Alert is not found";
            log.info("Alert is not found");
            ex.printStackTrace();
        }
        return alertText;
    }

    public void moveToElementAndClick(String moveToLocator, String clickToElement) {
        WebElement webElement = getElement(moveToLocator);

        Actions actions = new Actions(driver.getOriginalDriver());
        actions.moveToElement(webElement);
        actions.perform();
        clickButton(clickToElement);

        log.info("moved To Element " + moveToLocator + " and clicked on" + clickToElement);
    }

    /**
     *Methods for generation random six-digit number
     */
    public int getRandom() {
        return 100000 * onlyPlus() + 10000 * onlyPlus() + 1000 * onlyPlus() + 100 * onlyPlus() + 10 * onlyPlus() + onlyPlus();
    }

    private int onlyPlus() {
        return random.nextInt(9) + 1;
    }

    /**
     *Method for generation random email
     */
    public String generateRandomEmail(String inputEmail) {
        return getRandom() + inputEmail;
    }

    /**
     *Method for refresh page
     */
    public void refreshPage() {
        driver.navigate().refresh();
        log.info("Refresh page");
    }

    /**
     *Method#2 for refresh page
     */
    public void refreshPage2() {
        Actions actions = new Actions(driver.getOriginalDriver());
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
        log.info("Refresh page");
    }

    /**
     *Methods for pressing the keypad buttons
     */
    public void pressSpaceKey(String inputLocator) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.SPACE);
        log.info("Press Key SPACE");
    }

    public void pressEnterKey(String inputLocator) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ENTER);
        log.info("Press Key ENTER");
    }

    public void pressESCAPEKey(String inputLocator) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.ESCAPE);
        log.info("Press Key ESCAPE");
    }

    public void pressPageUp(String inputLocator) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.PAGE_UP);
        log.info("Press Key PAGE_UP");
    }

    public void pressPageDown(String inputLocator) {
        driver.findElement(UIMappingSingleton.ui(inputLocator)).sendKeys(Keys.PAGE_DOWN);
        log.info("Press Key PAGE_DOWN");
    }

    /**
     * This method is used to select menu item
     * Use Actions class
     */
    public void selectMenuItem(String menuLocator, String submenuLocator) {
        new Actions(driver.getOriginalDriver()).moveToElement(getElement(menuLocator)).perform();
        log.info("Focus on Menu to open list of submenus");

        clickButton(submenuLocator);
        log.info("Click on Submenu" + submenuLocator);
    }

    /**
     * This method is used to do Focus to Element And Click
     * Use Actions class
     */
    public void doFocusToElementAndClick(String focusElementLocator, String elementLocator) {
        new Actions(driver.getOriginalDriver()).moveToElement(getElement(focusElementLocator)).perform();
        log.info("Focus in to element" + focusElementLocator);

        driver.switchTo();

        if (isElementPresent(elementLocator)) {
            clickButton(elementLocator);
        }
    }

    /**
     * This method is used to click on something and open window in New Tab
     * Use Actions class
     */
    public void clickOnSomethingAndOpenNewTab(String elementLocator) {
        Set<String> oldWindowsSet = driver.getWindowHandles();
        clickButton(elementLocator);
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);

        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
    }

    //by Action class
    public void scrollPageToElement(String elementLocator) {
        Actions actions = new Actions(driver.getOriginalDriver());
        actions.moveToElement(getElement(elementLocator));
        actions.perform();
    }

}
