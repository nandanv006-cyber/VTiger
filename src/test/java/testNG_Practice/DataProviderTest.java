package testNG_Practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepo.LoginPage;

public class DataProviderTest {
	@Test(dataProviderClass= StoreDataTest.class, dataProvider="excelData")
	public void getData(String un , String pwd,String url)
	{
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);
		driver.quit();
//		System.out.println("company "+Company+"location "+Location);
	}
	
	
//	@DataProvider
//	public Object[][] storeData()
//	{
////		Object[][] object = new Object[1][3];
////		object[0][0]="admin";
////		object[0][1]="admin";
////		object[0][2]="http://localhost:8888/";
////		
//		String url = "http://localhost:8888/";
//		
////		object[1][1]="hydrabad";
////		object[2][0]="infosys";
////		object[2][1]="BTM";
//		return object;
		
	}

