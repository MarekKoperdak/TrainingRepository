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

import sk.qats.util.Util;

public class ParallelSimpleTestClass2 {
	static final Logger LOG = LoggerFactory.getLogger(ParallelSimpleTestClass2.class);

	@BeforeTest
	public void beforeTest() {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - Before TEST. Thread id is: " + id);
	}

	@BeforeClass
	public void beforeClass() {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - Before CLASS. Thread id is: " + id);
	}

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - Before METHOD. Thread id is: " + id);
	}

	@AfterMethod
	public void afterMethod() {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - After METHOD. Thread id is: {} ", id);
	}

	@Test(enabled = true)
	public void test3() throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - Test 3 is running ... Thread id is: {} ", id);
		Util.randomSleep();
		LOG.info("Class 2 - Test 3 is done!");
	}

	@Test 
	public void test2() throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - Test 2 is running ... Thread id is: {} ", id);
		Util.randomSleep();
		LOG.info("Class 2 - Test 2 is done!");
		assertTrue(true);

	}

	@Test
	public void test1() throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Class 2 - Test 1 is running ... Thread id is: {} ", id);
		Util.randomSleep();
		LOG.info("Class 2 - Test 1 is done!");
	}

}
