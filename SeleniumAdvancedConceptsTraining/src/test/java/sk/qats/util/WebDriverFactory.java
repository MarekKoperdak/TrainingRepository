package sk.qats.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebDriverFactory {
	private static final Logger LOG = LoggerFactory.getLogger(WebDriverFactory.class);
	private static String CHROME_DRIVER_PATH = "C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	private static String HUB_URL = "http://10.2.1.32:4444";

	public static WebDriver createWebDriver(BrowserName browser, Boolean remoteExec) throws MalformedURLException {
		WebDriver driver;

		// LOG.debug("Test will be executed REMOTELY: '{}'", remoteExec);
		if (remoteExec) {
			driver = createRemoteDriver(browser);
		} else {
			driver = createLocalDriver(browser);
		}
		return driver;
	}

	private static WebDriver createLocalDriver(BrowserName browser) {
		String deviceName = "Desktop";

		WebDriver driver = null;
		switch (browser) {
		case CHROME:
			driver = createChromeDriver(deviceName);
			break;
		case IE:
			LOG.error("TODO: Need to be implemented");
			break;

		case FF:
			LOG.error("TODO: Need to be implemented");
			break;

		default:
			driver = createChromeDriver(deviceName);
			break;
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();

		return driver;
	}

	private static WebDriver createFireFoxDriver() {
		return new FirefoxDriver();
	}

	private static WebDriver createRemoteDriver(BrowserName browser) throws MalformedURLException {
//		String deviceName = "Desktop";
		LOG.info("Preparing REMOTE web driver with browser '{}'", browser);
		RemoteWebDriver driver = null;
		DesiredCapabilities capabilities = null;
		switch (browser) {
		case CHROME:
			capabilities = setCapabilities();
			break;
		case FF:
			// TODO
			LOG.error("TODO: Need to be implemented");
		case IE:
			// TODO
			LOG.error("TODO: Need to be implemented");

		default:
			// TODO
			LOG.error("TODO: Need to be implemented");
			break;
		}

		driver = new RemoteWebDriver(new URL(HUB_URL + "/wd/hub"), capabilities);
		// driver.manage().window().maximize();
		return driver;
	}

	private static WebDriver createChromeDriver(String deviceName) {
		File file = new File(CHROME_DRIVER_PATH);
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		DesiredCapabilities capabilities = setCapabilities();
		return new ChromeDriver(capabilities);
	}

	private static DesiredCapabilities setCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		return capabilities;
	}

}
