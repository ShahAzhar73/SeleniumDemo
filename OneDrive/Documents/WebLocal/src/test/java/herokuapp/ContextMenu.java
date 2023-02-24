package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class ContextMenu extends BaseClass {

	@Test
	public void contextmenuEx() throws InterruptedException {
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
			ClickOnElement(ex.ContextMenu, "Click on Context Menu");
			Thread.sleep(2500);
			Actions actions = new Actions(driver_web);
			actions.contextClick(ex.ContextMenuobject).perform();
			Thread.sleep(2500);
			driver_web.switchTo().alert().accept();

		} finally {

		}

	}

}
