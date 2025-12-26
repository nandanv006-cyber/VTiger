package AdvancePractice1;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fs  = new FileInputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		
		Workbook wb = WorkbookFactory.create(fs);
		
		Sheet sh = wb.getSheet("Methods");
		
		Row row = sh.getRow(0);
		
		Cell cell = row.getCell(0);
		
		String method = cell.getStringCellValue();
		
		String modifiers = row.getCell(1).getStringCellValue();
		
		System.out.println(method+"  "+modifiers);
		
		
	}

}
