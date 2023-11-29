package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import base.BaseUI;

public class Confirmation extends BaseUI {

	WebDriver driver;

	public Confirmation(WebDriver driver) {
		this.driver = driver;
	}
	
	By successMessageElement = By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong");
	
	
	public String getSuccessMessage() {
		
	String successMessage =	driver.findElement(successMessageElement).getText();
	logger.log(Status.INFO, "confirmation message");
	
	return successMessage;
	
	
	}
	
}
