package ObjectRepo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtil;
public class CreateOpportunityPage extends WebDriverUtil {

//	Declaration
	@FindBy(name="potentialname")
	private WebElement opportunityName;
	@FindBy(xpath="//input[@id='related_to_display']/following-sibling::img")
	private WebElement relatedToIcon;
	@FindBy(id="search_txt")
	private WebElement search;
	@FindBy(id="jscal_trigger_closingdate")
	private WebElement calenderIcon;
	
	@FindBy(name="sales_stage")
	private WebElement salesStageDD;
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveBtn;
	
//	Initialization
	public CreateOpportunityPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization

	public WebElement getOpportunityName() {
		return opportunityName;
	}

	public WebElement getRelatedToIcon() {
		return relatedToIcon;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSalesStageDD() {
		return salesStageDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
// 	Business Logic
	public void createNewopportunity(WebDriver driver , String exp,String orgName,String expDate) {
		opportunityName.sendKeys(exp);
		String parent = driver.getWindowHandle();
		relatedToIcon.click();
		Set<String> handles = driver.getWindowHandles();
		switchToChildWindow(driver, handles, parent);
		search.sendKeys(orgName);
		driver.findElement(By.xpath("//a[contains(.,'"+orgName+"')]")).click();
		switchToParentWindow(driver, parent);
		calenderIcon.click();
		driver.findElement(By.xpath("//td[text()='"+expDate+"']")).click();
		salesStageDD.click();
		dropdownUsingValue(salesStageDD, "Negotiation/Review");
		saveBtn.click();
	}
		

		
		
		
}
