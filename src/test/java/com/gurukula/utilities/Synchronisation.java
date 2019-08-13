package com.gurukula.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class Synchronisation

{
	

	
	public static WebElement  SyncWaitforelementobeVisible(WebDriver driver, WebElement webelement , int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
		return element;

	}
	
	
	public static WebElement  SyncWaitforelementobeclicable(WebDriver driver, WebElement webelement , int seconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
		return element;

	}


	
	
}
