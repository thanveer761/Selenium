package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO53CreateNewRefund {

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

	//Click on Menu Button From left Corner
	Thread.sleep(30000);
	driver.findElementByClassName("slds-icon-waffle").click();
	//click view all
	driver.findElementByXPath("//button[text()='View All']").click();
	
	//click Service Console from App launcher
	Thread.sleep(10000);
	driver.findElementByXPath("//p[text()='Service Console']").click();
	
	//click  on dropDown and Select new
	Thread.sleep(10000);
	driver.findElementByXPath("//a[@title='Show one more action']").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//a[@title='New']").click();
	
	//select account Name 
	Thread.sleep(20000);
	driver.findElementByXPath("//input[@title='Search Accounts']").click();
	driver.findElementByXPath("//*[text()='abinesh']").click();
	
	//select status as escalated
	Thread.sleep(1000);
	driver.findElementByXPath("(//input[@role='textbox'])[2]").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//label[text()='Status']/following-sibling::div//span[text()='Escalated']").click();
	//select Type as structural
	driver.findElementByXPath("(//a[text()='--None--'])[2]").click();
	driver.findElementByXPath("//a[text()='Structural']").click();
	
    //select save
	driver.findElementByXPath("//span[text()='Save']").click();
	System.out.println("saved");
	}

}
