package org.vtiger.Practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PraticesJava {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
      int randomNumber = new Random().nextInt(1000);
      
      FileInputStream fis= new FileInputStream("./src/test/resources/commonData.properties");
      Properties properties = new Properties();
      properties.load(fis);
      WebDriver driver;
      String browser = properties.getProperty("browser").trim();
      switch(browser)
      {
      case"chrome":WebDriverManager.chromedriver().setup();
      				 driver=new ChromeDriver();
      				break;
      case"edge":WebDriverManager.edgedriver().setup();
      				 driver=new EdgeDriver();
      				 break;
		
      }
      
	}

}
