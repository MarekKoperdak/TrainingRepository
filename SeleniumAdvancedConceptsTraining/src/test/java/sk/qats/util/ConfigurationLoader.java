package sk.qats.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationLoader {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationLoader.class);

	
	public static void getProperties(String propertiesPath) {
		Properties properties = loadPropertiesFile(propertiesPath);
		
		LOG.info("base url: " + properties.getProperty("base.url"));
		LOG.info("hub url: " + properties.getProperty("hub.url"));
	}
	
	private static Properties loadPropertiesFile(String propertiesPath) {
		LOG.info("Loading properties file located: '{}'", propertiesPath);
		Properties properties = new Properties();
		InputStream inStream = null;

		try {
			inStream = new FileInputStream(propertiesPath);
			properties.load(inStream);
		} catch (Exception ex) {
			LOG.error("'{}' file is not in place", propertiesPath);
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					LOG.error("Exception caught by closing stream from Propeties file : {} ", e.getMessage());
				}
			}
		}

		return properties;
	}

}
