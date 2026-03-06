package genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class ListnerImplimentation implements ITestListener{

	ExtentReporter extentReport;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest= new  ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		
	}

	
	public void onTestFailure(ITestResult result) {
		
	}

	
	public void onTestSkipped(ITestResult result) {
	
	}

	
	public void onStart(ITestContext context) {
	
	}

	
	public void onFinish(ITestContext context) {
		
	}

	
	
}
