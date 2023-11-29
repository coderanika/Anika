package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BaseUI;

public class Listeners implements ITestListener {

	public static ExtentReports extent;
	
	public static ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		extent = ExtentReportManager.getReportInstance();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		logger = extent.createTest(result.getName());
		BaseUI.logger = logger;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		logger.log(Status.PASS, 
				MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		String testname = result.getName();
		String filename = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\" + testname + BaseUI.timestamp + "_success.png";
		try {
			BaseUI.takeScreenShot(filename);   //BaseUI.takeScreenShot(BaseUI.timestamp +"screenshot1.png");
			logger.log(Status.PASS, "Snapshot attached: " + logger.addScreenCaptureFromPath(filename));
		}catch (Exception e) {
			// this means if it throws any error, describe the error in console 
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		//logger.log(Status.FAIL, result.getThrowable());
		String testname = result.getName();
		String filename = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\" + testname +BaseUI.timestamp + "_failed.png";
		try {
			BaseUI.takeScreenShot(filename);
			logger.log(Status.FAIL, "Snapshot attached: " + logger.addScreenCaptureFromPath(filename));
		}catch (Exception e) {
			e.printStackTrace();
			 logger.log(Status.FAIL, "Actual result"+
			            logger.addScreenCaptureFromPath(filename));
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	//	logger = extent.createTest(result.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
		String testname = result.getName();
		String filename = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\" + testname +BaseUI.timestamp + "_skipped.png";
		try {
			BaseUI.takeScreenShot(filename);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	

	/*@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started");
	}
*/
	
	

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
	/*
	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		//logger.log(Status.FAIL, result.getThrowable());
		String testname = result.getName();
		String filename = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\" + testname +BaseUI.timestamp + "_failed.png";
		try {
			BaseUI.takeScreenShot(filename);
			logger.log(Status.FAIL, "Snapshot attached: " + logger.addScreenCaptureFromPath(filename));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	
	
	
}
