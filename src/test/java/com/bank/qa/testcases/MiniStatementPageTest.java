package com.bank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.pages.MiniStatementPage;
import com.bank.qa.pages.NewCustomerPage;

public class MiniStatementPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	MiniStatementPage ministatementpage;
	public MiniStatementPageTest()
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
	public void verifyMiniStamentPageTitleTest()
	{
		homepage.clickOnMiniStatementLink();
		
		String miniStatementTitle = ministatementpage.validateMstatementPageTitle();
		
		System.out.println(miniStatementTitle);
		
		Assert.assertEquals(miniStatementTitle, "Guru99 Bank Mini Statement Page ", "title not matched");
	}
	
	@Test(priority = 2)
	public void enterAccttNo()
	{
		ministatementpage = homepage.clickOnMiniStatementLink();
		ministatementpage.enterAccountNumber("2876151612");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		driver.quit();
	}
}