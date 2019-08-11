package com.gurukula.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateEditBranchForm {
	
	WebDriver ldriver;
	
	public CreateEditBranchForm(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	

	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtName;
	
	@FindBy(name="code")
	@CacheLookup
	WebElement txtCode;
	
	@FindBy(xpath="//span[(text()='Save')]")
	@CacheLookup
	WebElement btnSave;
	
	

	public void SetBranchname(String BranchName)
	{
		txtName.click();
		txtName.sendKeys(BranchName);
	}
	
	
	public void SetBranhcode(String BranchCode)
	{
		txtCode.click();
		txtCode.sendKeys(BranchCode);
	}
		
	
	public void clickSave()
	{
		btnSave.click();
	}
	
	
	public void clearBranchName()
	{
		txtName.clear();
	}

	public void clearCode()
	{
		txtCode.clear();
	}
	

	
	
	
	
	
	
	

}



 