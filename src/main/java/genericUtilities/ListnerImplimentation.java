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
	@Override
	public void onTestStart(ITestResult result) {
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
	
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	
	
}
