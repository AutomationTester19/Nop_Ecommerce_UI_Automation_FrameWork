package com.dev.nop.ecomerce.PageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public By userName = By.id("Email");
	public By passWord = By.id("Password");
	public By loginBtn = By.xpath("//button[normalize-space()='Log in']");

	public LoginPage(WebDriver driver) {

		driver = BasePage.driver;
		PageFactory.initElements(driver, this);

	}

	
	
	

	public void loginEcommerceApp() {

		ecommerceApp();
		waitForElementToBePresent(loginBtn);
		getWebElement(userName).click();
		getWebElement(userName).clear();
		getWebElement(userName).sendKeys(getPropertyValue("username"));
		getWebElement(passWord).click();
		getWebElement(passWord).clear();
		getWebElement(passWord).sendKeys(getPropertyValue("password"));
	}

	public void loginEcommerceApp(String username,String password) {

		ecommerceApp();
		waitForElementToBePresent(loginBtn);
		getWebElement(userName).click();
		getWebElement(userName).clear();
		getWebElement(userName).sendKeys(username);
		getWebElement(passWord).click();
		getWebElement(passWord).clear();
		getWebElement(passWord).sendKeys(password);
	}
}
