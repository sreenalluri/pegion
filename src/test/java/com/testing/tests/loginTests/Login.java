package com.testing.tests.loginTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testing.tests.CommonTest;

public class Login extends CommonTest {

	@Test(groups = { "sanity" })
	public void loginTest() {

		Assert.assertTrue(driver.getTitle().equals("Yahoo"));

	}
}
