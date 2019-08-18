package com.gurukula.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;



public class CreateEditSearchBranch {

	WebDriver ldriver;
	
	public CreateEditSearchBranch(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		//PageFactory.initElements(new AjaxElementLocatorFactory(ldriver, 15), this);
		
	}
	

	
	@FindBy(xpath="//span[contains(text(),'Create a new Branch')]")
	@CacheLookup
	WebElement btnCreateBranch;
	
	@FindBy(xpath="//input[@id='searchQuery']")
	@CacheLookup
	WebElement txtQuery;
	
	
	@FindBy(xpath="	//span[contains(text(),'Search a Branch')]")
	@CacheLookup
	WebElement btnSearch;
	
	
	@FindBy(xpath="//span[contains(text(),'Back')]")
	@CacheLookup
	WebElement btnBack;	

	
	int rowcount ;
	
	
	
	

			
	
	
	public void clickbtnCreateBranch() 
	{
		btnCreateBranch.click();

	}
	
	
	public void SetSearchQuery(String brname)
	{
		txtQuery.sendKeys(brname);
	}
	
	public void clearSearch()
	{
		txtQuery.clear();
	}
	
	

	public void btnSearch()
	{
		btnSearch.click();
	}
	
	public void clickBtnback()
	{
		btnBack.click();
	}
	
	
	public boolean SearchbyBranchName(String Expectedbrname)
	{
		
		boolean status1 = true;
		List<WebElement> rows  = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		rowcount= rows.size();
		
		for (int i= 1; i<=rowcount; i++)
		{
	
			String ActuaBranchName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[2]")).getText();

			if (!ActuaBranchName.equalsIgnoreCase(Expectedbrname))
			{
				status1 = false;
	
			}
			
			break;
			
		}
		
		return status1;
		
	}
	
	public boolean SearchbyBranchCode(String Expectedbrcode)
	{

		boolean status2 = true;
		List<WebElement> rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		rowcount= rows.size();
		
		for (int i= 1; i<=rowcount; i++)
		{
	
			String ActuaBranchcode = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[3]")).getText();
			if (!ActuaBranchcode.equalsIgnoreCase(Expectedbrcode))
			{
				status2 = false;
	
			}
			
			break;
			
		}
		
		return status2;
		
	}
	
	
	public boolean SearchbyBranchID(String ExpectedbrID)
	{

		boolean status3 = true;
		List<WebElement> rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		rowcount= rows.size();
		
		for (int i= 1; i<=rowcount; i++)
		{
	
			String ActuaBranchID = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[1]")).getText();

			if (!ActuaBranchID.equalsIgnoreCase(ExpectedbrID))
			{
				status3 = false;
	
			}
			
			break;
			
		}
		
		return status3;
		
	}
	
	
	
	
	
	public boolean checkExistanceOfBranch(String BranchName, String BranchCode)
	{
		
		ldriver.navigate().refresh();
		List<WebElement> rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));

		boolean status4 = false;
		int rowcount = rows.size();
		//getting the ID of the last row
		int ExpectedID = Integer.parseInt(ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + rowcount + "]/td[1]")).getText());

		for (int i= 1; i<=rowcount; i++)
		{

			int ActualID= Integer.parseInt(ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[1]")).getText());		
			String ActuaBranchName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[2]")).getText();
			String ActuaCodeName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[3]")).getText();
			System.out.println(ActuaCodeName + ActuaBranchName);
			
			if ( (ActualID == ExpectedID) && (ActuaBranchName.equalsIgnoreCase(ActuaBranchName)) && (ActuaCodeName.equalsIgnoreCase(BranchCode)))
			{
				status4 = true;
				break;
	
			}
			
			
			
		}
		return status4;
		
		
		
	}
	
	
	public  boolean ViewBranchByname(String ExpectedBranchName) 
	{
		boolean status5 = false ;
		ldriver.findElement(By.xpath("//td[contains(text(),'" + ExpectedBranchName + "')]//following-sibling::td//button[@ui-sref=\"branchDetail({id:branch.id})\"]")).click();
		String ActualBranchName = ldriver.findElement(By.xpath("//span[text()='Name']//parent::td//following-sibling::td//input[@type='text']")).getText();

		
		if (ActualBranchName.equalsIgnoreCase(ExpectedBranchName))
		{
			status5 = true;
			
					
		}

		return status5;
		
	}
	
	
	
	public  void clickEdit(String ExpectedBrNametochange) 
	{

		

		ldriver.findElement(By.xpath("//td[contains(text(),'" + ExpectedBrNametochange + "')]//following-sibling::td//button[@ng-click='showUpdate(branch.id)']")).click();

		
	}
	
	public  void clickDelete(String ExpecteNameToDelete) 
	{

		ldriver.findElement(By.xpath("//td[contains(text(),'" + ExpecteNameToDelete + "')]//following-sibling::td//button[@ng-click='delete(branch.id)']")).click();

		
	}

	
	public boolean checkDeletedBranch(String BranchName)
	{	
		
		ldriver.navigate().refresh();
		List<WebElement> rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
			

		rowcount = rows.size();
		
		boolean status6 = true;
		
		for (int i= 1; i<=rowcount; i++)		
		{
			
			String ActuaBranchName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[2]")).getText();
			if  (ActuaBranchName.equalsIgnoreCase(BranchName))
			{
				status6= false;
				break;
			}
			
			
			
		}

		return status6;
		
		
		
	}
	
	
	public boolean checkUpdatedBranch(String BranchName, String BranchCode)
	{
		ldriver.navigate().refresh();
		List<WebElement> rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));

		int rowcount = rows.size();

		boolean status7 = false;
		for (int i= 1; i<=rowcount; i++)
		{

		
			String ActuaBranchName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[2]")).getText();
			String ActuaCodeName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[3]")).getText();	
			if (  (ActuaBranchName.equalsIgnoreCase(ActuaBranchName)) && (ActuaCodeName.equalsIgnoreCase(BranchCode)))
			{
				status7 = true;
				break;
	
			}					
			
		}
		
		
		return status7;
		
		
		
	}
	



	
	
	
	
	
	
	

}



 