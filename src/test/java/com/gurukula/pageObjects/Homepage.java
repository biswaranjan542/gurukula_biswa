package com.gurukula.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;


public class Homepage {
	
	WebDriver ldriver;
	
	public Homepage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		PageFactory.initElements(new AjaxElementLocatorFactory(ldriver, 15), this);
	}
	

	
	@FindBy(xpath="//span[contains(text(),'Account')]")
	@CacheLookup
	WebElement Accountlink;
	
	@FindBy(xpath="//ul[@class='dropdown-menu']//li/a/span[@class='glyphicon glyphicon-log-out']")
	@CacheLookup
	WebElement Logout ;
	
	@FindBy(xpath="//span[text()='Entities']")
	@CacheLookup
	WebElement Entitieslink ;
	
	@FindBy(xpath="	//ul[@class='dropdown-menu']//li/a[@ui-sref=\"branch\"]")
	@CacheLookup
	WebElement dropdownBranch ;
	

	
	
	
	
		
	
	
	public void clickAccount() 
	{
		Accountlink.click();

	}
	
	
	public void Selectitemlogout()
	
	{
		Logout.click();
		
	}
	
	public void clickEntities()
	
	{
		Entitieslink.click();
	}
	
	
	public void Selectitembranch()
	
	{
		dropdownBranch.click();
		
	}
	
	
	
	
	
	
	

}



 