package week5.day2;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public ChromeDriver driver;
	public String excelName;
	@Parameters({"username", "password"})
	@BeforeMethod
	public void login(String username, String password) throws InterruptedException {
		//disable Chrome notifications
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				//get driver
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				//launch Url
			driver.get("https://login.salesforce.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 20);
			//Login
			Thread.sleep(5000);
			driver.findElementById("username").sendKeys(username);
			driver.findElementById("password").sendKeys(password);
			driver.findElementById("Login").click();
			
	}
	
			
	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		
		String[][] excelData = ReadExcel.excelData(excelName);
		return excelData;
	}
	
}
