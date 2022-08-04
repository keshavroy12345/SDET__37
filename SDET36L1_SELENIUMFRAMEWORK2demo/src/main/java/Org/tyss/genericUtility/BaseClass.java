package Org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Org.Vtiger.objectRepositry.CommonPage;
import Org.Vtiger.objectRepositry.LoginPage;

public class BaseClass {
	String browser,username,password,url,timeouts;

	FileUtility fileUtility;
	JavaUtility JavaUtility;
	protected static ExcelUtility execelUtility;
	WebdriverUtility webdriverUtility;
	protected static int randomnumber;
	long longtimeout;


	@BeforeSuite
	public void SuiteSetup() {
		//initialization of class
		fileUtility= new FileUtility();
		JavaUtility= new JavaUtility();
		execelUtility =new ExcelUtility();
		webdriverUtility = new WebdriverUtility();

		//intiallize data from property file
		fileUtility.initializethePropertyFile(IpathConstants.VTIGERPROPERTYFILEPATH);
		//get the control for particular sheet in excel
		execelUtility.initializeExcelFile(IpathConstants.VTIGEREXCELFILEPATH);
	}

	@BeforeClass
	public void getData() {

		//fetch the data from property file
		browser = fileUtility.getDataFromProperty("browser");
		username = fileUtility.getDataFromProperty("usename");
		password = fileUtility.getDataFromProperty("password");
		url = fileUtility.getDataFromProperty("url");

		timeouts = fileUtility.getDataFromProperty("timeouts");
		//convert string to long
		longtimeout =JavaUtility.convertStringToLong(timeouts);
	}
	LoginPage loginPage;
	CommonPage commonPage;
	public void  classSetup() {
		//launching the browser in run time based on browser key
		WebDriver driver= webdriverUtility.setupDriver(browser);
		//pre setting for the browser
		webdriverUtility.maximizebrowser();
		webdriverUtility.implicitwait(longtimeout);
		//instilize the explict wait ,Actions
		webdriverUtility.initializeActions();
		//create object for common pom repo classes
		loginPage = new LoginPage(driver);
		commonPage = new CommonPage(driver);

		//navigating the application
		webdriverUtility.openApplication(url);
	}
	@BeforeMethod
	public  void methodSetup() {
		//generate the random number
		randomnumber=JavaUtility.getRandomNumber();



	}
	@AfterMethod
	public void methodTearDown() {
		//signout
		commonPage.logoutAction(webdriverUtility);
	}
	@AfterClass
	public void classTearDown() {
		//close Browser
		webdriverUtility.closeBrowser();
	}




}

