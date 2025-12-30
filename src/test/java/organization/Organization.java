package organization;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ObjectRepo.CreateNewOrganizationPage;
import ObjectRepo.HomePage;
import ObjectRepo.OrganizationPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.RetryImplimentationClass;


public class Organization extends BaseClass
{
	@Test(groups="regression",retryAnalyzer = RetryImplimentationClass.class)
	public  void createOrganizationWithMandatoryFieldsTest() throws Exception
	{
//		TC_02
		ExcelUtils eLib = new ExcelUtils();
		int ran = jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcel("Organization", 1, 0);
		String exp =orgName+ran; 

//		Navigate to Home Page click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationsLink();
		
//		Click on Create Organization lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickNewOrganizationicon();
		
//		Enter valid data inside mandatory fields 
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrgMandateFiled(exp);
		

//		Verification
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actual.contains(orgName),"<b>Omg its not Working</b>");
//		if(actual.contains(orgName))
//			System.out.println("Verified");
//		else
//			System.out.println("Not Verified");
	}
	
	@Test(groups = {"regression","smoke","fumctional"})
	public  void createOrganizationTypeWithIndustryTypeTest() throws Exception 
	{
		ExcelUtils eLib = new ExcelUtils();
		int ran = jLib.getRandomNumber();
		String orgName = eLib.readDataFromExcel("Organization", 1, 0);
		String exp =orgName+ran; 
//		Navigate to Home Page click on Organization Link
		HomePage hp = new HomePage(driver);
		hp.clickOrganizationsLink();
//		Click on Create Organization lookup image
		OrganizationPage op = new OrganizationPage(driver);
		op.clickNewOrganizationicon();
//		Enter valid data inside mandatory fields 
		CreateNewOrganizationPage cno = new CreateNewOrganizationPage(driver);
		cno.createOrgIndustryType(exp, "Healthcare");
//		Verification
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actual.contains(orgName), "Omg its not Working");
//		if(actual.contains(orgName))
//			System.out.println("Verified");
//		else
//			System.out.println("Not Verified");
//		System.out.println("checking if this method works");
	}
	
}

