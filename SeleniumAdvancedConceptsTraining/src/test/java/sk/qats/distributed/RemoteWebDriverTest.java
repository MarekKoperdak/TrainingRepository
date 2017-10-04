package sk.qats.distributed;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteWebDriverTest {

	@Test(description = "simple example of RemoteWebDriver connetion")
	public void remoteTest() throws MalformedURLException, InterruptedException {
		// System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		// WebDriver driver = new ChromeDriver();
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
		// desiredCapabilities.setCapability(capabilityName, value);
		
		WebDriver driver = new RemoteWebDriver(new URL("http://10.86.43.175:4444/wd/hub"), desiredCapabilities);
		
		driver.get("http://sme.sk");
	}
}
