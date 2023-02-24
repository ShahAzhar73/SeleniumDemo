package herokuapp;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class UploadFile extends BaseClass {

	@Test
	public void seleniumUploadFile() throws InterruptedException {
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
			ClickOnElement(ex.fileUpload, "Click on File Upload");
			Thread.sleep(2500);

			WebElement browse = ex.fileUploadButoon;
			browse.sendKeys("C:\\Users\\azhar\\Downloads\\awesome.jpg");
			Thread.sleep(2500);
			ClickOnElement(ex.fileUploadSubmit, "Click on File Upload Submit Button");
			Thread.sleep(2500);

		} finally {
			teardown();
		}

	}

}
