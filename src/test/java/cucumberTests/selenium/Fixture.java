package cucumberTests.selenium;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import utils.*;
import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import ru.stqa.selenium.factory.WebDriverFactory;
import ru.stqa.selenium.factory.WebDriverFactoryMode;
import pages.Ellos;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;


public class Fixture extends AbstractTestNGCucumberTests {

    public WebDriverWrapper webDriverWrapper;
    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("selenium.implicit.timeout");
    private static final String LOADING_PAGE= PropertyLoader.loadProperty("selenium.pageLoad.timeout");
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static final Map<Long, Ellos> ELLOS = new ConcurrentHashMap<>();

    public Ellos ellos() {
        return ELLOS.get(currentThread().getId());
    }

    @BeforeSuite
    public void setUpSuite(){
        if (ru.stqa.selenium.factory.WebDriverFactory.isEmpty())
            WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
        log.info("<--- Start test suite --->");
    }


    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void init(@Optional String browser) {
        if (browser == null) Assert.fail("Browser - " + browser + "!");

        UIMappingSingleton.getInstance();

        webDriverWrapper = new WebDriverWrapper(new MyWebDriverFactory().getInstance(browser));
        log.info(" <--- WebDriverFactory.isEmpty() == " + WebDriverFactory.isEmpty() + " ---> ");

        ELLOS.putIfAbsent(currentThread().getId(), new Ellos(webDriverWrapper));
        log.info("<--- Ellos currentThread - " + ELLOS.get(currentThread().getId()) + " --->");

        webDriverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        webDriverWrapper.manage().timeouts().setScriptTimeout(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        webDriverWrapper.manage().timeouts().pageLoadTimeout(Long.parseLong(LOADING_PAGE), TimeUnit.SECONDS);

        webDriverWrapper.manage().deleteAllCookies();
        webDriverWrapper.manage().window().maximize();
        log.info("<--- Start tests --->");
    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        ELLOS.remove(currentThread().getId());
        //WebDriverFactory.dismissDriver(webDriverWrapper.getOriginalDriver());
        log.info("<--- Test finished --->");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownSuite() {
        WebDriverFactory.dismissAll();
        log.info("<--- Test suite finished --->");
    }

}
