package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;


public class HelpDeskPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public HelpDeskPage(WebDriverWrapper dr) {
        super(dr);
    }


    public void checkSwitchToHelpdeskPage() {
        Assert.assertTrue(web.isElementPresent("HelpDeskTextContainer"),
                "Switch to Helpdesk page was INCORRECTLY!");
    }

    public void checkHelpDeskUIShown() {
        Assert.assertTrue(web.isElementPresent("HelpDeskTextContainer")
                && web.isElementPresent("HelpDesk_MinaSidorBox")
                && web.isAllElementsPresent("HelpDesk_PushBoxes")
                && web.isElementPresent("HelpDesk_LogReg_Button")
                && web.isElementPresent("HelpDesk_MoreQuestionsAndAnswers_Button"),
                "Help Desk UI shown INCORRECTLY!");
    }

    public void checkSwitchToMoreQuestionsAndAnswersInfo() {
        Assert.assertTrue(web.isElementPresent("HelpDesk_GroupMenu")
                        && web.isElementPresent("HelpDesk_CommonQuestions"),
                "More Questions And Answers Info shown INCORRECTLY!");
    }

}
