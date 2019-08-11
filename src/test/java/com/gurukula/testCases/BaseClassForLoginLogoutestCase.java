package com.gurukula.testCases;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gurukula.utilities.ReadConfig;


public class BaseClassForLoginLogoutestCase {
	
	ReadConfig rc = new ReadConfig();
		
	 public String baseURL = rc.getbaseURL();
	 
	 public String username = rc.getusername();
	 public String passwd = rc.getpasswd() ;
	 public static WebDriver driver;
	 public static Logger logger;
	 
	 @BeforeClass
	 public void setup()
	 {
	
		 System.setProperty("webdriver.chrome.driver", rc.getchromepath());
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 logger = Logger.getLogger("Gurukulav0.1");
		 PropertyConfigurator.configure("log4j.properties");
		 
		 
			 
		 
		 
	 }
	 
	 @AfterClass
	 public void tearDown()
	 {
		 driver.quit();
	 }
	 
	 
	 		
	 
			 

}
