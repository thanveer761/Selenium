package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSalesforce1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(options);
		
	driver.get("https://login.salesforce.com");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	//Login
	driver.findElementById("username").sendKeys("nupela@testleaf.com");
	driver.findElementById("password").sendKeys("Bootcamp$123");
	driver.findElementById("Login").click();
	//click tonggle
	driver.findElementByClassName("slds-icon-waffle").click();
	//clcik view all
	driver.findElementByXPath("//button[text()='View All']").click();
	
	//click Service Console from App launcher
		Thread.sleep(10000);
		driver.findElementByXPath("//p[text()='Service Console']").click();
		//select home from the dropdown
		driver.findElementByXPath("//button[@title='Show Navigation Menu']//lightning-primitive-icon[1]").click();
		//driver.findElementByXPath("")

	}

}
