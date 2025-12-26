package assignment;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.WebDriverUtil;

public class Test6Bigbasket {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver= new ChromeDriver();
		WebDriverUtil wLib = new WebDriverUtil();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver, 10);
		driver.get("https://www.bigbasket.com/");
		
		driver.findElement(By.id("headlessui-menu-button-:Ramkj6:")).click();
		//a[@role='none']
//		(//ul[@role='none'])[2]//li[@class='jsx-1259984711']
//		(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs max-h-120 overflow-y-auto scroll-smooth'])[2]//li[@class='jsx-1259984711']
		List<WebElement> element1 = driver.findElements(By.xpath("//a[@role='none']"));
		
		
			for(WebElement ele1:element1) 
			{
				wLib.mouseHover(driver, ele1);
				
				System.out.println(ele1.getText());
				List<WebElement> element2 = driver.findElements(By.xpath("(//ul[@role='none'])[2]//li[@class='jsx-1259984711']"));
				
				
					for(WebElement ele2:element2)
					{
						wLib.mouseHover(driver, ele2);
						List<WebElement> element3 = driver.findElements(By.xpath("(//ul[@class='jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs max-h-120 overflow-y-auto scroll-smooth'])[2]//li[@class='jsx-1259984711']"));
						System.out.println(ele2.getText());
						Thread.sleep(1000);
							for(WebElement ele3:element3)
							{
								wLib.mouseHover(driver, ele3);
								Thread.sleep(1000);
								System.out.println(ele3.getText());
							}
							
							
							System.out.println(" ");
						
					}
					
					
					
				}
			}
			
			
		
		
		
		
	}


