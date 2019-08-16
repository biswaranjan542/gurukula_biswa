package com.gurukula.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.gurukula.pageObjects.ConfirmDeleteOperation;
import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;


 
public class TC_007_DeleteBranch  extends BaseClass {
	
public String bybranchname = "Rotterdam";




	@Test
	public void DeleteBranch() throws InterruptedException 	
	{
		//Landing on the branchpage
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitembranch();
		
		
		
	
		
		//Clicking Delete
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		cb.clickDelete(bybranchname);
		

		
		
		
		
		//Deleteing branch
		ConfirmDeleteOperation cdo = new ConfirmDeleteOperation(driver);
		cdo.ClickBtnDelete();
		//verifying the deleted ID,  branchname and code
		
		boolean isexist = cb.checkDeletedBranch(bybranchname);

		if (isexist == true)
		{
			Assert.assertTrue(true);
			logger.info("Deleted");
	
		}
		
		if (isexist == false)
		{
			Assert.assertTrue(false);
			logger.info("Not deleted");
	
		}




	

		
	
		
	}



}
