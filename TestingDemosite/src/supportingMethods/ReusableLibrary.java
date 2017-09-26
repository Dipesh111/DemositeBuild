package supportingMethods;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.relevantcodes.extentreports.LogStatus;
import utility.BaseClass;

public class ReusableLibrary extends BaseClass {
	// To perform mouse actions
	WebDriver driver;
	public ReusableLibrary(WebDriver driver ){
		this.driver=driver;
	}
	
	public static void mouserOver(WebDriver driver, WebElement ele0, WebElement ele1) {
		try {
			builder.moveToElement(ele0).click(ele1).build().perform();
			test.log(LogStatus.PASS, "User clicked on log out");
		} catch (Exception e) {
			System.out.println("unable to find an element for mouse houring");
			test.log(LogStatus.FAIL, "user is unable to click the mouse on desired element");
			e.getMessage();
		}
	}

	public static void waitFor(WebDriver driver, WebElement ele0) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele0));
			ele0.click();
		} catch (Exception e) {
			System.out.println("unable to click an element");
			test.log(LogStatus.FAIL, "user is unable to input the data");
			e.getMessage();
		}
	}

	public static boolean fieldEnabled(WebDriver driver, WebElement ele0) {
		try {
			if (driver.findElement((By) ele0).isEnabled()) {
				System.out.println("Element is enabled");
				return true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("Element is not enabled");
		}
		return false;
	}

	public static void waitAndInputData(WebDriver driver, WebElement ele0, String msg) {
		//fieldEnabled(driver, ele0);
		try {
			wait.until(ExpectedConditions.visibilityOf(ele0));
			ele0.sendKeys(msg);
		} catch (Exception e) {
			System.out.println("unable to input the data");
			test.log(LogStatus.FAIL, "user is unable to input the data");
			e.getMessage();
		}
	}
	public static void waitAndInputData(WebDriver driver, By ele0, String msg) {
		//fieldEnabled(driver, ele0);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele0));
			((WebElement) ele0).sendKeys(msg);
		} catch (Exception e) {
			System.out.println("unable to input the data");
			test.log(LogStatus.FAIL, "user is unable to input the data");
			e.getMessage();
		}
	}

	public static void waitForDisplay(WebDriver driver, WebElement ele0) {
		try {
			wait.until(ExpectedConditions.visibilityOf(ele0));
			//wait.until(ExpectedConditions.visibilityOfElementLocated((By) ele0));
			test.log(LogStatus.PASS, "user is able to view the desired element");
		} catch (Exception e) {
			System.out.println("unable to view an element"+ele0.getText());
			test.log(LogStatus.FAIL, "user is unable to view an element "+ele0.getText());
			e.getMessage();
		}
	}
	public static void waitForDisplay(WebDriver driver, By ele0) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele0));
			test.log(LogStatus.PASS, "user is able to view the desired element");
		} catch (Exception e) {
			System.out.println("unable to view an element");
			test.log(LogStatus.FAIL, "user is unable to view an element ");
			e.getMessage();
		}
	}

	public static void TotalLinksWorking(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total available links are :" + links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			verifyActiveLinks(url);
		}
	}

	public static void verifyActiveLinks(String linkURL) {
		try {
			URL url = new URL(linkURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				System.out.println(linkURL + " " + connection.getResponseMessage());
			}
			
			if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(
						linkURL + " " + connection.getResponseMessage() + "-" + HttpURLConnection.HTTP_NOT_FOUND);
			}
			if (connection.getResponseCode() == HttpURLConnection.HTTP_BAD_GATEWAY) {
				System.out.println(
						linkURL + " " + connection.getResponseMessage() + "-" + HttpURLConnection.HTTP_BAD_GATEWAY);
			}
			if (connection.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST) {
				System.out.println(
						linkURL + " " + connection.getResponseMessage() + "-" + HttpURLConnection.HTTP_BAD_REQUEST);
			}
			if (connection.getResponseCode() == HttpURLConnection.HTTP_FORBIDDEN) {
				System.out.println(
						linkURL + " " + connection.getResponseMessage() + "-" + HttpURLConnection.HTTP_FORBIDDEN);
			}
		} catch (Exception e) {
			System.out.println("Error occured duruing URL checking Process");
			test.log(LogStatus.FAIL, "Failure occured during URL checking process");
		}
	}
	public static void handleWindow(WebDriver driver, WebElement ele0) throws InterruptedException {
		try {
			driver=driver;
			String parent_window = driver.getWindowHandle();
			System.out.println("Before Switching title is :" + driver.getTitle());
			driver.findElement((By) ele0).click();
			test.log(LogStatus.PASS, "User clicked on preview post link");
			Set<String> s = driver.getWindowHandles();
			java.util.Iterator<String> itr = s.iterator();
			while (itr.hasNext()) {
				String child_window = itr.next();
				if (parent_window != child_window) {
					driver.switchTo().window(child_window);
					System.out.println("After Switching title is :" + driver.getTitle());
					Thread.sleep(2000);
				}
			}
		} catch (Exception e) {
			System.out.println("unable to handle the window");
			test.log(LogStatus.FAIL, "user is unable to View the child window");
			e.getMessage();
		}
	}public static void handleWindow(WebDriver driver, By ele0) throws InterruptedException {
		try {
			driver=driver;
			String parent_window = driver.getWindowHandle();
			System.out.println("Before Switching title is :" + driver.getTitle());
			driver.findElement(ele0).click();
			Set<String> s = driver.getWindowHandles();
			java.util.Iterator<String> itr = s.iterator();
			while (itr.hasNext()) {
				String child_window = itr.next();
				if (parent_window != child_window) {
					driver.switchTo().window(child_window);
					System.out.println("After Switching title is :" + driver.getTitle());
					Thread.sleep(2000);
				}
			}
		} catch (Exception e) {
			System.out.println("unable to handle the window");
			test.log(LogStatus.FAIL, "user is unable to View the child window");
			e.getMessage();
		}
	}

}
