package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class FileDetailsPage extends PreAndPost {
	public FileDetailsPage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	public FileDetailsPage VerifyFileNameandExtension() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement("xpath","//span[text()='Details']"));
		String fileName = getText(locateElement("xpath","//span[contains(@class,'test-id__field-value slds-form-element__static')]//span"));
		System.out.println(fileName);
		String fileExtension = getText(locateElement("xpath","//span[@title='File Extension']/following::span"));
		System.out.println(fileExtension);
		Assert.assertEquals(fileName, "TV");
		Assert.assertEquals(fileExtension, "png");
		return this;
	}
	public ServiceConsolePage closeFileWindow() throws InterruptedException {
		Thread.sleep(10000);
		click(locateElement("xpath", "//button[@title='Close TV']//lightning-primitive-icon[1]"));
		return new ServiceConsolePage(driver,test);
	}
}
