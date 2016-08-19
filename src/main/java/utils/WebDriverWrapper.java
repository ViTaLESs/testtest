package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class WebDriverWrapper implements WebDriver, TakesScreenshot {

    public WebDriver driver;
    public WebDriverWait waitForElement;
    public JavascriptExecutor javascriptExecutor;

    private static final int TIME_TO_WAIT = Integer.valueOf(PropertyLoader.loadProperty("selenium.implicit.timeout"));


    public WebDriverWrapper(WebDriver dr){
        this.driver = dr;
        this.driver = new Augmenter().augment(dr);

        waitForElement = new WebDriverWait(driver, TIME_TO_WAIT);
    }

    public JavascriptExecutor jsInit() {
        javascriptExecutor = (JavascriptExecutor)driver;
        return javascriptExecutor;
    }


    public WebDriver getOriginalDriver(){
        return this.driver;
    }

    @Override
    public void get(String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        Wait wait = new FluentWait(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outType) {
        try {
            if (driver instanceof FirefoxDriver) {
                return ((FirefoxDriver) driver).getScreenshotAs(outType);
            } else if (driver instanceof ChromeDriver) {
                return ((ChromeDriver) driver).getScreenshotAs(outType);
            } else if (driver instanceof InternetExplorerDriver) {
                return ((InternetExplorerDriver) driver).getScreenshotAs(outType);
            } else if (driver instanceof SafariDriver) {
                return ((SafariDriver) driver).getScreenshotAs(outType);
            } else if (driver instanceof PhantomJSDriver) {
                return ((PhantomJSDriver) driver).getScreenshotAs(outType);
            } else
                return null;
        }
        catch (Exception ignored) {}

        return null;
    }

    // RemoteWebDriver does not implement the TakesScreenshot class
    // if the driver does have the Capabilities to take a screenshot
    // then Augmenter will add the TakesScreenshot methods to the instance
    public void setUpScreenShotMaker(String screenShotDirectory, String fileName) throws IOException {
        String path;

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy/MMM/dd HH:mm:ss");
        String dateN = formatter.format(currentDate.getTime()).replace("/", "_");
        String dateNow = dateN.replace(":", "_");
        String snapShotDirectory = screenShotDirectory + dateNow;

        File f = new File(snapShotDirectory);

        if (!f.exists()) {
            f.mkdir();

            path = f.getAbsolutePath() + "/" + fileName + "/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        } else {
            path = f.getAbsolutePath() + "/" + fileName + "/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
    }



}
