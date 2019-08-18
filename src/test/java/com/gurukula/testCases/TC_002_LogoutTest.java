package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.Homepage;
import com.gurukula.pageObjects.Loginpage;

 
public class TC_002_LogoutTest  extends BaseClassForLoginLogoutestCase {
	


	@Test
	public void logouttest() throws InterruptedException
	{
		driver.get(baseURL);		
		Loginpage lp = new Loginpage(driver);
		lp.clickLogin();
		
		logger.info("logging in");
		lp.setUserName(username);
		lp.setUserPassword(passwd);
		lp.clickAuthenticate();
		
		logger.info("logging out");		
		Homepage hp = new Homepage(driver);
		hp.clickAccount();		
		hp.Selectitemlogout();
	

		
		
	}
		
}
		

		
		

		
