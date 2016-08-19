package cucumberTests.selenium;

import cucumber.api.java.en.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;


public class ErrorPageDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @And("^I check that I switch to Main page correct$")
    public void i_check_that_I_switch_to_Main_page_correct() {
        ellos().mainPage.checkCorrectSwitchToMainPage();
    }

    /**
     Verify
     */
    @Then("^I see that error messages \"([^\"]*)\" and \"([^\"]*)\" are present$")
    public void i_see_that_messages_are_present(String errorTitle, String errorMessage) {
        Assert.assertTrue(ellos().errorPage.isErrorMessagesPresentOnErrorPage(errorTitle, errorMessage));
    }

    @Then("^I press button Go to home page$")
    public void i_press_button_Go_to_home_page() {
        ellos().errorPage.pressButton_GoToHomePage();
    }

    @Then("^I press button Back to previous page$")
    public void i_press_button_Back_to_previous_page() {
        ellos().errorPage.pressButton_BackToPreviousPage();
    }

}
