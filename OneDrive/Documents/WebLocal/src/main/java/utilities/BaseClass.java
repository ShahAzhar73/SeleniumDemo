package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//import Caseslisteners.ExtentReporterNG;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;
//import pages.web_old_admin_panel;
//import testingServices.GenerateToken;

public class BaseClass {
	public static AndroidDriver<AndroidElement> driver;
	public static WebDriver driver_web;
	public static Properties property;
	public static WebDriverWait wait_app;
	public static WebDriverWait wait_web;
	public static AppiumDriverLocalService service;
	public static String screenshotName;
	public static JsonPath jsonData;
//	public static web_old_admin_panel webpanelOld;
	public SoftAssert softassert;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	public static final String packageName = "com.rufilo.user.staging";
	public static org.apache.poi.xssf.usermodel.XSSFCell userRef = null;
	public static org.apache.poi.xssf.usermodel.XSSFCell transRef = null;
	public static org.apache.poi.xssf.usermodel.XSSFCell mobileNo = null;
	public static org.apache.poi.xssf.usermodel.XSSFCell segmnet = null;

	String timestamp = new SimpleDateFormat("dd-MMM-yyyy_HH.mm").format(new Date());
	String repname = "RufiloTestReports_" + timestamp + "";
	String Rpaths = System.getProperty("user.dir") + "\\TestReports\\Rufilo_Test_Report\\" + repname + ".html";

	@BeforeSuite
	public void prerequisite() throws Exception {
//		service = AppiumDriverLocalService.buildDefaultService();
//		softassert = new SoftAssert();
//		ExtentReport();
//		ExtentReporterNG er = new ExtentReporterNG();
		// er.sendTestExecutionStatusToSlack("Automation Scripts are Executing ");
		// financierAutoApprove.financierApprove(GenToken());
	}

	@AfterSuite
	public void postrequisite() throws Exception {
		Thread.sleep(25000);

//		ExtentReporterNG er = new ExtentReporterNG();
//		// This code is used to send Suite Generated Reports to Slack
//		try {
//			er.sendTestExecutionReportToSlack(Rpaths);
//		} catch (FileNotFoundException e) {
//			System.out.println("File Not Found");
//		}

		// This code is used to send Suite Generated Excel to Slack
//		String ExcelPath = System.getProperty("user.dir") + "//UserDetails//UserTransactions.xlsx";
//		er.sendTestExecutionReportToSlack(ExcelPath);
//
//		er.sendTestExecutionStatusToSlack("The Automation Script Execution Completed  " + "\n\n"
//				+ "============================================================");
	}

