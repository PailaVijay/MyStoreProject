package com.MyStore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.MyStore.Utility.ExtentManager;

import net.bytebuddy.utility.RandomString;



public class BaseClass {

	//public  static WebDriver driver;
	public  static Properties prop;
	
    //Declare threadLocal driver
	public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
	
    public static WebDriver getDriver()
    {
    	return driver.get();
    }
    
    @BeforeSuite(groups= {"Regression","Smoke","Sanity"})
    public void loadConfig() throws IOException
    {
    	ExtentManager.setExtent();
    	DOMConfigurator.configure("log4j.xml");
    	
    	try {
			 prop = new Properties();
			String file = "C:\\Users\\Vijay\\eclipse-workspace\\SeleniumFramework\\Configuration\\config.properties";
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			System.out.println("driver" + driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

    }
	
	
	public static void lunchApp(String browserName) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		//String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			//driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		action.implicitWait(driver, 10);
//		action.pageLoadTimeOut(driver, 15);

		getDriver().get(prop.getProperty("url"));

	}
	@AfterSuite
	public void afterSuite() throws IOException
	{
		ExtentManager.endReport();
	}

}
