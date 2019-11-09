package Script;

import org.testng.annotations.Test;

import base.BaseInitialPage;

public class NewTest extends BaseInitialPage{
  @Test
  public void f() {
	  System.out.println(getDriver().getTitle());
  }
}
