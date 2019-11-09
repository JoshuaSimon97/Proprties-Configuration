package Script;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseInitialPage;

public class TestOne extends BaseInitialPage{
  @Test
  public void f() throws InterruptedException {
	  String parentWindow = getDriver().getWindowHandle();
		boolean flag = false;

		getDriver().findElement(By.xpath("//*[@id='button1']")).click();
		Thread.sleep(5000);

		String newWindowTitle = "Free QA Automation Tools Tutorial for Beginners with Examples";

		Set<String> handles = getDriver().getWindowHandles();

		for (String wHandles : handles) {
			
			if (!wHandles.equals(parentWindow)) {
				getDriver().switchTo().window(wHandles);
			}
			Thread.sleep(1500);
			
			if (getDriver().getTitle().equals(newWindowTitle)) {
				getDriver().manage().window().maximize();
				flag = true;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Desired window found");
		} else {
			getDriver().switchTo().window(parentWindow);
			System.out.println("Desired window not found");
		}

//		for (String wHandles : handles) {
//			if (!wHandles.equals(currentWindow)) {
//				driver.switchTo().window(wHandles);
//				Thread.sleep(5000);
//				driver.manage().window().maximize();
//				System.out.println(driver.getTitle());
//				Thread.sleep(5000);
//				driver.findElement(By.xpath("//*[@id='primary-menu']/li[1]/a/span/span")).click();
//			}
//		}
  }
}
