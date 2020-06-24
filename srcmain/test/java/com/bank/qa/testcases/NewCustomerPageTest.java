package com.bank.qa.testcases;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.pages.NewCustomerPage;

public class NewCustomerPageTest extends TestBase
{
	LoginPage loginpage;
    HomePage homepage;
	NewCustomerPage newcustomerpage;
    
	public NewCustomerPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
	    loginpage = new LoginPage();
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
        newcustomerpage = homepage.clickOnNewCustomerLink();
	    newcustomerpage = new NewCustomerPage();
	}
	
	@Test(priority = 1)
	public void validateNewCustomerPageTilteTest()
	{
		String title = newcustomerpage.validateNewCustommerPageTitle();
		Assert.assertEquals(title, "Gtpl Bank New Customer Entry Page", "tile not matched");
	}
	
	@Test(priority = 2)
	public void enterCustomerNameTest()
	{
		newcustomerpage.enterUsername(prop.getProperty("customername"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}