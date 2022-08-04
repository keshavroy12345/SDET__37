package org.vtiger.Documents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Org.tyss.genericUtility.ExcelUtility;
import Org.tyss.genericUtility.FileUtility;
import Org.tyss.genericUtility.IpathConstants;
import Org.tyss.genericUtility.JavaUtility;
import Org.tyss.genericUtility.WebdriverUtility;

public class CreateDocumentsTestSmiriti {

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
				String expectedTitleName = excelutility.getDataFromExcel("Title", 2, 1)+randomNumber;
				System.out.println(expectedTitleName);
				String filePath = excelutility.getDataFromExcel("Title", 2, 1);
				System.out.println(expectedTitleName);

				String expectedFilePath=System.getProperty("user.dir")+filePath;
				String[] splitFilePath= expectedFilePath.split("/");
				String expectedFileName=splitFilePath[splitFilePath.length-1];
				System.out.println(expectedFileName);

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
				driver.findElement(By.linkText("Documents")).click();
				driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
				driver.findElement(By.name("notes_title")).sendKeys(expectedTitleName);

				//Switch to Frame
				WebElement wb=driver.findElement(By.xpath("//iframe"));
				webdriverutility.switchFrame(wb);

				//Enter the value into Notes from excel 
				String expectedDescription = excelutility.getDataFromExcel("Title", 2, 4);
				System.out.println(expectedDescription);
				driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(expectedDescription);
				driver.switchTo().defaultContent();

				//upload the file 
				driver.findElement(By.id("filename_I__")).sendKeys(expectedFilePath);
				driver.findElement(By.xpath("//input[@accesskey='S']")).click();
				String actualTitleName=driver.findElement(By.id("dtlview_Title")).getText();
				System.out.println(actualTitleName);
				String actualDescription= driver.findElement(By.xpath("//td[@class='dvtCellInfo']/p")).getText();
				System.out.println(actualDescription);
				String actualFileName= driver.findElement(By.xpath("//td[@class='dvtCellInfo']/a")).getText();
				System.out.println(actualFileName);

				//validate the data
				if(actualTitleName.equals(expectedTitleName) && actualDescription.equals(expectedDescription) && expectedFileName.equals(actualFileName))
				{
					
					javautility.printStatement("Title created successfully----> TC is Pass");
					excelutility.setDataIntoExcel("Title",2,4, "Pass");

				}
				else
				{
					javautility.printStatement("Title not created successfully----> TC is Pass");
					excelutility.setDataIntoExcel("Title",2,4, "Fail");

				}

				//Creation of object of Actions class , Close the workbook and  driver
				WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				webdriverutility.mouseOverElement(administratorIcon);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				excelutility.workbookclose();
				webdriverutility.closeBrowser();


			}

		}
		