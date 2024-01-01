package com.vtiger.stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginstepdefinition {
	public WebDriver driver ;  
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost:100");
	   
	}
	@When("user enters valid credentials and click on login button")
	public void user_enters_valid_credentials_and_click_on_login_button() {
	   driver.findElement(By.name("user_name")).sendKeys("admin");
	   driver.findElement(By.name("user_password")).sendKeys("admin");
	   driver.findElement(By.name("Login")).click();
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	   driver.findElement(By.linkText("Home")).isDisplayed();
	}
	@Then("user can validate logout link")
	public void user_can_validate_logout_link() {
		 driver.findElement(By.linkText("Logout")).isDisplayed();
	}
	
	
	@When("user enters valid userid as {string} and valid password as {string} click on login button")
	public void user_enters_valid_userid_as_and_valid_password_as_click_on_login_button(String string, String string2) {
		driver.findElement(By.name("user_name")).sendKeys(string);
		   driver.findElement(By.name("user_password")).sendKeys(string2);
		   driver.findElement(By.name("Login")).click();
	}
	
	@When("user enters Invalid credentials and click on login button")
	public void user_enters_invalid_credentials_and_click_on_login_button() {
		 driver.findElement(By.name("user_name")).sendKeys("admin1");
		   driver.findElement(By.name("user_password")).sendKeys("admin123");
		   driver.findElement(By.name("Login")).click();
	}
	@Then("user should be navigated to login page")
	public void user_should_be_navigated_to_login_page() {
	   
	}
	@Then("user can validate error message")
	public void user_can_validate_error_message() {
		driver.findElement(By.xpath("//*[contains(text(),'You must specify a valid username and password.')]")).isDisplayed();
	    
	}
	
	@Then("close browser")
	public void closebrowser() {
	   driver.quit();
	}
	}







