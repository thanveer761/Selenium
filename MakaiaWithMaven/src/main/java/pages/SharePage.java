package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class SharePage extends PreAndPost{
	public SharePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	public SharePage clickSearchUserandSelectDerick() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath", "//input[@title='Search People']"));
		Thread.sleep(2000);
		click(locateElement("xpath", "//div[text()='Derrick Dsouza']"));
		return this;
	}
	
	public SharePage VerifyErrorMsg() {
		String Errormsg	= getText(locateElement("xpath", "//li[@class='form-element__help']"));
		System.out.println(Errormsg);
		Assert.assertEquals(Errormsg, "Can't share file with the file owner.");
return this;
	}
	public ServiceConsolePage clickCancelButton() throws InterruptedException {
		Thread.sleep(10000);
		click(locateElement("xpath", "(//span[text()='Cancel'])[2]"));
		Thread.sleep(5000);
		click(locateElement("xpath", "//button[@title='Close']"));
		return new ServiceConsolePage(driver,test);
	}
}
