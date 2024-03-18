package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class PaymentPage extends BaseClass {

	Action action= new Action();
	public PaymentPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Pay by bank wire')]")
	private WebElement payByBankWireMethod;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public OrderSummaryPage clickOnPayByBankWire()
	{
		action.click(getDriver(), payByBankWireMethod);
		return new OrderSummaryPage();
	}
	
	public void clickOnPayByCheck()
	{
		action.click(getDriver(), payByCheckMethod);
	}
	
	
}
