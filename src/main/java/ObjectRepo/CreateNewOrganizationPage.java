package ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtil;
public class CreateNewOrganizationPage extends WebDriverUtil {

//	Declaration
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrganizationName;
	@FindBy(name="industry")
	private WebElement indutryTypeDropDown;
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;
	

	
	//	Initialization 
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization
	public WebElement getOrganizationName() {
		return OrganizationName;
	}
	public WebElement getIndutryTypeDropDown() {
		return indutryTypeDropDown;
	}	
	public WebElement getSaveButton() {
		return saveButton;
	}
//	BusinessLogic
	public void createOrgMandateFiled(String exp) {
		OrganizationName.sendKeys(exp);
		saveButton.click();
	}
	public void createOrgIndustryType(String exp,String industryType) {
		OrganizationName.sendKeys(exp);
		dropdownUsingValue(indutryTypeDropDown, industryType);
		saveButton.click();
	}
	
}
