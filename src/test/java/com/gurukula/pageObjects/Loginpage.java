package com.gurukula.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver ldriver;
	
	public Loginpage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'login')]")
	@CacheLookup
	WebElement Linklogin;
	
	@FindBy(xpath="//input[@id='username']")
	@CacheLookup
	WebElement txtlogin;
	
	@FindBy(xpath="//input[@id='password']")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath="//button[@class='btn btn-primary ng-scope']")
	@CacheLookup
	WebElement txtAutheticate;
	
	@FindBy(xpath= "//div[@class='alert alert-success ng-scope ng-binding']")
	@CacheLookup
	public WebElement Loggedinmsg;
	
	@FindBy(xpath= "//h1[@class='ng-scope']")
	@CacheLookup
	public WebElement Welcomemsg;
	
	
	
	
	
	
	
	
	public void clickLogin()
	
	{
		Linklogin.click();
	}
	
	
	public  void setUserName (String uname)
	
	{
		txtlogin.sendKeys(uname);
		
	} 
	
	public  void setUserPassword (String pwd)
	
	{
		txtPassword.sendKeys(pwd);
		
	} 
	
	public void clickAuthenticate()
	{
		txtAutheticate.click();
	}
	
	
	
	
	

}



 