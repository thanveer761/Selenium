package week3.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC010_DeleteEvent {
	
	public static void main(String[] args) throws InterruptedException {

		//disable Chrome notifications
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//get driver
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

//		Authentication
		driver.findElementById("username").sendKeys("dhivya@testleaf.com");
		driver.findElementById("password").sendKeys("India@123");
		driver.findElementById("Login").click();
Thread.sleep(10000);
		driver.findElementByClassName("slds-icon-waffle").click();
		
		//click view all
		driver.findElementByXPath("//button[text()='View All']").click();

		//click sales
		driver.findElementByXPath("//p[text()='Sales']").click();
		
		Thread.sleep(10000);
		WebElement element = driver.findElementByXPath("//span[text()='More']");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
		WebElement ele = driver.findElementByXPath("//span[text()='Calendar']");
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		exe.executeScript("arguments[0].click();", ele);
		Thread.sleep(10000);
		new Actions(driver).moveToElement(driver.findElement(By.className("timeData"))).perform();
		
		//driver.findElement(By.xpath("//div[@data-aura-rendered-by='2295:0']")).click();
		
		driver.findElement(By.xpath("//div[@title='Delete']")).click();
		
		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();
		
		String eventemailwas = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		
		System.out.println(eventemailwas);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


}
