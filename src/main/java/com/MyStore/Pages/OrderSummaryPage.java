package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class OrderSummaryPage extends BaseClass{

	Action action= new Action();
	
	public OrderSummaryPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//button[@type='submit']/child::span[text()='I confirm my order']")
	private WebElement confirmOrderBtn;
	
	
	
	public OrderConfirmationPage clickOnConfirmOrder()
	{
		action.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
	
}
