package Org.tyss.genericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementationClass  implements IRetryAnalyzer{
   int count=0;
   int retrylimit=3;
	
	public boolean retry(ITestResult result) {
		while(count<retrylimit)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
