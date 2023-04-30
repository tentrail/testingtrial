package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.TestBase;
import com.orangehrm.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginpage;

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test
	public void loginPageTitleTest() {
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		loginpage = new LoginPage(driver);
		loginpage.login(un, pwd);
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}