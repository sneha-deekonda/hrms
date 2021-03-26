package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertScript {

	@Test
	public void test1()
	{
		Assert.assertEquals(12, 13, "msg error why caused");
		
	}
	
	//hard and soft asserts
	
}
