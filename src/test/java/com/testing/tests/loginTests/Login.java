package com.testing.tests.loginTests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.testing.tests.CommonTest;

public class Login extends CommonTest {
    protected static final Logger log = Logger.getLogger(Login.class.getName()); 

	
	@Test(groups = { "sanity" })
	public void loginTest() {

		Assert.assertTrue(driver.getTitle().equals("Yahoo"));
		log.info("Running loginTest");

	}
}
