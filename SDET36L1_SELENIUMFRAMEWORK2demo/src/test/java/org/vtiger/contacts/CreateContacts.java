package org.vtiger.contacts;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Org.tyss.genericUtility.ExcelUtility;
import Org.tyss.genericUtility.FileUtility;
import Org.tyss.genericUtility.IpathConstants;
import Org.tyss.genericUtility.JavaUtility;
import Org.tyss.genericUtility.WebdriverUtility;

public class CreateContacts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	creat object for genericutility
		
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
		WebdriverUtility webdriverUtility = new WebdriverUtility();
		JavaUtility javaUtility = new JavaUtility();
		
		//instilize data from property file
		fileUtility.intiallizePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);
		
		//get the control for particular sheet in excel
		excelUtility.initializeExcelFile(IpathConstants.VTIGEREXCELFILEPATH);
		
		//generate the random number
		int randomNumber = javaUtility.getRandomNumber();
		
		//fetch the data from property file
		String browser = fileUtility.getDataFromProperty("browser");
		String username = fileUtility.getDataFromProperty("usename");
		String password = fileUtility.getDataFromProperty("password");
		String url = fileUtility.getDataFromProperty("url");
		String timeout = fileUtility.getDataFromProperty("timeouts");
		
		//fetch the data from excel sheet
		String expectedContactsName = excelUtility.getDataFromExcel("Contacts",2,1)+randomNumber;
		
		//runtimepolymorphism
		WebDriver driver=webdriverUtility.setupDriver(browser);
		
		//presetting of browser
		webdriverUtility.maximizebrowser();
		long timeouts = javaUtility.convertStringToLong(timeout);
		webdriverUtility.implicitwait(timeouts);
	   
	   //create object for action class
	   webdriverUtility.initializeActions();
	   
	   //open the application
	   webdriverUtility.openApplication(url);
	   
	   //login to the application
	   driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
	
		
		
		

		

	}

}
