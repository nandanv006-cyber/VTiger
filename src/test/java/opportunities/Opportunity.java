package opportunities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepo.CreateOpportunityPage;
import ObjectRepo.HomePage;
import ObjectRepo.OpportunitiesPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;

public class Opportunity extends BaseClass {
	@Test(priority=-1,groups = "smoke")
	public  void createOpportunitiesWithMandatoryFieldsTest() throws Exception 
	{
//		TC_06
		ExcelUtils eLib = new ExcelUtils();
		int ran = jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcel("Opportunities", 1, 0);
		String exp = orgName+ran;
//		Click on "Opportinities" link 
		HomePage hp = new HomePage(driver);
		hp.clickOpportunititesLink();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.clickNewOpportunityIcon();
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.createNewopportunity(driver, exp, "TekPyramid", "22");
//		Verification
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actual.contains(exp),"OMG its not working");
		System.out.println("omg its working");
//		if(actual.contains(orgName))
//			System.out.println("Verified");
//		else
//			System.out.println("Not Verified");

	}
	@Test(groups = {"regression","smoke"})
	public  void deleteOpportunitesTest() throws Exception
	{	
//		TC_09

//		navigate to home page and click on Opportunities link
		HomePage hp = new HomePage(driver);
		hp.clickOpportunititesLink();
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.deleteAll();
//		Click on ok button
		wLib.acceptAlert(driver);
		
		String text = driver.findElement(By.xpath("//span[@class='genHeaderSmall']")).getText();
		
		Assert.assertEquals(text, "No Opportunity Found !");
//		if(text.equalsIgnoreCase("No Opportunity Found !"))
//			System.out.println("Verified");
//		else
//			System.out.println("Not Verified");

	}

}
