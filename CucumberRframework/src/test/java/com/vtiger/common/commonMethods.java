package com.vtiger.common;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.Stepdefination.BaseTest;

public class commonMethods {
	
	private WebDriver driver;
	public WebDriverWait  wait;
	
	public commonMethods(WebDriver driver)
	{
		this.driver = driver;
	//	wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,30);
	}
	
	//FUnctiona Name : 
	// Description:
	//created by:
	//created date:
	//Modified by:
	//Modified date: 
	
	public void enterValue(WebElement elm, String value, String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));	
		elm.clear();
		elm.sendKeys(value);
		System.out.println(msg);
		BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			BaseTest.logger.fail("value did not enter into field due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
			System.out.println("value did not enter into field due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public void clickElement(WebElement elm, String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));			
		elm.click();
		//com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
		//	com.vtiger.Stepdefination.BaseTest.logger.fail("Element did not click due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public void MouseClick(WebElement elm, String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));			
		Actions act = new Actions(driver);
		act.click(elm).perform();
		com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("Element did not click due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public void MouseMove(WebElement elm, String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeClickable(elm));			
		Actions act = new Actions(driver);
		act.moveToElement(elm).perform();
		com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("Element did not click due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public void selectDropdownText(WebElement elm, String text, String msg)
	{
		try
		{
		//wait.until(ExpectedConditions.elementToBeSelected(elm));	
		Select sel = new Select(elm);
		sel.selectByVisibleText(text);
		System.out.println("potentials selected");
		com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("value did not select due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public void selectDropdownValue(WebElement elm, String value, String msg)
	{
		try
		{
		wait.until(ExpectedConditions.elementToBeSelected(elm));	
		Select sel = new Select(elm);
		sel.selectByValue(value);
		com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("value did not select due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public boolean elementExist(WebElement elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(elm));			
		elm.isDisplayed();
		com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("Element did not visible due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		return false;
	}
	
	
	public void FileUploadRobot(String filepath,String msg)
	{
		try
		{
			
			 String file = filepath;
		        StringSelection stringSelection = new StringSelection(file);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("Element did not visible due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public void elementExist(String elm,String msg)
	{
		try
		{
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(elm))));			
		driver.findElement(By.xpath(elm)).isDisplayed();
		com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("Element did not visible due to exception "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
	
	public String getScreenshot() 
	{
		Date d = new Date();
		//DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		 SimpleDateFormat ft = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");		
		 String fileName = ft.format(d);
		String path = System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/screenshot/"+fileName+".png";
		TakesScreenshot ts = ((TakesScreenshot)driver);
		
		File SrcFile=ts.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File DestFile=new File(path);
		//Copy file at destination
		/*
		 * try { FileUtils.copyFile(SrcFile, DestFile); } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */
		return path;
	}
	
	public void switchtofirstwindow(String msg)
	{
		try
		{
		
		Set<String> set = driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        String firstWindow = itr.next();
        driver.switchTo().window(firstWindow);
        com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("window did not switch to first window due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}}
		
		public void switchtosecondwindow( String msg)
		{
			try
			{
			
			Set<String> set = driver.getWindowHandles();
	        Iterator<String> itr = set.iterator();
	        String firstWindow = itr.next();
	        String secondWindow = itr.next();
	        driver.switchTo().window(secondWindow);
	        com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
			}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("window did not switch to second window due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
		
		public void AcceptAlertHanle(String msg)
		{
			try
			{
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
		
	        com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
			}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("window did not switch to second window due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
		
		public void CancelAlertHanle(String msg)
		{
			try
			{
			
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
	        com.vtiger.Stepdefination.BaseTest.logger.pass(msg+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
			}
		catch(Exception e)
		{
			com.vtiger.Stepdefination.BaseTest.logger.fail("window did not switch to second window due to "+e.getMessage()+"<span class='label end-time'><a href='"+getScreenshot() +"'>Screenshot</a></span>");
		}
	}
}
