package com.n26.monefy.automation.pageobjects;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

	public static String XPATH="xpath";
	public static String ID="id";
	public static String NAME="name";
	
	int timeOut = 60;
	public WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * 
	 * @param seconds to sleep
	 */
	public void sleep(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * method verify whether element is present on screen
	 *
	 * @param targetElement element to be present
	 * @return true if element is present else throws exception
	 * 
	 */
	public Boolean isElementPresent(By targetElement) {
		Boolean isPresent = driver.findElements(targetElement).size() > 0;
		return isPresent;
	}

	/**
	 * method to hide keyboard
	 */
	public void hideKeyboard() {
		((AppiumDriver) driver).hideKeyboard();
	}

	/**
	 * method to go back by Android Native back click
	 */
	public void back() {
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}

	/**
	 * method to wait for an element to be visible
	 *
	 * @param targetElement element to be visible
	 * @return true if element is visible else throws TimeoutException
	 */
	public boolean waitForVisibility(By targetElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is not visible: " + targetElement);
			throw e;

		}
	}

	/**
	 * method to wait for an element until it is invisible
	 *
	 * @param targetElement element to be invisible
	 * @return true if element gets invisible else throws TimeoutException
	 */
	public boolean waitForInvisibility(By targetElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			return true;
		} catch (TimeoutException e) {
			System.out.println("Element is still visible: " + targetElement);
			System.out.println();
			System.out.println(e.getMessage());
			throw e;

		}
	}

	/**
	 * method to tap on the screen on provided coordinates
	 *
	 * @param xPosition x coordinate to be tapped
	 * @param yPosition y coordinate to be tapped
	 */
	public void tap(double xPosition, double yPosition) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> tapObject = new HashMap<String, Double>();
		tapObject.put("startX", xPosition);
		tapObject.put("startY", yPosition);
		js.executeScript("mobile: tap", tapObject);
	}

	/**
	 * method to click on Element By Name
	 *
	 * @param element - String element name to be clicked
	 * @param type - type of locator id, name, xpath
	 */

	public void click(String element,String type) {
		if(type.toLowerCase().equals("name")) {
			((AppiumDriver) driver).findElementByName(element).click();
		}else if(type.toLowerCase().equals("xpath")) {
			((AppiumDriver) driver).findElementByXPath(element).click();
		}else if(type.toLowerCase().equals("id")) {
			((AppiumDriver) driver).findElementById(element).click();
		}
		
	}

	/**
	 * method to type on Element By Name
	 *
	 * @param elementByName - String element name to be clicked
	 * @param type - type of locator id, name, xpath
	 * @param value - String value to be typed
	 */

	public void sendKeys(String element,String type, String value) {
		if(type.toLowerCase().equals("name")) {
			((AppiumDriver) driver).findElementByName(element).sendKeys(value);
		}else if(type.toLowerCase().equals("xpath")) {
			((AppiumDriver) driver).findElementByXPath(element).sendKeys(value);
		}else if(type.toLowerCase().equals("id")) {
			((AppiumDriver) driver).findElementById(element).sendKeys(value);
		}
	}
	
	/**
	 * method to return textarea of element
	 *
	 * @param elementByName - String element name to be clicked
	 * @param type - type of locator id, name, xpath
	 * @param value - String value to be typed
	 */

	public String getText(String element,String type) {
		String textValue = "";
		if(type.toLowerCase().equals("name")) {
			textValue = ((AppiumDriver) driver).findElementByName(element).getText();
		}else if(type.toLowerCase().equals("xpath")) {
			textValue = ((AppiumDriver) driver).findElementByXPath(element).getText();
		}else if(type.toLowerCase().equals("id")) {
			textValue = ((AppiumDriver) driver).findElementById(element).getText();
		}
		return textValue ;
	}
	/**
	 * method to scroll down on screen from java-client 6
	 *
	 * @param swipeTimes       number of times swipe operation should work
	 * @param durationForSwipe time duration of a swipe operation
	 */
	public void scrollDown(int swipeTimes, int durationForSwipe) {
		Dimension dimension = driver.manage().window().getSize();

		for (int i = 0; i <= swipeTimes; i++) {
			int start = (int) (dimension.getHeight() * 0.5);
			int end = (int) (dimension.getHeight() * 0.3);
			int x = (int) (dimension.getWidth() * .5);

			new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe))).release().perform();
		}
	}

	/**
	 * method to scroll up on screen from java-client 6
	 *
	 * @param swipeTimes       number of times swipe operation should work
	 * @param durationForSwipe time duration of a swipe operation
	 */
	public void scrollUp(int swipeTimes, int durationForSwipe) {
		Dimension dimension = driver.manage().window().getSize();

		for (int i = 0; i <= swipeTimes; i++) {
			int start = (int) (dimension.getHeight() * 0.3);
			int end = (int) (dimension.getHeight() * 0.5);
			int x = (int) (dimension.getWidth() * .5);

			new TouchAction((AppiumDriver) driver).press(PointOption.point(x, start)).moveTo(PointOption.point(x, end))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(durationForSwipe))).release().perform();
		}
	}

}
