package herokuapp;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class DisappearingElements extends BaseClass {

	@Test
	public void DisappearElements() throws InterruptedException {
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
			ClickOnElement(ex.DissapperingElements, "Click on Dissappering Elements");
			Thread.sleep(2500);

			String string = "//*[@id=\"content\"]/div/ul/li[5]/a";
			WebElement substring = ex.hiddenGallery;
			String RequiredSub = substring.toString();
			Thread.sleep(2500);
			for (int i = 0; string.length() == RequiredSub.length(); i++) {
				if (ex.hiddenGallery.isDisplayed()) {
					ClickOnElement(ex.hiddenGallery, "Click on Hidden Gallery");
					break;
				} else {
					BaseClass.RefreshPage();
				}
			}

		} finally {
			teardown();
		}
	}
}
