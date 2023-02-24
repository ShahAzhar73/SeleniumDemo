package herokuapp;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import pages.Examples;
import utilities.BaseClass;

public class BasicAuth extends BaseClass {

	@Test
	public void VerifyBasicAuth() throws InterruptedException, IOException {
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

			String username = "admin";
			String password = "admin";

			String URL = "https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth";
			driver_web.get(URL);

			Thread.sleep(5000);

		} finally {
			teardown();
		}
	}

}
