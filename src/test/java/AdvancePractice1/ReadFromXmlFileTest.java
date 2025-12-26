package AdvancePractice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXmlFileTest 
{
	@Test
	public void readXMLfile(XmlTest test)
	{
		System.out.println(test.getParameter("browser"));
		System.out.println(test.getParameter("url"));
		System.out.println(test.getParameter("username"));
		System.out.println(test.getParameter("password"));
		
		
		String URL =test.getParameter("url");
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
	
		
	} 
}