	// Start Server
	public void startService() {
		boolean flag = CheckServer(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
	}

	// Stop Server
	public void stopService() throws IOException {
		ServerSocket serversocket;
		serversocket = new ServerSocket(4723);
		serversocket.close();
	}

	// Checking Server Status Code
	public static boolean CheckServer(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	// TearDown the active Drivers
	public void teardown() throws InterruptedException {
		if (driver_web != null) {
			driver_web.quit();
			driver_web = null;
		}
		Thread.sleep(2500);
	}

	// Code for Web Initialization
	public static WebDriver getWebDriver() {
		WebDriverManager.chromedriver().browserVersion("105.0.5195.102").setup();
		WebDriverManager.chromedriver().driverVersion("105.0.5195.102").setup();
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--incognito");
		driver_web = new ChromeDriver(options);
		driver_web.manage().deleteAllCookies();
		driver_web.manage().window().maximize();
		driver_web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait_web = new WebDriverWait(driver_web, 15);
		return driver_web;
	}

	// windows switch
	public void windowswitch() {
		String parent_window = driver_web.getWindowHandle();
		Set<String> str = driver_web.getWindowHandles();
		for (String s : str) {
			if (!s.equals(parent_window)) {
				driver_web.switchTo().window(s);
			}
		}
	}

	// Taking ScreenShot on Web
	public void ScreenShot_web(String tname) throws InterruptedException {
		TakesScreenshot scrnShot = (TakesScreenshot) driver_web;
		File srcFile = scrnShot.getScreenshotAs(OutputType.FILE);
		screenshotName = tname + "_" + getCurrentdate("dd-MMM-yyyy_hh-mm-ss");
		File target = new File(
				System.getProperty("user.dir") + "//TestReports//screenshots//" + screenshotName + ".png");
		try {
			FileUtils.copyFile(srcFile, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Web ScreenShot Taken Successfully.");
	}

	// reports
	public void ExtentReport() throws Exception {
		String timestamp = new SimpleDateFormat("dd-MMM-yyyy_HH.mm").format(new Date());
		String repname = "RufiloTestReports_" + timestamp + "";
		htmlReporter = new ExtentHtmlReporter(
				System.getProperty("user.dir") + "\\TestReports\\Rufilo_Test_Report\\" + repname + ".html");
		htmlReporter.config().setTheme(Theme.DARK);
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
	}

	public void verifyEqualsOnApp(String expected, String actual, String passComment)
			throws IOException, InterruptedException {
		try {
			Assert.assertEquals(actual, expected);
			logger("pass", passComment);
		} catch (Throwable t) {
			if (test != null) {
				test.log(Status.FAIL, t.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(
						System.getProperty("user.dir") + "//TestReports//screenshots//" + screenshotName + ".png")
						.build());
				report.flush();
			}
		}
	}

	public void verifyEqualsOnBrowser(String expected, String actual, String passComment)
			throws IOException, InterruptedException {
		try {
			Assert.assertEquals(actual, expected);
			logger("pass", passComment);
		} catch (Throwable t) {
			ScreenShot_web("Assert_" + expected);
			if (test != null) {
				test.log(Status.FAIL, t.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(
						System.getProperty("user.dir") + "//TestReports//screenshots//" + screenshotName + ".png")
						.build());
				report.flush();
			}
		}
	}

	public void isDisplayed(WebElement element, String passComment, String failComment)
			throws IOException, InterruptedException {
		try {
			Assert.assertTrue(element.isDisplayed());
			logger("pass", passComment);
		} catch (AssertionError t) {
			if (test != null) {
				test.log(Status.FAIL, failComment, MediaEntityBuilder.createScreenCaptureFromPath(
						System.getProperty("user.dir") + "//TestReports//screenshots//" + screenshotName + ".png")
						.build());
				report.flush();
			}
		}
	}

	public void ClickOnElement(WebElement locator, String comment) {
		locator.click();
		if (test != null) {
			test.log(Status.INFO, "Click on " + comment);
		}
		System.out.println("Click on : " + comment);
	}

	public void TypeInElement(WebElement locator, String Value, String component) {
		locator.sendKeys(Value);
		if (test != null) {
			test.log(Status.INFO, "Typing in : " + component + ", Data : " + Value);
		}
		System.out.println("Typing in : " + component + ", Data : " + Value);
	}

	// Create logs of the status in test
	public void logger(String status, String comment) {
		if (test != null) {
			if (status.equalsIgnoreCase("pass")) {
				test.log(Status.PASS, comment);
				System.out.println(comment);
			}
			if (status.equalsIgnoreCase("info")) {
				test.log(Status.INFO, comment);
				System.out.println(comment);
			}
			if (status.equalsIgnoreCase("error")) {
				test.log(Status.ERROR, comment);
				System.out.println(comment);
			}
			if (status.equalsIgnoreCase("fail")) {
				test.log(Status.FAIL, comment);
				System.out.println(comment);
			}
		} else {
			System.out.println(comment);
		}
	}

	// Following below method is used to write excel
	public static void writeExcel(String filePath, String fileName, String sheetName, String[] dataToWrite)
			throws IOException {

		// Create an object of File class to open xlsx file
		File file = new File("C:\\Users\\azhar\\eclipse-workspace\\Rufilo\\UserDetails\\UserTransactions.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		// Create an object of FileInputStream class to read excel file
		Workbook wb = new XSSFWorkbook(inputStream);

		// Read excel sheet by sheet name
		Sheet sheet = wb.getSheet(sheetName);

		// Get the current count of rows in excel file
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		System.out.println("The Row Count is: " + rowCount);

		// Get the first row from the sheet
		Row row = sheet.getRow(0);

		// Create a new row and append it at last of sheet
		Row newRow = sheet.createRow(rowCount + 1);

		for (int j = 0; j < row.getLastCellNum(); j++) {

			// Fill data in row
			Cell cell = newRow.createCell(j);
			cell.setCellValue(dataToWrite[j]);

		}

		// Close input stream
		inputStream.close();

		// Create an object of FileOutputStream class to create write data in excel file
		FileOutputStream outputStream = new FileOutputStream(file);

		// write data in the excel file
		wb.write(outputStream);

		// close output stream
		outputStream.close();

	}

	public static HashMap<String, XSSFCell> importExcel(String sheetName) throws IOException {
		FileInputStream File = new FileInputStream(
				"C:\\Users\\azhar\\eclipse-workspace\\Rufilo\\UserDetails\\UserTransactions.xlsx");

		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(File);

		XSSFSheet sheet = workbook.getSheet(sheetName);
		// XSSFSheet sheet = workbook.getSheetAt(0);

		int lastRowNumber = sheet.getLastRowNum();
		System.out.println(lastRowNumber);
		userRef = sheet.getRow(lastRowNumber).getCell(0);
		transRef = sheet.getRow(lastRowNumber).getCell(1);
		mobileNo = sheet.getRow(lastRowNumber).getCell(2);
		segmnet = sheet.getRow(lastRowNumber).getCell(3);

		HashMap<String, XSSFCell> map = new HashMap<String, XSSFCell>();
		map.put("user_ref_no", userRef);
		map.put("trans_ref_no", transRef);
		map.put("mobile_no", mobileNo);
		map.put("segmnet", segmnet);

		return map;
	}

	// method to select UI based on text
	public MobileElement uiselector(String str) {
		MobileElement element = ((AndroidDriver<AndroidElement>) driver)
				.findElementByAndroidUIAutomator("new UiSelector().text(\"" + str + "\")");
		return element;
	}

	public static void RefreshPage() {
		driver_web.navigate().refresh();
	}

	// Get Random 9 digit code
	public static long random() {
		long min = 500000000L;
		long max = 599999999L;

		long random = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return random;
	}

	// Get Random 7 digit code
	public static long randomE() {
		long min = 10000L;
		long max = 9999999L;

		long random = (int) Math.floor(Math.random() * (max - min + 1) + min);
		return random;
	}

	// gets the current date
	public static String getCurrentdate(String format) {
		String date = new SimpleDateFormat(format).format(new Date());
		return date;
	}

	// To get Reusable data from config file
	public static String getProperty(String key) throws IOException {
		property = new Properties();
		FileInputStream File = new FileInputStream("./src/main/java/config/config.properties");
		property.load(File);
		return property.getProperty(key);
	}

	// Scroll to desired text
	public void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
				.click();
	}

	public void Suitestatus(ITestResult result) {
		System.out.println("Status of execution is:" + result.getStatus());
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				System.out.println("Test case execution status is SUCCESS");
			} else if (result.getStatus() == ITestResult.FAILURE) {
				// Do something here
				System.out.println("Test case execution status is FAILURE");
			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("Test case execution status is SKIP");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}