package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchthedtaFromExcellSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		 DataFormatter dataformat = new DataFormatter();
		 FileInputStream fisExcel =new FileInputStream("./src/test/resources/fetchtheDataFromExcelSheet.Xlsx");
		 Workbook workbook = WorkbookFactory.create(fisExcel);
		 Sheet sheet = workbook.getSheet("Contacts");
		String data = dataformat.formatCellValue(workbook.getSheet("Contacts").getRow(4).getCell(1));
		System.out.println(data);
		workbook.close();
		
		 

	}

}
