package com.asda.groceries.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Minitrolley_allpage {
	
	WebDriver driver;

	public Minitrolley_allpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	  }
	@FindBy(id="miniTrolley-Checkout")
	WebElement mini_checkout;
	
	
	
	public void minitrolley_checkout(){
		try {
			Thread.sleep(5000);
			WebElement contains=driver.findElement(By.xpath("//div [@id='boxMiniTrolley']"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", contains);

		//Thread.sleep(10000);
		mini_checkout.click();
		Thread.sleep(25000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
