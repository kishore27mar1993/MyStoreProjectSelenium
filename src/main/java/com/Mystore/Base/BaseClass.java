package com.Mystore.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Mystore.ActionDrivers.Action;
import com.Mystore.utility.ExtentManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;

	@BeforeSuite(groups = { "Regression", "Sanity", "Smoke" })
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");

	}

	// Declare ThreadLocal Driver;
	// public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	// public static WebDriver geDriver() {
	// Get Driver from threadLocalMap
	// return driver.get();
	// }

	@BeforeTest(groups = { "Regression", "Sanity", "Smoke" })
	public void loadConfig() {
		try {
			prop = new Properties();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Downloads\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NONE);
			// Instantiate the chrome driver
			// driver = new ChromeDriver(options);

			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\ConfigurationFolder\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void launchApp() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
			// WebDriverManager.chromedriver().setup();
			// driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			// WebDriverManager.firefoxdriver().setup();
			// driver.set(new FirefoxDriver());
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			// WebDriverManager.iedriver().setup();
			// driver.set(new InternetExplorerDriver());

			driver = new InternetExplorerDriver();
		}
		Action.implicitWait(driver, 10);
		Action.pageLoadTimeOut(driver, 10);
		driver.get(prop.getProperty("url"));

	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
