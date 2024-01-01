/**
 * 
 */
package com.Vtiger.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.Comman.comman_methods;

/**
 * 
 */
public class LoginPage
{
	public WebDriver driver;
	
	public comman_methods cm;
	
	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		cm=new comman_methods(driver);
	}
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(xpath="//input[@name='user_password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='Login']")
	WebElement elm_login;
	
	String logo="//img[@src='include/images/vtiger-crm.gif']";
	String errormsg="//*[contains(text(),'You must specify a valid username and password.')] ";
	
	//String tb_usernmae ="//input[@name='user_name']";
	//By tb_pass =By.xpath("//input[@name='user_password']")
			
	 
public void login(String userid,String pwd)
{
	cm.enterValue(username,"value is enter",userid);
	cm.enterValue(password,"password is enter",pwd );
	cm.clickElements(elm_login,"click on login button" );
}

public void verifyLogo()
{
	cm.elementDisplay(logo, "logo is display");
}

public void verifyerrorMes()
{
	cm.elementDisplay(errormsg,"error message is display");
}

}
