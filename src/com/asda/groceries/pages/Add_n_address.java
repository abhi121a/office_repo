package com.asda.groceries.pages;




import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Add_n_address {
  private WebDriver driver;
  private String baseUrl;
  
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://groceries-qa3.asda.com/";
    driver.get(baseUrl);
    driver.manage().window().maximize();
	driver.navigate().refresh();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
 
  }

  @Test
  public void testAbhi() throws Exception {	
	  Thread.sleep(5000);
		  driver.findElement(By.id("sign-in-button-accessible")).click();
		  driver.switchTo().frame("login");
		  driver.findElement( By.id("username")).sendKeys("abhi@test.com");
		  driver.findElement( By.id("password")).sendKeys("wipro@123");
		  driver.findElement( By.id("btn-signIn-accessible")).click();
		  Thread.sleep(5000);

		  System.out.println("test1-Login Completed");
		  driver.switchTo().defaultContent();
		  
		/*  Thread.sleep(10000);
		  String checkoutoverlay = driver.getWindowHandle();
		  System.out.println(checkoutoverlay);
		  Thread.sleep(5000);
		  driver.switchTo().window(checkoutoverlay);
		  driver.findElement(By.xpath("//a[@id='modal-close-btn']")).click();
		  driver.switchTo().defaultContent();
		  Thread.sleep(5000);*/
		  //title=driver.getTitle();
    //driver.get(baseUrl + "/asda-webstore/landing/home.shtml#");
		  Thread.sleep(5000);	  
    driver.findElement(By.id("sign-in-button-accessible")).click();
    
    driver.switchTo().frame("login");
    driver.findElement(By.linkText("Account settings")).click();
    driver.switchTo().defaultContent();
    
    for(int i=3;i<1010;i++)
    {
    	
    
   
    driver.findElement(By.id("addNewHomeAddress")).click();
    driver.findElement(By.id("f_postcode")).click();
    driver.findElement(By.id("f_postcode")).clear();
    driver.findElement(By.id("f_postcode")).sendKeys("dn211za");
    driver.findElement(By.xpath("//*[@id='addAddress']//a [@class='button-pri findPostCode' and contains(text(),'Find')]")).click();
    driver.findElement(By.xpath("//div[@id='chooseAddressID']/div")).click();
    driver.findElement(By.cssSelector("ul.drop-list > li > span")).click();
    driver.findElement(By.id("f_nickname")).clear();
    driver.findElement(By.id("f_nickname")).sendKeys("Address"+i);
    driver.findElement(By.id("f_delivery_instructions")).clear();
    driver.findElement(By.id("f_delivery_instructions")).sendKeys("home asap");
    driver.findElement(By.id("f_mobile")).clear();
    driver.findElement(By.id("f_mobile")).sendKeys("0987654321");
    driver.findElement(By.xpath("//button")).click();
    Thread.sleep(5000);
    System.out.println("Address"+i);
    //driver.navigate();
  }
    
    System.out.println("congratulation You added 100 addresses");
  }

  @AfterTest
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  }

