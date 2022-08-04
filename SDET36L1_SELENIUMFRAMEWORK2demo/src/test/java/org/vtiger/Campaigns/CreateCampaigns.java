package org.vtiger.Campaigns;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import Org.tyss.genericUtility.ExcelUtility;
import Org.tyss.genericUtility.FileUtility;

import Org.tyss.genericUtility.IpathConstants;
import Org.tyss.genericUtility.JavaUtility;
import Org.tyss.genericUtility.WebdriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaigns {

	
		public static void main(String[] args) throws IOException {

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
			String expectedCampaignName = excelutility.getDataFromExcel("Campaigns", 2, 1)+randomNumber;

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
			WebElement wb=driver.findElement(By.xpath("//a[text()='More']"));
			webdriverutility.mouseOverElement(wb);
			driver.findElement(By.xpath("//a[@name=\"Campaigns\"]")).click();
			driver.findElement(By.xpath("//img[@title=\"Create Campaign...\"]")).click();
			driver.findElement(By.name("campaignname")).sendKeys(expectedCampaignName);
			driver.findElement(By.xpath("//input[@onclick=\"this.form.action.value='Save'; displaydeleted(); return formValidate() \"]")).click();
			String actualCampaignName=driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();

			//validate the data
			if(actualCampaignName.equals(expectedCampaignName))
			{
				
				javautility.printStatement("Campaign created successfully----> TC is Pass");
				excelutility.setDataIntoExcel("Campaigns",2,4, "Pass");
				excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXCELFILEPATH);
				
				

			}
			else
			{
				javautility.printStatement("Campaign not created successfully----> TC is Fail");
				excelutility.setDataIntoExcel("Campaigns",2,4, "Fail");
				excelutility.provideDataToExcelPass(IpathConstants.VTIGEREXCELFILEPATH);


			}

			//Closing the workbook and driver
			WebElement administratorIcon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			webdriverutility.mouseOverElement(administratorIcon);
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			excelutility.workbookclose();
			webdriverutility.closeBrowser();


		}
}