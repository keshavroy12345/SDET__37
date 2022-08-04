package org.vtiger.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;import net.bytebuddy.matcher.EqualityMatcher;
public class CreateContactsPratice1 {
	public static void main(String[] args) throws IOException {
		
		int randomNumber = new Random().nextInt();	
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis);  
		
		 String username = properties.getProperty("username");
		 String password = properties.getProperty("password");
		 String url = properties.getProperty("url");
		 String browser = properties.getProperty("browser");
		 String timeouts = properties.getProperty("timeouts");
		 
		 FileInputStream fisexcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		 Workbook book = WorkbookFactory.create(fisexcel);
		  Sheet sheet = book.getSheet("contacts");
		 String data = sheet.getRow(8).getCell(4).getStringCellValue()+randomNumber;	
		 
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		 driver.manage().window().maximize();
		 driver.get("http://localhost:8888/");
		 
		 driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("root");
		 driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		 
		 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		 driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		 driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("kavita");
 driver.findElement(By.xpath("//b[text()='Contact Information']/../../preceding-sibling::tr/descendant::input[@title=\"Save [Alt+S]\"]")).click();
		 
	String get = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
	
	
		 
		 
	}

}
