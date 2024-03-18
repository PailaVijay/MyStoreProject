package com.MyStore.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyStore.actionDrivers.Action;
import com.MyStore.base.BaseClass;

public class OrderPage extends BaseClass {
    Action action= new Action();
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//td/ul/li[@class='price']")
	private WebElement unitPrice;

	@FindBy(xpath = "//td/span[@id='total_price']")
	private WebElement totalPrice;

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;

	public double getUnitPrice() {
       // action.expliciWait(getDriver(), unitPrice, 10);
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
        return finalUnitPrice;
	}

	public double getTotalPrice() {
        
		String totalPrice1 = totalPrice.getText();
		String total = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(total);
        return finalTotalPrice;
	}
	
	public LoginPage clickOnPrceedToCheckOut()
	{
		action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}
}
