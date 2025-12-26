package testNG_Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import genericUtilities.ExcelUtils;
import genericUtilities.IpathConstants;

public class StoreDataTest {
	@DataProvider(name ="validinvalid")
	public static Object[][] data1()
	{
		Object[][] obj = new Object[2][3];
		obj[0][0]="admin";
		obj[0][1]="admin";
		obj[0][2]="http://localhost:8888/";
		
		obj[1][0]="admin";
		obj[1][1]="password";
		obj[1][2]="http://localhost:8888/";
		return obj;
		
		
	}
	
	@DataProvider(name="invalidvalid")
	public Object[][] data2()
	{
		Object[][] obj = new Object[3][2];
		obj[0][0]="password";
		obj[0][1]="admin";
		obj[0][2]="http://localhost:8888/";
		
		obj[1][0]="admin";
		obj[1][1]="password";
		obj[1][2]="http://localhost:8888/";
		return obj;
	}

	@DataProvider
	public Object[][] excelData()throws Exception
	{
		ExcelUtils eu = new  ExcelUtils();
		return eu.readDataFromExcelStoreInObj("datafortestng");
	}
}
