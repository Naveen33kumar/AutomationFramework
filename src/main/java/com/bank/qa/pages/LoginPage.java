package com.bank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class LoginPage extends TestBase
{

	// PageFactory (or) - OR(ObjectReposatory)
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")	
	WebElement password;
	
	@FindBy(xpath="//img[@src='/logo.png']")
	WebElement guru99Logo;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;
	
	//initializing the page objects	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLogo()
	{
		return guru99Logo.isDisplayed();
	}
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
}