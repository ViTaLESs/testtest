package utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.stqa.selenium.factory.WebDriverFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


public class MyWebDriverFactory {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    /* Browsers constants */
    public static final String CHROME = "chrome";
    public static final String FIREFOX = "firefox";
    public static final String INTERNET_EXPLORER = "ie";
    public static final String SAFARI = "safari";
    public static final String IPHONE = "iphone";
    public static final String PHANTOMJS = "phantomjs";
    public static final String HTML_UNIT = "htmlunit";

    /* Platform constants */
    public static final String WINDOWS = "windows";
    public static final String ANDROID = "android";
    public static final String LINUX = "linux";
    public static final String IOS = "IOS";

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");
    public static final String hub = PropertyLoader.loadProperty("grid2.hub");

    public static DesiredCapabilities capability;


    public MyWebDriverFactory() {
    }

    /**
     * Factory method to return a RemoteWebDriver instance given the url of the
     * Grid hub and a Browser instance.
     * SetUp grid : browserName, browserVersion, platform.
     * @setBrowserAndVersion
     * @setPlatform
     *
     * @return WebDriver
     */
    public WebDriver getInstance(String browserName) {

        capability = new DesiredCapabilities();
        capability.setJavascriptEnabled(true);

        log.info(" <--- Start work WebDriver Factory ---> ");
        setBrowserAndVersion(capability, browserName, browserVersion);
        log.info(" <--- Successful set Browser And Version == " + capability + " ---> ");
        setPlatform(capability);
        log.info(" <--- Successful set Platform == " + capability + " ---> ");
        log.info(" <--- Hub URL == " + hub + " ---> ");

        return WebDriverFactory.getDriver(hub, capability);
    }


    /**
     * Method makes the check and returns hub url
     */
    public static URL getHubURL() {
        URL hubUrl = null;

        try {
            hubUrl = new URL(hub);
            log.info("HUBURL ==> " + hub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // In case there is no Hub
        if (hubUrl == null) {
            log.error("HUBURL == null!\n");
            return null;
        } else {
            return hubUrl;
        }
    }

    /**
     * Factory method to return a WebDriver instance given the browser to hit
     * @param capability : : DesiredCapabilities object coming from getInstance()
     * @param browserName : browserName from PropertyLoader.loadProperty("browser.name");
     * @param browserVersion : browserVersion from PropertyLoader.loadProperty("browser.version");
     *
     * @void : setUp capability
     */
    public void setBrowserAndVersion(DesiredCapabilities capability, String browserName, String browserVersion) {

        if (CHROME.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", "c:\\tools\\chromedriver.exe");
//TODO asLIST!
            capability.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
            capability.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
        } else if (FIREFOX.equals(browserName)) {
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.firefox();
            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        } else if (INTERNET_EXPLORER.equals(browserName)) {

            //TODO
            /**
             *need to debug
             */
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.internetExplorer();
            capability.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            capability.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
            capability.setCapability("requireWindowFocus", true);
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            capability.setCapability("browserstack.ie.enablePopups", false);
            System.setProperty("webdriver.ie.driver", "C:\\tools\\IEDriverServer.exe");
        } else if (SAFARI.equals(browserName)) {
            //TODO
            /**
             *need to debug
             */
            capability.setBrowserName(browserName);
            capability = DesiredCapabilities.safari();
            capability.setCapability("safari.cleanSession", true);
            capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
            capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


            //TODO
            /**
             * Most likely PHANTOMJS does not work!
             * Need debug!
             */
        } else if (PHANTOMJS.equals(browserName)) {
            capability.setBrowserName(browserName);
            //File phantomjs = Phanbedder.unpack();
            //capability.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjs.getAbsolutePath());
            capability = DesiredCapabilities.phantomjs();
            capability.setCapability("takesScreenshot", true);
            capability.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[]{
                    "--webdriver-loglevel=NONE"
            });
        }

        if (browserVersion != null) {
            capability.setVersion(browserVersion);
        } else {
            capability.setPlatform(Platform.ANY);
        }

    }


    /**
     * Helper method to set version and platform for a specific browser
     * @param capability : DesiredCapabilities object coming from getInstance()
     * @param /platform : browser platform
     *
     * @void setUp DesiredCapabilities
     */
    private void setPlatform(DesiredCapabilities capability) {
        if (WINDOWS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.WINDOWS);
        } else if (IOS.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.MAC);
        } else if (ANDROID.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.ANDROID);
        } else if (LINUX.equalsIgnoreCase(platform)) {
            capability.setPlatform(Platform.LINUX);
        } else {
            capability.setPlatform(Platform.ANY);
        }
    }

}
