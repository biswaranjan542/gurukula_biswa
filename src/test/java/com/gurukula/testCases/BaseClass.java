package com.gurukula.testCases;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.gurukula.pageObjects.Homepage;
import com.gurukula.pageObjects.Loginpage;
import com.gurukula.utilities.ReadConfig;


public class BaseClass {
	
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
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		 logger = Logger.getLogger("Gurukulav0.1");
		 PropertyConfigurator.configure("log4j.properties");
		 driver.get(baseURL);
		 Loginpage  lp= new Loginpage(driver);
		 lp.clickLogin();
		 lp.setUserName(username);
		 lp.setUserPassword(passwd);
		 lp.clickAuthenticate();	 
			 
		 
		 
	 }
	 
	/*@AfterClass
	 public void tearDown()
	 {
		Homepage hp = new Homepage(driver);
		
		hp.clickAccount();		
		hp.Selectitemlogout(); 
		driver.quit();
	 }
	 */
	 

	 
	 
	 		
	 
			 

}
