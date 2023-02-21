package com.dev.nop.ecomerce.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class DashBoardPage extends BasePage {

	
	public  By dashboard_header = By.xpath("//h1[normalize-space()='Dashboard']");
	public By searchBox = By.xpath("//input[@placeholder='Search']");
	
	Logger log = LogManager.getLogger(DashBoardPage.class);
	
	public DashBoardPage(WebDriver driver) {

		driver = BasePage.driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @param menu
	 * catalog
	 * ~products
	 */
	
	public void menuNavigation(String menu) {
		
		WebElement temp1_menuItem=null;
		String menu_item_xpath1=" ",base_xpath=" ";
		String[] menuList = menu.split("~");
		if(menu.contains("~")) {
			base_xpath = "//div[@class='sidebar-form']//following::nav[@class='mt-2']//ul//li";
			for(int i=0;i<menuList.length;i++) {
				menu_item_xpath1 = base_xpath+"//a//p[normalize-space()='"+menuList[i]+"']";
				temp1_menuItem = driver.findElement(By.xpath(menu_item_xpath1));
				if(temp1_menuItem.isDisplayed()) {
					temp1_menuItem.click();
				}
			}
			
		}
		
		
	}
}
