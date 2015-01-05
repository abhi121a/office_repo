package com.asda.groceries.pages;

import javax.naming.InitialContext;
import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Register extends Postcode {
public Register(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

//WebDriver driver;




@FindBy(xpath="//a [@href='#/registration' and contains(text(),'Register')]")
WebElement register_button;

@FindBy(id="formEmail")
WebElement email;

@FindBy(id="formConfirmEmail")
WebElement email_confirm;

@FindBy(id = "formPassword")
WebElement password;

@FindBy(id ="formConfirmPassword")
WebElement confirm_password;

@FindBy(id="formBusinessYes")
WebElement busi_yes;

@FindBy(id="formBusinessNo")
WebElement busi_no;

@FindBy(id="tAndC")
WebElement terms;

@FindBy(id= "ageCheck")
WebElement agecheck;

@FindBy(id = "servicesCheck")
WebElement servicescheck;
//locate register button in the end of page
@FindBy(id ="registerButton")
WebElement registerButton;
//locate cancel button in the end of page 
@FindBy (id="cancelButton")
WebElement cancelbutton;
//information links and overlays present on the page

@FindBy (id="termsOverlay")
WebElement tandc_overlay;

@FindBy (id="privacyOverlay")
WebElement privacyoverlay;






public void click_register(String postcode){
//	if(test(register_button))
		try {//String test1=register_button.getText();
			//Assert.assertEquals("Register", test1);
			//System.out.println("register is present");
			register_button.click();
		Thread.sleep(5000);
		//test_postcode_Element_present();
		check_postcode(postcode);
		Thread.sleep(5000);
		
	} catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	//else
	//	System.out.println("register is not present");	
	
}

public void fill_reg_form(){
	email.sendKeys("abhi@auto.com");
	email_confirm.sendKeys("abhi@auto.com");
	password.sendKeys("wipro@123");
	confirm_password.sendKeys("wipro@123");
	busi_no.click();
	terms.click();
	agecheck.click();
	servicescheck.click();
	registerButton.click();
	
}


}
