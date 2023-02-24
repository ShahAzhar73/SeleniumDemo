package herokuapp;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class DragNdrop extends BaseClass {

	@Test
	public void DragAndDrop() throws InterruptedException {
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
			ClickOnElement(ex.DragNDrop, "Click on Drag And Drop");
			Thread.sleep(2500);

			// Creating object of Actions class to build composite actions
			Actions actions = new Actions(driver_web);
			Action dragAndDrop = actions.clickAndHold(ex.DragNDropB).moveToElement(ex.DragNDropA).release(ex.DragNDropA)
					.build();

			// Performing the drag and drop action
			dragAndDrop.perform();

			Thread.sleep(2500);
		} finally {

			teardown();
		}
	}
}
