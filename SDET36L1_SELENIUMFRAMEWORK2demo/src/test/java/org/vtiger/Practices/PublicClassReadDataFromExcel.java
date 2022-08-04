package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PublicClassReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fis=new FileInputStream("src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh = book.getSheet("setu");
		Row row = sh.getRow(6);
		Cell cell = row.getCell(3);
		
		String data = cell.getStringCellValue();
		System.out.println(data);
		
		

	}

}
