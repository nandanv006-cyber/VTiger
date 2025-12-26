package ObjectRepo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CreateNewProduct 
{
//	Declaration
	@FindBy(name="productname")
	private WebElement productName;
	@FindBy(xpath="//input[@name='sales_start_date']//following-sibling::img")
	private WebElement salesStartDateIcon;
	@FindBy(xpath="//td[text()='15']")
	private WebElement date;
	@FindBy(id="my_file_element")
	private WebElement chooseFile;
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;
	
	
	@FindBy(xpath="//textarea[@class='detailedViewTextBox']")
	private WebElement description;
	
	
//	Initialization
	public CreateNewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//	Utilization

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSalesStartDateIcon() {
		return salesStartDateIcon;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getChooseFile() {
		return chooseFile;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}





	public WebElement getDescription() {
		return description;
	}
	
//  Business Logic
	public void addNewProductInfo(WebDriver driver ,String exp,String date,String pathImg) {
		productName.sendKeys(exp);
		salesStartDateIcon.click();
		driver.findElement(By.xpath("//td[text()='"+date+"']")).click();
		chooseFile.sendKeys(pathImg);
		saveButton.click();
	}
	public void editProduct(String descrp ) {
		description.sendKeys(descrp);
		saveButton.click();
	}
	
	
	
}
