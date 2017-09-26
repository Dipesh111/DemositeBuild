package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;
import pages.FunctionalityPage;
import pages.UserLoginPage;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriverWait wait;
	public static Actions builder;
	public static UserLoginPage ln;
	public static FunctionalityPage fn;
	//final String filePath = "C:\\Temp\\Regression.html";
	final String filePath = "./Report/Regression.html";

	@BeforeSuite
	public void reportSetUp() {
		extent = new ExtentReports(filePath, true, NetworkMode.ONLINE);
		extent.addSystemInfo("Selenium Version", "3.4.0");
		extent.addSystemInfo("Environment", "Pre-Prod");
		// test = extent.startTest("reportsetUp");
	}

	@BeforeTest
	public void SetUp() {
		new ConfigReader();
		new ExcelData(ConfigReader.getexcelPath());
		Reporter.log("=====Initializing Browser=====", true);
		System.setProperty("webdriver.chrome.driver", ConfigReader.getChromePath());
		driver = new ChromeDriver();
		// test.log(LogStatus.INFO, "Browser session started");
		Reporter.log("=====Browser Session Started=====", true);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ConfigReader.getUrl1());
		// test.log(LogStatus.INFO, "Application started");
		wait = new WebDriverWait(driver,100);
		builder = new Actions(driver);
		ln = PageFactory.initElements(driver, UserLoginPage.class);
		fn = PageFactory.initElements(driver, FunctionalityPage.class);
	}
	 @AfterMethod
	    protected void afterMethod(ITestResult result) {
	        if (result.getStatus() == ITestResult.FAILURE) {
	            test.log(LogStatus.FAIL, result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
	        } else {
	            test.log(LogStatus.PASS, "Test passed");
	        }
	        
	        // extent.endTest(test);        
	        //extent.flush();
	    }
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		// test.log(LogStatus.INFO, "Browser session ended");
		Reporter.log("=====Browser Session Ended=====", true);
		extent.endTest(test);
		extent.flush();
		// driver.get("C:\\Report\\LearnAutomation.html");
		driver.quit();
	}

}
