package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.Homepage;
import com.gurukula.pageObjects.Loginpage;

 
public class TC_001_LoginTest  extends BaseClassForLoginLogoutestCase {
	


	@Test(priority=1)
	public void loginTest() throws InterruptedException
	{
		driver.get(baseURL);
	
		
		Loginpage lp = new Loginpage(driver);
		


		logger.info("Clicking Link");
		lp.clickLogin();

		
		logger.info("Entering username");
		lp.setUserName(username);
		logger.info("Entering password");
		lp.setUserPassword(passwd);
		
		logger.info("Singing in");
		lp.clickAuthenticate();
		

		
		String ActualConfMsg = lp.Loggedinmsg.getText();
		String ExpecteConfdMsg = "You are logged in as user "+"\"" + username + "\""+ ".";
		String Welcomemsg = lp.Welcomemsg.getText();
		
			
		if (ActualConfMsg.equalsIgnoreCase(ExpecteConfdMsg))
		//(Welcomemsg.equalsIgnoreCase("Welcome to Gurukula!")) 	

		{
			Assert.assertTrue(true);

		
		}
		
		else
		{
			Assert.assertTrue(false);

		}
		
		
	}
		
	
}
