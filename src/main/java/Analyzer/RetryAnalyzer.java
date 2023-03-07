package Analyzer;

import base.TestBase;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer {
	int count = 0;
	int retryLimit = 3;

	public boolean retry(ITestResult result) {
		if (count < retryLimit) {
			count++;
			return true;
		}
		return false;
	}
}
