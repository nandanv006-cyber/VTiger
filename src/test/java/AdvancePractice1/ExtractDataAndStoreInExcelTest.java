package AdvancePractice1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtractDataAndStoreInExcelTest {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("Mobiles",Keys.ENTER);
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='RG5Slk']"));
		System.out.println(ele.size());

		FileInputStream fis=new FileInputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("ProductName");
		//Row row = sh.createRow(0);
	    //Cell cel = row.createCell(0);
		for (int i = 0; i < ele.size(); i++) {
//			List<WebElement> ele1 = driver.findElements(By.cssSelector("[class='hZ3P6w DeU9vF']"));
//			for (int j = 0; j< ele1.size(); j++) {
//	            String price = ele1.get(j).getText();
//
//	            Row row = sh.getRow(j);
//	            Cell cel = row.createCell(1);
//
//	            cel.setCellValue(price);
//	        }
            String name = ele.get(i).getText();

            Row row = sh.createRow(i);
            Cell cel = row.createCell(0);

            cel.setCellValue(name);
        }
		

		FileOutputStream fos=new FileOutputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		wb.write(fos);
		wb.close();
		}
		
	}

