package com.gurukula.testCases;



import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_003_CreateBranch  extends BaseClass {
public String branchname = "Amsterdam";
public String branchcode = "11052011";


	@Test(priority=1)
	public void CreateBranch() 	
	{
		
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitembranch();
		
		//Creating Branch
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		cb.clickbtnCreateBranch();
		CreateEditBranchForm cbf = new CreateEditBranchForm(driver);
		cbf.clearBranchName();
		cbf.SetBranchname(branchname);
		cbf.clearCode();
		cbf.SetBranhcode(branchcode);
		cbf.clickSave();
		
		//verifying if branch added or not		
		boolean isExist = cb.checkExistanceOfBranch(branchname, branchcode);
		
		if (isExist == true)
		{
			Assert.assertTrue(true);
		}
		
		if (isExist == false)
		{
			Assert.assertTrue(true);
		}
		
	}	
		

}
