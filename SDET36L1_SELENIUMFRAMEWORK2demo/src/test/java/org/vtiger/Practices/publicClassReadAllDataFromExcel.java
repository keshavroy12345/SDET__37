package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class publicClassReadAllDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    // FileInputStream fis=new FileInputStream("src/test/resources/fetchtheDatafromExcelSheet.xlsx");
     //Properties properties = new Properties();
     //properties.load(fis);
     
     FileInputStream fisExcel=new FileInputStream("src/test/resources/fetchtheDatafromExcelSheet.xlsx");
     Workbook book= WorkbookFactory.create(fisExcel);
     Sheet sh = book.getSheet("setu");
     
     //get the last used row count
     int count = sh.getLastRowNum();
     for(int i=1; i<count; i++) {
    	
    	 Row row = sh.getRow(8);
    	 
    	 String firstData = row.getCell(7).getStringCellValue();
    	// String secondData = row.getCell(8).getStringCellValue();
    	// System.out.println(firstData+"\t"+secondData);
    	
    	 
     }
     
     
	}

}
