package week1.day1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class LoginSalesforce {
public static void main(String[] args) {
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
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
//click sales
driver.findElementByXPath("//p[text()='Sales']").click();
//click opprtunities
WebElement ele = driver.findElementByXPath("//span[text()='Opportunities']");
JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", ele);

//clik new button
driver.findElementByXPath("//div[text()='New']").click();

//driver.findElementByXPath("//a[@class='datePicker-openIcon display']").click();

//select calendar
Date date = new Date(); 
Calendar c = Calendar.getInstance(); 

c.setTime(date); 
c.add(Calendar.DATE, 1); 

String strMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH); 
System.out.println(strMonth); 

String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime()); 
System.out.println(tommorowsDate);

//pass the tommorow date in calendar icon
driver.findElementByXPath("//input[@class=' input']").sendKeys(tommorowsDate);
driver.findElementByXPath("(//span[text()='Save'])[2]").click();
String text = driver.findElementByXPath("//li[text()='These required fields must be completed: Opportunity Name, Stage']").getText();
System.out.println(text);



//select calendar
/*driver.findElementByXPath("//input[@class=' input']").sendKeys("9/28/2020");
driver.findElementByXPath("(//span[text()='Save'])[2]").click();
String text = driver.findElementByXPath("//li[text()='These required fields must be completed: Opportunity Name, Stage']").getText();
System.out.println(text);*/
}
}
