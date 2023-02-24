package herokuapp;

import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class DynamicContent extends BaseClass {

	@Test
	public void DynamiContent() throws InterruptedException {
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
			ClickOnElement(ex.DynamicContent, "Click on Dynamic Content");
			Thread.sleep(2500);

			String img1 = ex.DynamicContentimg1.toString();

			String DynamicIMG1 = "src=\"/img/avatars/Original-Facebook-Geek-Profile-Avatar-1.jpg\"";
			if (img1 == DynamicIMG1) {
				System.out.println("Its Mario");
			}

		} finally {
			teardown();
		}
	}

}
