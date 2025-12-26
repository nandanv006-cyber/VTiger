package AdvancePractice1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadDataFromPropertyFileTest 
{
	public static void main(String[] args) throws Exception
	{
		
		//create object for a physical representation of file 
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\AdvancePractice1\\commondata.properties");
		
		//object for properties class
		Properties pObj = new Properties();
		
		//load all the Keys
		pObj.load(fis);
		
		//fetch the value using "getProperty" method 
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);
		
		
		//launch a browser
		WebDriver driver = null;
		
		if(BROWSER.equalsIgnoreCase("chrome"))
			driver =  new ChromeDriver();
		else if(BROWSER.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if(BROWSER.equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(URL);
		
		//sending values
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		Thread.sleep(3000);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		Thread.sleep(3000);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		
		driver.quit();
		
		
		
	
		
	}
}
