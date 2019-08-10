package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.Homepage;
import com.gurukula.pageObjects.Loginpage;

 
public class TC_LoginTest_001  extends BaseClassForLoginLogoutestCase {
	


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
		
				
		System.out.println(ExpecteConfdMsg);
		System.out.println(ActualConfMsg);
		System.out.println(Welcomemsg);

			
		if (ActualConfMsg.equalsIgnoreCase(ExpecteConfdMsg))
		//(Welcomemsg.equalsIgnoreCase("Welcome to Gurukula!")) 	

		{
			Assert.assertTrue(true);
			//System.out.println("I am passed");
		
		}
		
		else
		{
			Assert.assertTrue(false);
			//System.out.println("I am failed");
		}
		
		
	}
		
	@Test(priority=2)

	public void logout() {
		
		Homepage hp = new Homepage(driver);
		hp.clickAccount();
		
		hp.Selectitemlogout();
		
		

		
	}

}
