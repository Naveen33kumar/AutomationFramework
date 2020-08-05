package com.bank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class MiniStatementPage extends TestBase
{
	@FindBy(xpath = "//input[@name='accountno']")
	WebElement accountNo;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	WebElement submitBtn;
	
	public MiniStatementPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateMstatementPageTitle()
	{
		return driver.getTitle();	
	}
	
	public void enterAccountNumber(String acttNo)
	{
		accountNo.sendKeys(acttNo);
		
		submitBtn.click();
		
	}	
}