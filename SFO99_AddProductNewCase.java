package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO99_AddProductNewCase {

	public static void main(String[] args) throws InterruptedException {
		//disable Chrome notifications
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				//get driver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver(options);
				driver.manage().window().maximize();
				
				//launch Url
			driver.get("https://login.salesforce.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, 20);


			//Login
			driver.findElementById("username").sendKeys("nupela@testleaf.com");
			driver.findElementById("password").sendKeys("Bootcamp$123");
			driver.findElementById("Login").click();

			//click tonggle
			Thread.sleep(10000);
			driver.findElementByClassName("slds-icon-waffle").click();
			//click view all
			driver.findElementByXPath("//button[text()='View All']").click();
		//click Content tab
			Thread.sleep(5000);
			driver.findElementByXPath("//p[text()='Content']").click();
			//click viewAll keyDeals
			Thread.sleep(2000);
driver.findElementByXPath("//span[text()='View All Key Deals']").click();
			//click list view
Thread.sleep(2000);
			driver.findElementByXPath("//a[@title='Select List View']").click();
			//clik All opportunites
			Thread.sleep(2000);
			driver.findElementByXPath("//span[text()='All Opportunities']").click();
			Thread.sleep(5000);
			WebElement element = driver.findElementByXPath("//label[text()='Search this list...']/following::input");
			element.sendKeys("SRM steels");
			Thread.sleep(1000);
			element.sendKeys(Keys.ENTER);
			
			Thread.sleep(10000);
			driver.findElementByXPath("//table//th//span//a").click();
			Thread.sleep(10000);
			driver.findElementByXPath("//div[@title='New Case']").click();
			Thread.sleep(5000);
			driver.findElementByXPath("//input[@placeholder='Search Contacts...']").click();
			driver.findElementByXPath("//div[@title='Naveen Elumalai']").click();	
			driver.findElementByXPath("//span[text()='Subject']/following::input").sendKeys("New case to SRM Steels");
			driver.findElementByXPath("(//span[text()='Save'])[3]").click();
	}
	

}
