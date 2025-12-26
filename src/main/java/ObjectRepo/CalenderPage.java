package ObjectRepo;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtil;

public class CalenderPage extends WebDriverUtil{
//	Declaration
	@FindBy(linkText="Day")
	private WebElement dayBtn;
	@FindBy(xpath="//td[normalize-space()='Add']")
	private WebElement addBtn;	
	@FindBy(id="addcall")
	private WebElement calllink;
	@FindBy(xpath="//input[@name='subject']")
	private WebElement eventname;
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement description;
	@FindBy(id="starthr")
	private WebElement starthrdd;
	@FindBy(id="startmin")
	private WebElement startmindd;
	@FindBy(id="startfmt")
	private WebElement startfmtdd;
	@FindBy(id="endhr")
	private WebElement endhrdd;
	@FindBy(id="endmin")
	private WebElement endmindd;
	@FindBy(id="endfmt")
	private WebElement endfmtdd;
	@FindBy(xpath="//input[@alt='Save [Alt+S]']")
	private WebElement save;
//	Initialization 
	public CalenderPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization
	public WebElement getDayBtn() {
		return dayBtn;
	}
	public WebElement getAddBtn() {
		return addBtn;
	}
	public WebElement getClassLink() {
		return calllink;
	}
	public WebElement getEventname() {
		return eventname;
	}
	public WebElement getDescription() {
		return description;
	}
	public WebElement getStarthrdd() {
		return starthrdd;
	}
	public WebElement getStartmindd() {
		return startmindd;
	}
	public WebElement getStartfmtdd() {
		return startfmtdd;
	}
	public WebElement getEndhrdd() {
		return endhrdd;
	}
	public WebElement getEndmindd() {
		return endmindd;
	}
	public WebElement getEndfmtdd() {
		return endfmtdd;
	}
	public WebElement getSave() {
		return save;
	}
	
	
// Business Logic
	public void addAnEventInDay(WebDriver driver,String eventName,String descriptn ) {
		dayBtn.click();
		mouseHover(driver, addBtn);
		addBtn.click();
		calllink.click();
		String parentwindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		switchToChildWindow(driver,handles, parentwindow);
		eventname.sendKeys(eventName);
		description.sendKeys(descriptn);
		dropdownUsingValue(starthrdd, "06");
		dropdownUsingValue(startmindd, "30");
		dropdownUsingValue(startfmtdd, "pm");
		dropdownUsingValue(endhrdd, "07");
		dropdownUsingValue(endmindd, "30");
		dropdownUsingValue(endfmtdd, "pm");
		save.click();
		switchToParentWindow(driver, parentwindow);
		
	}
	//see getter method also like non static method and business liabrary also like nonstatic method and you are using refernce variable of webelement at both the places.
	
}
