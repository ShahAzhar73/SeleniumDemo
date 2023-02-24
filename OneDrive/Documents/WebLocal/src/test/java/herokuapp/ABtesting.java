package herokuapp;

import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class ABtesting extends BaseClass {

	@Test
	public void verifyABtesting() throws InterruptedException {
		try {
			// Initialize WebDriver
			logger("info", "Opening browser ");
			driver_web = getWebDriver();

			// Launching the specified URl
			logger("info", "Getting URL");
			driver_web.get("https://the-internet.herokuapp.com/");

			// Login via Email
			Thread.sleep(5000);
			Examples ex = new Examples();
			ClickOnElement(ex.ABTesting, "AB Testing");
			Thread.sleep(2500);
			ClickOnElement(ex.ABTestinglink, "AB Testing Link");
			Thread.sleep(6500);
			System.out.println("The Task is Completed");

		} finally {
			teardown();
		}
	}

}
