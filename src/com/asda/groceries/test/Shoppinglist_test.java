package com.asda.groceries.test;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.asda.groceries.data.Register_excel;
import com.asda.groceries.pages.Checkout_slot_evo_sum;
import com.asda.groceries.pages.Login_page;
import com.asda.groceries.pages.Minitrolley_allpage;
import com.asda.groceries.pages.Register;
import com.asda.groceries.pages.Shopping_list;

public class Shoppinglist_test  {
WebDriver driver;
Shopping_list obj;
Register reg;
Register_excel reg_excel;
Login_page login;
Minitrolley_allpage minitrolley;
Checkout_slot_evo_sum ckout;
String[] a;
@BeforeTest
public void setup(){
	reg_excel=new Register_excel();
	reg_excel.inp_excel_read();
	driver=new FirefoxDriver();
	driver.get("http://groceries-qa5.asda.com/");
	driver.manage().window().maximize();
	//driver.navigate().refresh();
	//PageFactory.initElements(driver,obj1 );
	obj=new Shopping_list(driver);
	login=new Login_page(driver);
	minitrolley=new Minitrolley_allpage(driver);
	ckout=new Checkout_slot_evo_sum(driver);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
}
@Test
//register a new user
public void Registeration_test() throws Exception{
		reg.click_register("dn211za");
		//obj.test_postcode_Element_present();
		reg.fill_reg_form();
		Thread.sleep(20000);

}
@Test(enabled=false)
//Login a user
public void Shoppinglist_test_test() throws Exception{
	login.login_user("saraswathi5@wipro.com", "wipro@123");
	//obj.slisttitlecheck();saraswathi5
}
@Test
public void place_order(){
	for(int i=0;i<5;i++)
	{ String slot_type="HD";
		
	obj.add_slist_to_trolley();
	minitrolley.minitrolley_checkout();
	ckout.slot_voucher_summary(slot_type,"01/01/2015", "Before 12pm");
}}


@AfterTest
public void close(){
	
	driver.manage().deleteAllCookies();
	
	driver.close();
	driver.quit();
}


}
