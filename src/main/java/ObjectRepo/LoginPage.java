package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
//	declaration
	@FindBy(name="user_name")
	private WebElement username;
	@FindBy(name="user_password")
	private WebElement password;
	@FindBy(id="submitButton")
	private WebElement submitbtn;
//	Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//	Utilization
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmitbtn() {
		return submitbtn;
	}
//	BusinessLogic
	public void login(String un , String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submitbtn.click();
	}
	

}
