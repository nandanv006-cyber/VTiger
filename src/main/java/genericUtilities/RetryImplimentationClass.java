package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplimentationClass implements IRetryAnalyzer{
	int initialCount=0;
	int retryLimit=4;
	public boolean retry(ITestResult result)
	{
		if(initialCount<retryLimit)
		{
			initialCount++;
			return true;
			
		}
		return false;
		
	}
	
}
