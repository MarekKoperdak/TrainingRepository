package sk.qats.distributed;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleTestClass {
	static final Logger LOG = LoggerFactory.getLogger(SimpleTestClass.class);

	@BeforeTest
	public void beforeTest() {
		long id = Thread.currentThread().getId();
		System.out.println("Before TEST. Thread id is: " + id);
	}

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		System.out.println("Before CLASS. Thread id is: " + id);
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		long id = Thread.currentThread().getId();
		System.out.println("Before METHOD. Thread id is: " + id);
	}

	@AfterMethod
	public void afterMethod() {
		long id = Thread.currentThread().getId();
		LOG.info("After METHOD. Thread id is: {} ", id);
	}

	@Test(enabled = true, priority = 2, description = "test in progress")
	public void test3() throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Test 3 is running ... Thread id is: {} ", id);
		LOG.info("Test 3 is done!");
	}

	@Test (priority = 3)
	public void test2() throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Test 2 is running ... Thread id is: {} ", id);
		LOG.info("Test 2 is done!");
		assertTrue(true);

	}

	@Test(enabled = false, description = "showcase how to test can have dependency", dependsOnMethods = { "test2" })
	public void test() throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Test 1 is running ... Thread id is: {} ", id);
		LOG.info("Test 1 is done!");
	}

}
