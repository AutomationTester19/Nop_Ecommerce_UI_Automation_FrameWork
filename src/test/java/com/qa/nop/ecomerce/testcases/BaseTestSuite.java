package com.qa.nop.ecomerce.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.dev.nop.ecomerce.Listeners.AllureListeners;
import com.dev.nop.ecomerce.PageObjects.BasePage;
import com.dev.nop.ecomerce.PageObjects.LoginPage;

@Listeners({AllureListeners.class})
public class BaseTestSuite extends BasePage {

	
	@BeforeMethod
	public void setUp() {
		
		System.out.println();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.loginEcommerceApp();
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
