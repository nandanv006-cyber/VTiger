package ObjectRepo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtil;
public class Product extends WebDriverUtil {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createProductIcon;
	@FindBy(id="bas_searchfield")
	private WebElement inDropDown;
	@FindBy(name="search_text")
	private WebElement search;
	@FindBy(xpath="//a[text()='edit']")
	private WebElement edit;
	
	public WebElement getEdit() {
		return edit;
	}
	public Product(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public WebElement getCreateProductIcon() {
	return createProductIcon;
	}
	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getSearch() {
		return search;
	}
//	Business Logic 
	public void clickOnAddProduct() {
		createProductIcon.click();
		
	}
	public void editproduct(WebDriver driver , String ddvalue, String exp)
	{
		dropdownUsingValue(inDropDown, ddvalue);
		search.sendKeys(exp);
		edit.click();
	}

}
