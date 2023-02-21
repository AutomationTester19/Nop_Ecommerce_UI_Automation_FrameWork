package com.dev.nop.ecomerce.utils;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.dev.nop.ecomerce.PageObjects.BasePage;

public class Utils extends BasePage{

	
	public static long getTimeStamp() {
		
		Date date = new Date();
		return date.getTime();
	}
	
	public static int randomIntegerValue() {
		
		Random random = new Random();
		int random_value = random.nextInt();
		return random_value;
	}
	
	public static void JSClick(WebElement element) {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static void sleep(long seconds) {
		
		try {
			Thread.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
