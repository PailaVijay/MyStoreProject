package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.IndexPage;
import com.MyStore.base.BaseClass;

public class IndexPageTest extends BaseClass {
	// public WebDriver driver;
	
	IndexPage indexpage;
	
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
	public void verifyLogo() {
		indexpage = new IndexPage();
		boolean result= indexpage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle()
	{
		String actMyStoreTitle=indexpage.getMyStoreTitle();
		Assert.assertEquals(actMyStoreTitle, "My Shop");
	}
	

	
}
