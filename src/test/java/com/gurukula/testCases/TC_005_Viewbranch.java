package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;


import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_005_Viewbranch  extends BaseClass {
	
public String bybranchname = "Amsterdam";
public String bybranchcode = "11052011";
public String bybranchID  = "6";


	@Test
	public void viewBranch() throws InterruptedException 	
	{
		//Landing on the branchpage
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitembranch();
		
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		
		//Viewing the branchbyname
		
		boolean isexist = cb.ViewBranchByname(bybranchname);
		cb.clickBtnback();
		

		
		if (isexist == true)
		{
			Assert.assertTrue(true);
	
		}
		if (isexist == false)
		{
			Assert.assertTrue(false);
	
		}
	
	
		
	}



}
