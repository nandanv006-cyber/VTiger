package products;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepo.CreateNewProduct;
import ObjectRepo.HomePage;
import ObjectRepo.Product;
import genericUtilities.BaseClass;
import genericUtilities.ExcelUtils;

public class product extends BaseClass{
	@Test(groups="regression")
	
	public void addNewProductInformationTest() throws Exception 
	{	
//		TC_07
		
		ExcelUtils eLib = new ExcelUtils();
		String pathImg="C:\\Users\\Nandan V\\Downloads\\111868_SP781-iPhone-xr.jpg";
		String Product = eLib.readDataFromExcel("Products", 1, 0);
		int ran = jLib.getRandomNumber();
//		String description = eLib.readDataFromExcel("Product", 1, 1);
		
		String exp =Product+ran; 
//		Click on "Products" Link
		HomePage hp = new HomePage(driver);
		hp.clickproductLink();
//		Click on Add new product icon
		Product p = new Product(driver);
		p.clickOnAddProduct();
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.addNewProductInfo(driver,exp,"20",pathImg);
		String actual = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		Assert.assertTrue(actual.contains(exp),"omg its not working ");
//		if(actual.contains(exp))
//			System.out.println("Verified");
//		else
//			System.out.println("Not Verified");
	}
	@Test(groups="regression")
	public  void editProductsTest() throws Exception
	{
//		TC_08
		
		ExcelUtils eLib = new ExcelUtils();
		int ran = jLib.getRandomNumber();
		String Product = eLib.readDataFromExcel("Products", 1, 0);
		String description = eLib.readDataFromExcel("Products", 1, 1);
		String exp =Product+ran;
		String ddvalue="productname";
//		Click on 'products' link
		HomePage hp = new HomePage(driver);
		hp.clickproductLink();
//		Click on 'search' lookup image
		Product p = new Product(driver);
		p.editproduct(driver,ddvalue,exp);
		CreateNewProduct cnp = new CreateNewProduct(driver);
		cnp.editProduct(description);
		WebElement drop = driver.findElement(By.id("bas_searchfield"));
		wLib.dropdownUsingValue(drop, ddvalue);
        
	}
	

}
