package com.gurukula.testCases;



import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_CreateBranch_002  extends BaseClass {
public String branchname = "Usharanidas";
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
		cbf.SetBranchname(branchname);
		cbf.SetBranhcode(branchcode);
		cbf.clickSave();
		
		//verifying if branch added or not		
		boolean isExist = cb.checkExistanceOfBranch("Ushara", "1232323");
		
		if (isExist == true)
		{
			Assert.assertTrue(true);
		}
		
	}	
		

}
