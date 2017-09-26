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

public class FunctionalityPage extends BaseClass {
	
	@FindBy(xpath = "//li[@id='menu-posts']//a[contains(@class,'wp-has-submenu wp-not-current-submenu open-if-no-js menu-top menu-icon-post menu-top-first')]")
	public	static WebElement posts;
	@FindBy(xpath = "//div[@id='wpbody-content']//a[contains(@href,'post-new.php')]")	WebElement addNew;
	@FindBy(how = How.XPATH, using = "//*[@id='title']")	WebElement title;
	@FindBy(how = How.XPATH, using = "//*[@id='content']")	WebElement content;
	//div[@class='postarea']//textarea[contains(@name,'content')]
	//By content = By.xpath("//*[@id='content']");
	
	@FindBy(how = How.XPATH, using = "//*[@id='publish']")	WebElement publishbtn;
	@FindBy(how = How.XPATH, using = "//div[@id='message']//a[contains(text(),'View post')]")	WebElement viewPostLink;
	@FindBy(how = How.XPATH, using = "//div[@id='message']//p[text()='Post published. ']")	WebElement textOfPostPublished;

	@FindBy(how = How.XPATH, using = "//*[@id='save-post']")	WebElement saveDraftbtn;
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Preview post')]")	public static WebElement previewPostLink;
	By previewPostLink1 =By.xpath("//*[contains(text(),'Preview post')]");
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Post draft updated. ')]")	WebElement textOfPostDraftUpdated;
	By textOfPostDraftUpdated1 =By.xpath("//*[contains(text(),'Post draft updated. ')]");
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Comment')]")	WebElement commentsText;
	@FindBy(how = How.XPATH, using = "//*[@id='comment']")	WebElement comments;
	@FindBy(how = How.XPATH, using = "//*[@id='submit']")	WebElement postcomment;
	
		
	public void addNewPost() throws InterruptedException {
		posts.click();
		test.log(LogStatus.PASS, "User clicked on post menu");
		addNew.click();
		test.log(LogStatus.PASS, "User clicked on add new post link");
		title.sendKeys("Hello world");
		test.log(LogStatus.PASS, "User input title of the post");
		//ReusableLibrary.waitForDisplay(driver, content);
       // ReusableLibrary.waitAndInputData(driver, content, "This is my first post");
		//content.sendKeys("This is my first post");
		test.log(LogStatus.PASS, "User input content of the post");
		Reporter.log("Post is ready",true);
		}
	
	public void publishPost() {
		ReusableLibrary.waitFor(driver, publishbtn);
		test.log(LogStatus.PASS, "User clicked on publish button");
		Reporter.log("User clicks on publish Post button",true);
		Assert.assertTrue(textOfPostPublished.getText().contains("Post published"), "Checking Post Published message is displayed");
		test.log(LogStatus.PASS, "Post published test appeared on screen");
		Reporter.log("Post published",true);
	}
	public void viewPost() {
		Assert.assertTrue(textOfPostPublished.getText().contains("View post"), "Checking View post link appears on screen");
		test.log(LogStatus.PASS, "View post link appeared on screen");
		Reporter.log("User able to view  Post",true);
		//ReusableLibrary.waitFor(driver, viewPostLink);
		//Reporter.log("User clicks on viewPost link",true);
	}
	public void addPost() {
		addNew.click();
		test.log(LogStatus.PASS, "User clicked on add new post link");
		//title.sendKeys("Hello world");
		ReusableLibrary.waitAndInputData(driver, title, "Hieeee");
		test.log(LogStatus.PASS, "User input the title of the post");
		//ReusableLibrary.waitAndInputData(driver, content, "i am new here");
		//content.sendKeys("This is my first post");
		test.log(LogStatus.PASS, "User input the content of the post");
		Reporter.log("Post is ready", true);
		}
	public void savePost() {
		//saveDraftbtn.click();
		ReusableLibrary.waitFor(driver, saveDraftbtn);
		test.log(LogStatus.PASS, "User clicked save button");
		Reporter.log("User clicks on save post link",true);
		ReusableLibrary.waitForDisplay(driver, textOfPostDraftUpdated1);
		//System.out.println(textOfPostDraftUpdated.getText());
		Assert.assertTrue(textOfPostDraftUpdated.getText().contains("Post draft updated. Preview post"), "Checking Post draft updated appears on screen");
		test.log(LogStatus.PASS, "Post draft updated appeared on screen");
		Reporter.log("user saved the post",true);
		
	}
	public void preview() throws InterruptedException {
		Assert.assertTrue(previewPostLink.getText().contains("Preview post"), "Checking Preview post appears on screen");
		test.log(LogStatus.PASS, "Preview post appeared on screen");
		//ReusableLibrary.handleWindow(driver, previewPostLink1);
	}
	public void preViewClick() throws InterruptedException {
		ReusableLibrary.handleWindow(driver, previewPostLink1);
		//previewPostLink.click();
		test.log(LogStatus.PASS, "User clicked on preview post link");
		Reporter.log("User clicks on preview Post link",true);
	}
	public void addComments() throws InterruptedException {
		Assert.assertTrue(commentsText.getText().contains("Comment"), "Checking comment appears on screen");
		test.log(LogStatus.PASS, "Comment text appeared on screen");
		comments.sendKeys("Checked");
		test.log(LogStatus.PASS, "User entered comments");
		Reporter.log("User inputs comments",true);
	}
	public void postComment(){
		postcomment.click();
		test.log(LogStatus.PASS, "User successfully posted comments");
	}
}
