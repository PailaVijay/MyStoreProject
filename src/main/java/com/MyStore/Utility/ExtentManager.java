package com.MyStore.Utility;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentManager {
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;
	
	public static void setExtent() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\Reports\\MyReports.html";
		htmlReporter= new ExtentSparkReporter(path);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"\\extent-config.xml");
		
//		htmlReporter.config().setDocumentTitle("Automation Test Report");
//		htmlReporter.config().setReportName("MyStore Test Automation Report");
//		htmlReporter.config().setTheme(Theme.DARK);
		
	    extent= new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    
	    extent.setSystemInfo("HostName", "MyHost");
	    extent.setSystemInfo("ProjectName", "MyStoreProject");
	    extent.setSystemInfo("Tester", "Bijaya Kumar Reddy");
	    extent.setSystemInfo("OS", "Windows 10");
	    extent.setSystemInfo("browser", "chrome");
	    
	  }
	public static void endReport()
	{
		extent.flush();
		
	}
	
	
}
