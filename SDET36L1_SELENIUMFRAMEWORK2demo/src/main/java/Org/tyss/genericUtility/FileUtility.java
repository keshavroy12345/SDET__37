package Org.tyss.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

/**
 * This Class contains reusable method for Csv file and property file
 * @author keshav
 * 
 */
  public final class FileUtility {
	  
	private  Properties properties;
	/**
	 * This method is used for intiallize the property file
	 * @param filePath
	 */
	
	public void intiallizePropertyFile(String filepath) {
	
	
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/test/resources/commonData.properties");
			 properties= new Properties();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 properties= new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
		/**
		 * This method is used to fetch the data from property file
		 * @param key
		 * @return
		 */
	
	 public String getDataFromProperty(String key)
	 {
		 return properties.getProperty(key).trim();
		 
	 }
		public void initializethePropertyFile(String vtigerpropertyfilepath) {
			// TODO Auto-generated method stub
			
		}


}