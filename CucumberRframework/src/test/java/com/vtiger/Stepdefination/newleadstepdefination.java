package com.vtiger.Stepdefination;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class newleadstepdefination extends BaseTest
{

@Given("user should be on home page")
public void user_should_be_on_home_page() 
{
	launchapp();
	LoginPage lp = new LoginPage(driver);
	lp.login(dt.get(TCname).get("Userid"), dt.get(TCname).get("Password"));
}
@When("user click on new lead tab leadinfo form should open")
public void user_click_on_new_lead_tab_leadinfo_form_should_open() 
{
	LeadPage lp=new LeadPage(driver);
	lp.clickonnewlead();
}
@When("user enter lastname and company")
public void user_enter_lastname_and_company() 
{
	LeadPage lp=new LeadPage(driver);
	
	lp.enterlastname(dt.get(TCname).get("lastname"));
	System.out.println();
	lp.entercompany(dt.get(TCname).get("company"));

}
  
@When("Click on save button")
public void click_on_save_button() 
{
	LeadPage lp=new LeadPage(driver);
	lp.clickonsave();
}
@Then("user should navigate to leads page and lead should created successfully")
public void user_should_navigate_to_leads_page_and_lead_should_created_successfully() 
{
	LeadPage lp=new LeadPage(driver);
	lp.checkleadiscreated();

}

@When("user click on leads tab user can see leads list")
public void user_click_on_leads_tab_user_can_see_leads_list() 
{
	LeadPage lp=new LeadPage(driver);
	lp.clickonLeadstab();
   
}
@When("user click on any lead element")
public void user_click_on_any_lead_element()
{
	LeadPage lp=new LeadPage(driver);
	lp.clickonelementtobedeleted();
   
}
@When("click on delete button")
public void click_on_delete_button() 
{
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	LeadPage lp=new LeadPage(driver);
	lp.clickondelete();
}

@Then("user click on ok")
public void user_click_on_ok()
{
	LeadPage lp=new LeadPage(driver);
	lp.clickokonalert();
    
}
@Then("lead element should delete from leads list.")
public void lead_element_should_delete_from_leads_list() 
{
	LeadPage lp=new LeadPage(driver);
	lp.checkdeletelead();
	System.out.println("lead is deleted");
}



@When("lead should be created and user should navigate to leads page")
public void lead_should_be_created_and_user_should_navigate_to_leads_page() 
{
	LeadPage lp=new LeadPage(driver);
	lp.clickonnewlead();
	lp.createLead(dt.get(TCname).get("firstname"),dt.get(TCname).get("lastname"),dt.get(TCname).get("company"));
	System.out.println("lead is created");
}

@When("user click on new task,user should navigate to activities page")
public void user_click_on_new_task_user_should_navigate_to_activities_page() 
{
	LeadPage lp=new LeadPage(driver);
	lp.clickonnewtask();
   
}

@When("enter start date and due date")
public void enter_start_date_and_due_date() 
{
	LeadPage lp=new LeadPage(driver);
	lp.entervalueincalender();
	lp.enterduedate();
}

@When("select lead from dropdownlist")
public void select_lead_from_dropdownlist()
{
	LeadPage lp=new LeadPage(driver);
	lp.selectvaluefrommenu(dt.get(TCname).get("dropdown1")); 
}

@When("select status from dropdownlist")
public void select_status_from_dropdownlist()
{
	LeadPage lp=new LeadPage(driver);
	lp.selectvaluefromstatusmenu(dt.get(TCname).get("dropdown2"));
   
}

@When("check the notification from checkbox")
public void check_the_notification_from_checkbox() 
{
   LeadPage lp=new LeadPage(driver);
   lp.checkthecheckbox();
}





@When("select contact name")
public void select_contact_name()
{
	  LeadPage lp=new LeadPage(driver);
	   lp.selectcontactnum();
    
}




@Then("user should accept that message click on ok")
public void user_should_accept_that_message_click_on_ok() 
{
	  LeadPage lp=new LeadPage(driver);
	   lp.alerthandle();
	
}

@Then("enter subject")
public void enter_subject()
{
	LeadPage lp=new LeadPage(driver);
	   lp.entersubject1(dt.get(TCname).get("subjectname"));
}

@Then("click on save")
public void click_on_save()
{
	LeadPage lp=new LeadPage(driver);
	   lp.clickonsave1();
   
}

@Then("new created activities should present on leads page.")
public void new_created_activities_should_present_on_leads_page() 
{
   
}






}