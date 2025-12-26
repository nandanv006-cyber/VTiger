package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
//Initialization
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOpportunity;
	@FindBy(id="selectCurrentPageRec")
	private WebElement opportunityNoCheckBox;
	@FindBy(xpath="//input[@class='crmbutton small delete']")
	private WebElement deleteButton;
	
//	Initialization
	public OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization
	public WebElement getCreateOpportunity() {
		return createOpportunity;
	}
	
//	BusinessLogic
	public void clickNewOpportunityIcon() {
		createOpportunity.click();
	}
	public void deleteAll() {
		opportunityNoCheckBox.click();
		deleteButton.click();
	}
	
}
