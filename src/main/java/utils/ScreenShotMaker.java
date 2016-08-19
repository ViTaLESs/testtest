package utils;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;


public class ScreenShotMaker {

    private WebDriverWrapper driver;

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static String screenShotDirectory = PropertyLoader.loadProperty("screenshot.folder");


    public ScreenShotMaker(WebDriverWrapper driver) {
        this.driver = driver;

        File scrDir = new File(screenShotDirectory);
        if (!scrDir.exists())
            scrDir.mkdirs();
    }


    public void getScreenShot(String fileName) {
        try {
            driver.setUpScreenShotMaker(screenShotDirectory, fileName);
            log.info("Make screenshot " + fileName);
        } catch (IOException e) {
            log.error("Failed to capture screenshot: " + e.getMessage());
        }
    }


}
