package AdvancePractice1;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet rough = wb.createSheet("Rough");
		Row row = rough.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("qwertyuiop");
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/AdvancePractice1/Selenium.xlsx");
		wb.write(fos);
		wb.close();
		
		

	}

}
