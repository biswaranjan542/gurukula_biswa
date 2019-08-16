package com.gurukula.testCases;



import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_006_Updatebranch  extends BaseClass {
	
public String bybranchname = "Amsterdam";
public String newbranchname = "Rotterdam";
public String newbranchcode = "11052011";
public String bybranchID  = "6";


	@Test
	public void updateBranch() throws InterruptedException 	
	{

	
		logger.info("Landing on the branchpage");
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitembranch();
		
		
		
	
		
	
		logger.info("Clicking Edit");
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		cb.clickEdit(bybranchname);
		
		
		
		logger.info("updating the branchbyname");
		CreateEditBranchForm cbf = new CreateEditBranchForm(driver);
		cbf.clearBranchName();
		cbf.SetBranchname(newbranchname);
		cbf.clearCode();
		cbf.SetBranhcode(newbranchcode);
		cbf.clickSave();
		
		//
		logger.info("verifying the updated ID,  branchname and code");
		Boolean isexist = cb.checkUpdatedBranch(newbranchname, newbranchcode);

		if (isexist==true)
		{
			Assert.assertTrue(true);
			logger.info("Updated value reflected");
	
		}
		
		else 
		{
			Assert.assertTrue(false);
			logger.info("Updated value not reflected");
	
		}


	

		
	
		
	}



}
