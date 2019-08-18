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


 
public class TC_008_CreateStaff  extends BaseClass {



	@Test(dataProvider = "StaffDetails")
	public void CreateBranch(String staffName, String staffBranchname) throws InterruptedException 	
	{
		                        
		Homepage hp = new Homepage(driver);
		hp.clickEntities();
		hp.Selectitemstaff();
		
		//Adding Staff
		CreateEditSearchStaff cbs = new CreateEditSearchStaff(driver);
		cbs.clickbtnCreateSTaff();
		CreateEditStaffForm csf = new CreateEditStaffForm(driver);
		csf.clearStaffName();
		csf.SetStaffName(staffName);
		csf.selectBranchName(staffBranchname);
		csf.clickSave();
		

	}	
		
		@DataProvider(name="StaffDetails")
		String [][] getData() throws IOException
		
		{
			//String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\gurukula\\testData\\StaffDetails.xlsx";
			String path=System.getProperty("user.dir")+"/src/test/java/com/gurukula/testData/StaffDetails.xlsx";
			
			int rownum=XLUtils.getRowCount(path, "Sheet1");
			int colcount=XLUtils.getCellCount(path,"Sheet1",1);
			
			String StaffDetails[][]=new String[rownum][colcount];
			
			for(int i=1;i<=rownum;i++)
			{
				for(int j=0;j<colcount;j++)
				{
					StaffDetails[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);
				}
					
			}
		return StaffDetails;
		}
		
		
		
	}





		


