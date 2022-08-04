package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetechTheDataFromExcelSheetTest23 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int randomNumber=new Random().nextInt(1000);
		FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties");
		Properties properties =new Properties();
		properties.load(fis);
	       String browser = properties.getProperty("browser").trim();
	       String usename = properties.getProperty("username").trim();
	       String password = properties.getProperty("password").trim();
	        String Url = properties.getProperty("url").trim();
	        String timeouts = properties.getProperty("timeout").trim();
	        
	        
	        FileInputStream fisExcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
			Workbook book = WorkbookFactory.create(fisExcel);
			Sheet sheet = book.getSheet("Contacts");
			String expectedOrganizationName = sheet.getRow(4).getCell(1).getStringCellValue()+randomNumber;
			Sheet sheet1 = book.getSheet("Contacts");
			String expectLastName = sheet1.getRow(2).getCell(1).getStringCellValue()+randomNumber;
			
			WebDriverManager.edgedriver().setup();// method chaining
			WebDriver driver= new EdgeDriver();// abstraction
			driver.manage().window().maximize();
			long longTimeout = Long.parseLong(timeouts);
			driver.get(Url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
			driver.findElement(By.name("user_name")).sendKeys(usename);
			driver.findElement(By.name("user_password")).sendKeys(password);
		  driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			driver.findElement(By.name("lastname")).sendKeys(expectedOrganizationName);
	driver.findElement(By.xpath("//input[@accesskey=\"S\"]")).click();
		String s = driver.findElement(By.id("dtlview_Last Name")).getText();
		if(s.contains("TYSS"))
		{
			System.out.println("name is same");
		}
	}

}
