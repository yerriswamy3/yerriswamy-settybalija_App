package com.n26.monefy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage{

	public SettingsPage(WebDriver driver) {
		super(driver);
	}

	String darkThemeId = "com.monefy.app.lite:id/is_night_mode_enabled_checkbox";
	public void clickDarkTheme() {
		click(darkThemeId, ID);
	}
	
	
	public boolean isSettingsPage() {
		return isElementPresent(By.id("com.monefy.app.lite:id/settings_imagebutton"));
	}
	
	public void selectDropbox() {
		click("com.monefy.app.lite:id/is_dropbox_synchronization_enabled_checkbox",ID);
	}
}
