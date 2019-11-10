package com.n26.monefy.automation.runners;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.n26.monefy.automation.pageobjects.HomePage;
import com.n26.monefy.automation.pageobjects.NewIncomeOrExpensePage;
import com.n26.monefy.automation.pageobjects.ProPage;
import com.n26.monefy.automation.pageobjects.SettingsPage;

public class TestFeatures extends AppiumBase{

	
	@Test
	public void verifyBalanceCalculations() {
		
		HomePage homePage = new HomePage(driver);
		String initialBalance = homePage.currentBalance();
		System.out.println(initialBalance);
		homePage.clickIncomeButton();
		NewIncomeOrExpensePage newIncomeOrExpensePage = new NewIncomeOrExpensePage(driver);
		newIncomeOrExpensePage.enterAmount("200");
		newIncomeOrExpensePage.clickChooseCategory();
		newIncomeOrExpensePage.selectCategory("Deposits");
		
		
		String balanceWithIncome = homePage.currentBalance();
		System.out.println(balanceWithIncome);
		homePage.clickExpenseButton();
		newIncomeOrExpensePage.enterAmount("20");
		newIncomeOrExpensePage.clickChooseCategory();
		newIncomeOrExpensePage.selectCategory("Car");
		String balanceWithAddedExpense = homePage.currentBalance();
		System.out.println(balanceWithAddedExpense);
		
		System.out.println("Expected balance : 180" );
	}
	
	@Test
	public void addExpenseFromHomePage() {
		
		HomePage homePage = new HomePage(driver);
		String initialBalance = homePage.currentBalance();
		System.out.println(initialBalance);
		homePage.clickIncomeButton();
		NewIncomeOrExpensePage newIncomeOrExpensePage = new NewIncomeOrExpensePage(driver);
		newIncomeOrExpensePage.enterAmount("150");
		newIncomeOrExpensePage.clickChooseCategory();
		newIncomeOrExpensePage.selectCategory("Deposits");
		
		
		String balanceWithIncome = homePage.currentBalance();
		System.out.println(balanceWithIncome);
		homePage.clickExpenseButton();
		newIncomeOrExpensePage.enterAmount("23");
		newIncomeOrExpensePage.clickChooseCategory();
		newIncomeOrExpensePage.selectCategory("Home");
		String balanceWithAddedExpense = homePage.currentBalance();
		System.out.println(balanceWithAddedExpense);
		
		System.out.println("Expected balance : 180" );
	}
	
	
	@Test
	public void changeToDarkTheme() {
		HomePage homePage = new HomePage(driver);
		homePage.clickSettings();
		homePage.clickSettingsView();
		
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.clickDarkTheme();
		
		ProPage proPage = new ProPage(driver);
		Assert.assertTrue(proPage.isProPage());
		proPage.backToSettingsPage();
	}
	
	
	@Test
	public void checkSynchronization() {
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.selectDropbox();
		ProPage proPage = new ProPage(driver);
		proPage.backToSettingsPage();
	}
}
