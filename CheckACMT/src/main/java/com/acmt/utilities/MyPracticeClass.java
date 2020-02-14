package com.acmt.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyPracticeClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Xls_Reader reader=new Xls_Reader("C:\\Users\\swapnil.kadale\\Documents\\My Practice Book.xlsx");
		List<String> myList=new ArrayList<String>();
		int columnCount=reader.getColumnCount("Sheet1");
		int rowCount=reader.getRowCount("Sheet1"); 
		System.out.println("Column Count"+columnCount+"Row Count"+rowCount);
		for(int i=2;i<rowCount;i++)
		{
			for(int j=1;j<columnCount;j++)
			{
				myList.add(reader.getCellData("Sheet1", j, i));
			}
		}
		/*
		 * while(myList.listIterator().hasNext()) {
		 * System.out.println(myList.listIterator().next()); }
		 */
		
		System.out.println(myList);
	}

}
//}