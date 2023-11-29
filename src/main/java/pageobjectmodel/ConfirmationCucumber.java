package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class ConfirmationCucumber {

	
	WebDriver driver;

	public ConfirmationCucumber(WebDriver driver) {
		this.driver = driver;
	}
	
	By successMessageElement = By.xpath("//*[@id=\"loop-container\"]/div/article/div[2]/p[1]/strong");
	
	
	public String getSuccessMessage() {
		
	String successMessage =	driver.findElement(successMessageElement).getText();

	
	return successMessage;
	
	
	}

	
	
	
}
