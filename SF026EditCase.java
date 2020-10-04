package week1.day1;

import java.awt.Window;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SF026EditCase {

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
	//Thread.sleep(10000);
	wait.until(ExpectedConditions.visibilityOf(driver.findElementByClassName("slds-icon-waffle"))).click();
	//click view all
	driver.findElementByXPath("//button[text()='View All']").click();

	//click sales
	driver.findElementByXPath("//p[text()='Sales']").click();
	
	//click on Cases tab
	Thread.sleep(20000);
	driver.findElementByXPath("//span[text()='More']").click();
	Thread.sleep(10000);
	WebElement ele = driver.findElementByXPath("(//span[text()='Cases'])[2]");
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", ele);

	//click on your Name dropdown Button
	Thread.sleep(20000);
	driver.findElementByXPath("//*[@title='00001031']").click();
	Thread.sleep(10000);
	driver.findElementByXPath("//div[text()='Edit']").click();
	
	//update status as working
	Thread.sleep(10000);
    driver.findElementByXPath("(//input[@role='textbox'])[2]").click();
	//driver.findElementByXPath("//label[text()='Status']/following::input").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//label[text()='Status']/following-sibling::div//span[text()='Working']").click();
	//driver.findElementByXPath("//label[text()='Status']/following::input").click();
	//driver.findElementByXPath("//*[text()='Working']").click();
	
	//update priority to low
	driver.findElementByXPath("//a[@class='select']").click();
	driver.findElementByXPath("//a[text()='Low']").click();
	
	//update SLA vilation as NO
	//driver.findElementByXPath("(//span[text()='SLA Violation'])[2]").click();
	Thread.sleep(10000);
	driver.findElementByXPath("(//a[text()='--None--'])[6]").click();
	driver.findElementByXPath("//a[text()='No']").click();

	//update case origin as phone
	driver.findElementByXPath("(//a[@class='select'])[3]").click();
	driver.findElementByXPath("//a[@title='Phone']").click();
	
	//update save and verify status as working
	driver.findElementByXPath("(//span[text()='Save'])[2]").click();
	
	//Verification status
	Thread.sleep(10000);
	 String status = driver.findElementByXPath("(//lightning-formatted-text[text()='Working'])[2]").getText();
	if (status.contains("Working")) {
		System.out.println("status is working");
		
	}else {
		System.out.println("status is not workng");
	}


	}

}
