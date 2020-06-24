package com.bank.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bank.qa.pages.HomePage;
import com.bank.qa.pages.LoginPage;
import com.bank.qa.pages.NewCustomerPage;
import com.bank.qa.util.TestUtils;

public class NewCustomerPageTest extends TestBase
{
	LoginPage loginpage;
    HomePage homepage;
	NewCustomerPage newcustomerpage;
    String sheetname="Sheet1";
	
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
	
	@Test(priority = 2)
	public void validateNewCustomerPageTilteTest()
	{
		String title = newcustomerpage.validateNewCustommerPageTitle();
		Assert.assertEquals(title, "Gtpl Bank New Customer Entry Page", "tile not matched");
	}
	
	@DataProvider
	public Object[][] getCustomerData()
	{
		Object data [][] = TestUtils.getTestData(sheetname);
		return data;
	}
	
	@Test(priority = 1, dataProvider = "getCustomerData")
	public void enterCustomerNameTest(String customername, String address, String city, String state, String pin
			, String mobilenumber, String email)
	{    
		 //newcustomerpage.enterCustommerDetails("naveen", "no 33 a ", "chennai", "TN", "4545", "3434343434", "allsjK@gmail.com");
		 
		  newcustomerpage.enterCustommerDetails(customername, address, city, state, pin, mobilenumber, email);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}