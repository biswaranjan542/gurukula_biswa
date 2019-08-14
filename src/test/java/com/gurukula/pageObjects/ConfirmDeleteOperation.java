package com.gurukula.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ConfirmDeleteOperation {
	
	WebDriver ldriver;
	
	public ConfirmDeleteOperation(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		//PageFactory.initElements(new AjaxElementLocatorFactory(ldriver, 15), this);
		
	}
	

	

	
	@FindBy(xpath="//form[@name = 'deleteForm']//div[@class='modal-footer']//button[@type='submit']")
	@CacheLookup
	WebElement btnDelete;
	
	
	public void ClickBtnDelete() 
		
	{
		
		btnDelete.click();
		
	}
	
	

	
	
	
	
	
	
	

}



 