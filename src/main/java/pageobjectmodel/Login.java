 package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.BaseUI;

public class Login extends BaseUI {

	WebDriver driver;
	
	//location of web elements using BY class
	By username = By.id("username");
	By password = By.id("password");
	By submit = By.id("submit");
	By invalidUsernameMessageElement = By.xpath("//*[@id=\"error\"]");
	By invalidPasswordMessageElement = By.xpath("//*[@id=\"error\"]");
	
	//constructor to initialize driver 
	public Login (WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	
	//methods for each elements 
	
	public void setUsername(String usernameValue) {
		driver.findElement(username).sendKeys(usernameValue);
		logger.log(Status.INFO, "Entered username");
	}
	
	public void setPassword(String passwordValue) {
		driver.findElement(password).sendKeys(passwordValue);
		logger.log(Status.INFO, "setPassword");
		
		
	}
	
	
	public void submitClick() {
		driver.findElement(submit).click();
		logger.log(Status.INFO, "Clicked on submit button");
	}
	
	
	
	public String getInvalidUsernameMessage() {
		
		String invalidUsernameMessage = driver.findElement(invalidUsernameMessageElement).getText();
		logger.log(Status.INFO, "invalid User name message");
		return invalidUsernameMessage;
		
	}
	
	public String getInvalidPasswordMessage() {
		
		String invalidPasswordMessage = driver.findElement(invalidPasswordMessageElement).getText();
		logger.log(Status.INFO, "invalid password message");
		return invalidPasswordMessage;
		
	}
	
	


	
	
}
