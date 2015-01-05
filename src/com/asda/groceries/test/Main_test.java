package com.asda.groceries.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.asda.groceries.data.Excel_data_setup;
import com.asda.groceries.pages.*;

	public class Main_test {
		protected static String uname;
		protected static String pwd;
		
		protected static String slot_date;
		protected static String slot_time;
		protected static String order_no;
		protected static int rows_input;
		protected static int cols_input;
		protected static boolean user_flag;
		static WebDriver driver;
		static Login_page login;
		static Checkout_slot_evo_sum chk_slot;
		static Product_search search;
		static Minitrolley_allpage mini_trolley;
		static Excel_data_setup obj2;
		protected static String[] item_no;
		
		
		
		
	public static void main(String args[]) throws Throwable{
		
		//Register obj4=new Register(driver);
		
System.out.println("Verifying Output Excel............");
//Objects
obj2=new Excel_data_setup();
if(obj2.input_excel_relevance() && obj2.output_excel_relevance())
	{  
		obj2.inp_excel_read_row_col();
		for( int j=0;j<rows_input;j=j+5)
			   {
			System.out.println("values for row starts with --"+ j);
			obj2.data_driven_thru_excel(j);
			
			driver=new FirefoxDriver();
			driver.get("http://groceries-qa5.asda.com/");
			driver.manage().window().maximize();
			driver.navigate().refresh();
			//PageFactory.initElements(driver,obj1 );
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
			//Register obj4=new Register(driver);
			//PageFactory.initElements(driver,obj4 );
			//obj4.click_register("dn211nz");
			
			
			login=new Login_page(driver);
			login.login_user(uname,pwd);
			for(int y=0;y<item_no.length;y++)
			{
				search.search_add_product_checkout(item_no[y]);
			}
			mini_trolley.minitrolley_checkout();
			//order_no = "789790";
			order_no =chk_slot.slot_voucher_summary("CNC",slot_date, slot_time);
			System.out.println("Storing order no.----"+order_no);
			//System.out.println(item_no.length);
			for(int y=0;y<item_no.length;y++)
			{
				System.out.println(item_no[y]);
			}
			//for(int x=0;x<item_no.length;x++)
			//{	 System.out.println(item_no[x]+ "--A--"+ order_no);
				//obj2.Order_no_save(item_no[x], order_no);
			//}
			obj2.new_order_no_save(order_no);
			System.out.println("Checking user is same --" + user_flag);
			if(user_flag)
				    {
				j=j+5;
				System.out.println(j);
				    
					//driver.get("http://groceries-qa3.asda.com/");
				    obj2.data_driven_thru_excel(j);
				   System.out.println(uname + pwd +item_no + slot_date + slot_time);
				    for(int y=0;y<item_no.length;y++)
					{
						search.search_add_product_checkout(item_no[y]);
					}
					mini_trolley.minitrolley_checkout();
					order_no =chk_slot.slot_voucher_summary("CNC",slot_date, slot_time);
					System.out.println("Storing order no.");
					for(int x=0;x<item_no.length;x++)
					{    System.out.println(item_no[x]+ "--A--"+ order_no);
						obj2.Order_no_save(item_no[x], order_no);
					}
					//String order_no1="123123";
					obj2.new_order_no_save(order_no);
					System.out.println("Order no. stored");
					System.out.println("Checking user is same --" + user_flag);
				    
				    //j=j+5;
				    System.out.println(j);
				    }
				    else
				    {
				    System.out.println("Test completed closing the Browser");
				    //driver.close();
				    //driver.quit();
				    }
				    
		
						
		 
		}	System.out.println("data read and used completely");
			 System.out.println("Successfully completed");
			 }
		else
		{
			System.out.println("failed please verify data sheet");
			
		}
	    
	    
	   
	}
	public static void webdriver_setup_heart(){
			
	}
	
	
	}
/*	 		
	 		
	 	//System.out.println("Xpath for Slot page "+"//table[@class='slot-table two-hour-slots']/tbody/tr/td/a[@data-slotdate='" + slot_date + "' and @data-slottime='"+ slot_time + "']");
	 	
	 	
			 	count=0;
			 	for(int row=4;row<=rows-1;row++)
			 		{
			 		Cell productid=sh.getCell(2,row);
			 		//System.out.println(productid.getContents());
			 		cinlist1.add(productid.getContents());
			 		
			 		System.out.println("Product cin no. added to array at"+count+ "index is"+ cinlist1.get(count));
			 //System.out.println(cinlist1.get(0));
			 		
			 count++;
	 	 
	 
	 public static void Order_no_save(String item, String order)throws BiffException, IOException{
		 try {  
			 System.out.println(item);
			 System.out.println(order);
		 Workbook workbook = Workbook.getWorkbook(new File("data.xls"));
		 WritableWorkbook workbookCopy= Workbook.createWorkbook(new File("data.xls"), workbook);
		 WritableSheet shsheet= workbookCopy.getSheet(1);
		 Label Item_no;
		 Label Order_nbr;
		int rows=shsheet.getRows();
		int cols=shsheet.getColumns();
		 	System.out.println("rows-"+ rows);	
		 	System.out.println("cols-"+cols);
		 int x;//y,z;
		 x=rows;
		 if (rows==1 && cols==2)
		 {
			  Item_no = new Label(0,1,item);
			  Order_nbr = new Label(1,1,order); 
		 }
		 y=rows-2;
		 z=x-1;
		 System.out.println(x);
		 System.out.println(y);
		 System.out.println(z);
		 	System.out.println( x +  "," +  cols  );
		 	System.out.println( z +  "," +  cols  );
		 else {
		 Item_no = new Label(0,rows,item);
		  Order_nbr = new Label(1,rows,order);
		  System.out.println("adsfasd");
		 } 
		 
			shsheet.addCell(Item_no);
			shsheet.addCell(Order_nbr);
			workbookCopy.write();
	          workbookCopy.close();
	          
	          rows=0;
	          cols=0;
	          x=0;
	          Item_no=null;
	         Order_nbr=null;

		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 }	

	 }

*/