package calender;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ObjectRepo.CalenderPage;
import ObjectRepo.HomePage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
@Listeners
public class Calender extends BaseClass
{
	@Test(groups = "regression")
	public  void addEventInTheCalender() throws Exception 
	{	
//		TC_11
		ExcelUtils eLib = new ExcelUtils();
		String eventname = eLib.readDataFromExcel("Calender", 1, 0);
		String descripion = eLib.readDataFromExcel("Calender", 1, 1);
		HomePage hp = new HomePage(driver);
		hp.clickCalenderLink();
		CalenderPage cp = new CalenderPage(driver);
		cp.addAnEventInDay(driver, eventname, descripion);
	}

}
