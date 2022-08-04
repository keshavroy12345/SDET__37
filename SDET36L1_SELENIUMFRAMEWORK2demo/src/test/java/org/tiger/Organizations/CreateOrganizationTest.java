package org.tiger.Organizations;

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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     
		
		 int randomNumber = new Random().nextInt(1000);
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties properties = new Properties();
	    properties.load(fis);
	    
	    String browser = properties.getProperty("browser").trim();
	       String usename = properties.getProperty("username").trim();
	       String password = properties.getProperty("password").trim();
	        String Url = properties.getProperty("url").trim();
	        String timeouts = properties.getProperty("timeout").trim();
	        
	        FileInputStream fisExcel =new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
	        Workbook book =WorkbookFactory.create(fisExcel);
	      Sheet sheet = book.getSheet("Contacts");
	      String data = sheet.getRow(1).getCell(1).getStringCellValue()+randomNumber;
	     String data1 = sheet.getRow(2).getCell(1).getStringCellValue()+randomNumber;
	       
	      
	  	WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		driver.manage().window().maximize();
	driver.get("http://localhost:8888/");
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("root");
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	driver.findElement(By.name("accountname")).sendKeys(data);
	driver.findElement(By.name("button")).click();
   String s=driver.findElement(By.id("dtlview_Organization Name")).getText();
	        
	}

}
