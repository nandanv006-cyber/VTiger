package contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepo.ContactsPage;
import ObjectRepo.CreateNewContact;
import ObjectRepo.HomePage;
import ObjectRepo.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;
import genericUtilities.FileUtils;
import genericUtilities.WebDriverUtil;

public class Contact extends BaseClass{
	@Test(groups="regression")
	public  void createContactWithOrganizationName() throws Exception
	{
//		TC_05
		ExcelUtils eLib = new ExcelUtils();
		String Lname = eLib.readDataFromExcel("Contacts", 1, 0);
//		Click on "Contact" link
	    HomePage hp = new HomePage(driver);
	    hp.clickContactsPage();
//		Click on Create New Contact icon 
	    ContactsPage cp = new ContactsPage(driver);
	    cp.clickOnAddcontact();
//		Enter valid data inside mandatory fields 
	    CreateNewContact cnc = new CreateNewContact(driver);
	    cnc.createNewContactWithOrganizationName(driver,Lname,"TekPyramid");

//		Verification
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actual.contains(Lname),"Omg its not working");
//		if(actual.contains(Lname))
//			System.out.println("Verified");
//		else
//			System.out.println("Not Verified");

	}
	@Test(groups = {"regression","smoke"})
		public void createContactsWithMandatoryFields() throws Exception 
	{
	
//	TC_04
	
		ExcelUtils eLib = new ExcelUtils();
		String Lname = eLib.readDataFromExcel("Contacts", 1, 0);
	//	Click on "Contact" link
	    HomePage hp = new HomePage(driver);
	    hp.clickContactsPage();
	//	Click on "Create a Contact" link 
	    ContactsPage cp = new ContactsPage(driver);
	    cp.clickOnAddcontact();
	   
	//	Enter valid data inside mandatory fields 
	    CreateNewContact cnc = new CreateNewContact(driver);
	    cnc.createNewContactWithMandateField(Lname);
	//	Verification
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertTrue(actual.contains(Lname), "Omg Its not working");
		//	if(actual.contains(Lname));
	//		System.out.println("Verified");
	//	else
	//		System.out.println("Not Verified");
		

	}


}
