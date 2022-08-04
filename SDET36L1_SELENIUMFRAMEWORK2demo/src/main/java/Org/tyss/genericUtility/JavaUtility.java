package Org.tyss.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
* This class contains java reusable methods
* @author keshav
*
*/

   public class JavaUtility {

	/**
	 * This method is used to generate Random Number
	 * @return
	 */

	public int getRandomNumber()
	{
		return new Random().nextInt(1000);
	}
	/**
	 * This method is used to convert the String to Long data type
	 * @param stringData
	 * @return
	 */
	public long convertStringToLong(String stringData)
	{
		return Long.parseLong(stringData);
	}
	/**
	 * This method is used to get current date in specified strategy
	 * @param strategy
	 * @return
	 */
	public String getCurrentDate(String strategy)
	{
		return new SimpleDateFormat(strategy).format(new Date());
	}
	/**
	 * This method is used to split the String based on Strategy
	 * @param value
	 * @param strategy
	 * @return
	 */
	public String[] SplitString(String value, String strategy)
	{

		return value.split(strategy);
	}
	/**
	 * This method is used to print the value in Console 
	 * @param statement
	 */
	public void printStatement(String statement)
	{
		System.out.println(statement);

	}
}


		
	
	
	