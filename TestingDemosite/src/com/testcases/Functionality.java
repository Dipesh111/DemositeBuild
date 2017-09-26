package com.testcases;

import org.testng.annotations.Test;

import supportingMethods.ReusableLibrary;
import utility.BaseClass;
import utility.ExcelData;

public class Functionality extends BaseClass {

	/*@Test(priority = 0, enabled = true)
	@Parameters({ "uname", "upass" })
	public void userLoginToApplication(String uname, String upass) {
		ln.login(uname, upass);
	}*/
	
	@Test(priority = 0, enabled = true)
	//@Parameters({ "uname", "upass" })
	public void userLoginToApplication() throws InterruptedException {
		test = extent.startTest("userLoginToApplication");
		ln.login(ExcelData.getData( 0, 0, 0), ExcelData.getData( 0, 0, 1));
	}

	/*@Test(priority = 1, enabled = false)
	public void activeLinkCheckup() {
		ReusableLibrary.TotalLinksWorking(driver);
	}*/

	@Test(priority = 1, enabled = true)
	// @Parameters({ "uname", "upass" })
	public void userIsAbleToPublishNewPost() throws InterruptedException {
		// ln.login(uname, upass);
		// Reporter.log("User logged in to an application successfully");
		//ReusableLibrary.waitForDisplay(driver, FunctionalityPage.posts);
		test = extent.startTest("userIsAbleToPublishNewPost");
		fn.addNewPost();
		fn.publishPost();
	}

	@Test(priority = 2, enabled = true)
	public void userIsAbleToViewPost() throws InterruptedException {
		test = extent.startTest("userIsAbleToViewPost");
		fn.viewPost();
		// driver.navigate().back();
		// Thread.sleep(2000);
	}

	@Test(priority = 3, enabled = true)
	public void userIsAbleToSavePost() {
		test = extent.startTest("userIsAbleToSavePost");
		fn.addPost();
		fn.savePost();
	}

	@Test(priority = 4, enabled = true)
	public void userIsAbleToPreviewPost() throws InterruptedException {
		test = extent.startTest("userIsAbleToPreviewPost");
		fn.preview();
		fn.preViewClick();
		
	}
	@Test(priority = 5, enabled = true)
	public void userIsAbleToPostComment() throws InterruptedException {
		test = extent.startTest("userIsAbleToPostComment");
		fn.addComments();
		fn.postComment();
	}

}
