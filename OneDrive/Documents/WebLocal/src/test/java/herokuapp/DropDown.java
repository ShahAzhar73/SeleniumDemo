package herokuapp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class DropDown extends BaseClass {

	@Test
	public void DropDownList() throws InterruptedException {

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
			ClickOnElement(ex.DropDownMenu, "Click on DropDown Menu");
			Thread.sleep(2500);
			ClickOnElement(ex.DropDown, "Click on DropDown");
			Thread.sleep(2500);
			Select dropDown = new Select(ex.DropDown);
			dropDown.selectByIndex(2);
			Thread.sleep(2500);

		} finally {
			teardown();
		}

	}
}
