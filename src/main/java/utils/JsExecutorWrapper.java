package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by lavi on 5/11/2016.
 */
public class JsExecutorWrapper {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private JavascriptExecutor js;
    WebDriver driver;
    WebElementsActions web;

    public JsExecutorWrapper(WebDriverWrapper driver) {
        this.driver = driver.getOriginalDriver();
        this.web = new WebElementsActions(driver);
        js = (JavascriptExecutor)driver.getOriginalDriver();
    }

    /**
     * This method gets the value of the input field by querySelector
     */
    public String getFieldValue(String element_cssSelector) {
        String cssSelector = UIMappingSingleton.uiStr(element_cssSelector);
        String fieldValue = String.valueOf(js.executeScript("return document.querySelector('" + cssSelector + "').value;"));

        return fieldValue;
    }

    /**
     * This method gets Web page title
     */
    public String getPageTitle() {
        return js.executeScript("return document.title;").toString();
    }

    /**
     * This method Refresh browser window using Javascript
     */
    public void refreshPage() {
        js.executeScript("history.go(0)");
    }

    /**
     * This method Navigate to one page to other page using Javascript
     */
    public void navigateToPage(String pageUrl) {
        js.executeScript("window.location = '" + pageUrl + "'");
        log.info("Switch to page - " + pageUrl);
    }

    /**
     * This method Handle Scroll on Web page
     * Vertical scroll - down by XX pixels
     */
    public void scrollOnWebPage(String pixels) {
        js.executeScript("window.scrollBy(0," + pixels + ")");
        log.info("Scroll the page by " + pixels + " pixels");
    }

    public void scrollToElement(String element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);"
                , driver.findElement(UIMappingSingleton.ui(element)));

        log.info("Scroll to element - " + element);
    }


    /*
    Click a button in Selenium WebDriver using JavaScript

        Code:
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);

    */

}
