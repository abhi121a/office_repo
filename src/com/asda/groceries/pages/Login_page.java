package com.asda.groceries.pages;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Login_page {
WebDriver driver;

public Login_page(WebDriver driver) {
this.driver=driver;
PageFactory.initElements(driver, this);
  }
@FindBy(id ="sign-in-button-accessible")
WebElement sign_in_button;

@FindBy(id ="username")
WebElement username;

@FindBy(id ="password")
WebElement password;

@FindBy(id ="btn-signIn-accessible")
WebElement signin_btn_onframe;


public void login_user(String uname,String pwd) throws Exception{

Thread.sleep(10000);
sign_in_button.click();
driver.switchTo().frame("login");
username.sendKeys(uname);
password.sendKeys(pwd);
signin_btn_onframe.click();
Thread.sleep(10000);

System.out.println("test1-Login Completed");
driver.switchTo().defaultContent();
}






}