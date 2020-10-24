package week4.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO107_LeadsScenario {

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
			//click sales
			Thread.sleep(5000);
			driver.findElementByXPath("//p[text()='Sales']").click();
			//click lead Button
			Thread.sleep(5000);
			WebElement ele = driver.findElementByXPath("//span[text()='Leads']");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", ele);
			//click on new Button
			Thread.sleep(5000);
			driver.findElementByXPath("//div[@title='New']").click();
			//select Mr
			Thread.sleep(10000);
			driver.findElementByXPath("//a[text()='--None--']").click();
			driver.findElementByXPath("//a[@title='Mr.']").click();
			//click first and last name as allen
			driver.findElementByXPath("//input[@placeholder='First Name']").sendKeys("James");
            driver.findElementByXPath("//input[@placeholder='Last Name']").sendKeys("Allen");
            //give company Name as ABC
            driver.findElementByXPath("(//input[@class=' input'])[3]").sendKeys("ABC");
            //give Title as Buisness Analyst
            driver.findElementByXPath("(//span[text()='Title'])[2]/following::input").sendKeys("Buisness Analyst");
            //give Phone number
            driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys("123456789");
            //give Email
            driver.findElementByXPath("//input[@inputmode='email']").sendKeys("abc@gmail.com");
            //clik save
            driver.findElementByXPath("(//span[text()='Save'])[2]/..").click();
            
            //verification of james allen created
            Thread.sleep(5000);
            WebDriverWait wai = new WebDriverWait(driver, 20);
            String text = wai.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//span[text()='Lead']"))).getText();
            System.out.println(text);
            if (text.contains("James Allen")) {
				System.out.println("lead created");
			}else {
				System.out.println("not Created");
			}
            //click new Case Button
            Thread.sleep(2000);
            driver.findElementByXPath("//button[text()='New Case']").click();
            //clik contatcts and select James Allen
            driver.findElementByXPath("//input[@placeholder='Search Contacts...']").click();
            driver.findElementByXPath("//div[@title='James Allen']").click();
            //enter subject as sales report issue
            driver.findElementByXPath("//span[text()='Subject']/following::input").sendKeys("Sales report issue");
            //clcik save
            driver.findElementByXPath("(//span[text()='Save'])[3]").click();
            //verification of case has created
            Thread.sleep(2000);
            String text2 = wai.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@data-key='success']"))).getText();
            System.out.println(text2);
            if (text2.contains("Case 00001049 was created")) {
				System.out.println("case got created");
			}else {
				System.out.println("case not got created");
			}
            Thread.sleep(2000);
            driver.findElementByXPath("//button[text()='New Note']").click();
            //give title as sales report
            Thread.sleep(2000);
            driver.findElementByXPath("//span[text()='*']/following::input").sendKeys("sales report");
            //clik sale
            driver.findElementByXPath("(//span[text()='Save'])[3]").click();
            Thread.sleep(3000);
            String text3 = wai.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@data-key='success']"))).getText();
            System.out.println(text3);
            if (text3.contains("Note sales report was created")) {
				System.out.println("sales report created");
			}else {
				System.out.println("sales report not created");
			}
            //click leads button
            Thread.sleep(10000);
            WebElement elem = driver.findElementByXPath("//span[text()='Leads']");
			JavascriptExecutor exec = (JavascriptExecutor)driver;
			exec.executeScript("arguments[0].click();", elem);
			Thread.sleep(2000);
			//clik check box
			Thread.sleep(2000);
			driver.findElementByXPath("(//input[@type='checkbox']/following-sibling::span)[3]").click();
			//clik change status
			driver.findElementByXPath("//div[@title='Change Status']").click();
			//select status as working contacted
			Thread.sleep(3000);
			driver.findElementByXPath("//a[text()='Open - Not Contacted']").click();
			driver.findElementByXPath("(//a[@title='Working - Contacted'])[2]").click();
			//clik save
			driver.findElementByXPath("(//span[text()='Save'])[2]/..").click();
			//verification of lead status
			String text4 = driver.findElementByXPath("//table//td[8]//span/span").getText();
			System.out.println(text4);
	if (text4.contains("Working - Contacted")) {
		System.out.println("lead changed");
	}else {
		System.out.println("remains not changed");
	}
	//clik check box
	Thread.sleep(2000);
	driver.findElementByXPath("(//input[@type='checkbox']/following-sibling::span)[3]").click();
	//clik edit button
	driver.findElementByXPath("(//*[@data-key='down'])[8]/..").click();
	driver.findElementByXPath("//a[@title='Edit']").click();
	//clik lead source as web
	Thread.sleep(3000);
	driver.findElementByXPath("(//a[@class='select'])[2]").click();
	Thread.sleep(5000);
	driver.findElementByXPath("//a[@title='Web']").click();
	//clik save
	driver.findElementByXPath("(//span[text()='Save'])[2]").click();
	//clik james allen and verify the updated changes
	Thread.sleep(5000);
	driver.findElementByXPath("//table//th//span//a").click();
	//clik details tab
	Thread.sleep(2000);
	driver.findElementByXPath("//a[@data-label='Details']").click();
	//verificaton of details tab
	String text5 = driver.findElementByXPath("(//slot[@name='outputField']//lightning-formatted-text)[3]").getText();
	System.out.println(text5);
	if (text5.contains("Web")) {
		System.out.println("Details tab updated");
	}else {
		System.out.println("not updated");
	}
	 //click leads button
    Thread.sleep(3000);
    WebElement eleme = driver.findElementByXPath("//span[text()='Leads']");
	JavascriptExecutor exe = (JavascriptExecutor)driver;
	exe.executeScript("arguments[0].click();", eleme);
	//clik Add to campaign
	Thread.sleep(3000);
	driver.findElementByXPath("(//input[@type='checkbox']/following-sibling::span)[3]").click();
	Thread.sleep(1000);
	driver.findElementByXPath("//div[@title='Add to Campaign']").click();
	//select first resulting contact name
	driver.findElementByXPath("//input[@title='Search Campaigns']").click();
	driver.findElementByXPath("//div[@title='Bootcamp_5']").click();
	//clik submit
	driver.findElementByXPath("//span[text()='Submit']").click();
	//verifcation 
	String text6 = wai.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@data-key='success']"))).getText();
    System.out.println(text6);
    if (text6.contains("Bootcamp was successfully added")) {
		System.out.println("passed");
	}else {
		System.out.println("failed");
	}
  //clik james allen and verify the upddate Add-campaignchanges
  	Thread.sleep(5000);
  	driver.findElementByXPath("//table//th//span//a").click();
  	Thread.sleep(2000);
  	String text7 = driver.findElementByXPath("(//a[@data-navigable='true'])[2]").getText();
  	System.out.println(text7);
  	if (text7.contains("Bootcamp_5")) {
		System.out.println("Add-Campaign verified");
	}else {
		System.out.println("Add-Campaign not verified");
	}
}
}