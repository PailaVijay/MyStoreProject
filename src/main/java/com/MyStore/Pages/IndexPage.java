package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;

import com.MyStore.base.BaseClass;

public class IndexPage extends BaseClass {
	Action action = new Action();

	public IndexPage() {

		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//a[@class='login']")
	private WebElement singInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;

	@FindBy(xpath = "//input[@id='search_query_top']")
	private WebElement searchFiled;

	@FindBy(xpath = "//button[@name='submit_search']")
	private WebElement searchBtn;

	public LoginPage clickOnSignIn() {
		action.click(getDriver(), singInBtn);
		return new LoginPage();
	}

	public boolean validateLogo() {
		return action.isDisplayed(getDriver(), myStoreLogo);
	}

	public String getMyStoreTitle() {
		String myStoreTitle = getDriver().getTitle();
		return myStoreTitle;
	}

	public SearchResultPage searchProduct(String productName) {
		action.type(searchFiled, productName);
		action.click(getDriver(), searchBtn);
		return new SearchResultPage();
	}
}
