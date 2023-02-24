package utilities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;

public class TesseractExtender {

	public static void capturePicture(WebElement element) throws IOException {
		// cast element to wrapsDriver
		WrapsDriver wrapsDriver = (WrapsDriver) element;

		// get the entire screenshot from the driver of passed WebElement
		File screen = ((TakesScreenshot) wrapsDriver.getWrappedDriver()).getScreenshotAs(OutputType.FILE);

		// create an instance of buffered image from captured screenshot
		BufferedImage image = ImageIO.read(screen);

		// get the width and height of the WebElement using getSize()
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		// create a rectangle using width and height
		Rectangle rect = new Rectangle(width, height);

		// get the location of WebElement in a Point.
		// this will provide X & Y co-ordinates of the WebElement
		Point point = element.getLocation();

		// create image for element using its location and size.
		// this will give image data specific to the WebElement
		BufferedImage dest = image.getSubimage(point.getX(), point.getY(), rect.width, rect.height);

		// write back the image data for element in new File
		ImageIO.write(dest, "png", new File("C:\\Users\\azhar\\eclipse-workspace\\Web\\testdata\\testImage.png"));

	}

}