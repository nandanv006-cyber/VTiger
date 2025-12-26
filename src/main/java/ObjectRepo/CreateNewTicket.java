package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewTicket {
//	declartion
	@FindBy(xpath="//textarea[@name='ticket_title']")
	private WebElement ticketTitle;
	@FindBy(xpath="//select[@name='ticketcategories']")
	private WebElement categoryDropDown;
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement saveButton;
//	Initialization
	public CreateNewTicket(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
//	Utilization
	public WebElement getTicketTitle() {
		return ticketTitle;
	}
	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	
}
