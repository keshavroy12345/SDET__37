package smirti;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser {
	@Test(retryAnalyzer = Org.tyss.genericUtility.RetryAnalyserImplementationClass.class)
	
	public void practiceRetryAnalyser()
	
	{
		System.out.println("testscript---1");
		System.out.println("testscript---2");
		Assert.fail();
		System.out.println("testscript---3");
         System.out.println("testscript---4");
}
}