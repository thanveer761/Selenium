package week1.day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SFO25CreateNewCase {
	
public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		FirefoxOptions options_firfox = new FirefoxOptions();
		options_firfox.setProfile(new FirefoxProfile());
		options_firfox.addPreference("dom.webnotifications.enabled", false);
        WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(options_firfox);
		
		//launch Url
	driver.get("https://login.salesforce.com");
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, 20);
	
	//click login
	driver.findElement(By.id("username")).sendKeys("nupela@testleaf.com");
	driver.findElement(By.id("password")).sendKeys("Bootcamp$123");
	driver.findElement(By.id("Login")).click();
	
	//click global actions svg icon

	Thread.sleep(30000);
	WebElement element = driver.findElement(By.xpath("//*[@data-key='add']"));
	//WebElement element = driver.findElementByXPath("//*[@data-key='add']");
	element.click();
	
	//click newCase
	//Thread.sleep(10000);
	driver.findElement(By.xpath("//span[text()='New Case']")).click();

   //click contact name
	Thread.sleep(10000);
	// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//div[text()='Naveen Elumalai']")).click();
	 

//choose dropDown status as escalated
	 driver.findElement(By.xpath("//*[text()='New']")).click();
driver.findElement(By.xpath("//a[@title='Escalated']")).click();

//enter subject  as testing
driver.findElement(By.xpath("//span[text()='Subject']/following::input")).sendKeys("testing");

//enter description as dummy
driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys("dummy");

//click save
driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

System.out.println("new case created");
	}

}
