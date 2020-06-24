package com.bank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
    LoginPage loginpage;
	HomePage homepage;
    
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "GTPL Bank Home Page", "title not matched");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest()
	{
		boolean flag = loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}