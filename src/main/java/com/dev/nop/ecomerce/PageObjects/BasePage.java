package com.dev.nop.ecomerce.PageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dev.nop.ecomerce.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static Properties prop;
	public static WebDriver driver;
	public static FileInputStream inputStream;
	public static WebDriverWait wait;

	Logger log = LogManager.getLogger(BasePage.class);
	
	public Properties getProperty() {

		String filePath = System.getProperty("user.dir") + "//config.properties";
		try {
			inputStream = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

	public String getPropertyValue(String key) {

		Properties property = getProperty();
		String propertyValue = "";
		if (!key.isEmpty()) {
			propertyValue = property.getProperty(key);
		}

		return propertyValue;
	}

	public void ecommerceApp() {

		String browser = getPropertyValue("browser");

		if (browser.equalsIgnoreCase("chrome"))
			driver = WebDriverManager.chromedriver().create();
		else if (browser.equalsIgnoreCase("edge"))
			driver = WebDriverManager.edgedriver().create();

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(getPropertyValue("url"));
	}
	
	public void waitForElementToBePresent(By locator) {

		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			log.info("Element is present in the Dom " +locator);
		} catch (ElementNotInteractableException e) {
			log.error("Element is not present in the Dom " +locator);
			e.printStackTrace();
		}
	}
	public WebElement getWebElement(By locator) {

		WebElement webElement = driver.findElement(locator);
		return webElement;
	}
	
	public String selectDropDownValue(By dropdownLocator,String value) {
		
		String dropdwn = getLocatorAsString(dropdownLocator);
		WebElement drpdown = null;
		if(!dropdwn.isEmpty())
		{
			drpdown = driver.findElement(By.xpath(dropdwn+"//li[normalize-space()='"+value+"']"));
			Utils.JSClick(drpdown);
		}
		
		log.info("Selected Value From DropDown " +value);
		return value;
	}
	
	public static String getLocatorAsString(By by) {
        String str = by.toString();
        return str.substring(str.indexOf(" ") , str.length());
      }
	
	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}
		return path;
	}

}
