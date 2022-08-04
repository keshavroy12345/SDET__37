package org.tiger.Organizations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Org.tyss.genericUtility.ExcelUtility;
import Org.tyss.genericUtility.FileUtility;
import Org.tyss.genericUtility.IpathConstants;
import Org.tyss.genericUtility.JavaUtility;
import Org.tyss.genericUtility.WebdriverUtility;

public class CreateorganizationTestKeshav {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
	


				//Creating objects for GenericUtility
				FileUtility fileutility= new FileUtility();
				ExcelUtility excelutility = new ExcelUtility();
				JavaUtility javautility= new JavaUtility();
				WebdriverUtility webdriverutility= new WebdriverUtility();

				//Initialize data from Property file
				fileutility.initializethePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);

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
				String expectedOrganizationName = excelutility.getDataFromExcel("Organizations", 2, 1)+randomNumber;
				javautility.printStatement(expectedOrganizationName);

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
				driver.findElement(By.xpath("//a[text()='Organizations']")).click();
				driver.findElement(By.xpath("//img[@alt=\"Create Organization...\"]")).click();
				driver.findElement(By.name("accountname")).sendKeys(expectedOrganizationName);
				driver.findElement(By.xpath("//input[@accesskey='S']")).click();
				webdriverutility.explicitwait(By.xpath("aah"), 10);
				
				//calling the method to wait excplicitily
		//		webdriverutility.("//span[contains(text(),'Updated today')]");
				
				String actualOrganizationName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();

				

				//validate the data
				if(actualOrganizationName.equals(expectedOrganizationName))
				{
					javautility.printStatement("Organization created successfully----> TC is Pass");
					javautility.printStatement("Actual organization name==>"+actualOrganizationName);
					excelutility.setDataIntoExcel("Organizations", 2, 4,"Pass");
					excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXCELFILEPATH);
				}
				else
				{
					javautility.printStatement("Organisation not created successfully----> TC is Fail");
					excelutility.setDataIntoExcel("Organizations", 2, 4,"Fail");
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
	