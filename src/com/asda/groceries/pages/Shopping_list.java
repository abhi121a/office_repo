package com.asda.groceries.pages;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Shopping_list {
	WebDriver driver;
	
	public Shopping_list(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="load-your-shoppingList-button-a")
	WebElement Shopping_list;
	
	@FindBy(xpath ="//table[@class='fav-list-table']/tbody/tr[1]/td/div[@id='listIcons']/a[1]")
	WebElement Add_shopping_list;
	
	@FindBy(xpath ="//div[@class='table-body']/div[1]//a[@id='addListToTrolley' and @class='btn btn-primary']")
	WebElement addfirsttotrolley;
	
	
	public void slisttitlecheck(){
		Shopping_list.click();
		String Actual_title=driver.getTitle();
		String Expected_title = "ASDA Groceries - Favourites and Lists";
		Assert.assertEquals(Actual_title, Expected_title);
	}
	public void add_slist_to_trolley(){
		Shopping_list.click();
		addfirsttotrolley.click();
	}
}
