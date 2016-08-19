package cucumberTests.selenium;

import cucumber.api.java.en.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * Created by kvitlap on 2016-07-25.
 */
public class HelpDeskDefinitions extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @And("^I check that I switch to HelpDesk page correctly$")
    public void i_check_that_I_switch_to_HelpDesk_page_correctly() {
        ellos().helpDeskPage.checkSwitchToHelpdeskPage();
    }

    @And("^I check that HelpDesk MoreQuestionsAndAnswers info shown correctly$")
    public void iCheckThatHelpDeskMoreQuestionsAndAnswersInfoShownCorrectly() {
        ellos().helpDeskPage.checkSwitchToMoreQuestionsAndAnswersInfo();
    }

    @And("^I check that I switch to Lend And Insure page correctly$")
    public void iCheckThatISwitchToLendAndInsurePageCorrectly() {
        Assert.assertTrue(ellos().mainPage.getCurrentPageURL().contains("page/finance/start"), "Switch to Lend And Insure page was incorrectly!");
    }

    @Then("^I see that HelpDesk UI shown correctly$")
    public void iSeeThatHelpDeskUIShownCorrectly() {
        ellos().helpDeskPage.checkHelpDeskUIShown();
    }

}
