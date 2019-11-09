package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.myproject.configManager.PropertiesManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import logger.LoggerClass;

public class DriverInitializePage extends LoggerClass{

	WebDriver driver = null;
	DesiredCapabilities desiredCapabilities = null;

	public WebDriver getDriver() {
		return driver;
	}

	public void initializeDriver() throws Exception {
		
		if(PropertiesManager.get("driver").equalsIgnoreCase("chromeDriver")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			desiredCapabilities = DesiredCapabilities.chrome();
			logger.info("chromeDriver");
		} else if(PropertiesManager.get("driver").equalsIgnoreCase("ieDriver")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			desiredCapabilities = DesiredCapabilities.internetExplorer();
		}
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
