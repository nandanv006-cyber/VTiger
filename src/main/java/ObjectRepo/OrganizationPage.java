package ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class OrganizationPage {
	
//	Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganizationIcon;
//	Initialization
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	utilization
	public WebElement getCreateOrganizationIcon() {
		return createOrganizationIcon;
	}
//	BusinessLogic
	public void clickNewOrganizationicon() {
		createOrganizationIcon.click();
	}
}
