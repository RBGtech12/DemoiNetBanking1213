package com.iNetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.iNetBanking.Utilities.ReadConfig;

public class BaseClass 
{
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest childExtentLogger;
	public static ExtentTest parentExtentLogger;

	ReadConfig readconfig=new ReadConfig();
	
	public String baseUrl=readconfig.geturl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup()
	{		
		driver=new ChromeDriver();
		driver.get(baseUrl);


		 logger=Logger.getLogger("ebanking");
		 
		PropertyConfigurator.configure("log4j.properties");
//		if(driver.equals("Chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if(driver.equals("firefox"))
//		{
//			driver=new FirefoxDriver();
//		}
//		else if(driver.equals("IE"))
//		{
//			driver=new EdgeDriver();
//		}
//		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws IOException
	{

			Date date=new Date();
			System.out.println(date);
			SimpleDateFormat sDate=new SimpleDateFormat("YYYYMMddHHmmss");
			String newDate=sDate.format(date);
			System.out.println(newDate);
			File file=new File("test"+newDate+".txt");
			file.createNewFile();
		

			htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtendReports");
			extent=new ExtentReports();
			extent.attachReporter(htmlReporter);
			parentExtentLogger=extent.createTest("RBGTechnologies");
			childExtentLogger=parentExtentLogger.createNode("scenario1");
			childExtentLogger.log(Status.PASS,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));
			extent.flush();
			System.out.println("Done");
			driver.quit();
	}
}
