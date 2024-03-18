/**
 * 
 */
package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

/**
 * 
 */
public class HomePage extends BaseClass{
 Action action= new Action();
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//i[@class='icon-list-ol']//following-sibling::span")
	private WebElement orderHistory;
	
	public boolean validateOrderHistory()
	{
		return action.isDisplayed(getDriver(), orderHistory);
		
	}
	
	public String getCurrentURL()
	{
		String homePageUrl=getDriver().getCurrentUrl();
		return homePageUrl;
		
	}
}
