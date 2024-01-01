package com.vtiger.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.commonMethods;

public class ProductPage {
	
	public WebDriver driver;
	public commonMethods cm;
	
	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new commonMethods(driver);
	}
	
	@FindBy(xpath="//input[@name='productname']")
	WebElement productname;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement browsebutton;
	
	@FindBy(xpath="//input[@name='button']")
	List<WebElement> savebutton;
	
	public void createproduct(String pname, String filepath)
	{
		cm.enterValue(productname, pname, "Product Name entered successfully");		
		cm.MouseClick(browsebutton, "Browse button clicked");
		cm.FileUploadRobot(filepath, "File uploaded successfully");
		cm.clickElement(savebutton.get(2), "Save button clicked");
	}

}
