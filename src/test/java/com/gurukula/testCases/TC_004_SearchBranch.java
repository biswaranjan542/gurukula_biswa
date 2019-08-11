package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;


import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_004_SearchBranch  extends BaseClass {
public String bybranchname = "Amsterdam";
public String bybranchcode = "11052011";



	@Test(priority=1)
	public void SearchBranch() throws InterruptedException 	
	{
		//Landing on the branchpage
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitembranch();
		
	
		//Searching by branchchname
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		cb.clearSearch();
		cb.SetSearchQuery(bybranchname);
		cb.btnSearch();
		Thread.sleep(3000);
		boolean statusBranchname = cb.SearchbyBranchName(bybranchname);
		
		//Searching by branchcode
		cb.clearSearch();
		cb.SetSearchQuery(bybranchcode);
		cb.btnSearch();
		Thread.sleep(3000);
		boolean statusBranchcode= cb.SearchbyBranchCode(bybranchcode);
		


		
		if (statusBranchname == true && statusBranchcode == true)
		{
			Assert.assertTrue(true);

		}
		
		else
		{
			Assert.assertTrue(false);

		}

		
	}	
		

}
