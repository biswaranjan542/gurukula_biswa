package com.gurukula.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class CreateEditSearchBranch {

	WebDriver ldriver;
	
	public CreateEditSearchBranch(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
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
	
	List<WebElement> rows ;
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
	
	
	public boolean SearchbyBranchName(String Expectedbrname)
	{
		
		boolean status1 = true;
		rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		rowcount= rows.size();
		
		for (int i= 1; i<=rowcount; i++)
		{
	
			String ActuaBranchName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[2]")).getText();
			System.out.println(ActuaBranchName);			
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
		rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		rowcount= rows.size();
		
		for (int i= 1; i<=rowcount; i++)
		{
	
			String ActuaBranchcode = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[3]")).getText();
			System.out.println(ActuaBranchcode);			
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
		rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		rowcount= rows.size();
		
		for (int i= 1; i<=rowcount; i++)
		{
	
			String ActuaBranchID = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[1]")).getText();
			System.out.println(ActuaBranchID);	
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
		List<WebElement> rows = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));

		int rowcount = rows.size();
		//getting the ID of the last row
		//
		int ExpectedID = Integer.parseInt(ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr[" + rowcount + "]/td[1]")).getText());

		for (int i= 1; i<=rowcount; i++)
		{

			int ActualID= Integer.parseInt(ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[1]")).getText());		
			String ActuaBranchName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[2]")).getText();
			String ActuaCodeName = ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody/tr["+ i +"]/td[3]")).getText();
			
			if ( (ActualID == ExpectedID) && (ActuaBranchName.equalsIgnoreCase(ActuaBranchName)) && (ActuaCodeName.equalsIgnoreCase(BranchCode)))
			{
				return true;
	
			}
			
			break;
			
		}
		return false;
		
		
		
	}



	

	
	
	
	
	
	
	

}



 