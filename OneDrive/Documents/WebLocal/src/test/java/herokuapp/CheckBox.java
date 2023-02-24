package herokuapp;

import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class CheckBox extends BaseClass {

	@Test
	public void checkboxverify() throws InterruptedException {
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
			Thread.sleep(5000);
			ClickOnElement(ex.Checkbox, "Click on CheckBox");
			Thread.sleep(2500);
			ClickOnElement(ex.Checkboxclick1, "Click on CheckBox");
			Thread.sleep(500);
			ClickOnElement(ex.Checkboxclick2, "Click on CheckBox");
			Thread.sleep(500);
			ClickOnElement(ex.Checkboxclick1, "Click on CheckBox");
			Thread.sleep(500);
			ClickOnElement(ex.Checkboxclick2, "Click on CheckBox");
			Thread.sleep(500);
			ClickOnElement(ex.Checkboxclick1, "Click on CheckBox");
			Thread.sleep(500);

		} finally {
			teardown();
		}
	}

}
