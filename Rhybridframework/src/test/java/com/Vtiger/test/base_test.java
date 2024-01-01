package com.Vtiger.test;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base_test
{


	public WebDriver driver;
	public Properties pro;
	public Map<String,Map<String,String>> dt;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	@BeforeSuit
	public void  initialization() throws IOException, FilloException
	{
		pro= readproprties();
	
		dt= readTestData();
		createExtentReport();
		System.out.println(dt);
		launchApp();
		
	}
	




	public WebDriver launchApp()
	{
		if(pro.getProperty("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(pro.getProperty("browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		
			
		}
		else if(pro.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(pro.getProperty("implicitewait"))));
		driver.get(pro.getProperty("appurl"));
		return driver;
	}
	@AfterSuite
	public void closeapp()
	{
	driver.quit();
	}
	
	public Properties readproprties() throws IOException
	{
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/settings.properties");
		pro.load(fis);
		return pro;		
	}
	public Map<String,Map<String,String>> readTestData() throws FilloException
	{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/test/resources/test_data/data.xlsx");
		String strQuery="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		int rowcount = recordset.getCount();
		System.out.println(rowcount);
		int colmcount = recordset.getFieldNames().size();
		System.out.println(colmcount);
		Map<String,Map<String,String>> data = new HashMap<String,Map<String,String>>();
		
		while(recordset.next())
		{
			Map<String,String> rowdata = new HashMap<String,String>();	
			String vTcname = recordset.getField("Tcname");
			for(int i=0;i<colmcount;i++)
			{
				String colname = recordset.getFieldNames().get(i);
				String colVal = recordset.getField(colname);
				rowdata.put(colname,colVal);
			}
			
			data.put(vTcname, rowdata);
		}	
		recordset.close();
		connection.close();
		return data;
	}
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/Vtiger/report/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Shesha");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.DARK); 
	
}
}
