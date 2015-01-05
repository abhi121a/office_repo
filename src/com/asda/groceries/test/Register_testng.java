package com.asda.groceries.test;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.asda.groceries.data.Register_excel;
import com.asda.groceries.pages.Register;

public class Register_testng {
WebDriver driver;
Register obj;
Register_excel obj1;
String[] a;
@BeforeTest
public void setup(){
	obj1=new Register_excel();
	obj1.inp_excel_read();
	driver=new FirefoxDriver();
	driver.get("http://groceries-qa3.asda.com/");
	driver.manage().window().maximize();
	driver.navigate().refresh();
	//PageFactory.initElements(driver,obj1 );
	obj=new Register(driver);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
}
@Test
public void Registeration_test() throws Exception{
		obj.click_register("dn211za");
		//obj.test_postcode_Element_present();
		obj.fill_reg_form();
		Thread.sleep(20000);

}

@AfterTest
public void Closing_browser()
{	driver.manage().deleteAllCookies();
	driver.close();
	driver.quit();
}
}

