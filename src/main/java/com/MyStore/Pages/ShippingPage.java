package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class ShippingPage extends BaseClass{
	
	Action action= new Action();
	public ShippingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='cgv']")
	private WebElement checkBoxTermAndServices;
	
	@FindBy(xpath="//button//span[normalize-space()='Proceed to checkout']")
	private WebElement proceedToChekOut;
	
	public void clickOnCheckBox()
	{
		action.click(getDriver(), checkBoxTermAndServices);
	}

	public PaymentPage clickProceedToCheckOut()
	{
		action.click(getDriver(), proceedToChekOut);
		return new PaymentPage();
	}
}
