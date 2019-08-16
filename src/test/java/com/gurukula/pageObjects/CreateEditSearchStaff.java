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
	

	
	@FindBy(xpath="//span[contains(text(),'Create a new Staff')]")
	@CacheLookup
	WebElement btnCreateStaff;
	
	
		
	
	public void clickbtnCreateSTaff() 
	{
		btnCreateStaff.click();

	}
	
		
		
		
	}
	



	
	
	
	
	
	
	




 