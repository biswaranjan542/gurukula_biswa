package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_006_Updatebranch  extends BaseClass {
	
public String bybranchname = "Amsterdam";
public String newbranchname = "Rotterdam";
public String newbranchcode = "23233232";
public String bybranchID  = "6";


	@Test
	public void updateBranch() throws InterruptedException 	
	{
		//Landing on the branchpage
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitembranch();
		
		
		
	
		
		//Clicking Edit
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		cb.clickEdit(bybranchname);
		
		
		
		//updating the branchbyname
		CreateEditBranchForm cbf = new CreateEditBranchForm(driver);
		cbf.clearBranchName();
		cbf.SetBranchname(newbranchname);
		cbf.clearCode();
		cbf.SetBranhcode(newbranchcode);
		cbf.clickSave();
		
		//verifying the updated ID,  branchname and code
		
		Boolean isexist = cb.checkUpdatedBranch(newbranchname, newbranchcode);

		if (isexist==true)
		{
			Assert.assertTrue(true);
	
		}
		
		else 
		{
			Assert.assertTrue(false);
	
		}


	

		
	
		
	}



}
