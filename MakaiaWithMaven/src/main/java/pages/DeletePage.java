package pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class DeletePage extends PreAndPost{
	public DeletePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	public DeletePage confirmDeletePage() throws InterruptedException {
		Thread.sleep(2000);
		click(locateElement("xpath", "//span[text()='Delete']"));
		return this;
	}
	
	public ServiceConsolePage VerifyDeleteMsg() {
		String text = getText(locateElement("xpath","//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		System.out.println(text);
		return new ServiceConsolePage(driver,test);
	}
}
