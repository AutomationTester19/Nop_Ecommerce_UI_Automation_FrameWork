package com.dev.nop.ecomerce.PageObjects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.dev.nop.ecomerce.utils.Utils;

public class ProductsPage extends BasePage {
	
	public By products_header = By.xpath("//h1[normalize-space()='Products']");
	public By add_new_Btn = By.xpath("//*[normalize-space()='Add new']");
	public By download_catalog_pdf = By.xpath("//*[normalize-space()='Download catalog as PDF']");
	public By export_Btn = By.xpath("//*[normalize-space()='Export']");
	public By import_Btn = By.xpath("//*[normalize-space()='Import']");
	public By category_dropdwnValue = By.id("SearchCategoryId");
	public By product_searchBox = By.name("SearchProductName");
	public By warehouse_dropdownValue = By.name("SearchWarehouseId");
	public By product_name_element = By.cssSelector("#Name");
	public By categories_list = By.xpath("//ul[@id='SelectedCategoryIds_listbox']");
	public By manfacture_list = By.xpath("//ul[@id='SelectedManufacturerIds_listbox']");
	public By categories_element = By.cssSelector("ul#SelectedCategoryIds_taglist+input");
	public By manufactures_element = By.cssSelector("ul#SelectedManufacturerIds_taglist+input");
	public By shortDesc = By.id("ShortDescription");
	public By saveBtn = By.name("save");
	public By productSearchBox = By.id("SearchProductName");
	public By searchBtn = By.id("search-products");
	public By delteBtn = By.id("delete-selected");
	public By yesBtn = By.xpath("//*[normalize-space()='Yes']");

	public ProductsPage(WebDriver driver1) {

		driver1 = BasePage.driver;
		PageFactory.initElements(driver1, this);

	}

	public Map<String, String> createNewProduct(Map<String, String> productMap) {

		String productName_Key = " ", categoryName_key = " ", manufactureName_key = " ";
		try {
			if (productMap.get("productName").equals("random"))
				productName_Key = "Automation_Product_" + Utils.getTimeStamp();
			else
				productName_Key = productMap.get("product_name");

			productMap.put("productName", productName_Key);
			getWebElement(product_name_element).sendKeys(productMap.get("productName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		getWebElement(categories_element).click();
		try {
			if (productMap.get("categoryName").equals("random")) {
				categoryName_key = selectDropDownValue(categories_list, "random");
			} else
				{ 
				categoryName_key = productMap.get("categoryName");
			    selectDropDownValue(categories_list, categoryName_key);
				}
			    
			productMap.put("categoryName", categoryName_key);
		} catch (Exception e) {
			e.printStackTrace();
		}
       getWebElement(manufactures_element).click();
		try {
			if (productMap.get("manufactureName").equals("random")) {
				manufactureName_key = selectDropDownValue(manfacture_list, "random");
			} else
			{	manufactureName_key = productMap.get("manufactureName");
			    selectDropDownValue(manfacture_list, manufactureName_key);
			}
			productMap.put("manufactureName", manufactureName_key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return productMap;
	}
}
