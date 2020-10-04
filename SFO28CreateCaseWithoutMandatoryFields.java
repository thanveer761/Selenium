package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO28CreateCaseWithoutMandatoryFields {

	public static void main(String[] args) throws InterruptedException {
		//disable Chrome notifications
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-notifications");
				
				//get driver
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver(options);
				
				//launch Url
			driver.get("https://login.salesforce.com");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();

			//Login
			driver.findElementById("username").sendKeys("nupela@testleaf.com");
			driver.findElementById("password").sendKeys("Bootcamp$123");
			driver.findElementById("Login").click();

			//click tonggle
			Thread.sleep(30000);
			driver.findElementByClassName("slds-icon-waffle").click();
			//click view all
			driver.findElementByXPath("//button[text()='View All']").click();

			//click sales
			driver.findElementByXPath("//p[text()='Sales']").click();
			//click on Cases tab
			Thread.sleep(30000);
			driver.findElementByXPath("//span[text()='More']").click();
			Thread.sleep(10000);
			WebElement ele = driver.findElementByXPath("(//span[text()='Cases'])[2]");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			
			//click newCase
			Thread.sleep(10000);
			 driver.findElementByXPath("//div[text()='New']").click();
			 
			//choose contact name
				Thread.sleep(10000);
				driver.findElementByXPath("//input[@title='Search Contacts']").click();
				 driver.findElementByXPath("//div[text()='Naveen Elumalai']").click();
				 
				 //select as None
				 Thread.sleep(10000);
				driver.findElementByXPath("(//input[@role='textbox'])[2]").click();
				 Thread.sleep(1000);
					driver.findElementByXPath("//label[text()='Status']/following-sibling::div//span[text()='--None--']").click();
				 
				 //enter subject as testing
				 driver.findElementByXPath("(//span[text()='Subject'])[2]/following::input").sendKeys("testing");

				 //enter description as automation testing
				 driver.findElementByXPath("//span[text()='Description']/following::textarea").sendKeys("Automation Testing");
				 
				 //click save
				 driver.findElementByXPath("(//span[text()='Save'])[2]").click();
				 
				//get the text of error message
				 String text = driver.findElementByXPath("//*[text()='These required fields must be completed: Case Origin, Status']").getText();
				 System.out.println(text);
				 
				 if (text.contains("These required fields must be completed:")) {
					System.out.println("error message displayed");
				}else {
					System.out.println("error message not displayed");
				}
	}

}
