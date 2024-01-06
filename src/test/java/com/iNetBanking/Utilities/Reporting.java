package com.iNetBanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporting extends TestListenerAdapter
{

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest childExtentLogger;
	public static ExtentTest parentExtentLogger;


	@Test
	public void screen() throws IOException
	{

		Date date=new Date();
		System.out.println(date);
		SimpleDateFormat sDate=new SimpleDateFormat("YYYYMMddHHmmss");
		String newDate=sDate.format(date);
		System.out.println(newDate);
		File file=new File("test"+newDate+".txt");
		file.createNewFile();
	

		htmlReporter =new ExtentHtmlReporter("C:\\Users\\LENOVO\\workspace\\iNetBankingv2\\test-output");
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		parentExtentLogger=extent.createTest("RBGTechnologies");
		childExtentLogger=parentExtentLogger.createNode("scenario1");
		childExtentLogger.log(Status.PASS,MarkupHelper.createLabel(" - Test Case passed", ExtentColor.GREEN));
		extent.flush();
		System.out.println("Done");




	}





}
