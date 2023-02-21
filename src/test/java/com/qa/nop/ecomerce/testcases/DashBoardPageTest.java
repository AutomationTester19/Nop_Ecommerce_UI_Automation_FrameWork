package com.qa.nop.ecomerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dev.nop.ecomerce.Listeners.ExtentReportListener;
import com.dev.nop.ecomerce.PageObjects.BasePage;
import com.dev.nop.ecomerce.PageObjects.DashBoardPage;
import com.dev.nop.ecomerce.PageObjects.LoginPage;

@Listeners({ExtentReportListener.class})
public class DashBoardPageTest extends BaseTestSuite {
	
	
	@Test(description="Verify After Login , By Default User is DashBoard Page")
	public void nop_ecomerce_dashboard_tc001() {
		
		LoginPage loginpage = new LoginPage(driver);
		BasePage basepage = new BasePage();
		DashBoardPage dashboardPage = new DashBoardPage(driver);
		basepage.waitForElementToBePresent(loginpage.loginBtn);
		basepage.getWebElement(loginpage.loginBtn).click();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Dashboard / nopCommerce administration");
		boolean flag = basepage.getWebElement(dashboardPage.dashboard_header).isDisplayed();
		Assert.assertEquals(true, flag, "DashBoard Header Is Displayed");
	}

}
