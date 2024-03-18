package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.HomePage;
import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.LoginPage;
import com.MyStore.base.BaseClass;

public class HomePageTest extends BaseClass {
	HomePage homePage;
	IndexPage indexPage;
	LoginPage loginPage;

	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Smoke","Sanity"})
	public void setUp(String browser) {

		lunchApp(browser);

	}

	@AfterMethod(groups= {"Regression","Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Smoke")
	public void verifyOrderHistory() {
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignIn();
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		boolean actrderListTesxt = homePage.validateOrderHistory();
		Assert.assertTrue(actrderListTesxt);

	}
}
