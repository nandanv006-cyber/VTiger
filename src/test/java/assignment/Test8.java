package assignment;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test8 
{
	public static void main(String[] args) throws Exception

	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.worldometers.info/geography/countries-of-the-world/");

		driver.findElement(By.xpath("//button[@id='menu-button-5']")).click();
		String option="  Food & Agriculture  ";
		
		driver.findElement(By.xpath("//el-menu//a[contains(.,'Food & Agriculture')]")).click();
		String country=" India ";
		
		Actions act=new Actions(driver);
		act.scrollToElement(driver.findElement(By.xpath("//h2/following-sibling::ul//a[.='India']"))).perform();
		
		driver.findElement(By.xpath("//h2/following-sibling::ul//a[.='India']")).click();
		String data = driver.findElement(By.xpath("(//div[@class='not-prose bg-white border rounded shadow-sm text-center mx-auto max-w-xl']//span[@class='text-2xl font-bold'])[1]")).getText();
		System.out.println(data);
		
		act.scrollByAmount(0, 700).perform();
		
		List<WebElement> points = driver.findElements(By.xpath("//div[@id='country-undernourished-chart']//*[name()='svg']//*[name()='g' and contains(@class,'highcharts-markers highcharts-ser')]//*[name()='path' and contains(@class,'highcharts-point')]"));
		for(WebElement point: points)
		{
			act.moveToElement(point).perform();
			point.click();
			WebElement tt = driver.findElement(By.xpath("//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='tspan']"));
			WebElement tt1 = driver.findElement(By.xpath("//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']"));
			System.out.println(tt.getText()+"=====>"+tt1.getText());
		}

		driver.quit();
	}

}
