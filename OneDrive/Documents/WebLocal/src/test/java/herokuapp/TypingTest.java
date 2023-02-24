package herokuapp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class TypingTest extends BaseClass {

	@Test
	public void Typing() throws InterruptedException {
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
			ClickOnElement(ex.KeyPress, "Click on Key Press");
			Thread.sleep(2500);
			ClickOnElement(ex.KeyPressEnter, "Click on Key Press Enter");
			Thread.sleep(2500);
			WebElement m = ex.KeyPressEnter;

			m.sendKeys(Keys.NUMPAD1);
			Thread.sleep(1000);
			m.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
			m.sendKeys(Keys.NUMPAD7);
			Thread.sleep(1000);
			m.sendKeys(Keys.NUMPAD3);
			Thread.sleep(1000);
			m.sendKeys(Keys.ENTER);

		} finally {
			teardown();
		}
	}

}
