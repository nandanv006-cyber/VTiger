package ObjectRepo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtil;

public class CreateNewContact extends WebDriverUtil{

//Declaration
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastname;
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	@FindBy(xpath="//input[@name='account_name']//following-sibling::img")
	private WebElement organizationicon;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement search;
	@FindBy(xpath="//a[text()='TekPyramid']")
	private WebElement searchnowBtn;
	
//	Initialization
	public CreateNewContact(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization

	public WebElement getLastname() {
		return lastname;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getOrganizationDD() {
		return organizationicon;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchnowBtn() {
		return searchnowBtn;
	}
//	Business Logic
	public void createNewContactWithMandateField(String text) {
		
		lastname.sendKeys(text);
		saveBtn.click();
	}
	public void createNewContactWithOrganizationName(WebDriver driver, String lname,String orgname) {
		lastname.sendKeys(lname);
		String parentWindowHandle = driver.getWindowHandle();
		organizationicon.click();
		Set<String> handles = driver.getWindowHandles();
		switchToChildWindow(driver, handles, parentWindowHandle);
		search.sendKeys(orgname,Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'"+orgname+"')]")).click();
		switchToParentWindow(driver, parentWindowHandle);
		saveBtn.click();
	}
	

}
