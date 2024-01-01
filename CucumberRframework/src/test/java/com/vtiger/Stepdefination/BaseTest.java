package com.vtiger.Stepdefination;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

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

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Map<String,Map<String,String>> dt;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public  static String TCname;
	

	public void initiation() throws IOException, FilloException
	{
		prop = readproprties();
		
		dt = readTestData();
		createExtentReport();
		System.out.println(dt);
		//System.exit(0);
	//	launchapp();
	}
	
	
	public void launchapp()
	{
		if(prop.getProperty("Browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}		
		else if(prop.getProperty("Browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		else if(prop.getProperty("Browser").equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("ImplicitWait"))));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(prop.getProperty("AppURL"));
	}
	


	public void closeapp()
	{
		driver.quit();
	}
	
	
	public Properties readproprties() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/Config/settings.properties");
		prop.load(fis);
		return prop;		
	}
	
	public Map<String,Map<String,String>> readTestData() throws FilloException
	{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(System.getProperty("user.dir")+"/src/main/resources/TestData/data.xlsx");
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
			String vTCName = recordset.getField("TCName");
			for(int i=0;i<colmcount;i++)
			{
				String colname = recordset.getFieldNames().get(i);
				String colVal = recordset.getField(colname);
				rowdata.put(colname,colVal);
			}
			
			data.put(vTCName, rowdata);
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
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.DARK); 
		
	}

}
