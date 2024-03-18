package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.AddToCartPage;
import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.OrderPage;
import com.MyStore.Pages.SearchResultPage;
import com.MyStore.base.BaseClass;

public class OrderPageTest extends BaseClass {
	IndexPage indexPage;
	SearchResultPage searchResultPAge;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Smoke","Sanity"})
	public void setUp(String browser) {

		lunchApp(browser);

	}

	@AfterMethod(groups= {"Regression","Smoke","Sanity"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups="Regression")
	public void verifyTotalPrice()
	{
		indexPage= new IndexPage();
		searchResultPAge=indexPage.searchProduct("t-Shirt");
		addToCartPage = searchResultPAge.clickOnProduct();
		addToCartPage.selectProductSize("L");
		addToCartPage.enterProductQty("2");
		addToCartPage.selectColor();
		addToCartPage.clickAddToCart();
		addToCartPage.clickOnPrceedToCheck();
		orderPage= new OrderPage();
		double unitPrice=orderPage.getUnitPrice();
		double totalPrice = orderPage.getTotalPrice();
		double totalExpPrice=(unitPrice*2)+7;
		Assert.assertEquals(totalExpPrice, totalPrice);
		
	}

}
