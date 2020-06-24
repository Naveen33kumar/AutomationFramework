package com.bank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.pages.NewCustomerPage;

public class HomePageTest extends TestBase
{

	LoginPage loginpage;
	HomePage homepage;
	NewCustomerPage newcustomerpage;
	
    public HomePageTest()
	{
		super();
	}
    
    @BeforeMethod
    public void setUp()
    {
    	initialization();
    	loginpage = new LoginPage();
    	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
	
    @Test(priority = 1)
    public void verifyHomePageTitleTest()
    {
    	String homepageTitle = homepage.validateHomePageTitle();
    	Assert.assertEquals(homepageTitle, "GTPL Bank Manager HomePage", "Home Page Title Not Matched ");
    }
    
    @Test(priority = 2)
    public void clickNewCustomerLink()
    {
    	newcustomerpage = homepage.clickOnNewCustomerLink();   	
    }
    
    @AfterMethod
    public void tearDown()
    {
    	driver.quit();
    }
}