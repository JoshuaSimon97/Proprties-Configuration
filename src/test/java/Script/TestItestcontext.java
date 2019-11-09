package Script;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.myproject.configManager.PropertiesManager;

import base.BaseInitialPage;

public class TestItestcontext extends BaseInitialPage{
  @Test
  public void f() throws InterruptedException {
	  logger.info(getDriver().getTitle());
	  
  }
}
