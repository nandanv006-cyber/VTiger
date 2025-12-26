package genericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils 
{
	/**
	 * This method read the single value in Excel
	 * @author Nandan V
	 * @param name
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Exception
	 */
	public String readDataFromExcel(String name,int rownum,int cellnum)throws Exception
	{
		FileInputStream fi = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
//		Sheet sh = wb.getSheet(name);
//		Row row = sh.getRow(rownum);
//		Cell cell = row.getCell(cellnum);
//		String value = cell.getStringCellValue();
		String value = wb.getSheet(name).getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}
	
	public int getRowCount(String name)throws Exception
	{
		FileInputStream fi = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(name);
		int rowCount = sh.getLastRowNum();
		return rowCount;
	}
	
	public int getCellCount(String name)throws Exception
	{
		FileInputStream fi = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(name);
		int cellCount = sh.getRow(0).getLastCellNum();
		return cellCount;
	}
	
	
	/**
	 * This Method will read multiple data from Excel
	 * @author Nandan V
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> readMultipleDataFromExcel(String name)throws Exception
	{
		FileInputStream fi = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(name);
		int num = getRowCount(name);
		int num2 = getCellCount(name);
		
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0 ;i <=num ; i++ )
		{
			for (int j= 0 ;j<num2;j++)
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				list.add(value);
			}
		}
			
		return list;
	}
	
	public void writeDataToExcel(String name,String value)throws Exception
	{
		FileInputStream fi = new FileInputStream(IpathConstants.excelFilePath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(name);
		Row row = sh.getRow(0);
		Cell cell = row.createCell(0);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IpathConstants.excelFilePath);
		wb.write(fos);
		wb.close();
		
	}
	
	
	public Object[][] readDataFromExcelStoreInObj(String nameofSheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis  =	new FileInputStream(IpathConstants.excelFileForTestNG);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(nameofSheet);
		int lastRow = sh.getPhysicalNumberOfRows();
		int lastCell= sh.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i =0 ; i<lastRow;i++)
		{
			for(int j = 0 ;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
}



