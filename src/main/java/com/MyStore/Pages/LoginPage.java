package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class LoginPage extends BaseClass{

	Action action= new Action();
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement emailAddress;
	
	@FindBy(xpath="//input[@id='passwd']")
	private WebElement password;
	
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	private WebElement signInIcon;
	
	@FindBy(xpath="//input[@id='email_create']")
	private WebElement emailCreation;
	
	@FindBy(xpath="//span[normalize-space()='Create an account']")
	private WebElement createAnAccountBtn;
	
	public HomePage login(String userName,String pswd)
	{
		action.type(emailAddress, userName);
		action.type(password, pswd);
		action.click(getDriver(), signInIcon);
		return new HomePage();
	}
	public AddressPage login1(String userName,String pswd)
	{
		action.type(emailAddress, userName);
		action.type(password, pswd);
		action.click(getDriver(), signInIcon);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail)
	{
		action.type(emailCreation, newEmail);
		action.click(getDriver(), createAnAccountBtn);
		return new AccountCreationPage();
	}
}
