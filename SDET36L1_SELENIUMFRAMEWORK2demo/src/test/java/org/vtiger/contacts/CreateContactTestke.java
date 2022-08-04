package org.vtiger.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Org.tyss.genericUtility.ExcelUtility;
import Org.tyss.genericUtility.FileUtility;
import Org.tyss.genericUtility.IpathConstants;
import Org.tyss.genericUtility.JavaUtility;
import Org.tyss.genericUtility.WebdriverUtility;

public class CreateContactTestke {

	public static void main(String[] args) {
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
				String timeouts=fileutility.getDataFromProperty("timeout");

				//Fetch the data from excel sheet
				String expectedContactName = excelutility.getDataFromExcel("Contacts", 2, 1)+randomNumber;

				//run time polymorphism
				WebDriver driver=webdriverutility.setupDriver(browser);

				//pre-setting for browser
				webdriverutility.maximizebrowser();
				long timeout=javautility.convertStringToLong(timeouts);
				webdriverutility.implicitwait(timeout);

				//creating object for Actions class
				webdriverutility.initializeActions();

				//navigate the application
				webdriverutility.openApplication(url);


				//login to the app
				driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

				driver.findElement(By.name("lastname")).sendKeys(expectedContactName);
				driver.findElement(By.xpath("//input[@onclick=\"this.form.action.value='Save'; displaydeleted(); return formValidate() \"]")).click();
				String actualLastName=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();

				//validate the data
				if(actualLastName.equals(expectedContactName))
				{
					javautility.printStatement("Contacts created successfully----> TC is Pass");
					excelutility.setDataIntoExcel("Contacts",2,4, "Pass");

				}
				else
				{			
					javautility.printStatement("Contacts not created successfully----> TC is Fail");
					excelutility.setDataIntoExcel("Contacts",2,4, "Fail");
				}

				//Closing the workbook and driver
				WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				webdriverutility.mouseOverElement(administratorIcon);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				excelutility.workbookclose();
				webdriverutility.closeBrowser();


			}
		}
	