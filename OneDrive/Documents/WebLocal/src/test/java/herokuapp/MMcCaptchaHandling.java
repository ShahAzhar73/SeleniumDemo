package herokuapp;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import pages.Examples;
import utilities.BaseClass;
import utilities.TesseractExtender;

public class MMcCaptchaHandling extends BaseClass {

	@Test
	public void DomCallenge() throws InterruptedException, IOException, TesseractException {
		try {
			// Initialize WebDriver
			logger("info", "Opening browser ");
			driver_web = getWebDriver();

			// Launching the specified URl
			logger("info", "Getting URL");
			driver_web.get("https://codepen.io/grapdroad/pen/XWEwJGr/");

			// Login via Email
			Thread.sleep(5000);
			Examples ex = new Examples();

			WebElement image = driver_web.findElement(By.xpath("/html/body/div/form/div[3]/div[1]/span[1]"));
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
