package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.PreAndPost;

public class ServiceConsolePage extends PreAndPost {
	public ServiceConsolePage(EventFiringWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	public ServiceConsolePage clickUploadFile() throws InterruptedException {
		Thread.sleep(10000);
		click(locateElement("xpath", "//div[text()='Upload Files']"));
		return this;
	}
	public ServiceConsolePage uploadFiles() throws AWTException, InterruptedException {
		Thread.sleep(10000);
		StringSelection stringSelection = new StringSelection("C:\\Users\\Thanveer Ahmed\\Pictures\\Screenshots\\TV.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		return this;
	}
	public ServiceConsolePage finishDownload() throws InterruptedException {
		Thread.sleep(20000);
		click(locateElement("xpath", "//span[text()='Done']"));
		return this;
	}
	public ServiceConsolePage clickDropDownNewlyUploadedFile() throws InterruptedException {
		Thread.sleep(5000);
		click(locateElement("xpath", "//div[@data-aura-class='forceVirtualAction']/a"));
		return this;
	}
	public FileDetailsPage selectViewFileDetails() throws InterruptedException {
		Thread.sleep(5000);
		click(locateElement("xpath", "//a[@title='View File Details']"));
		return new FileDetailsPage(driver,test);
	}
	public ServiceConsolePage clickItemLink() throws InterruptedException {
		Thread.sleep(5000);
		click(locateElement("xpath", "(//div[@class='slds-truncate']//span)[1]"));
		return this;
	}
	public SharePage clickShare() throws InterruptedException {
		Thread.sleep(5000);
		click(locateElement("xpath", "//button[@title='Share']"));
		return new SharePage(driver,test);
		}
	public ServiceConsolePage clickDropDownforNewlyUploadedFile() throws InterruptedException {
		Thread.sleep(5000);
	click(locateElement("xpath", "//li[@class='oneActionsDropDown']//a"));
		return this;
	}
	public DeletePage  clickDelete() throws InterruptedException {
		Thread.sleep(2000);
		click(locateElement("xpath", "//a[@title='Delete']"));
		return new DeletePage(driver, test);
	}
	}
