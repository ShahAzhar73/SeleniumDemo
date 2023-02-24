package herokuapp;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pages.Examples;
import utilities.BaseClass;

public class DigestAuthentication extends BaseClass {

	@Test
	public void DigestAuthent() throws InterruptedException {
		try {
			// Initialize WebDriver
			logger("info", "Opening browser ");
			driver_web = getWebDriver();

			// Launching the specified URl
			logger("info", "Getting URL");
			driver_web.get("https://the-internet.herokuapp.com/");

			// Login via Digest Authentication
			Thread.sleep(5000);
			String username = "admin";
			String pass = "admin";
			String URL = "https://" + username + ":" + pass + "@" + "the-internet.herokuapp.com/digest_auth";
			driver_web.get(URL);
			Thread.sleep(2500);

		} finally {
			teardown();
		}

	}

}
