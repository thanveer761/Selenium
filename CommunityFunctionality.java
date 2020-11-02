package steps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommunityFunctionality {
	public  ChromeDriver driver;
	
	@Given("open Chrome Browser")
		public void open_Chrome_Browser() {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
	}
	
	@Given("load the application url")
	public void load_the_application_url() {
		driver.get("https://login.salesforce.com");
	    
	}
	@Given("maximze the browser")
	public void maximze_the_browser() {
		driver.manage().window().maximize();
	    
	}

	@Given("apply implicit wait")
	public void apply_implicit_wait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    
	}
	     @And ("Enter the user name as (.*)")
		public void enterUserName(String data) {
			driver.findElementById("username").sendKeys(data);
		}
	     @And ("Enter the password as (.*)")
		public void enterPassword(String pwd) {
			driver.findElementById("password").sendKeys(pwd);
		}
	     @When("click on login button")
	     public void click_on_login_button() {
	    	 driver.findElementById("Login").click();
	     }
	     @When("click community on most recently used")
	     public void clikCommunity() throws InterruptedException {
	    	 Thread.sleep(2000);
	    		WebElement element = driver.findElementByXPath("//a[@class='setupLink']");
	    		Actions actions = new Actions(driver);
	    		actions.moveToElement(element).click().perform();
		}
	     @Then ("Print the Application Name and Developer Name for the App Type Lighting")
	     public void printAppNameandDevName() {
	    	 List<WebElement> appNames = driver.findElementsByXPath("//table//tbody//tr//th//span/span");
	    		List<WebElement> devNames= driver.findElementsByXPath("//table//tbody//tr//td[2]//span/span");
	    		List<WebElement> appTypes= driver.findElementsByXPath("//table//tbody//td[5]//span//div");
	    		for (int i = 1; i <appTypes.size(); i++) {
	    				System.out.println(appNames.get(i).getText()+" "+devNames.get(i).getText());
	    			}}
	     @When("Click on View Profile icon")
	     public void clickIcon() throws InterruptedException {
	    		Thread.sleep(2000);
	    		driver.findElementByXPath("//span[@data-aura-class='uiImage']").click();

		}
	     @When("Click on Switch to Salesforce Classic")
	     public void switchClassic() throws InterruptedException {
	    	 Thread.sleep(1000);
	    		driver.findElementByLinkText("Switch to Salesforce Classic").click();
		}
	     @When ("Click on Create New and Select Event")
	     public void createNew() throws InterruptedException {
	    	 Thread.sleep(5000);
	    		driver.findElementById("createNewButton").click();
	    		Thread.sleep(2000);
	    		driver.findElementByXPath("//div[@id='createNewMenu']//a[1]").click();
		}
	     @And("Enter subject as Call/Email/Meeting (.*)")
	     public void enter_subject_as_Call_Email_Meeting(String data) {
	    	 driver.findElementByXPath("//label[text()='Subject']/following::input").sendKeys(data);
	     }
	     
	     @And ("Enter Start date as tomorrow")
	     public void enterDateasTomorow() throws InterruptedException {
	    	 Date date = new Date(); 
	    		Calendar c = Calendar.getInstance(); 
	    		c.setTime(date); 
	    		c.add(Calendar.DATE, 1); 
	    		String strMonth = c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH); 
	    		System.out.println(strMonth); 
	    		String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(c.getTime()); 
	    		System.out.println(tommorowsDate);
	    		Thread.sleep(2000);
	    		driver.findElementByXPath("//span[@class='dateInput dateOnlyInput']//input").clear();
	    		driver.findElementByXPath("//span[@class='dateInput dateOnlyInput']//input").sendKeys(tommorowsDate);
		}
	     @And ("Enter End date as aftertomorrow")
	     public void AfterTomoroDate() throws InterruptedException {
	    	 Date Date = new Date(); 
	    		Calendar ca = Calendar.getInstance(); 
	    		ca.setTime(Date); 
	    		ca.add(Calendar.DATE, 2); 
	    		String strmonth = ca.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH); 
	    		System.out.println(strmonth); 
	    		String AftertomoroDate = new SimpleDateFormat("MM/dd/yyyy").format(ca.getTime()); 
	    		System.out.println(AftertomoroDate);
	    		Thread.sleep(2000);
	    		driver.findElementByXPath("(//span[@class='dateInput dateOnlyInput']//input)[3]").clear();
	    		Thread.sleep(2000);
	    		driver.findElementByXPath("(//span[@class='dateInput dateOnlyInput']//input)[3]").sendKeys(AftertomoroDate);
		}
	     @When ("click on Add invitees as Contact: Click on the LookUp icon")
	     public void clickLookUpIcon() {
	    	 driver.findElementByXPath("//img[@title='Name Lookup (New Window)']").click();
		}
	     @When ("Search for Sarath and select first result")
	     public void selectFirstResultAsSarath() throws InterruptedException {
	    	 Set<String> windowHandles = driver.getWindowHandles();
	    	 List<String> listHandles = new ArrayList<String>(windowHandles);
	    		String firstWin = listHandles.get(0);
	    		String title2 = driver.getTitle();
	    		System.out.println(title2);
	    		System.out.println(firstWin);
	    		String secondWin = listHandles.get(1);
	    		Thread.sleep(2000);
	    		driver.switchTo().window(secondWin);
	    		String title = driver.getTitle();
	    		System.out.println(title);
	    		driver.manage().window().maximize();
	    		Thread.sleep(2000);
	    		driver.switchTo().frame("searchFrame");
	    		driver.findElementByXPath("//label[text()='Search']/following-sibling::input").sendKeys("sarath");
	    		Thread.sleep(1000);
	    		driver.findElementByName("go").click();
	    		driver.switchTo().defaultContent();
	    		Thread.sleep(1000);
	    		driver.switchTo().frame("resultsFrame");
	    		driver.findElementByXPath("//table//tr//a").click();

		}
}
