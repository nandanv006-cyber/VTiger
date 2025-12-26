package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
//declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addcontact;
	@FindBy(xpath="//a[text()='edit']")
	private WebElement edit;
	
//	Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization
	public WebElement getAddcontact() {
		return addcontact;
	}
	public WebElement getEdit() {
		return edit;
	}
//	Business Logic
	public void clickOnAddcontact() {
		addcontact.click();
	}
	
	
	
}
