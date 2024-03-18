package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class AddressPage extends BaseClass{

	Action action= new Action();
	public AddressPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//button[@name='processAddress']//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckout;
	
	public ShippingPage clickOnCheckOut()
	{
		action.click(getDriver(), proceedToCheckout);
		return new ShippingPage();
	}
	
}
