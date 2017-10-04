package sk.qats.distributed;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import sk.qats.util.BrowserName;
import sk.qats.util.Util;
import sk.qats.util.WebDriverFactory;

public class SimpleWebDriverTestClass1 {

	static final Logger LOG = LoggerFactory.getLogger(SimpleWebDriverTestClass1.class);
	public WebDriver driver;

	@BeforeTest
	public void beforeTest() {
		long id = Thread.currentThread().getId();
		LOG.info("Class1 - Before test. Thread id is: " + id);
	}

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		LOG.info("Class1 - Before test-class. Thread id is: " + id);
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		long id = Thread.currentThread().getId();
		LOG.info("Class1 - Before method. Thread id is: " + id);
		driver = WebDriverFactory.createWebDriver(BrowserName.CHROME, false);
		LOG.debug("Driver : " + driver);
	}

	@AfterMethod
	public void afterMethod() {
		long id = Thread.currentThread().getId();
//		driver.close();
		driver.quit();
		LOG.info("Class1 - After method. Thread id is: " + id);
	}

	@Test
	public void test3() throws InterruptedException {
		LOG.info("Class1 - Test 3 is running ...");
		LOG.debug("Driver : " + driver);
		driver.get("http://hnonline.sk");
		Util.randomSleep();
		LOG.info("Class1 - Test 3 is done!");
	}

	@Test
	public void test2() throws InterruptedException {
		LOG.info("Class1 - Test 2 is running ...");
		LOG.debug("Driver : " + driver);
		driver.get("http://google.com");
		Util.randomSleep();
		LOG.info("Class1 - Test 2 is done!");
	}

	@Test
	public void test() throws InterruptedException {
		LOG.info("Class1 - Test 1 is running ...");
		LOG.debug("Driver : " + driver);
		driver.get("http://sme.sk");
		Util.randomSleep();
		LOG.info("Class1 - Test 1 is done!");
	}
}
