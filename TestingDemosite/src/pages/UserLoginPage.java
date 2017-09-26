package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

import supportingMethods.ReusableLibrary;
import utility.BaseClass;

public class UserLoginPage extends BaseClass {
	
	

	@FindBy(id = "user_login")	WebElement username;
	By username1 =By.id("user_login");
	@FindBy(id = "user_pass")	WebElement password;
	By password1 =By.id("user_pass");
	@FindBy(how = How.ID, using = "wp-submit")	WebElement logInbtn;
	@FindBy(how = How.XPATH, using = "//img[contains(@class,'avatar avatar-16 photo')]") WebElement admin;	
	@FindBy(how = How.XPATH, using = "//ul[@id='wp-admin-bar-user-actions']//following::li[3]//a[contains(text(),'Log Out')]") WebElement logout;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'	You are now logged out.')]") WebElement logoutMessage;
	
	
	public void enterUsername(String uname) {
		try {
			username.sendKeys(uname);
		} catch (Exception e) {
			System.out.println("Unable to find an element username");
		}
	}
	public void enterPassword(String upass) {
		try {
			password.sendKeys(upass);
		} catch (Exception e) {
			System.out.println("Unable to find an element password");
		}
	}
	public void clickOnLogin() {
		try {
			logInbtn.click();
		} catch (Exception e) {
			System.out.println("Unable to find an element loginbtn");
		}
	}
    public void login(String uname , String upass) throws InterruptedException {
    	ReusableLibrary.waitForDisplay(driver, username);
		username.clear();
		username.sendKeys(uname);
		test.log(LogStatus.PASS, "User entered username");
		Reporter.log("Username entered",true);
     	ReusableLibrary.waitForDisplay(driver, password);
		password.clear();
		password.sendKeys(upass);
		test.log(LogStatus.PASS, "User entered password");
		Reporter.log("password entered", true);
		logInbtn.click();
		test.log(LogStatus.PASS, "User clicked on login button");
		Reporter.log("Login button clicked", true);
		Thread.sleep(1000);
	}

	public void logOut() throws InterruptedException {
		ReusableLibrary.mouserOver(driver, admin, logout);
		test.log(LogStatus.PASS, "User logged out of an application");
		Reporter.log("User has logged Out of an Application",true);
		Assert.assertTrue(logoutMessage.getText().contains("You are now logged out."),"User logout confirmation message");
		test.log(LogStatus.PASS, "User is able to see "+"You are now logged out."+" confirmation message");
		Reporter.log("User has seen logout confirmation message from an Application",true);
		Thread.sleep(1000);
	}
}
