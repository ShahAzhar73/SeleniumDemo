package herokuapp;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pages.Examples;
import utilities.BaseClass;
import utilities.TesseractExtender;

public class DomChallenging extends BaseClass {

	@Test
	public void DomCallenge() throws InterruptedException, IOException, TesseractException {
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
			ClickOnElement(ex.DomChallenge, "DOM Challenge");
			Thread.sleep(2500);
			ClickOnElement(ex.DomChallengeblue, "DOM Challenge Blue");
			Thread.sleep(2500);
			System.out.println("Clicked on Blue Button");
			ClickOnElement(ex.DomChallengered, "DOM Challenge Red");
			Thread.sleep(2500);
			System.out.println("Clicked on Red Button");
			ClickOnElement(ex.DomChallengegreen, "DOM Challenge Green");
			Thread.sleep(2500);
			System.out.println("Clicked on Green Button");
			Thread.sleep(2500);

			WebElement image = driver_web.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]/div/div"));
			TesseractExtender.capturePicture(image);

			Tesseract tesseract = new Tesseract();
			tesseract.setDatapath("C:\\Users\\azhar\\eclipse-workspace\\Web\\testdata");

			// the doOCR method of Tesseract will retrive the text
			// from image captured by Selenium
			String result = tesseract
					.doOCR(new File("C:\\Users\\azhar\\eclipse-workspace\\Web\\testdata\\testImage.png"));
			System.out.println(result);
			// Assert.assertTrue(result.contains("TEST"));

		} finally {
			teardown();
		}
	}

}
