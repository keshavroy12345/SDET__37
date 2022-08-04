package Org.tyss.genericUtility;

import org.openqa.selenium.WebDriver;

import Org.Vtiger.objectRepositry.CommonPage;
import Org.Vtiger.objectRepositry.LoginPage;

public class InstanceClass {
	public WebdriverUtility webdriverUtility;
	public  FileUtility fileUtility;
	public JavaUtility javaUtility;
	public ExcelUtility excelUtility;
    protected String browser;
    protected String username;
    protected String password;
    protected String url;
    protected long longtimeout;
    protected  LoginPage loginPage;
    public CommonPage commonPage;
    public int randomNumber;
    public WebDriver driver;
    

}

