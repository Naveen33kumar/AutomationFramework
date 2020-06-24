package com.bank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class HomePage extends TestBase
{
 
	@FindBy(xpath="//img[@src='/logo.png']")
	WebElement homePageLogo;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newCustomerLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateHomePageLogo()
	{
		return homePageLogo.isDisplayed();
	}

	public NewCustomerPage clickOnNewCustomerLink()
	{
		newCustomerLink.click();
		
		return new NewCustomerPage();
	}
}