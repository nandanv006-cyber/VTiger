package assignment;

import org.testng.asserts.SoftAssert;

public class Practice1 {

	public static void main(String[] args) {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("qwertyuiop");
		System.out.println("qwertyuiop");
		sa.assertEquals("a", "b","omg error ");
		
		System.out.println("qwertyuiop");
		System.out.println("qwertyuiop");
		sa.assertAll();
		
	}

}
