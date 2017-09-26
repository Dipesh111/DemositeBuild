package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	static Properties pro;
	static String browser;

	public ConfigReader() {
		try {
			File src = new File("./Configuration/Config.property");
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (IOException e) {
			System.out.println("Error is ==" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static String getBrowser() {
		browser = pro.getProperty("browser");
		return browser;
	}

	public static String getUrl() {
		String url = pro.getProperty("App_url");
		return url;
	}
	public static String getUrl1() {
		String url = pro.getProperty("App_url1");
		return url;
	}

	public static String getChromePath() {
		String path = pro.getProperty("chromedriver_path");
		return path;
	}

	public static String getIEPath() {
		String path = pro.getProperty("iedriver_path");
		return path;
	}

	public static String getffPath() {
		String path = pro.getProperty("geckodriver_path");
		return path;
	}
	public static String getexcelPath() {
		String path = pro.getProperty("excel_path");
		return path;
	}

}
