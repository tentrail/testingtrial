package com.orangehrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.TestBase;


public class LoginPage extends TestBase {
	public static WebDriver driver;
	// Page Factory - OR:
	@FindBy(name = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement password;

	@FindBy(name = "Submit")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"divLogo\"]/img")
	WebElement crmLogo;

	// Initializing the Page Objects:
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		LoginPage.driver=driver;
	}

//	 Actions:
//	public String validatePageTitle() {
//		return driver.getTitle();
//	}

	public boolean validateImage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return crmLogo.isDisplayed();
	}
	
	
	public void login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
