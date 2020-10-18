package week4.day1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clone {

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
//click Content tab
	Thread.sleep(5000);
	driver.findElementByXPath("//p[text()='Content']").click();
	//click view All
	driver.findElementByXPath("(//span[text()='View All'])[2]").click();
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@data-key='chevrondown']").click();
	Thread.sleep(2000);
	WebElement ele = driver.findElementByXPath("(//span[@class='slds-truncate']//span)[2]");
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", ele);
	//select table view
	Thread.sleep(10000);
driver.findElementByXPath("//*[@data-key='side_list']/..").click();
driver.findElementByXPath("//li[@title='Table']//a[1]").click();
//click settings icon and click clone
Thread.sleep(2000);
driver.findElementByXPath("//*[@data-key='settings']/..").click();
Thread.sleep(1000);
driver.findElementByXPath("(//a[@role='menuitem'])[2]").click();
//enter name as New open tasks and New_Open Tasks
Thread.sleep(5000);
driver.findElementByXPath("(//input[@type='text'])[3]").clear();
driver.findElementByXPath("(//input[@type='text'])[3]").sendKeys("New Today6 Tasks");
driver.findElementByXPath("(//input[@type='text'])[4]").clear();
driver.findElementByXPath("(//input[@type='text'])[4]").sendKeys("New_Today6_Tasks");
//click All users can see this list view
Thread.sleep(2000);
driver.findElementByXPath("(//span[@class='slds-radio_faux'])[2]").click();
//clik save
driver.findElementByXPath("(//span[text()='Save'])[2]").click();
//verification
Thread.sleep(5000);
Map<String, String> todayTask = new LinkedHashMap();

String subject = "";
String name = "";
for (int i = 1; i <=1; i++) {
	subject = driver.findElementByXPath("//table//th//span//a").getText();
	name= driver.findElementByXPath("//table//td//span//a").getText();
	todayTask.put(subject, name);
}
for(Entry<String, String>each : todayTask.entrySet()) {
	System.out.println(each.getKey()+" "+each.getValue());
}
Thread.sleep(5000);
driver.findElementByXPath("//*[@data-key='chevrondown']").click();
Thread.sleep(2000);
WebElement elem = driver.findElementByXPath("//span[text()='New Today Tasks']");
JavascriptExecutor exec = (JavascriptExecutor)driver;
exec.executeScript("arguments[0].click();", elem);
Thread.sleep(1000);
Map<String, String> newtodayTask = new LinkedHashMap();

String sub = "";
String nam = "";
for (int i = 1; i <=1; i++) {
	sub = driver.findElementByXPath("//table//th//span//a").getText();
	nam= driver.findElementByXPath("//table//td//span//a").getText();
	newtodayTask.put(sub, nam);
}
for(Entry<String, String>eachkey : newtodayTask.entrySet()) {
	System.out.println(eachkey.getKey()+" "+eachkey.getValue());
	
	if (todayTask.equals(newtodayTask)) {
		System.out.println("Both are same");
	}else {
		System.out.println("Not same");
	}
}
	}

}
