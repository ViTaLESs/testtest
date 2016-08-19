package utils;

import org.apache.log4j.Logger;
import org.testng.Assert;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Util {

	private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

	public WebDriverWrapper driver;
	WebElementsActions web;

	public Util (WebDriverWrapper driver) {
		this.driver = driver;
		web = new WebElementsActions(driver);
	}


	/**
	 * Add text at the end of text file
	 */
	public static void addText(String filePath, String text) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
		out.write(text);
		out.close();
	}

	/**
	 * Check if the test failed or not and complete the test.
	 */
	public static void testResult(boolean isTestPassed) {
		if (!isTestPassed) {
			log.error("TEST FAILED!\n");
			Assert.fail();
		}
		log.info("TEST SUCCESSFULLY COMPLETED");
	}

	/**
	 * This method is used to kill all opened Firefox processes
	 * Old Method for kill all processes
	 */
	static public void killAllProcesses() {
		try {
			Process process = Runtime.getRuntime().exec("cmd /c Taskkill /IM firefox.exe /F");
			process.waitFor();
			log.info("All Firefox processes closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to kill all opened Firefox processes
	 * New method for kill all processes
	 */
	static public void killAllBrowserProcesses(String driverName) {
		try {
			if (driverName.equals("Google Chrome")) {
				driverName = "chrome";
			}
			if (driverName.equals("Opera")) {
				driverName="opera";
			}
			Process process = Runtime.getRuntime().exec("cmd /c Taskkill /IM "+driverName+".exe /F");
			process.waitFor();
			log.info("All Firefox processes closed.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method return digit from inputString
	 */
	public static double getDigitFromString(String inputString) {
		return Double.valueOf(inputString
				.substring(0, inputString.length() - 3)
				.replaceAll(" ", "")
				.replaceAll(",", "."));
	}



}
