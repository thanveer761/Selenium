package week5.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateNewCase extends BaseClass {
	@BeforeTest
	public void setFile() {
		excelName = "passsendkeys";
	}
	@Test(dataProvider="fetchData")
public void createCase(String subject, String description) throws InterruptedException {
	Thread.sleep(30000);
	WebElement element = driver.findElement(By.xpath("//*[@data-key='add']"));
	//WebElement element = driver.findElementByXPath("//*[@data-key='add']");
	element.click();
	
	//click newCase
	Thread.sleep(10000);
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
driver.findElement(By.xpath("//span[text()='Subject']/following::input")).sendKeys(subject);

//enter description as dummy
driver.findElement(By.xpath("//span[text()='Description']/following::textarea")).sendKeys(description);

//click save
driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();

System.out.println("new case created");

}
}
