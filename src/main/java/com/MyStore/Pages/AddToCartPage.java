package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class AddToCartPage extends BaseClass{

	Action action= new Action();
	
	public AddToCartPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	
	
	@FindBy(xpath="//p[@class='our_price_display']")
	private WebElement productPrice;
	
	@FindBy(xpath="//select[@id='group_1']")
	private WebElement productSize;
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	private WebElement productQty;
	
	@FindBy(xpath="//a[@name='Blue']")
	private WebElement productColor;
	
	@FindBy(xpath="//button[@name='Submit']/span[text()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	private WebElement addToCartSuccessMsge;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	private WebElement proceedToCheckutBtn;
	
	public boolean validateProductPrice()
	{
		return action.isDisplayed(getDriver(), productPrice);
	}
	
	public void selectProductSize(String size1)
	{
		action.selectByVisibleText(size1, productSize);
	}
	
	public void enterProductQty(String qty)
	{
		action.type(productQty, qty);
	}
	
	public void selectColor()
	{
		action.click(getDriver(), productColor);
	}
	
	public void clickAddToCart()
	{
		action.click(getDriver(), addToCart);
	}
	
	public boolean addTocartSuccessfullMsge()
	{
		action.expliciWait(getDriver(), addToCartSuccessMsge, 10);
		return action.isDisplayed(getDriver(), addToCartSuccessMsge);
	}
	
	public OrderPage clickOnPrceedToCheck()
	{
		action.expliciWait(getDriver(), proceedToCheckutBtn, 10);
		action.JSClick(getDriver(), proceedToCheckutBtn);
		return new OrderPage();
	}
	
	
}
