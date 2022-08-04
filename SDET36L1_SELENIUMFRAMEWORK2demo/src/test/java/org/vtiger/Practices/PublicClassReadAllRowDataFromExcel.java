package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PublicClassReadAllRowDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("shetu");
		//get the last used row count
		 int count = sh.getLastRowNum();
		 
		 String expectedData = "keshavram";
		 for(int i=1; i<count; i++); {
			 
			Row row = sh.getRow(6);
			String firstcolData = row.getCell(7).getStringCellValue();
			
			if (firstcolData.equals(expectedData)) {
		
		String secondData = row.getCell(count).getStringCellValue();
		System.out.println("available...."+secondData);
			}
	//	break;
			}
		 }
}
		

		
