package org.vtiger.Documents;

import java.io.FileInputStream;
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
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int randomNumber=new Random().nextInt(1000);
		
		FileInputStream fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties properties = new Properties();
		properties.load(fis);

		String browser=properties.getProperty("browser").trim();
		String Url=properties.getProperty("url").trim();
		String username=properties.getProperty("username").trim();
		String password=properties.getProperty("password").trim();
		String timeout=properties.getProperty("timeout").trim();
		
		FileInputStream fisExcel=new FileInputStream("./src/test/resources/fetchtheDatafromExcelSheet.xlsx");
		Workbook book = WorkbookFactory.create(fisExcel);
		Sheet sheet=book.getSheet("Products");
	
	
				
				WebDriverManager.edgedriver().setup();
				WebDriver driver= new EdgeDriver();
				driver.manage().window().maximize();

								driver.get("http://localhost:8888/");
							driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("root");
				driver.findElement(By.id("submitButton")).click();
				driver.findElement(By.linkText("Products")).click();
				driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
				
				String expectedProductName="Cream"+randomNumber;
				System.out.println("Expected product name==>"+expectedProductName);
				driver.findElement(By.name("productname")).sendKeys(expectedProductName);
				driver.findElement(By.xpath("//input[@accesskey='S']")).click();
				String actualProductName=driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
				 if(actualProductName.equals(expectedProductName))
					{
						System.out.println("Product created successfully----> TC is Pass");
						System.out.println("Actual product name==>"+actualProductName);
					}
					else
					{
						System.out.println("Product not created successfully----> TC is Fail");
					}

	}

}
