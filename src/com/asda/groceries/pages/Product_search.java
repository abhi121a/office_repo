package com.asda.groceries.pages;
	import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class Product_search {
	  
	   
	  WebDriver driver;

	  public Product_search(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
	  }
	  
	  
	  //Element identification
	  
	  
	  @FindBy(css =".button.button-sec.addItemToTrolley.fav-test-item")
	  WebElement add_btn; 
	  
	  
	  //"//a[@data-skuid='20293' and contains(text(),'Add')]")
	  //(xpath="//a[@data-skuid='20293']")
	  //(css =".button.button-sec.addItemToTrolley.fav-test-item")

	  @FindBy(id="plusButtonId")
	  WebElement plus_button;
	  
	  @FindBy(xpath="//input [@class='prd-txt' and @type='number']")
	  WebElement prd_txt;
	  
	  @FindBy(xpath="// a[@id='applyItemToTrolley' and @class='button button-sec add-small']")
	  WebElement add_prd;
	  
	  @FindBy(id="listingsContainer")
	  WebElement list_container;

	  @FindBy(className ="container")
	  WebElement container;
	  
		  
	  @FindBy(name ="search")
	  WebElement search_box;

	  @FindBy(className="search-button")
	  WebElement search_button;
	  
	  public void search_add_product_checkout(String item) throws Throwable{
		  Product_search search=new Product_search(driver);
		  search_box.sendKeys(item);
		  System.out.println("Item searched");
		  Thread.sleep(5000);
		  search.searchclick();
		  //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		  System.out.println("searched");
		  //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  //System.out.println("add wait");
		  //list_container.click();
		  //container.click();
		  //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", list_container);
		  //Thread.sleep(10000); 
		  add_btn.click();
		  //Thread.sleep(5000);
		  System.out.println("Product added");
		  Thread.sleep(5000);
		  prd_txt.click();
		  prd_txt.sendKeys("10");
		  add_prd.click();


		  /*for(int i =0;i<10;i++)
		  {
		   plus_button.click();
		   Thread.sleep(5000);
		   System.out.println(i);
		  }
		  */}
	  
	  void searchclick()
	  {
	    System.out.println("Search");
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    search_button.click();
	    
	  }
	}


