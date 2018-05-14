
package org.testng.demo;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondAppTest {

	@Test
	public void firstNGTest() {

		Assert.fail("This is TestNG-Maven Example 2 - test 1 : " + new Date());
	}

	@Test
	public void secondNGTest() {

		System.out.println("This is TestNG-Maven Example 2 - test 2 " + new Date());
	}

}
