package com.gurukula.testCases;



import org.apache.log4j.Logger;
import org.testng.Assert;
//import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.Homepage;
import com.gurukula.utilities.XLUtils;
import org.testng.annotations.DataProvider;





public class TC_003_CreateBranch  extends BaseClass {

	@Test(dataProvider = "BranchDetails")
	public void CreateBranch(String branchname, String branchcode ) 	
	{
		
		Homepage hp = new Homepage(driver);
		logger.info("Click entiies");
		hp.clickEntities();
		logger.info("Clik branch");
		hp.Selectitembranch();
		
		logger.info("Creating branch");
		CreateEditSearchBranch cb = new CreateEditSearchBranch(driver);
		
		cb.clickbtnCreateBranch();
		CreateEditBranchForm cbf = new CreateEditBranchForm(driver);
		cbf.clearBranchName();
		cbf.SetBranchname(branchname);
		cbf.clearCode();
		cbf.SetBranhcode(branchcode);
		cbf.clickSave();
		logger.info("Branch Created");
		
		logger.info("verifying if branch added or not")	;	
		boolean isExist = cb.checkExistanceOfBranch(branchname, branchcode);
		
		if (isExist == true)
		{
			Assert.assertTrue(true);
			logger.info("Brannch is displayed the list")	;
		}
		
		if (isExist == false)
		{
			Assert.assertTrue(false);
			logger.info("Brannch is not displayed the list" )	;
		}
		
	}	
	
	@DataProvider(name="BranchDetails")
	String [][] getData() throws IOException
	
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\gurukula\\testData\\BranchDetails.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String BranchDetails[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				BranchDetails[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
			}
				
		}
	return BranchDetails;
	}
	
		

}
