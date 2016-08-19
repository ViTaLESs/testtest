package pages;

import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import utils.WebDriverWrapper;


public class ErrorPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public ErrorPage(WebDriverWrapper dr) {
        super(dr);
    }

    public boolean isErrorMessagesPresentOnErrorPage(String errorTitle, String errorMessage) {
        if (web.getElementText("ErrorPageTitle").equals(errorTitle)
                && web.getElementText("ErrorPageMessage").equals(errorMessage)) {
            log.info("Error message displays correctly on ErrorPage");
            return true;
        } else {
            log.info("Error message displays INCORRECTLY on ErrorPage!\n" +
                    "ErrorPageTitle - " + web.getElementText("ErrorPageTitle").equals(errorTitle) + "\n" +
                    "ErrorPageMessage - " + web.getElementText("ErrorPageMessage").equals(errorMessage));
            return false;
        }
    }

    public void pressButton_GoToHomePage() {
        web.clickButton("GoToHomePage_Button");
    }

    public void pressButton_BackToPreviousPage() {
        web.clickButton("BackToPreviousPage_Button");
    }

}
