package com.vtiger.Stepdefination;

import java.io.IOException;

import org.openqa.selenium.By;

import com.codoid.products.exception.FilloException;
import com.vtiger.pages.LoginPage;
import com.vtiger.pages.orders;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class orderStepdefination extends BaseTest
{

@Given("user should be on Home page")
public void user_should_be_on_home_page() 
{
	launchapp();
	LoginPage lp = new LoginPage(driver);
	lp.login(dt.get(TCname).get("Userid"), dt.get(TCname).get("Password"));

}
@When("user click on submenu")
public void user_click_on_submenu()
{
	orders op=new orders(driver);
	op.clickonshowsubmenu();
}

@When("user click on new sales order")
public void user_click_on_new_sales_order() 
{
	orders op=new orders(driver);
	op.clickonnewsalesorder();
}

  
@When("user enter subject and account nameaddress order information")
public void user_enter_subject_and_account_nameaddress_order_information() throws InterruptedException
{
	
	orders op=new orders(driver);
	op.entersubject(dt.get(TCname).get("subjectname"));
	op.selectaccountname();
	op.switchbaseWindow();
	Thread.sleep(5000);
}

@When("user enter address order information")
public void user_enter_address_order_information()
{
	orders op=new orders(driver);
	op.enterbillingaddress(dt.get(TCname).get("BillingAdd"));
	op.entershippingaddress(dt.get(TCname).get("shippingAdd"));
}
@When("user enter product information")
public void user_enter_product_information() throws InterruptedException
{
	orders op=new orders(driver);
	op.enterproduct();
	op.switchbaseWindow();
	Thread.sleep(5000);
	op.enterqty(dt.get(TCname).get("qty"));
}
@When("click on save button")
public void click_on_save_button() throws InterruptedException 
{
	orders op=new orders(driver);
	op.clickonsave();
	Thread.sleep(3000);
}

@Then("user should navigate to orders page and order should successfully created")
public void user_should_navigate_to_orders_page_and_order_should_successfully_created()
{
	orders op=new orders(driver);
	op.checkorder();
}

}
