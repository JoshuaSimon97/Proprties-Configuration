package base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.myproject.configManager.PropertiesManager;

public class BaseInitialPage extends DriverInitializePage {

	@BeforeMethod
	public void beforeMethod() throws Exception {
		try {
			Logger logger = Logger.getLogger("BaseInitialPage.class");	
			PropertyConfigurator.configure("log4j.properties");
			PropertiesManager.addBundle();
			initializeDriver();
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			getDriver().get(PropertiesManager.get("baseurl"));
			getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}

	@AfterMethod
	public void afterMethod() {
		getDriver().quit();
	}

}
