package com.Vtiger.Comman;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class comman_methods 
{
			 public WebDriver driver;
			public WebDriverWait wait;
			 
			 public comman_methods(WebDriver driver)
			 {
				 this.driver=driver;
				 wait=new WebDriverWait(driver,Duration.ofSeconds(30));
				 
			 }
			 
			 public void enterValue(WebElement elm,String msg,String value)
			 {
				 
				 try
				 {
				 wait.until(ExpectedConditions.visibilityOf(elm));
				
				 elm.clear();
				 elm.sendKeys(value);
				 System.out.println(msg);
				 }
				 catch(Exception e)
				 {
					System.out.println("value did not enter due to exception"+e.getMessage());
				 }
			 }
			 public void clickElements(WebElement elm,String msg)
			 {
				 try
				 {
					 wait.until(ExpectedConditions.elementToBeClickable(elm));
					 elm.click();
					 System.out.println(msg);
				 }
					 catch(Exception e)
					 {
						System.out.println("element is not clickable due to exception"+e.getMessage()); 
					 }
			 }

			public void elementDisplay(WebElement elm,String msg)
			{
				try
				{
					wait.until(ExpectedConditions.visibilityOf(elm));
					elm.isDisplayed();
					System.out.println(msg);
				}
				catch(Exception e)
				{
					System.out.println("element is not find due to exception"+e.getMessage());
			}
			}
			
			public void elementDisplay(String elm,String msg)
			{
				try
				{
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));
					driver.findElement(By.xpath(elm)).isDisplayed();
					System.out.println(msg);
				}
				catch(Exception e)
				{
					System.out.println("element is not find due to exception"+e.getMessage());
			}
			}
			
					public void selectDropDownvalue(WebElement elm,String value,String msg) 
					{
						try
						{
							wait.until(ExpectedConditions.elementToBeSelected(elm));
							Select dp=new Select(elm);
							dp.selectByValue(value);
							System.out.println("dropdownvalue is selected");
						}
							catch(Exception e)
							{
								System.out.println("dropdownvalue does not selected due to"+e.getMessage());
								
							}
						
						
					}
					public void selectDropDownbyIndex(WebElement elm,int value,String msg) 
					{
						try
						{
							wait.until(ExpectedConditions.elementToBeSelected(elm));
							Select dp=new Select(elm);
							dp.selectByIndex(value);
							System.out.println("dropdownvalue is selected");
						}
							catch(Exception e)
							{
								System.out.println("dropdownvalue does not selected due to"+e.getMessage());
								
							}
						}
					public void selectDropDownbyText(WebElement elm,String Text,String msg)
					{
						try
						{
							wait.until(ExpectedConditions.elementToBeSelected(elm));
							Select dp=new Select(elm);
							dp.selectByVisibleText(Text);
						}
						catch(Exception e)
						{
						System.out.println("dropdown is not selected by text due to exception"+e.getMessage());
						}
						
					}
					}
				 
			 

