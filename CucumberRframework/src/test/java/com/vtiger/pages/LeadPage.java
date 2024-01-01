package com.vtiger.pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.commonMethods;

public class LeadPage 
{
	public WebDriver driver;
public commonMethods cm;


public LeadPage(WebDriver driver)
{
	this.driver = driver;		
	PageFactory.initElements(driver, this);
	cm = new commonMethods(driver);
}
@FindBy(xpath="//*[text()='Lead:   khairnar']")
WebElement leadcheckelm;
@FindBy(xpath="//input[@name='firstname']")
WebElement fname;

@FindBy(xpath="//input[@name='lastname']")
WebElement lname;

@FindBy(xpath="//input[@name='company']")
WebElement company;


@FindBy(xpath="//input[@value='  Save  ']")
WebElement save;

@FindBy(xpath="//*[text()='New Lead']")
WebElement lead;

@FindBy(linkText="Leads")
WebElement LeadsTab;

@FindBy(linkText="ram")
WebElement elementtobedeleted;

@FindBy(xpath="//input[@title='Delete [Alt+D]']")
WebElement delete;

@FindBy(xpath="//input[@value='New Task']")
WebElement newtask;

@FindBy(xpath="//input[@name='subject']")
WebElement subject1;

@FindBy(xpath="//img[@id='jscal_trigger_date_start']")
WebElement calenderstartdate;

@FindBy(xpath="//select[@name='parent_type']")
WebElement dropdownmenu;

@FindBy(xpath="//select[@name='taskstatus']")
WebElement statusmenu;
@FindBy(xpath="//input[@name='sendnotification']")
WebElement checkbox;
@FindBy(xpath="//input[@name='Button']")
WebElement changebutton;
@FindBy(xpath="//a[text()='Patricia Johnson']")
WebElement windowelm;
@FindBy(xpath="(//input[@name='button'])[2]")
WebElement savebutton;
public void enterfirstname(String sname)
{
	cm.enterValue(fname,sname,"first name entered");
}
public void enterlastname(String lname1)
{
	cm.enterValue(lname, lname1, "last name entered");
}
public void entercompany(String com)
{
	cm.enterValue(company, com, "last name entered");
}
public void clickonsave()
{
	cm.clickElement(save, "click on saveed");
}

public void clickonnewlead()
{
	cm.clickElement(lead, "click on new lead");
}
public void checkleadiscreated()
{
	cm.elementExist( leadcheckelm, "lead is created");
}

public void createLead(String sname,String lname1,String com)
{
	
	cm.enterValue(fname,sname,"first name entered");
	cm.enterValue(lname, lname1, "last name entered");
	cm.enterValue(company, com, "last name entered");
	cm.clickElement(save, "click on saveed");
}


//delete lead
public void clickonLeadstab()
{
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	cm.clickElement(LeadsTab, "click on Leads tab");
}
public void clickonelementtobedeleted()
{
	cm.clickElement(elementtobedeleted, "clicked on elementtobedeleted");
}
public void clickondelete()
{
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	cm.clickElement(delete, "click on delete button");
	System.out.println("Delete button clicked");
	try {
		Thread.sleep(20000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public void clickokonalert()
{
	cm.AcceptAlertHanle("accepting alert");
}

public Boolean checkdeletelead()
{
	if(cm.elementExist(elementtobedeleted, "element is not deleted"))
	{
		System.out.println("element deleted succesfuuly");
	}
	return null;
	
}

//leadActivity

public void clickonnewtask()
{
	cm.clickElement(newtask,"clicked on new task");
}

public void entersubject1(String sub) 
{
	cm.enterValue(subject1, sub, "subject entered");
}
public void clickondatepicker()
{
	cm.clickElement(leadcheckelm, null);
}
public void clickoncalender1()
{
	cm.clickElement(calenderstartdate, "clicked on date picker1");
}
  public void entervalueincalender()
  {
	  try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  JavascriptExecutor js = (JavascriptExecutor) driver; 
	  js.executeScript("document.getElementById('jscal_field_date_start').value=''");
	  js.executeScript("document.getElementById('jscal_field_date_start').value='2023/12/21'");
  }
  public void selectvaluefrommenu( String Potentials)
  {
	System.out.println("select dropdown");
	cm.selectDropdownText(dropdownmenu, Potentials,"element selected from dropdown");
  }
  public void selectvaluefromstatusmenu(String NotStarted)
  {
	  cm.selectDropdownValue(statusmenu,NotStarted," status selected from statusmenu");
  }
  public void checkthecheckbox()
  {
	  cm.clickElement(checkbox, "click on checkbox");
  }
  public void enterduedate()
  {
	  JavascriptExecutor js = (JavascriptExecutor) driver; 
	  js.executeScript("document.getElementById('jscal_field_due_date').value=''");
	  js.executeScript("document.getElementById('jscal_field_due_date').value='2023/12/26'");
  }
  
  public void selectcontactnum()
  {
	  cm.clickElement(changebutton, "clicked on change");
	  cm.switchtosecondwindow("i m on second window");
	  cm.clickElement(windowelm, "element selected");
	  cm.switchtofirstwindow("i m on first window");
  }
  
  public void clickonsave1()
  {
	  cm.clickElement( savebutton, "clicked on saved");
  }
public void alerthandle()
{
	cm.AcceptAlertHanle("yes i m in");
}
}

