package com.asda.groceries.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout_slot_evo_sum {
	WebDriver driver;

	public Checkout_slot_evo_sum(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	  }

	//elements identifications
	
	
	@FindBy(xpath="//a[@class='button button-sec'and contains(text(),'Finish')]")
	WebElement  finish;

	@FindBy(xpath="//img[@width='203' and @alt='Asda Groceries']")
	WebElement asda_icon;
	
	
	
	
	// Slot page Method
	
	//System.out.println("checkout");
	public String slot_voucher_summary(String slot_type,String slot_date,String slot_time){
	
		
		
		String order_id = null;
		
		
		try {
	String title=driver.getTitle();
	System.out.println(title);

		Thread.sleep(5000);

	title=driver.getTitle();
	if(title .equals("Before you go - ASDA Groceries") )
	 
	{   System.out.println("Before you go - ASDA Groceries in if statement");
	driver.findElement(By.xpath("//div[@id='forgottenListingsContainer']/div[1]/a")).click();
	}


	System.out.println("Choose your slot - ASDA Groceries");
	// Selecting CNC&rcnc slots logic
	WebElement slot_typea=driver.findElement(By.xpath("//div [@class='delivery-type']/a[@data-deliverytype='homedelivery']"));
	//div [@class='delivery-type']/a[@data-deliverytype='homedelivery']
	System.out.println(slot_typea.getAttribute("class"));
	
	if (slot_type.equals("CNC"))
	{
	

		if(slot_typea.getAttribute("class").equals("deliver active"))
		{
			driver.findElement(By.xpath("//a[@class='collect inactive' and @data-deliverytype='clickandcollect']")).click();	
		}
			List<WebElement> listofslots = driver.findElements(By.xpath("//table[@class='slot-table -hour-slots']/tbody/tr/td//a[@data-slotdate='" + slot_date + "']"));
			//"//table[@class='slot-table -hour-slots']/tbody/tr/td/a[@data-slotdate='" + slot_date + "' and @data-slottime='"+ slot_time + "']"));
			System.out.println(listofslots.size());
			listofslots.get(0).click();
	}
	else
	if(slot_type.equals("HD"))
	{
	
		if(slot_typea.getAttribute("class").equals("deliver inactive"))
			{	
			driver.findElement(By.xpath("//a[@class='deliver inactive' and @data-deliverytype='homedelivery']")).click();
			}
		List<WebElement> listofslots = driver.findElements(By.xpath("//table[@class='slot-table two-hour-slots']/tbody/tr/td//a[@data-slotdate='" + slot_date + "']"));
		//"//table[@class='slot-table -hour-slots']/tbody/tr/td/a[@data-slotdate='" + slot_date + "' and @data-slottime='"+ slot_time + "']"));
		System.out.println(listofslots.size());
		listofslots.get(0).click();	
	}

	//WebElement slot_typeb=driver.findElement(By.xpath("//div [@class='delivery-type']/a[@data-deliverytype='clickandcollect']"));
	//div [@class='delivery-type']/a[@data-deliverytype='clickandcollect']





	//Slot xpath is to be changed for cnc n rcnc respectively.


	Thread.sleep(10000);
	String checkoutoverlay = driver.getWindowHandle();
	System.out.println(checkoutoverlay);
	Thread.sleep(5000);
	driver.switchTo().window(checkoutoverlay);
	driver.findElement(By.xpath("//a[@id='checkoutContinueButtonId']")).click();
	driver.switchTo().defaultContent();
	Thread.sleep(5000);
	title=driver.getTitle();
	System.out.println(title);
	if(title .equals("Your eVouchers - ASDA Groceries"))
	{
	System.out.println("evoucher page in if statement");
	//qa5
	driver.findElement(By.xpath("//fieldset[@class='submit-buttons eVoucher-buttons']/button[@class='btn btn-primary continue-chkout']")).click();
	//other qa
	//driver.findElement(By.xpath("//div[@id='eVouchers']/fieldset[2]/button[@class='button button-sec continue-chkout']")).click();
	}
	System.out.println("Order summary - ASDA Groceries");
	WebElement myElement=driver.findElement(By.xpath("//input[@name='f_cc_security_number']"));
	myElement.sendKeys("646");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	if(title =="ASDA Groceries - Order Confirmation");
	order_id = driver.findElement(By.xpath("//div [@class='summary-info']/p[1]/span[2]")).getText();
	System.out.println(order_id);
	asda_icon.click();
	Thread.sleep(20000);
	//slot_box.click();
	//s

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Failed to place order in slot_voucher_summary");
		}
		return order_id;
	}



}
