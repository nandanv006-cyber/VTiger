package AdvancePractice1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteMultipleDataToExcel {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=phone&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_2_2_na_na_na&otracker1=AS_QueryStore_OrganicAutoSuggest_2_2_na_na_na&as-pos=2&as-type=RECENT&suggestionId=phone%7CMobiles&requestId=3e29121a-6d53-4153-9d74-54a8759b9104&as-searchtext=ph");
		List<WebElement> ele = driver.findElements(By.xpath("//div[@class='RG5Slk']"));
		int lastele = ele.size();
		
		FileInputStream fis =  new FileInputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("Phones1");
		
		for(int i=0 ; i < lastele ;i++)
		{
			String name = ele.get(i).getText();
			Row row = sh.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(name);
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		wb.write(fos);
		wb.close();
		
		
	}

}
