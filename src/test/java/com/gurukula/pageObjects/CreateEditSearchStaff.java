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



public class CreateEditSearchStaff {

	WebDriver ldriver;
	
	public CreateEditSearchStaff(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		//PageFactory.initElements(new AjaxElementLocatorFactory(ldriver, 15), this);
		
	}
	

	@FindBy(className="table table-striped")
	@CacheLookup	
	WebElement stafftable;
	
	
	
	
	@FindBy(xpath="//span[contains(text(),'Create a new Staff')]")
	@CacheLookup
	WebElement btnCreateStaff;
	
	@FindBy(xpath="//li[@ng-show=\"links['next']\"]")
	@CacheLookup
	public WebElement linkNextNavigation;
	
	@FindBy(xpath="//li[@ng-show=\"links['prev']\"]")
	@CacheLookup
	public WebElement linkPreviousNavigation;	
	
	@FindBy(xpath="//li[@ng-show=\"links['last']\"]")
	@CacheLookup
	public WebElement linklastNavigation;
	
	
	
	
	
	
		
	
	public void clickbtnCreateSTaff() 
	{
		btnCreateStaff.click();

	}
	
	public int getRowcount()
	{
		
		List<WebElement> rows  = ldriver.findElements(By.xpath("//table[@class='table table-striped']//tbody/tr"));
		int rowcount= rows.size();
		return rowcount;
	}
	
	public void clickNextNavigation()
	{
		linkNextNavigation.click();
		
	}
	
	
	public int gettingLastrowId(int rowcount)
	{
		String last_rowvalue =ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[" + rowcount + "]//td[1]")).getText();
		int lastrowid = Integer.parseInt(last_rowvalue);
		return lastrowid;
		
	}
	
	
	public int gettingfirstrowId()
	{
		String first_rowvalue =ldriver.findElement(By.xpath("//table[@class='table table-striped']//tbody//tr[1]//td[1]")).getText();
		int firstrowid = Integer.parseInt(first_rowvalue);
		return firstrowid;
		
	}
	
	
	public void clicklastNavigation()
	
	{
		linklastNavigation.click();
	}

		
	public void clickPrevioustNavigation()
	
	{
		linkPreviousNavigation.click();
	}
	}

	




	
	
	
	
	
	
	




 