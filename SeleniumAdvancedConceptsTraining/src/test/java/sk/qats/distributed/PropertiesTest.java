package sk.qats.distributed;

import org.testng.annotations.Test;

import sk.qats.util.ConfigurationLoader;

public class PropertiesTest {

	@Test(description = "example of loading property files")
	public void testProertiesFile() {
		// example of RELATIVE path to a file
		String propertiesPath = "config\\user.properties";
		ConfigurationLoader.getProperties(propertiesPath);
	}
}
