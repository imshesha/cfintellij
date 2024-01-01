package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Vtiger.Comman.comman_methods;

public class HomePage
{
	WebDriver driver;
	public comman_methods cm;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		cm=new comman_methods(driver);
		
}
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutlnk;
	
	
	public void verifyLogout()
	{
		cm.elementDisplay(logoutlnk, "logout is display");
	}
	
	public void clicklogout()
	{
		cm.clickElements(logoutlnk, "click on logout");
	}

}
