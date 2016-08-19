package pages;

import utils.ClassNameUtil;
import utils.JsExecutorWrapper;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.WebDriverWrapper;
import utils.WebElementsActions;


public abstract class Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private String PAGE;
    public WebDriverWrapper webDriverWrapper;
    public WebElementsActions web;
    public JsExecutorWrapper js;


    public Page(WebDriverWrapper dr, String page) {
        webDriverWrapper = dr;
        PAGE = page;
        web = new WebElementsActions(dr);
        js = new JsExecutorWrapper(dr);
    }

    public Page(WebDriverWrapper dr) {
        webDriverWrapper = dr;
        web = new WebElementsActions(dr);
        js = new JsExecutorWrapper(dr);
    }


    /*
     * Open Page in a browser
     */
    public void openPage(){
        get(PAGE);

        if (PAGE.equals(getCurrentPageURL())) {
            log.info("Page was opened successfully.");
        } else {
            log.error("Page: Page has been opened unsuccessfully!\n");
            Assert.fail("Input URL - " + PAGE + ";\tCurrentUrl - " + getCurrentPageURL());
        }
    }

    public void openPage(String pageURL) {
        get(pageURL);

        if (pageURL.equals(getCurrentPageURL())) {
            log.info("Page was opened successfully.");
        } else {
            log.error("Page: Page has been opened unsuccessfully!\n");
            Assert.fail("Input URL - " + pageURL + ";\tCurrentUrl - " + getCurrentPageURL());
        }
    }

    /*
     * Verification Page open correct. Check on pageLocator
     */
    public boolean isOpenPage(String checkLocator){
        web.waitForElementPresent(checkLocator);

        if (web.isElementPresent(checkLocator)) {
            log.info("Page: Page has been opened successfully.");
            return true;
        } else {
            log.error("Page: Page has been opened unsuccessfully!\n");
            Assert.fail("Page has been opened unsuccessfully! Element - " + checkLocator + "is not present!");
        }
        return false;
    }

    /*
     * Get page title for verification correct switch between pages
     */
    public String getTitle() {
        return webDriverWrapper.getTitle();
    }

    public String getCurrentPageURL() {
        log.info("Page: Method getCurrentUrl() return - " + webDriverWrapper.getCurrentUrl());
        return webDriverWrapper.getCurrentUrl();
    }

    public void get(String URL) {
        log.info("Page: Beginning of the opening page == " + URL);
        webDriverWrapper.get(URL);
    }

    public void deleteAllCookies() {
        log.info("<--- All Cookies have been deleted --->");
        webDriverWrapper.manage().deleteAllCookies();
    }

    public void sleep(long millis) {
        try {
            log.info("*Start TO* Wait " + millis + " milliseconds");
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
