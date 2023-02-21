package com.qa.nop.ecomerce.testcases;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dev.nop.ecomerce.Listeners.ExtentReportListener;
import com.dev.nop.ecomerce.PageObjects.BasePage;
import com.dev.nop.ecomerce.PageObjects.DashBoardPage;
import com.dev.nop.ecomerce.PageObjects.LoginPage;
import com.dev.nop.ecomerce.PageObjects.ProductsPage;
import com.dev.nop.ecomerce.utils.Utils;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Listeners({ ExtentReportListener.class })
public class ProductPageTest extends BaseTestSuite {

	@Test(enabled = true)
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the Title Of the Page Before Logging In")
	@Story("Story Name: To Check Login Page Title Before Logging In ")
	public void nop_ecomerce_products_tc001() {

		LoginPage loginpage = new LoginPage(driver);
		BasePage basepage = new BasePage();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Your store. Login");
		basepage.waitForElementToBePresent(loginpage.loginBtn);

	}

	@Test(enabled = true)
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify the Title Of the Page After Logging In")
	@Story("Story Name: To Check Login Page Title After Logging In ")
	public void nop_ecomerce_products_tc002() {

		LoginPage loginpage = new LoginPage(driver);
		BasePage basePage = new BasePage();
		basePage.waitForElementToBePresent(loginpage.loginBtn);
		basePage.getWebElement(loginpage.loginBtn).click();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Dashboard / nopCommerce administration");

	}

	@Test(enabled = true)
	@Severity(SeverityLevel.NORMAL)
	@Description("Verify Page Is Navigated to Products Page")
	@Story("Story Name: To Check Page Is Navigated to Products Page")
	public void nop_ecomerce_products_tc003() {

		LoginPage loginpage = new LoginPage(driver);
		BasePage basePage = new BasePage();
		DashBoardPage dashboardpage = new DashBoardPage(driver);
		ProductsPage productspage = new ProductsPage(driver);
		basePage.waitForElementToBePresent(loginpage.loginBtn);
		basePage.getWebElement(loginpage.loginBtn).click();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Dashboard / nopCommerce administration");
		basePage.waitForElementToBePresent(dashboardpage.searchBox);
		dashboardpage.getWebElement(dashboardpage.searchBox).click();
		dashboardpage.menuNavigation("Catalog~Products");
		basePage.waitForElementToBePresent(productspage.products_header);
		boolean flag = basePage.getWebElement(productspage.products_header).isDisplayed();
		Assert.assertEquals(true, flag, "Products Header Is Displayed");

	}

	@Test(enabled = true)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify New Product Is Created and Same Product is Displayed in Products Grid")
	@Story("Story Name: Create New Product and Verify in Products Grid")
	public void nop_ecomerce_products_tc004() {

		LoginPage loginpage = new LoginPage(driver);
		BasePage basePage = new BasePage();
		DashBoardPage dashboardpage = new DashBoardPage(driver);
		ProductsPage productspage = new ProductsPage(driver);
		basePage.waitForElementToBePresent(loginpage.loginBtn);
		basePage.getWebElement(loginpage.loginBtn).click();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Dashboard / nopCommerce administration");
		basePage.waitForElementToBePresent(dashboardpage.searchBox);
		dashboardpage.getWebElement(dashboardpage.searchBox).click();
		dashboardpage.menuNavigation("Catalog~Products");
		basePage.waitForElementToBePresent(productspage.products_header);
		boolean flag = basePage.getWebElement(productspage.products_header).isDisplayed();
		Assert.assertEquals(true, flag, "Products Header Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.add_new_Btn).isDisplayed(),
				"Add New Button Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.download_catalog_pdf).isDisplayed(),
				"Download Catalog PDF Button Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.export_Btn).isDisplayed(),
				"Export Button  Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.import_Btn).isDisplayed(),
				"Import Button Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.delteBtn).isDisplayed(),
				"Delete(Selected) Button Is Displayed");
		basePage.getWebElement(productspage.add_new_Btn).click();
		Map<String, String> product_dataMap = new HashMap<String, String>();
		product_dataMap.put("productName", "random");
		product_dataMap.put("categoryName", "Electronics");
		product_dataMap.put("manufactureName", "Apple");
		productspage.createNewProduct(product_dataMap);
		productspage.getWebElement(productspage.saveBtn).click();
		basePage.waitForElementToBePresent(productspage.searchBtn);
		basePage.getWebElement(productspage.product_searchBox).sendKeys(product_dataMap.get("productName"));
		basePage.getWebElement(productspage.searchBtn).click();
		Utils.sleep(500);
		WebElement product_grid_name = driver
				.findElement(By.xpath("//table[@id='products-grid']//tbody//tr[1]//td[3]"));
		Assert.assertEquals(product_dataMap.get("productName"), product_grid_name.getText().trim(),
				product_grid_name.getText() + " is Displayed in the Product Grid");
	}

