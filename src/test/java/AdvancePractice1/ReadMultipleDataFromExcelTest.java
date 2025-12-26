package AdvancePractice1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadMultipleDataFromExcelTest {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fi = new FileInputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Methods");
		
		int lastrow = sh.getLastRowNum();
		
		for(int i =0;i<=lastrow;i++)
		{
			String methods = sh.getRow(i).getCell(0).getStringCellValue();
			String modifiers = sh.getRow(i).getCell(1).getStringCellValue();
			
			
			System.out.println(methods +"               "+modifiers);
		}
		
		
	}

}
