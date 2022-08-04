package org.vtiger.contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsandFetchthedatafromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
        
		
      int randomNumber=new Random().nextInt(1000);
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
		
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook workbook=WorkbookFactory.create(fisExcel);
		Sheet sheet=workbook.getSheet("Contacts");
		String data=sheet.getRow(7).getCell(1).getStringCellValue()+randomNumber;
		System.out.println(data);
		
		
	
		String url = pobj.getProperty("url");
	
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		String browser = pobj.getProperty("browser");
		String timeouts = pobj.getProperty("timeouts");
		System.out.println(username);
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(data);
		

driver.findElement(By.xpath("//b[text()='Contact Information']/../../preceding-sibling::tr/descendant::input[@title=\"Save [Alt+S]\"]")).click();
		String s=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		
		
		if(s.contains("SDET"))
		{
			System.out.println("Validation is Pass");
		}
		else
		{
			System.out.println("Validation is Fail");
		}
		
		
		WebElement wb1=driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]"));
		Actions act1=new Actions(driver);
		act1.moveToElement(wb1).perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.close();
	}

}
