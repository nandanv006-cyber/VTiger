package ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class TroubleTicketPage {

//	Declaration
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createTroubleTicketicon;
	@FindBy(xpath="//textarea[@name='ticket_title']")
	private WebElement ticketTitle;
//	Initialization
	public TroubleTicketPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getCreateTroubleTicketicon() {
		return createTroubleTicketicon;
	}
	public WebElement getTicketTitle() {
		return ticketTitle;
	}	
	
	
}
