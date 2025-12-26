package genericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplimentationClass implements  ITestListener{
	
	

	ExtentReports report;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) 
	{
		String methodName= result.getMethod().getMethodName();
		test = report.createTest(methodName);
		extentTest.set(test);
		extentTest.get().log(Status.INFO, methodName+"<b>execution starts</b>");
	}

	public void onTestSuccess(ITestResult result) 
	{
		String mthdName  = result.getMethod().getMethodName();
		extentTest.get().log(Status.PASS, mthdName+new JavaUtils().sysDate()+"Passed");
	}
    
	public void onTestFailure(ITestResult result) {
		String mthdName  = result.getMethod().getMethodName();
	try {
			
			String filepath = ".\\screenShot\\"+mthdName+new JavaUtils().sysDate()+".png";
			TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
		
//			System.out.println("SRC exists: " + src.exists());
//			System.out.println("SRC path: " + src.getAbsolutePath());

			File des = new File(filepath);
//			des.getParentFile().mkdirs();
//			FileHandler.copy(src, des);
			FileUtils.copyFile(src, des);
			String path = des.getAbsolutePath();
			extentTest.get().addScreenCaptureFromPath(path);
		} 
	
	catch (IOException e) 
	{
			e.printStackTrace();
	}
	extentTest.get().log(Status.FAIL, result.getThrowable());
	extentTest.get().log(Status.FAIL, mthdName+"failed");
	}

	public void onTestSkipped(ITestResult result) 
	{
		String mthdName  = result.getMethod().getMethodName();
		extentTest.get().log(Status.SKIP, mthdName+"oh shit skipped Babyyy");
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = 	new ExtentSparkReporter(".\\ExtentReport\\report"+new JavaUtils().sysDate()+".html");
		htmlreport.config().setDocumentTitle("ReportByNandan");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTiger");
		
		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "window");
		report.setSystemInfo("base_url", "http://localhost:8888/");
		report.setSystemInfo("Reporter_Name", "Nandan.V");
		
	}

	public void onFinish(ITestContext context) 
	{
		report.flush();
	}

}
