
package com.bank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class NewCustomerPage extends TestBase
{

	@FindBy(xpath = "//input[@name='name']")
	WebElement username;
	
	public NewCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateNewCustommerPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterUsername(String un)
	{
		username.sendKeys(un);
	}
}