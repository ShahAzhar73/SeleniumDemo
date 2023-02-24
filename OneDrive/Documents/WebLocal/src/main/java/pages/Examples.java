package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;

public class Examples extends BaseClass {

	public Examples() {
		PageFactory.initElements(driver_web, this);
	}

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a")
	public WebElement ABTesting;

	@FindBy(xpath = "//*[@id=\"page-footer\"]/div/div/a")
	public WebElement ABTestinglink;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[2]/a")
	public WebElement AddRemove;

	@FindBy(xpath = "//*[@id=\"content\"]/div/button")
	public WebElement Add;

	@FindBy(xpath = "//*[@id=\"elements\"]/button")
	public WebElement Remove;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[3]/a")
	public WebElement BasicAuth;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[4]/a")
	public WebElement BrokenImage;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")
	public WebElement DomChallenge;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]")
	public WebElement DomChallengeblue;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[2]")
	public WebElement DomChallengered;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[3]")
	public WebElement DomChallengegreen;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/canvas[1]")
	public WebElement DomChallengeans;

	@FindBy(id = "canvas")
	public WebElement DomChallengeid;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[6]/a")
	public WebElement Checkbox;

	@FindBy(xpath = "/html/body/div[2]/div/div/form/input[1]")
	public WebElement Checkboxclick1;

	@FindBy(xpath = "/html/body/div[2]/div/div/form/input[2]")
	public WebElement Checkboxclick2;

	@FindBy(xpath = "/html/body/div[2]/div/ul/li[7]/a")
	public WebElement ContextMenu;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]")
	public WebElement ContextMenuobject;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[8]/a")
	public WebElement DigestAuth;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[9]/a")
	public WebElement DissapperingElements;

	@FindBy(xpath = "//*[@id=\"content\"]/div/ul/li[5]/a")
	public WebElement hiddenGallery;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[10]/a")
	public WebElement DragNDrop;

	@FindBy(xpath = "//*[@id=\"column-a\"]")
	public WebElement DragNDropA;

	@FindBy(xpath = "//*[@id=\"column-b\"]")
	public WebElement DragNDropB;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[11]/a")
	public WebElement DropDownMenu;

	@FindBy(xpath = "//*[@id=\"dropdown\"]")
	public WebElement DropDown;

	@FindBy(xpath = "//*[@id=\"dropdown\"]/option[2]")
	public WebElement DropDownOption1;

	@FindBy(xpath = "//*[@id=\"dropdown\"]/option[3]")
	public WebElement DropDownOption2;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[12]/a")
	public WebElement DynamicContent;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[1]/img")
	public WebElement DynamicContentimg1;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[18]/a")
	public WebElement fileUpload;

	@FindBy(xpath = "//*[@id=\"file-upload\"]")
	public WebElement fileUploadButoon;

	@FindBy(xpath = "//*[@id=\"file-submit\"]")
	public WebElement fileUploadSubmit;

	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[31]/a")
	public WebElement KeyPress;

	@FindBy(xpath = "//*[@id=\"target\"]")
	public WebElement KeyPressEnter;

}
