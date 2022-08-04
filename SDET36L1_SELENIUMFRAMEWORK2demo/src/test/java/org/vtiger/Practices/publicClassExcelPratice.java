package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class publicClassExcelPratice {

	public static void main(String[] args) throws IOException {
		
	//read common data from properties file
		FileInputStream fis=new FileInputStream("src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis); 
		
		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String username = properties.getProperty("username");
		String browser = properties.getProperty("browser");
		String timeout = properties.getProperty("timeouts");
		
		//getrandom number
		Random ran=new Random();
		int RandomNum = ran.nextInt(10000);
		
		//read test data from excel file
		FileInputStream fisExcel= new FileInputStream("src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook book=WorkbookFactory.create(fisExcel);
		Sheet sh=book.getSheet("setu");
		Row row = sh.getRow(6);
		Cell cell = row.getCell(3);
		String data = row.getCell(3).getStringCellValue()+RandomNum;
		System.out.println(data);
		

	}

}
