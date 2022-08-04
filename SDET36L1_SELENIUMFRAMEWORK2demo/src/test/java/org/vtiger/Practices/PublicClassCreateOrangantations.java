package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriverInfo;

import com.github.dockerjava.api.model.Driver;

public class PublicClassCreateOrangantations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//read common data from properties file

		FileInputStream fis=new FileInputStream("src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis); 

		String url = properties.getProperty("url");
		String password = properties.getProperty("password");
		String username = properties.getProperty("username");
		String browser = properties.getProperty("browser");
		String timeout = properties.getProperty("timeouts");

		//getrandom number
		Random ran=new Random();
		int RandomNum = ran.nextInt(10000);

		//read test data from Excel file
		FileInputStream fisExcel= new FileInputStream("src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook book=WorkbookFactory.create(fisExcel);
		Sheet sh=book.getSheet("org");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(2);

		String orgName = row.getCell(2).getStringCellValue()+RandomNum;

		WebDriver driver;
		if(browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (browser.equals("ie")) {
		
		driver=new InternetExplorerDriver();
	}
	else {
		driver=new ChromeDriver();
	}
		//login
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1990));
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	


}
}
