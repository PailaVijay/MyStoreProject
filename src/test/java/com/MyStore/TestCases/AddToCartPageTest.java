package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.AddToCartPage;
import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.SearchResultPage;
import com.MyStore.base.BaseClass;

public class AddToCartPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPAge;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Smoke","Sanity"})
	public void setUp(String browser) {

		lunchApp(browser);

	}

	@AfterMethod(groups= {"Regression","Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups={"Regression","Sanity"})
	public void addToCartTest()
	{
		indexPage= new IndexPage();
		searchResultPAge=indexPage.searchProduct("t-Shirt");
		addToCartPage = searchResultPAge.clickOnProduct();
		addToCartPage.selectProductSize("M");
		addToCartPage.enterProductQty("2");
		addToCartPage.selectColor();
		addToCartPage.clickAddToCart();
		boolean actAddPrdSucc=addToCartPage.addTocartSuccessfullMsge();
		Assert.assertTrue(actAddPrdSucc);
		addToCartPage.clickOnPrceedToCheck();
		
	}
	
}
