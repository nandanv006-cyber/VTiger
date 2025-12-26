package assignment;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 {

	public static void main(String[] args) throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele1 = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		WebElement ele2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
		Actions act=new Actions(driver);
		act.clickAndHold(ele1).moveByOffset(15, 0).release().build().perform();
		WebDriverWait ew= new WebDriverWait(driver, Duration.ofSeconds(10));
		ew.until(ExpectedConditions.elementToBeClickable(ele2));
		act.clickAndHold(ele2).moveByOffset(59, 0).release().build().perform();
		Thread.sleep(5000);
		//driver.quit();

	}

}
