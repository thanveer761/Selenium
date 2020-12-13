package testcases;

import java.awt.AWTException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.LoginPage;

public class TC001 extends PreAndPost{
	
	@BeforeTest
	public void setData() {
		testCaseName = "TC001";
		testDescription = "Salesforce";
		authors = "Thanveer";
		category = "smoke";
		nodes = "Salesforce";
	}
		
	@Test
	public void login() throws AWTException, InterruptedException {
		new LoginPage(driver, test)
		.typeUserName("nupela@testleaf.com")
		.typePassword("Bootcamp$123")
		.clickLogIn()
		.clickAppLauncer()
		.clickViewAll().clickServiceConsole().clickUploadFile().uploadFiles().finishDownload().clickDropDownNewlyUploadedFile().selectViewFileDetails()
		.VerifyFileNameandExtension().closeFileWindow().clickItemLink().clickShare().clickSearchUserandSelectDerick()
		.VerifyErrorMsg().clickCancelButton().clickDropDownforNewlyUploadedFile().clickDelete().confirmDeletePage().VerifyDeleteMsg();
	}} 
//https://github.com/thanveer761/Selenium.git