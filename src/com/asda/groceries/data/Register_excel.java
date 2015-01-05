package com.asda.groceries.data;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Register_excel {
	Workbook wbk;
	Sheet sh;
	int rows_input;
	int cols_input;
	
 void inp_excel_read_row_col(){
		
		try {
		wbk = Workbook.getWorkbook(new File("data.xls"));		
		sh=wbk.getSheet("Register");
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

 public void inp_excel_read(){
	String[] a= new String[5];
	inp_excel_read_row_col();
	Cell Store_id=sh.getCell(1,0);
	a[0]=Store_id.getContents();
	System.out.println(a[0]);
	Cell postcode=sh.getCell(1,1);
	a[1]=postcode.getContents();
	System.out.println(a[1]);
	Cell email=sh.getCell(1,2);
	a[2]=email.getContents();
	System.out.println(a[2]);
	Cell pwd=sh.getCell(1,3);
	a[3]=pwd.getContents();
	System.out.println(a[3]);
	Cell Business=sh.getCell(1,4);
	a[4]=Business.getContents();
	System.out.println(a[4]);
	//return a[5];
	
	for(int i=0;i<5;i++){
		System.out.println(a[i]);
	}
}




}