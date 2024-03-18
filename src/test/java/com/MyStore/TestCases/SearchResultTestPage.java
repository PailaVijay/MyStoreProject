package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.SearchResultPage;
import com.MyStore.base.BaseClass;

public class SearchResultTestPage extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	
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
	public void productAvialabilityTest()
	{
		indexPage= new IndexPage();
		searchResultPage=indexPage.searchProduct("t-Shirt");
		boolean actResult=searchResultPage.isProductAvailable();
		Assert.assertTrue(actResult);
			
	}
}

