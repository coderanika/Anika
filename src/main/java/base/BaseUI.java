package base;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.DateUtils;

public class BaseUI {

	public static WebDriver driver;
	public static String timestamp = DateUtils.getTimestamp();
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	public static void setDriver (WebDriver driver) {
		BaseUI.driver = driver;
	}
	
	public static void takeScreenShot(String filename) {
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 //String filePath = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\";
			FileUtils.copyFile(src, new File(filename));
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
		
	
  public static void passScreenShot(String username, String password ) {
		
		String uniqueFilename = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\" + "_" + BaseUI.timestamp +username + password + ".png";
        try {
            BaseUI.takeScreenShot(uniqueFilename);
            logger.log(Status.PASS, "Snapshot attached: " + logger.addScreenCaptureFromPath(uniqueFilename));
        } catch (Exception e) {
            e.printStackTrace();
        }
    
	}
/*
  public static void failScreenShot(String username, String password ) {
	
	String uniqueFilename = "C:\\Users\\anika\\eclipse-workspace-2023\\RealSelenium\\screenshots\\" + "_" + BaseUI.timestamp +username + password + ".png";
    try {
        BaseUI.takeScreenShot(uniqueFilename);
        logger.log(Status.FAIL, "Snapshot attached: " + logger.addScreenCaptureFromPath(uniqueFilename));
    } catch (Exception e) {
        e.printStackTrace();
    }

}

	*/
	
	//to scroll by pixel
	public static void scrollByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0]);", pixels);
    }
	
	//to scroll upto the webelement
		public static void scrollDownToElement(WebElement element) {
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true)", element);
	    }
	
	// to click and click the element
	public static void scrollByPixels(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        
    }
}
	
	
	
	

