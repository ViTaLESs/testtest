package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;


public class MyCabinetPage extends Page{

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public MyCabinetPage(WebDriverWrapper driver) {
        super(driver);
    }


    public void checkCorrectSwitchToMyCabinet() {
        web.waitForElementPresent("LogoutLink");

        Assert.assertTrue(web.isElementPresent("LogoutLink"),
                "Switch To MyCabinet was INCORRECT! LogoutLink not present after Switch To MyCabinet; LogoutLink - absent.");

        log.info("Switch To MyCabinet was correct");
    }

    public void clickOnLogoLink() {
        web.clickLink("MyCabinet_LogoLink");
    }

    public void logout() {
        web.clickButton("ProfileSettingsTab");

        Action dragAndDrop = new Actions(webDriverWrapper.getOriginalDriver())
                .clickAndHold(web.getElement("ProfileSettingsTab"))
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT)
                .build();

        dragAndDrop.perform();

        web.clickButton("LogoutLink");

        Assert.assertTrue(web.isElementPresent("Logo"), "Logout was INCORRECT!");
        log.info("Switch from Logout to Main Page was correct");

    }

    public  void switchToMainPageFromMyCabinet() {
        web.waitForElementPresent("LoginPage_Logo");
        web.waitForElementToBeClickable("LoginPage_Logo");
        web.clickLink("LoginPage_Logo");
    }

    //TODO improve checking
    public void checkCorrectSwitchToMainPage() {
        Assert.assertTrue(web.isElementPresent("Logo"), "Switch to MainPage was INCORRECT!");
        log.info("Switch to MainPage was correct");
    }

    public void checkCorrectSwitchToWishListTab() {
        Assert.assertTrue(web.isElementPresent("MyCabinet_EmailToFriend_Button")
                && web.isElementPresent("MyCabinet_AddAllProducts_Button"), "Switch to WishListTa was INCORRECT!");
        log.info("Switch to WishListTa was correct");
    }


}
