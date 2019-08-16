package com.gurukula.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;



public class CreateEditStaffForm {
	
	WebDriver ldriver;
	
	public CreateEditStaffForm(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		//PageFactory.initElements(new AjaxElementLocatorFactory(ldriver, 15), this);
		
	}
	

	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtStaffName;
	
	
	@FindBy(name="related_branch")
	@CacheLookup
	WebElement Dropdownnamebranch;
	;
	
	
	@FindBy(xpath="//button[@type='submit']")
	@CacheLookup
	WebElement btnSubmit;
	
	

	public void SetStaffName(String staffName)
	{
		//txtName.click();
		txtStaffName.sendKeys(staffName);

	}
	
	
	public void selectBranchName(String Branchname)
	{
		Select DropdownBranch = new Select (Dropdownnamebranch);
		DropdownBranch.selectByVisibleText(Branchname);
	}
		
	
	public void clickSave()
	{
		btnSubmit.click();
	}
	
	
	public void clearStaffName()
	{
		txtStaffName.clear();
	}


	

	
	
	
	
	
	
	

}



 