package com.n26.monefy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProPage  extends BasePage{

	public ProPage(WebDriver driver) {
		super(driver);
	}

	String proTitle = "com.monefy.app.lite:id/monefyProTitle";
	public boolean isProPage() {
		return isElementPresent(By.id(proTitle));
	}
	
	public void backToSettingsPage() {
		back();
	}
}
