package testNG_Practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.JavaUtils;

public class P1 

{
	@Test
	public void m1 ()
	{
//		driver.findElement(By.xpath("//img[@alt='vtiger-crm-logo.gif']")).click();
		JavaUtils jLib = new JavaUtils();
		String date = jLib.futureDateIntermsOfMonths(2);
		System.out.println(date);
	}
}
