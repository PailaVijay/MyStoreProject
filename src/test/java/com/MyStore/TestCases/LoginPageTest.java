package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.HomePage;
import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.LoginPage;
import com.MyStore.Utility.Log;
import com.MyStore.base.BaseClass;

public class LoginPageTest extends BaseClass {

	IndexPage indexpage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Smoke","Sanity"})
	public void setUp(String browser) {

		lunchApp(browser);

	}

	@AfterMethod(groups= {"Regression","Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups={"Smoke","Sanity"})
	public void loginTest() {
		Log.startTestCase("loginTest");
		indexpage = new IndexPage();
		Log.info("user is going to click on signin");
		loginPage = indexpage.clickOnSignIn();
		Log.info("Enter username and password");
		homePage = loginPage.login(prop.getProperty("userName"), prop.getProperty("password"));
		String actUrl = homePage.getCurrentURL();
		String expUrl = "http://www.automationpractice.pl/index.php?controller=my-account";
		Log.info("verifying if user is able to login");
		Assert.assertEquals(actUrl, expUrl);
		Log.info("login success");
		Log.endTestCase("loginTest");
	}
}
