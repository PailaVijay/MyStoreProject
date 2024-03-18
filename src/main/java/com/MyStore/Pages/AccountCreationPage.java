package com.MyStore.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class AccountCreationPage extends BaseClass{

	Action action = new Action();
	public AccountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//h1[@class='page-heading' or text()='Create an account']")
	private WebElement createAnAccount;
	
	@FindBy(xpath="//div[@class='clearfix']//child::input")
	private List<WebElement> titleOfGender;
	
	@FindBy(id="customer_firstname")
	private WebElement firstName;
	
	@FindBy(id="customer_lastname")
	private WebElement lastName;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	private WebElement date;
	
	@FindBy(xpath="//select[@id='months']")
	private WebElement month;
	
	@FindBy(xpath="//select[@id='years']")
	private WebElement year;
	
	@FindBy(xpath="//span[text()='Register']")
	private WebElement registerBtn;
	
	
	
	public boolean validateAccountCreatedSuccessfully()
	{
		return action.isDisplayed(getDriver(), createAnAccount);
	}
	
	public void getGenderTitle()
	{
		//titleOfGender.get(0).click();
		for(WebElement  gender:titleOfGender )
		{
			if(gender.getText().contains("Mr."))
			{
				action.click(getDriver(), gender);
			}
		}
	}
	
	public void registrationWithValue(String fName,String lName,String pswd)
	{
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.type(password, pswd);
	}
	
	public void enterDateOfBirth(String d,String m,String y)
	{
		action.selectByValue(month, d); 
		action.selectByValue(createAnAccount, m);
		action.selectByValue(createAnAccount, y);
	}
	public void clickOnRegister()
	{
		action.click(getDriver(), registerBtn);
	}
	
}
