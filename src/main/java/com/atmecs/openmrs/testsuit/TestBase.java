package com.atmecs.openmrs.testsuit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.atmecs.openmrs.constants.Constants;
import com.atmecs.openmrs.utils.PropertiesUtil;

public class TestBase {
	public static WebDriver driver;

	public static PropertiesUtil props = PropertiesUtil.getInstance();
	/*
	 * String environment; String gridip;
	 */

	@BeforeTest
	public void openBrowser() throws MalformedURLException {
		/*
		 * environment = props.getValue("environment"); gridip =
		 * props.getValue("gridip");
		 */

		/*
		 * if (environment.equalsIgnoreCase("grid")) { if
		 * (props.getValue("browser").equalsIgnoreCase("chrome")) {
		 * 
		 * Capabilities caps = DesiredCapabilities.chrome(); driver = new
		 * RemoteWebDriver(new URL(gridip), caps);
		 * 
		 * 
		 * } else if (props.getValue("browser").equalsIgnoreCase("firefox")) {
		 * Capabilities caps = DesiredCapabilities.firefox(); driver = new
		 * RemoteWebDriver(new URL(gridip), caps); }
		 * 
		 * } else if (environment.equalsIgnoreCase("local")) {
		 * 
		 * if (props.getValue("browser").equalsIgnoreCase("chrome")) {
		 * System.setProperty("webdriver.chrome.driver", Constants.Chrome_path); driver
		 * = new ChromeDriver(); } else if
		 * (props.getValue("browser").equalsIgnoreCase("firefox")) {
		 * System.setProperty("webdriver.gecko.driver", Constants.firefox_path); driver
		 * = new FirefoxDriver(); }
		 */
		System.setProperty("webdriver.chrome.driver", Constants.Chrome_path);
		driver = new ChromeDriver();
		driver.get(props.getValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LODE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}


	@AfterTest
	public void quitBrowser() {

		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.quit();
	}
}
