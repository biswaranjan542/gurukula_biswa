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


 
public class TC_010_navigation_Previous  extends BaseClass {



	@Test
	public void checknavigationPrevious() throws InterruptedException 	
	{
		boolean status = false;                        
		logger.info("Landing on the staffpage ");
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitemstaff();
		
		
		
	
		CreateEditSearchStaff csf = new CreateEditSearchStaff(driver);
		if(csf.linklastNavigation.isDisplayed())
			
		{
			csf.clicklastNavigation();		
			
			while (csf.linkPreviousNavigation.isDisplayed())
							
			{
				
				logger.info("Getting the ID of first row of the current page");
				int firstrowIDnextpage = csf.gettingfirstrowId();
				System.out.println(firstrowIDnextpage);
				
				logger.info("Clicking the next navigation link");
				csf.clickPrevioustNavigation();

				logger.info("Getting the rowcount of currentpage");
				int rowCountcurrentpage = csf.getRowcount();
				logger.info("Getting the ID of last row of the previous page");
				int lastrowIDcurrentpage = csf.gettingLastrowId(rowCountcurrentpage);	
				System.out.println(lastrowIDcurrentpage);

				
				
				if (lastrowIDcurrentpage < firstrowIDnextpage)
				{
					 status = true;
					 
				}
					
				
			}
			
			
			if(status == true)
			{
				Assert.assertTrue(true);
				logger.info("navigation prev is correctly working");
			}
			
			else
			{
				Assert.assertTrue(false);
				logger.info("navigation prev is not correctly working");
			}
		}
		
		else
		{
			Assert.assertTrue(false);
			logger.info("navigation last not present");
		}

		
		
		

		
	}	
		
		
		
		
		
	}





		


