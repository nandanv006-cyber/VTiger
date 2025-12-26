package testNG_Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo {

	@BeforeClass
	public void bc() {
		System.out.println("bc");	
	}
	@AfterClass
	public void ac()
	{
		System.out.println("ac");
	}
	@BeforeMethod
	public void bm() {
		System.out.println("bm");	
	}
	@AfterMethod
	public void am() {
		System.out.println("am");	
	}
	@Test
	public void d1()
	{
		System.out.println("d1 mkc");
	}
}
