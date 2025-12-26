package testNG_Practice;

import org.testng.annotations.Test;

public class SampleTest    
{
	@Test(priority = -99)
	public void sample_1()
	{
		System.out.println("--1--");
	}
	@Test
	public void sample_4()
	{
		
		System.out.println("--4--");
	}
	@Test(dependsOnMethods = "sample_4" ,priority = -100)
	public void sample_2()
	{
		System.out.println("--2--");
	}
	
	@Test(dependsOnMethods = "sample_4" ,priority = -100)
	public void sample_5()
	{
		System.out.println("--5--");
	}
	@Test(dependsOnMethods = "sample_4" ,priority = -100)
	public void sample_6()
	{
		System.out.println("--6--");
	}
	@Test(dependsOnMethods = "sample_4" ,priority = -100)
	public void sample_7()
	{
		System.out.println("--7--");
	}
	
}
