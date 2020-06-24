
package com.bank.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;

public class NewCustomerPage extends TestBase
{

	@FindBy(xpath="//input[@name='name']")
	WebElement customername;
	
	@FindBy(xpath="//input[@value='m']")
	WebElement GenderMale;
	
	@FindBy(xpath="//input[@value='f']")
	WebElement GenderFeMale;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement address;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement city;
	
	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pinnumber;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement mobilenumber;
	
	@FindBy(xpath = "//input[@name='emailid']")
	WebElement emailid;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitbutton;
	
	@FindBy(xpath = "//input[@name='state']")
	WebElement state;
	
	public NewCustomerPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String validateNewCustommerPageTitle()
	{
		return driver.getTitle();
	}
	
	public void enterCustommerDetails(String cn, String adrs, String cty, String ste, String pinnum, String mobnum, String eid)
	{
		
		customername.sendKeys(cn);
		address.sendKeys(adrs);
		city.sendKeys(cty);
		state.sendKeys(ste);
		pinnumber.sendKeys(pinnum);
		mobilenumber.sendKeys(mobnum);
		emailid.sendKeys(eid);
	}
}