	@Test(enabled = true)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Verify New Product Is Created and Delete The Same Products")
	@Story("Story Name: Create New Product,Delete The Product and Verify in Products Grid")
	public void nop_ecomerce_products_tc005() {

		LoginPage loginpage = new LoginPage(driver);
		BasePage basePage = new BasePage();
		DashBoardPage dashboardpage = new DashBoardPage(driver);
		ProductsPage productspage = new ProductsPage(driver);
		basePage.waitForElementToBePresent(loginpage.loginBtn);
		basePage.getWebElement(loginpage.loginBtn).click();
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, "Dashboard / nopCommerce administration");
		basePage.waitForElementToBePresent(dashboardpage.searchBox);
		dashboardpage.getWebElement(dashboardpage.searchBox).click();
		dashboardpage.menuNavigation("Catalog~Products");
		basePage.waitForElementToBePresent(productspage.products_header);
		boolean flag = basePage.getWebElement(productspage.products_header).isDisplayed();
		Assert.assertEquals(true, flag, "Products Header Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.add_new_Btn).isDisplayed(),
				"Add New Button Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.download_catalog_pdf).isDisplayed(),
				"Download Catalog PDF Button Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.export_Btn).isDisplayed(),
				"Export Button  Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.import_Btn).isDisplayed(),
				"Import Button Is Displayed");
		Assert.assertEquals(true, basePage.getWebElement(productspage.delteBtn).isDisplayed(),
				"Delete(Selected) Button Is Displayed");
		basePage.getWebElement(productspage.add_new_Btn).click();
		Map<String, String> product_dataMap = new HashMap<String, String>();
		product_dataMap.put("productName", "random");
		product_dataMap.put("categoryName", "Electronics");
		product_dataMap.put("manufactureName", "Apple");
		productspage.createNewProduct(product_dataMap);
		productspage.getWebElement(productspage.saveBtn).click();
		basePage.waitForElementToBePresent(productspage.searchBtn);
		basePage.getWebElement(productspage.product_searchBox).sendKeys(product_dataMap.get("productName"));
		basePage.getWebElement(productspage.searchBtn).click();
		Utils.sleep(500);
		WebElement product_grid_name = driver
				.findElement(By.xpath("//table[@id='products-grid']//tbody//tr[1]//td[3]"));
		Assert.assertEquals(product_dataMap.get("productName"), product_grid_name.getText().trim(),
				product_grid_name.getText() + " is Displayed in the Product Grid");
		WebElement chckBox = driver.findElement(By.xpath(
				"//div[@id='products-grid_wrapper']//table[@id='products-grid']//tr//td[1]//input[@name='checkbox_products']"));
		chckBox.click();
        basePage.getWebElement(productspage.delteBtn).click();
        Utils.sleep(200);
        basePage.getWebElement(productspage.yesBtn).click();
	}
}
