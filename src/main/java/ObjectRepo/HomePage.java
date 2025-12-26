package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtil;

public class HomePage extends WebDriverUtil
{
//	Declaration
	@FindBy(linkText="Calendar")
	private WebElement calender;
	@FindBy(linkText="Organizations")
	private WebElement organizations;
	@FindBy(linkText="Contacts")
	private WebElement contacts;
	@FindBy(linkText="Opportunities")
	private WebElement opportunities;
	@FindBy(linkText="Products")
	private WebElement products;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signouticon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
//	Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization
	
public WebElement getCalender() {
		return calender;
	}

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getOpportunities() {
		return opportunities;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getSignouticon() {
		return signouticon;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
//Business Logic 
	public void clickCalenderLink(){
		calender.click();
	}
	public void clickOrganizationsLink() {
		organizations.click();
	}
	public void clickContactsPage() {
		contacts.click();
	}
	public void clickOpportunititesLink() {
		opportunities.click();
	}
	public void clickproductLink() {
		products.click();
	}
	
	public void clicksignoutLink(WebDriver driver) {
		mouseHover(driver, signouticon);
		mouseHoverAndClick(driver, signoutlink);
	}
	
}
