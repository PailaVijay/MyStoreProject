package com.MyStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.MyStore.Pages.AddToCartPage;
import com.MyStore.Pages.AddressPage;
import com.MyStore.Pages.IndexPage;
import com.MyStore.Pages.LoginPage;
import com.MyStore.Pages.OrderConfirmationPage;
import com.MyStore.Pages.OrderPage;
import com.MyStore.Pages.OrderSummaryPage;
import com.MyStore.Pages.PaymentPage;
import com.MyStore.Pages.SearchResultPage;
import com.MyStore.Pages.ShippingPage;
import com.MyStore.base.BaseClass;

public class EndToEndTest extends BaseClass{
	IndexPage indexPage;
	SearchResultPage searchResultPAge;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	LoginPage loginPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	
	OrderConfirmationPage orderConfirmationPage;
	
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
public void endToEndTest()
{
	indexPage= new IndexPage();
	searchResultPAge=indexPage.searchProduct("t-Shirt");
	addToCartPage = searchResultPAge.clickOnProduct();
	addToCartPage.selectProductSize("M");
	addToCartPage.enterProductQty("2");
	addToCartPage.selectColor();
	addToCartPage.clickAddToCart();
	addToCartPage.clickOnPrceedToCheck();
	orderPage= new OrderPage();
	orderPage.clickOnPrceedToCheckOut();
	loginPage=new LoginPage();
	loginPage.login1(prop.getProperty("userName"), prop.getProperty("password"));
	addressPage= new AddressPage();
	ShippingPage shippingPage = addressPage.clickOnCheckOut();
	shippingPage.clickOnCheckBox();
	paymentPage = shippingPage.clickProceedToCheckOut();
    orderSummaryPage = paymentPage.clickOnPayByBankWire();
    orderSummaryPage.clickOnConfirmOrder();
    orderConfirmationPage=new OrderConfirmationPage();
    String actOrderConfirmMsge=orderConfirmationPage.getOrderSuccessMsge();
    String expOrderConfirmMsge="Your order on My Shop is complete.";
    Assert.assertEquals(actOrderConfirmMsge, expOrderConfirmMsge);
	
	
	
}
}
