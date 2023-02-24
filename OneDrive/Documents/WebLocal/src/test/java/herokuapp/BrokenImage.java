package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class BrokenImage extends BaseClass {

	@Test
	public void VerifyBrokenImage() throws InterruptedException {

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
			ClickOnElement(ex.BrokenImage, "Broken Image");
			Thread.sleep(2500);

			for (WebElement image : driver_web.findElements(By.cssSelector("img"))) {
				isBrokenImage(image);
			}

		} finally {
			teardown();
		}
	}

	public void isBrokenImage(WebElement image) {

		if (image.getAttribute("naturalWidth").equals("0")) {
			System.out.println(image.getAttribute("src") + " is Broken.");
		}
	}

}
