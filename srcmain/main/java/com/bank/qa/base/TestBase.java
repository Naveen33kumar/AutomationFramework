package com.bank.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bank.qa.util.TestTimeouts;

public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() 
	{
		try
		{
		prop = new Properties();
		FileInputStream io = new FileInputStream("D:\\java programs\\BankAppAutomation\\src\\main\\java\\com\\bank\\qa\\config\\config.properties");
		prop.load(io);
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
}

	public static void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\LatestChromeDriver\\chromedriver_win32 (4)\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
            System.setProperty("webdriver.gecko.driver", "D:\\GeckoDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestTimeouts.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestTimeouts.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
}
