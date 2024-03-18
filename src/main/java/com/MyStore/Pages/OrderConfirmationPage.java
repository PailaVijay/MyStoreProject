package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass{

	Action action= new Action();
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement orderSuccessMsge;
	
	public String getOrderSuccessMsge()
	{
		String confirmMsge=orderSuccessMsge.getText();
		return confirmMsge;
	}
}
