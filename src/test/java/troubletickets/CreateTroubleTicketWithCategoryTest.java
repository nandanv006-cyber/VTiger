package troubletickets;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelUtils;
import genericUtilities.FileUtils;
import genericUtilities.JavaUtils;
import genericUtilities.WebDriverUtil;

public class CreateTroubleTicketWithCategoryTest {
	@Test
	public  void createTroubleTicketWithCategoryTest() throws Exception
	{
//		TC_10
		FileUtils fLib = new FileUtils();
		ExcelUtils eLib = new ExcelUtils();
		JavaUtils jLib =	new JavaUtils();
		WebDriverUtil wLib = new WebDriverUtil();
		int ran = jLib.getRandomNumber();
		String troubleticket = eLib.readDataFromExcel("TroubleTickes", 1, 0);
		
		
		String exp =troubleticket+ran; 
		
		String BROWSER=fLib.readDataFromPropertyFile("browser");
		String URL=fLib.readDataFromPropertyFile("url");
		String USERNAME=fLib.readDataFromPropertyFile("username");
		String PASSWORD=fLib.readDataFromPropertyFile("password");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Login to Application 
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
//		navigate to home page and click on trouble ticket link
		driver.findElement(By.linkText("Trouble Tickets")).click();

//		click on create trouble ticket lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//		Enter title text field.
		driver.findElement(By.xpath("//textarea[@name='ticket_title']")).sendKeys(exp);
//		Click on category field
		WebElement ele = driver.findElement(By.xpath("//select[@name='ticketcategories']"));
//		Select small problem from category dropdown.
		wLib.dropdownUsingValue(ele, "Small Problem");
		
//		Click on save button.
		
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
//		verification
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(actual.contains(exp))
			System.out.println("Verified");
		else
			System.out.println("Not Verified");
//		LogOut From Application
		wLib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		wLib.mouseHoverAndClick(driver,driver.findElement(By.xpath("//a[text()='Sign Out']")));

	}

}
