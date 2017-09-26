package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public WebDriver driver;

	public static void captureScreenShot(WebDriver driver, String Screenshotname) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./ScreenShots/" + Screenshotname + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static String captureScreenShotWithLocation(WebDriver driver, String Screenshotname) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String dest = "./ScreenShots/" + Screenshotname + System.currentTimeMillis() + ".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Exception while taking Screenshot " + e.getMessage());
			return e.getMessage();
		}

		return dest;
	}

}