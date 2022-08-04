package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchTheDataFromExcelSheet1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      
		
		FileInputStream fis=new  FileInputStream("./src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis);

		
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook book = WorkbookFactory.create(fisExcel);
		Sheet sheet=book.getSheet("Contacts");
		DataFormatter data = new DataFormatter();
		String s = data.formatCellValue(sheet.getRow(13).getCell(8));
		System.out.println(s);
		
}

}