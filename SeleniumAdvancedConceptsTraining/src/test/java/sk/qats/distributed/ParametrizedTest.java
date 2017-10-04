package sk.qats.distributed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedTest {
	static final Logger LOG = LoggerFactory.getLogger(ParametrizedTest.class);

	@Test
	public void testWithouParameters() {
		System.out.println("nieco robi");
	}

	@Test(enabled = true, description = "parameterized test")
	@Parameters({ "param1" })
	public void testWithParamFromSuite(String param1) throws InterruptedException {
		long id = Thread.currentThread().getId();
		LOG.info("Test PARAM is with parameters ... {}", param1);
		LOG.info("Test PARAM is running ... Thread id is: {} ", id);
		LOG.info("Test PARAM is done!");
	}

	@DataProvider(name = "Authentication")
	public Object[][] dataProvider2() {
		return new Object[][] { { "marek", "pswd_x", 12 }, { "jozef", "Testjozezf", 32 }, { "lubor", "pswd", 10 } };
	}

	@Test(dataProvider = "Authentication")
	public void testWithParamFromDataProvider(String user, String pswd, int vek) {
		LOG.info("Username: " + user);
		LOG.info("Pswd: " + pswd);
		LOG.info("Ve: k" + vek);
	}

}
