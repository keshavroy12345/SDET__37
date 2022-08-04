package org.vtiger.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactPratice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 
		int randomNumber = new Random().nextInt();
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
	String usename = properties.getProperty("username");
	  String password = properties.getProperty("password");
	  String browser = properties.getProperty("browser");
	  String url = properties.getProperty("url");
	  String timeout = properties.getProperty("timeouts");
	  
	  FileInputStream fisExcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
	  Workbook book=WorkbookFactory.create(fisExcel);
	  Sheet sheet = book.getSheet("Contacts");
	  String data = sheet.getRow(1).getCell(1).getStringCellValue()+randomNumber;
	    String data1 = sheet.getRow(3).getCell(1).getStringCellValue()+randomNumber;
	    
	   WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	 driver.get("http://localhost:8888/");
	 
	  driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("root");
		  driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		  
		  driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		  driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	

	}

}
