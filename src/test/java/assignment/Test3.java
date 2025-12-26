package assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test3 {

	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[text()='Youtube']"))).perform();
		SearchContext host = driver.findElement(By.xpath("//div[@id='shadow_host']")).getShadowRoot();
		host.findElement(By.cssSelector("[href='https://www.pavantestingtools.com/']~[type='file']")).sendKeys("C:\\Users\\PRATHEEP RAJ S\\Downloads\\might-guy-n2xmbymd7tjjcav0.jpg");
		

	}

}
