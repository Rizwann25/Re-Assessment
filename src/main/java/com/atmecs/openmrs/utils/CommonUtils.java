package com.atmecs.openmrs.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.atmecs.openmrs.constants.ErrorMessages;
import com.atmecs.openmrs.testsuit.TestBase;

public class CommonUtils extends TestBase {

	static LogReporter report = new LogReporter();

	public WebElement findsWebelement(String Xpath) {
		WebElement Name = driver.findElement(By.xpath(Xpath));
		return Name;
	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = true;
		try {
			Assert.assertTrue(condition);
			report.info("PASS : " + message);
			Reporter.log("PASS : " + message);
			result = true;

		} catch (AssertionError assertionError) {

			result = false;
		}
		  return result;

	}

	public boolean isDisplayed(String XPathIsDisplayed, String message) {
		boolean isDisplayed = false;
		try {
			isDisplayed = driver.findElement(By.xpath(XPathIsDisplayed)).isDisplayed();
			report.info("PASS : " + message + " IsDisplayed");
			Reporter.log("PASS : " + message + " IsDisplayed");

		} catch (Exception e) {
			report.info(ErrorMessages.ELEMENTNOTFOUND.toString());

			isDisplayed = false;
		}
		return isDisplayed;
	}

	public void clickElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = findsWebelement(xpath);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();

		} catch (Exception e) {
			report.info(ErrorMessages.ELMENTNOTCLICKABLE.toString());
		}
	}

	public boolean sendkeys(String xpath, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = findsWebelement(xpath);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			element.clear();
			element.sendKeys(value);

		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String elementGetText(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = findsWebelement(xpath);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			String elementText = element.getText();

			return elementText;

		} catch (Exception e) {
			return ErrorMessages.TEXTNOTFOUND.toString();

		}
	}

	public void selectDropdown(String Xpath, String value) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = findsWebelement(Xpath);
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Xpath)));
			Select option = new Select(element);
			option.selectByVisibleText(value);

		} catch (Exception e) {
			report.info(ErrorMessages.DROPDOWNNOTFOUND.toString());

		}

	}

	public boolean verifyMsg(String actual, String expected, String message) {
		try {
			Assert.assertEquals(actual, expected);
			report.info("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			Reporter.log("PASS : " + message + ": " + "ACTUAL : " + actual + " 	" + "EXPECTED :" + expected);
			return true;
		} catch (AssertionError assertionError) {
			return false;
		}
	}

	public String DynamicXpath(String Name) {
		String template = "//td[contains(text(),'&&')]";
		return template.replace("&&", Name);

	}

}
