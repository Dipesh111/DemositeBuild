package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	public static WebDriver driver;

	public static WebDriver startBrowser(String Browser) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ConfigReader.getChromePath());
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ConfigReader.getIEPath());
			driver = new InternetExplorerDriver();
		} else if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.ghecko.driver", ConfigReader.getffPath());
			driver = new FirefoxDriver();
		} else {
			System.out.println("couldn't find the driver");
		}
		return driver;
	}
}
