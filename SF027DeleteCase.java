package week1.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SF027DeleteCase {
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

//click on your Name dropdown Button
Thread.sleep(30000);
driver.findElementByXPath("//*[@title='00001030']").click();

//click on delete
Thread.sleep(30000);
driver.findElementByXPath("//div[text()='Delete']").click();

//confirmation on delete( non-modal dialog alert)
WebElement element = driver.findElementByXPath("//span[text()='Delete']");
element.click();
System.out.println("Case got deleted successfully");
}
}
