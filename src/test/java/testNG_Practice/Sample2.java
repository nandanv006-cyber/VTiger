package testNG_Practice;

import org.testng.annotations.Test;

public class Sample2 {
	@Test

	public void sample_M4() 

	{

		System.out.println("----Create---");

	}

	

	@Test

	public void sample_M2()

	{

		System.out.println("----Edit----");

	}

	

	@Test

	public void sample_M3()

	{

		System.out.println("-----Delete-----");

	}

	

	@Test(dependsOnMethods = "sample_M4")

	public void sample_M1()

	{

		System.out.println("-----Test-----");

	}
}
