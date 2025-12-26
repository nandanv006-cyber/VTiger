package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test9 
{
	public static void main(String[] args) 

	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.worldometers.info/world-population/");
		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//div[@class='text-end']"))).perform();
		act.scrollByAmount(0, 100).perform();
		String country="  Ukraine  ";
		for(int i=2;i<25;i++)
		{
			try
			{
				WebElement f = driver.findElement(By.xpath("//h2[@id='country']/following-sibling::div//a[contains(.,'"+country+"')]/../../td[12]"));
				System.out.println(f.getText());
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//h2[@id='country']/following-sibling::div//nav[@class='datatable-pagination']//button[.='"+i+"']")).click();
			}
		}

		driver.quit();

	}

}
