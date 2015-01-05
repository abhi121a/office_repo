package com.asda.groceries.data;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import com.asda.groceries.test.*;

public class  Excel_data_setup extends Main_test {
	//Main_test obj3=new Main_test();
	Workbook wbk;
	Sheet sh;
	//int cols_input;
	int rows_output;
	int cols_output;
	
	
	public void inp_excel_read_row_col(){
		
		try {
		wbk = Workbook.getWorkbook(new File("data.xls"));		
		sh=wbk.getSheet(0);
		rows_input=sh.getRows();
	 	cols_input=sh.getColumns();
	 	System.out.println("Input");
	 	System.out.println("No. of rows --" + rows_input );	
	 	System.out.println("No. of cols --" + cols_input);
		} catch (BiffException e) {
				e.printStackTrace();
		} catch (IOException e) {
				e.printStackTrace();
		}
	
	}
public void out_excel_write_row_col(){
			
		//wbk = Workbook.getWorkbook(new File("data.xls"));		
		sh=wbk.getSheet(1);
		rows_output=sh.getRows();
	 	cols_output=sh.getColumns();
	 	System.out.println("Output");
	 	System.out.println("No. of rows --" + rows_output);	
	 	System.out.println("No. of cols --" + cols_output);
		
	
	}
		public Boolean input_excel_relevance(){
		inp_excel_read_row_col();
		boolean excel_relevance=false;
		if(rows_input%5 == 0)
		{ System.out.println("Input file is valid");
		excel_relevance=true;
		}
		else
		System.out.println("Input file is invalid");
		return excel_relevance;
	}
	public Boolean output_excel_relevance(){
		out_excel_write_row_col();
		boolean excel_relevance=false;
		if(cols_output == 2)
		{ System.out.println("Output file is valid");
		excel_relevance=true;
		}
		else
		System.out.println("Output file is invalid");
		return excel_relevance;
	}
	
	 public void data_driven_thru_excel(int j)throws BiffException, IOException{
		user_flag = false;
		if(j+5 !=rows_input){
		String user_a=sh.getCell(1,j).getContents();
		String user_b=sh.getCell(1,j+5).getContents();
		System.out.println("present user--" + user_a);
		System.out.println("next user--" + user_b);
		if(user_a.equals(user_b))
		user_flag = true;
		}
		System.out.println("User flag = " + user_flag);
		System.out.println("***EXL FILE OUTPUT***");
		Cell un = sh.getCell(1,j);
	 	System.out.println("Username --"+ un.getContents());
	 	uname =un.getContents();
	 	
	 	Cell pw = sh.getCell(1,j+1);
	 	System.out.println("password --"+ pw.getContents());
	 	pwd=pw.getContents();
	 	
	 	if(cols_input == 2)
	 	{//item_no =new String[cols_input-1];
	 		item_no=new String[1];	
	 	Cell item= sh.getCell(1,j+2);
	 	item_no[0] = item.getContents();
	 	System.out.println("Product id --"+ item.getContents());
	 	}
	 	if(cols_input > 2)
	 	{ 	
	 					
	 		Cell[] item= sh.getRow(j+2);
	 		//item_no[y]
	 		item_no=new String[item.length-1];
	 		System.out.println(item.length);
	 		for(int i=1;i<item.length;i++)
	 		System.out.println("values--" +i +"---"+ item[i].getContents());
	 		for(int i=1;i<item.length;i++)
	 		{
	 			item_no [i-1]=item[i].getContents();
	 			
	 		}
	 		//for(y=i;y<i)
	 		//item_no [i-1]=item[i+1].getContents();
	 		//System.out.println("values in item_no.entered"+ item_no[i-1]);
	 		//System.out.println("Product id entered in array--"+ i + item.getContents());
	 		//}
	 		
	 	}
	 	
	 	Cell s_date= sh.getCell(1,j+3);
	 	slot_date = s_date.getContents();
	 	System.out.println("Slot Date --"+slot_date);
	 	
	 	
	 	Cell s_time = sh.getCell(1,j+4);
	 	slot_time = s_time.getContents();
	 	System.out.println("Slot Time --" + slot_time);
	 	
	 	
	 	
	 	
	 }
	
	public void Order_no_save(String item_no2, String order)throws BiffException, IOException{
		 try {  
			 System.out.println(item_no2 +"---"+ order);
			 //System.out.println();
		 Workbook workbook = Workbook.getWorkbook(new File("data.xls"));
		 WritableWorkbook workbookCopy= Workbook.createWorkbook(new File("data.xls"), workbook);
		 WritableSheet shsheet= workbookCopy.getSheet(1);
		 Label Item_no;
		 Label Order_nbr;
		int rows_output=shsheet.getRows();
		int cols_output=shsheet.getColumns();
		 //	System.out.println("rows-"+ rows_output);	
		 	//System.out.println("cols-"+cols_output);
		 int x;//y,z;
		 x=rows_output;
		 if (rows_output==1 && cols_output==2)
		 {
			  Item_no = new Label(0,1,item_no2);
			  Order_nbr = new Label(1,1,order); 
		 }
		 /*y=rows-2;
		 z=x-1;
		 System.out.println(x);
		 System.out.println(y);
		 System.out.println(z);
		 	System.out.println( x +  "," +  cols  );
		 	System.out.println( z +  "," +  cols  );*/
		 else {
		 Item_no = new Label(0,rows_output,item_no2);
		  Order_nbr = new Label(1,rows_output,order);
		  System.out.println("Order no. added successfully");
		 } 
		 
			shsheet.addCell(Item_no);
			shsheet.addCell(Order_nbr);
			workbookCopy.write();
	          workbookCopy.close();
	          
	          rows_output=0;
	          cols_output=0;
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

	
	public void new_order_no_save(String order) throws BiffException, IOException{
		try {  
			
			 System.out.println( "Order---"+ order);
			 //System.out.println();
		 Workbook workbook = Workbook.getWorkbook(new File("data.xls"));
		 WritableWorkbook workbookCopy= Workbook.createWorkbook(new File("data.xls"), workbook);
		 WritableSheet shsheet= workbookCopy.getSheet(1);
		 Label Item_no;
		 Label Order_nbr;
		int rows_output=shsheet.getRows();
		int cols_output=shsheet.getColumns();
		 //	System.out.println("rows-"+ rows_output);	
		 	//System.out.println("cols-"+cols_output);
		 int x;//y,z;
		 x=rows_output;
		 if (rows_output==1 && cols_output==2)
		 {
			  Item_no = new Label(0,1,"order-1");
			  Order_nbr = new Label(1,1,order); 
		 }
		/* y=rows-2;
		 z=x-1;
		 System.out.println(x);
		 System.out.println(y);
		 System.out.println(z);
		 	System.out.println( x +  "," +  cols  );
		 	System.out.println( z +  "," +  cols  );*/
		 else {
		 Item_no = new Label(0,rows_output,"order -"+rows_output);
		  Order_nbr = new Label(1,rows_output,order);
		  System.out.println("Order no. added successfully");
		 } 
		 
			shsheet.addCell(Item_no);
			shsheet.addCell(Order_nbr);
			workbookCopy.write();
	          
				workbookCopy.close();
			
	          rows_output=0;
	          cols_output=0;
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


