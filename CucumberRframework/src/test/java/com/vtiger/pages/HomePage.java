package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.commonMethods;

public class HomePage {
	
	public WebDriver driver;
	public commonMethods cm;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new commonMethods(driver);
	}
	

	@FindBy(xpath="//a[text()='Logout']")
	WebElement lnkLogout;
	
	@FindBy(xpath="//a[text()='New Product']")
	WebElement lnkNewProduct;
	
	public void verifyLogout()
	{
		cm.elementExist(lnkLogout, "Logout is dipslayed");
	}
	
	public void clickLogout()
	{
		cm.clickElement(lnkLogout, "Logout link clicked");
	}
	
	public void clickNewProduct()
	{
		cm.clickElement(lnkNewProduct, "New Product link clicked");
	}

}
