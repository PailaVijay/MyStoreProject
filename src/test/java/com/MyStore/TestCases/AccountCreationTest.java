package com.MyStore.TestCases;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.AccountCreationPage;
import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.LoginPage;
import com.MyStore.base.BaseClass;

public class AccountCreationTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Smoke","Sanity"})
	public void setUp(String browser) {

		lunchApp(browser);

	}

	@AfterMethod(groups= {"Regression","Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}

	 @Test(groups="Sanity")
	public void createAccount() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();

		String randomName = RandomStringUtils.randomAlphabetic(5);
		String domain = "gmail.com";

		accountCreationPage = loginPage.createNewAccount(randomName + "@" + domain);

	}

	@Test
	public void enterPersonalInformatio() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();

		String randomName = RandomStringUtils.randomAlphabetic(5);
		String domain = "gmail.com";
		accountCreationPage = loginPage.createNewAccount(randomName + "@" + domain);
		boolean actAccountcreated = accountCreationPage.validateAccountCreatedSuccessfully();
		accountCreationPage.getGenderTitle();
		accountCreationPage.registrationWithValue(randomName, randomName, randomName);
		accountCreationPage.enterDateOfBirth("15", "05", "2000");

	}

}
