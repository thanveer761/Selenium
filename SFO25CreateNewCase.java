package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO25CreateNewCase {

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
	
	//click login
	driver.findElementById("username").sendKeys("nupela@testleaf.com");
	driver.findElementById("password").sendKeys("Bootcamp$123");
	driver.findElementById("Login").click();
	
	//click global actions svg icon

	Thread.sleep(30000);
	
	WebElement element = driver.findElementByXPath("//*[@data-key='add']");
	element.click();
	
	//click newCase
	//Thread.sleep(10000);
	 driver.findElementByXPath("//span[text()='New Case']").click();

   //click contact name
	Thread.sleep(10000);
	driver.findElementByXPath("//input[@title='Search Contacts']").click();
	 driver.findElementByXPath("//div[text()='Naveen Elumalai']").click();
	 

//choose dropDown status as escalated
	 driver.findElementByXPath("//*[text()='New']").click();
driver.findElementByXPath("//a[@title='Escalated']").click();

//enter subject  as testing
driver.findElementByXPath("//span[text()='Subject']/following::input").sendKeys("testing");

//enter description as dummy
driver.findElementByXPath("//span[text()='Description']/following::textarea").sendKeys("dummy");

//click save
driver.findElementByXPath("(//span[text()='Save'])[2]").click();

System.out.println("new case created"

	}

}
