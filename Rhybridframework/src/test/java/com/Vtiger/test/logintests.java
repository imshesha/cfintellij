package com.Vtiger.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

public class logintests extends  base_test {
	

	
	@Test(priority=1)
	public void verifylogin_TC01()
	{
		String TCname = "verifylogin_TC01";
		logger = extent.createTest(TCname);
		
		LoginPage lp = new LoginPage(driver);
		lp.login(dt.get(TCname).get("Userid"), dt.get(TCname).get("Password"));
		HomePage hp = new HomePage(driver);
		hp.verifyLogout();
		hp.clickLogout();
		extent.flush();
	}
	
	@Test(priority=2)
	public void verifyInValidlogin_TC02()
	{
		String TCname = "verifyInValidlogin_TC02";
		logger = extent.createTest(TCname);
		LoginPage lp = new LoginPage(driver);
		lp.login("admin1", "admin123");		
		lp.verifyErrorMsg();
		extent.flush();
	}
	
	@Test(priority=3)
	public void verifyLogoonLoginScreen_TC03()
	{
		String TCname = "verifyLogoonLoginScreen_TC03";
		logger = extent.createTest(TCname);
		LoginPage lp = new LoginPage(driver);
		lp.verifyLogo();
		extent.flush();
	}
	
	
	

}
