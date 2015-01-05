package com.asda.groceries.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Postcode 
{  WebDriver driver;

	public Postcode(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);}
	
@FindBy(xpath="//img[@width='203' and @alt='Asda Groceries']")
WebElement asda_icon;


@FindBy(xpath="//a[@class='button button-ter' and contains(text(),'Need some help?')]")
WebElement need_some_help;

@FindBy(xpath="//span[@class='arrow-back' and contains(text(),'Back to shop')]")
WebElement Back_to_shop;

@FindBy(xpath="//div[@id='reg-wrapper']/h1[contains(text(),'Registering is quick and easy')]")
WebElement register_text;

@FindBy(id="postcode")
WebElement postcode_text_box;

@FindBy(xpath="//input[@class='btn btn-accent' and @value='Continue']")
WebElement continue_button;

@FindBy(xpath="//a[@class='button button-ter online-help-link' and contains(text(),'Online help')]")
WebElement Online_help_button;

public boolean test(WebElement element) {
	boolean flag=false;
	try{
		if(element.isDisplayed())
		flag=true;
		return flag;
	}catch(Exception throwException)
	{
	return flag;
	}
	
}
public void test_postcode_Element_present(){
	if(test(asda_icon)){
		System.out.println("asda icon present");
		}
	else
		System.out.println("asda icon not present");
	if(test(need_some_help)){
		System.out.println("need_some_help present");
	}
}

public void check_postcode(String postcode){
	postcode_text_box.click();
	postcode_text_box.sendKeys(postcode);
	continue_button.click();
}



}
