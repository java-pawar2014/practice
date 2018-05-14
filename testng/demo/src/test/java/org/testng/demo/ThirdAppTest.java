
package org.testng.demo;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ThirdAppTest {

	@Test
	public void firstNGTest() {

		Assert.fail("This is TestNG-Maven Example 3 - test 1 : " + new Date());
	}

	@Test
	public void secondNGTest() {

		System.out.println("This is TestNG-Maven Example 3 - test 2 " + new Date());
	}

}
