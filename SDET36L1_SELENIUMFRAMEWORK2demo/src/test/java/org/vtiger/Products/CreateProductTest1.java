package org.vtiger.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Org.tyss.genericUtility.ExcelUtility;
import Org.tyss.genericUtility.FileUtility;
import Org.tyss.genericUtility.IpathConstants;
import Org.tyss.genericUtility.JavaUtility;
import Org.tyss.genericUtility.WebdriverUtility;

public class CreateProductTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           
		

	
				// TODO Auto-generated method stub

				//Creating objects for GenericUtility
				FileUtility fileutility= new FileUtility();
				ExcelUtility excelutility = new ExcelUtility();
				JavaUtility javautility= new JavaUtility();
				WebdriverUtility webdriverutility= new WebdriverUtility();

				//Initialize data from Property file
				fileutility.intiallizePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);

				//Generate the random number
				int randomNumber= javautility.getRandomNumber();

				//Get the control for particular sheet in excel
				excelutility.initializeExcelFile(IpathConstants.VTIGEREXCELFILEPATH);

				//Fetch the data from Property file
				String browser=fileutility.getDataFromProperty("browser");
				String url=fileutility.getDataFromProperty("url");
				String username=fileutility.getDataFromProperty("username");
				String password=fileutility.getDataFromProperty("password");
				String timeout=fileutility.getDataFromProperty("timeout");

				//Fetch the data from excel sheet
				String expectedProductName = excelutility.getDataFromExcel("Product", 2, 1)+randomNumber;
				System.out.println(expectedProductName);

				//run time polymorphism
				WebDriver driver=webdriverutility.setupDriver(browser);

				//pre-setting for browser
				webdriverutility.maximizebrowser();
				javautility.convertStringToLong(timeout);


				//creating object for Actions class
				webdriverutility.initializeActions();

				//navigate the application
				webdriverutility.openApplication(url);


				//login to the app
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				System.out.println("Expected product name==>"+expectedProductName);
				driver.findElement(By.name("productname")).sendKeys(expectedProductName);
				driver.findElement(By.xpath("//input[@accesskey='S']")).click();
				String actualProductName=driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

				//validate the data
				if(actualProductName.equals(expectedProductName))
				{
					javautility.printStatement("Product created successfully----> TC is Pass");
					javautility.printStatement("Actual product name==>"+actualProductName);
					excelutility.setDataIntoExcel("Product", 4, 3,"Pass");
					excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXCELFILEPATH);

				}
				else
				{
					javautility.printStatement("Product not created successfully----> TC is Fail");
					excelutility.setDataIntoExcel("Product", 4, 3,"Fail");
					excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXCELFILEPATH);
				}

				//Creation of object of Actions class , Close the workbook and  driver
				WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				webdriverutility.mouseOverElement(administratorIcon);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				excelutility.workbookclose();
				webdriverutility.closeBrowser();

			}

}