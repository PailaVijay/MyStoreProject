package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	Action action= new Action();
	public SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy(xpath="//div[@class='right-block']//child::a[normalize-space()='Faded Short Sleeve T-shirts']")
	private WebElement productResult;
	
	public boolean isProductAvailable()
	{
		return action.isDisplayed(getDriver(), productResult);
	}
	public AddToCartPage clickOnProduct()
	{
		action.click(getDriver(), productResult);
		return new AddToCartPage();
	}
}
