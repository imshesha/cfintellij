package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.commonMethods;

public class orders {


		public WebDriver driver;
		public commonMethods cm;
		
		
		public orders(WebDriver driver)
		{
			this.driver = driver;		
			PageFactory.initElements(driver, this);
			cm = new commonMethods(driver);
		}
		
		@FindBy(xpath="//*[text()='Sales Order:  order1']")
		WebElement ordercheck;
		
		@FindBy(xpath="//input[@name='subject']")
		WebElement subject;
		
		@FindBy(xpath="//a[text()='vtiger']")
		WebElement accname;
		
		@FindBy(xpath="//*[@name='bill_street']")
		WebElement billaddress;
		
		
		
		@FindBy(xpath="//*[@name='ship_street']")
		WebElement shipaddress;
		
		@FindBy(xpath="//input[@name='button']")
		WebElement savebutton;
		
		
		
		@FindBy(xpath="//a[text()='Vtiger 5 Users Pack']")
		WebElement product;
		
		@FindBy(xpath="//*[@name='txtQty1']")
		WebElement qty;
		
		@FindBy(xpath="//*[@value='Add Product']")
		WebElement addproductbtn;
		
		@FindBy(xpath="//*[@name='btn1']")
		WebElement change;
		
		@FindBy(xpath="//*[@src='themes/blue/images/search.gif']")
		WebElement productsearchicon;
			
		@FindBy(xpath="//*[text()='New Sales Order']")
		WebElement newsale;
			
		@FindBy(xpath="//a[@id='showSubMenu']")
				WebElement mousemove;
				
		public void entersubject(String subjectname)
		{
			cm.enterValue(subject,subjectname,"subject is successfully entered");
			
		}
		public void selectaccountname() throws InterruptedException
		{
			cm.clickElement(change, "click on change");
			Thread.sleep(5000);
			cm.switchtosecondwindow("switch on second window");
			cm.clickElement(accname,"click on account name of second window");
			
		}
		public void switchbaseWindow()
		{
			cm.switchtofirstwindow("switch on first window");
			//driver.switchTo().defaultContent();
		}
		public void enterbillingaddress(String value)
		{
			System.out.println(value);
			cm.enterValue(billaddress, value, "billing address success fully enter");
		}
		public void entershippingaddress(String value)
		{
			cm.enterValue(shipaddress, value, "shipaddress success fully enter");
		}
	
		public void enterproduct()
		{
			cm.clickElement( productsearchicon, "click on searchicon");
			
			cm.switchtosecondwindow("product is selected");
			
			cm.clickElement(product,"product is selected on second window");
			
		}
		public void enterqty(String value)
		{
			cm.enterValue(qty,value,"quantity enter successfully");
		}
		public void clickonaddproduct()
		{
			cm.clickElement(addproductbtn,"click on addproduct");
		}
		
		public void clickonshowsubmenu()
		{
			cm.MouseMove(mousemove, "mouse hover done");
		}
		public void clickonnewsalesorder()
		{
			cm.MouseClick(newsale,"succesfully click on element");
		}
		
		public void clickonsave()
		{
			cm.clickElement(savebutton, "click on save");
		}
		
		public void checkorder()
		{
			cm.elementExist(ordercheck,"element is present");
		}
		
	}



