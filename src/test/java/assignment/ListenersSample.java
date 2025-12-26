package assignment;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;


@Listeners(genericUtilities.ListenersImplimentationClass.class)

public class ListenersSample extends BaseClass
{ 
	@Test
	public void m1() {
		System.out.println("ohh yaaa");
	}
	@Test
	public void m2() {
		System.out.println("ohh yaaa");
		Assert.fail();
	}@Test
	public void m3() {
		System.out.println("ohh yaaa");
	}
	
}
