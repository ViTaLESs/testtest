package cucumberTests.selenium;

import cucumber.api.Scenario;
import cucumber.api.java.*;
import utils.ClassNameUtil;
import org.apache.log4j.Logger;

/**
 * Created by lavi on 3/10/2016.
 */
public class CucumberSeleniumHooks extends Fixture {
    /**
     In addition to, getStatus() and getSourceTagNames(), there is another method, getName() that returns the scenario's description. For example, for a scenario as follows:
     Scenario: verify number of topics shown in the UI
     scenario.getName() returns "verify number of topics shown in the UI"
     */

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());


    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("\n\n\t<--- Start running Scenario: " + scenario.getName() + " --->\n");
    }

    @After
    public void afterScenario(Scenario scenario) {
        if(scenario.isFailed()) {
            ellos().screenShotMaker.getScreenShot(scenario.getName());
        }
        log.info("\n\n\t<--- End of Scenario: " + scenario.getName() + " --->");
        log.info("\t\t Status ==> " + scenario.getStatus().toUpperCase());
        log.info("***");
        log.info("***");
        log.info("***");
    }

}
