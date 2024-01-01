package com.vtiger.Stepdefination;

import java.io.IOException;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.codoid.products.exception.FilloException;
import com.vtiger.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginStepDefination extends BaseTest
{
	@Before
	public void getScenarioName(Scenario scenario) throws IOException, FilloException
	{
		initiation();
		TCname=scenario.getName();
		System.out.println(TCname);
		logger = extent.createTest(TCname);
	}
	@After
	public void savereport()
	{
		extent.flush();
	}
	
	@When("user perform valid login")
	public void user_perform_valid_login() throws IOException, FilloException
	{	
		LoginPage lp = new LoginPage(driver);
		lp.login(dt.get(TCname).get("Userid"), dt.get(TCname).get("Password"));
	}
	
	@When("user perform Invalid login")
	public void user_perform_invalid_login() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.login(dt.get(TCname).get("Userid"), dt.get(TCname).get("Password"));
	}
	@Then("user should validate error message")
	public void user_should_validate_error_message()
	{
		LoginPage lp = new LoginPage(driver);
		lp.verifyErrorMsg();
	}
	@Then("user should validate logo")
	public void user_should_validate_logo() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.verifyLogo();
	}




	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() throws IOException, FilloException 
	{
		launchapp();
		
	}
}