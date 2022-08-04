package org.vtiger.contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest11 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
			int randomNumber= new Random().nextInt(1000);
			FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties");
			Properties properties= new Properties();
			properties.load(fis);
			
			String browser=properties.getProperty("browser").trim();
			String url=properties.getProperty("url").trim();
			String username=properties.getProperty("username").trim();
			String password=properties.getProperty("password").trim();
			String timeout=properties.getProperty("timeouts").trim();
			FileInputStream fisExcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.Xlsx");
			Workbook book = WorkbookFactory.create(fisExcel);
			Sheet sheet = book.getSheet("Contacts");
			String contact = sheet.getRow(4).getCell(1).getStringCellValue()+randomNumber;
			
			
			WebDriverManager.edgedriver().setup();// method chaining
			WebDriver driver= new EdgeDriver();// abstraction
			driver.manage().window().maximize();
			long longTimeout = Long.parseLong(timeout);
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
			
			driver.findElement(By.name("lastname")).sendKeys(contact);
			driver.findElement(By.xpath("//input[@onclick=\"this.form.action.value='Save'; displaydeleted(); return formValidate() \"]")).click();
			String actualLastName=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
			if(actualLastName.equals(contact))
			{
				System.out.println("Contact created successfully----> TC is Pass");
			}
			else
			{
				System.out.println("Contact not created successfully----> TC is Fail");
			}

			WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act= new Actions(driver);
			act.moveToElement(administratorIcon).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.quit();
WebElement administratorIcon1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act1= new Actions(driver);
			act.moveToElement(administratorIcon1).perform();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			driver.quit();
	
	}

}
