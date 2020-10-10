package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC006_NewLead {


		public static void main(String[] args) throws InterruptedException {

			//disable Chrome notifications
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			//get driver
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver(options);
			driver.get("https://login.salesforce.com/");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

//			Authentication
			driver.findElementById("username").sendKeys("dhivya@testleaf.com");
			driver.findElementById("password").sendKeys("India@123");
			driver.findElementById("Login").click();

			Thread.sleep(30000);
			
//			Click SVG Icon
			WebElement svg = driver.findElementByXPath("//*[@data-key='add']");
			svg.click();
			//Click New Event and maximize it
			Thread.sleep(20000);
				Actions builder = new Actions(driver);
				builder.click(driver.findElementByXPath("(//span[text()='New Opportunity'])[1]")).perform();
				Thread.sleep(10000);
				driver.findElementByXPath("//button[@title='Maximize']//lightning-primitive-icon[1]").click();
				Thread.sleep(2000);
				driver.findElementByXPath("//input[@class=' input']")
															.sendKeys("On site");
				
				driver.findElementByXPath("//a[text()='--None--']").click();
				
				driver.findElementByXPath("//a[text()='Prospecting']").click();
					
				driver.findElementByXPath("(//span[text()='Save'])[2]").click();
				
				Thread.sleep(5000);
				
				driver.close();
//			Click New Event and maximize it
		/*	Thread.sleep(20000);
			Actions builder = new Actions(driver);
			builder.click(driver.findElementByXPath("(//span[text()='New Opportunity'])[1]")).
			Thread.sleep(10000);
			driver.findElementByXPath("//button[@title='Maximize']//lightning-primitive-icon[1]").click();
			
			driver.findElementByXPath("//span[text()='Opportunity Name']//following-sibling::input")
														.sendKeys("On site");
			
			driver.findElementByXPath("//span[text()='Stage']/../following-sibling::div").click();
			
			driver.findElementByXPath("//a[text()='Prospecting']").click();
				
			driver.findElementByXPath("(//span[text()='Save'])[2]").click();
			
			Thread.sleep(5000);
			
			driver.close();
			*/
		}
	}


