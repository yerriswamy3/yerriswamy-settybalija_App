package com.n26.monefy.automation.pageobjects;

import org.openqa.selenium.WebDriver;

public class NewIncomeOrExpensePage extends BasePage {

	public NewIncomeOrExpensePage(WebDriver driver) {
		super(driver);
	}

	String dateTxtElement = "com.monefy.app.lite:id/textViewDate";
	String amountTxtElement = "com.monefy.app.lite:id/amount_text";
	String chooseCategoryTxtElement = "com.monefy.app.lite:id/textViewChooseCategory";
	
	
	public String getDate() {

		String date = getText(dateTxtElement, ID);
		System.out.println(date);
		return date;
	}

	public String getCurrentAmount() {
		String amount = getText(amountTxtElement, ID);
		System.out.println(amount);
		return amount;
	}

	public void enterAmount(String value) {
		char[] ch = value.toCharArray();
		
		for (char c : ch) {
			String id = "com.monefy.app.lite:id/buttonKeyboard"+c;
			click(id, ID);
		}
		
	}
	
	public void clickChooseCategory() {
		click(chooseCategoryTxtElement, ID);
	}
	
	/**
	 * 
	 * @param category for income -  Deposits, Salary, Savings and categories for expense examples are listed few : Bills,Car, Clothes, Food
	 */
	public void selectCategory(String category) {
		String categoryEle = "//*[@resource-id='com.monefy.app.lite:id/textCategoryName' and @text='"+category+"']";
		click(categoryEle, XPATH);
	}

}
