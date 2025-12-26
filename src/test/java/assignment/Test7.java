package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test7 
{
	public static void main(String[] args) 

	{

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.bbc.com/sport/olympics/paris-2024/BKBMTEAM5/results");

		String discipline="Boxing";
		String event="Men's 80kg";

		Select s1 = new Select(driver.findElement(By.id("discipline-selector")));
		s1.selectByVisibleText(discipline);

		Select s2 = new Select(driver.findElement(By.id("event-selector")));
		s2.selectByVisibleText(event);


		WebElement gold = driver.findElement(By.xpath("//img[@alt='gold']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'PrimaryName ')]|//img[@alt='gold']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'SecondaryName')]"));
		System.out.println("Gold :"+gold.getText());
		try
		{

			WebElement s = driver.findElement(By.xpath("//img[@alt='gold']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'SecondaryName')]"));
			System.out.println("country:"+s.getText());
			WebElement silver = driver.findElement(By.xpath("//img[@alt='silver']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'PrimaryName ')]"));
			System.out.println("Silver :"+silver.getText());
			WebElement si = driver.findElement(By.xpath("//img[@alt='gold']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'SecondaryName')]"));
			System.out.println("country:"+si.getText());
			WebElement bronze = driver.findElement(By.xpath("//img[@alt='bronze']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'PrimaryName ')]"));
			System.out.println("Bronze :"+bronze.getText());
			WebElement br = driver.findElement(By.xpath("//img[@alt='gold']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'SecondaryName')]"));
			System.out.println("country:"+br.getText());
		}

		catch(Exception e)
		{
			WebElement silver = driver.findElement(By.xpath("//img[@alt='silver']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'PrimaryName ')]|//img[@alt='silver']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'SecondaryName')]"));
			System.out.println("silver :"+silver.getText());
			WebElement bronze = driver.findElement(By.xpath("//img[@alt='bronze']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'PrimaryName ')]|//img[@alt='bronze']//ancestor::tr[contains(@class,'TableRowBody ')]//div[contains(@class,'SecondaryName')]"));
			System.out.println("bronze :"+bronze.getText());
		}
		
		driver.quit();

	}
}


