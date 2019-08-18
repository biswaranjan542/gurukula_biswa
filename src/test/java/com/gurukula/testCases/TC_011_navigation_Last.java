package com.gurukula.testCases;



import org.testng.Assert;
import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import com.gurukula.pageObjects.CreateEditBranchForm;
import com.gurukula.pageObjects.CreateEditSearchBranch;
import com.gurukula.pageObjects.CreateEditSearchStaff;
import com.gurukula.pageObjects.CreateEditStaffForm;
import com.gurukula.pageObjects.Homepage;
import com.gurukula.utilities.XLUtils;


 
public class TC_011_navigation_Last  extends BaseClass {



	@Test
	public void checkNavigationLast() throws InterruptedException 	
	{
		boolean status = false;                        
		logger.info("Landing on the staffpage ");
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitemstaff();
		

		CreateEditSearchStaff csf = new CreateEditSearchStaff(driver);
		csf.clicklastNavigation();	
		
		
		
		while (csf.linklastNavigation.isDisplayed())
						
		{
			logger.info("Getting the ID of last row of the current page");
			int rowCountcurrentpage = csf.getRowcount();
			int lastrowIDcurrentpage = csf.gettingLastrowId(rowCountcurrentpage);	

			
			logger.info("Clicking the next navigation link");
			csf.clickNextNavigation();
			
			logger.info("Getting the ID of first row of thge next page");
			int firstrowIDnextpage = csf.gettingfirstrowId();

			
			if (firstrowIDnextpage > lastrowIDcurrentpage)
			{
				 status = true;
				 
			}
				
			
		}
		
		
		if(status == true)
		{
			Assert.assertTrue(true);
			logger.info("navigation next is correctly working");
		}
		
		else
		{
			Assert.assertTrue(false);
			logger.info("navigation next is not correctly working");
		}

		
		
		

		
		
		
		
		
		
		


		
		

		
		
		
		
		
		
		

		
	}	
		
		
		
		
		
	}





		


