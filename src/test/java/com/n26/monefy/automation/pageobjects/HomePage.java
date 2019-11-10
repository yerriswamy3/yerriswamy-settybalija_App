package com.n26.monefy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	String income = "//*[@resource-id='com.monefy.app.lite:id/income_button_title']";
	String expenseId = "com.monefy.app.lite:id/expense_button_title";
	String isMainCurrencyCanBeChangedHereLabelElement = "//*[@text='Main currency can be changed here']";
	String balanceAmountTxt = "com.monefy.app.lite:id/balance_amount";
	String settingsElement = "//android.widget.TextView[@content-desc='Settings']";
	String settingsViewElement = "com.monefy.app.lite:id/settings_textview";
	
	public void clickIncomeButton() {
		click(income, XPATH);
	}

	public boolean isMainCurrencyCanBeChangedHereLabelExists() {
		return isElementPresent(By.xpath(isMainCurrencyCanBeChangedHereLabelElement));
	}

	public String currentBalance() {
		sleep(3);
		String currentBalance = getText(balanceAmountTxt, ID);
		System.out.println(currentBalance);
		return currentBalance;
	}
	
	public void clickExpenseButton() {
		click(expenseId,ID);
	}
	
	public void clickSettings() {
		click(settingsElement, XPATH);
	}
	
	public void clickSettingsView() {
		click(settingsViewElement, ID);
	}

}
