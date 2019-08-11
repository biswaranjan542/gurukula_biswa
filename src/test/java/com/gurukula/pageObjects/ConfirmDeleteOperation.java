package com.gurukula.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ConfirmDeleteOperation {
	
	WebDriver ldriver;
	
	public ConfirmDeleteOperation(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	//WebDriverWait wait = new WebDriverWait(ldriver, 5000l);

	
	//@FindBy(xpath="//span[text()='Delete']")
	@FindBy(xpath="//p[contains(text(),'Are you sure you want to delete Branch')]//parent::div[@class='modal-body']//following-sibling::div[@class='modal-footer']//button[@type='submit']")
	@CacheLookup
	WebElement btnDelete;
	
	
	public void ClickBtnDelete()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
		btnDelete.click();
		
	}
	
	

	
	
	
	
	
	
	

}



 