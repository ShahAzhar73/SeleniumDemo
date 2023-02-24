package herokuapp;

import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class AddRemove extends BaseClass {

	@Test
	public void verfiyAddRemove() throws InterruptedException {
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
			ClickOnElement(ex.AddRemove, "ADD Remove");
			Thread.sleep(5000);
			ClickOnElement(ex.Add, "ADD");
			Thread.sleep(2500);
			ClickOnElement(ex.Remove, "Remove");
			Thread.sleep(2500);
			System.out.println("The Add And Remove is Done Successfully");

		} finally {
			teardown();
		}

	}

}
