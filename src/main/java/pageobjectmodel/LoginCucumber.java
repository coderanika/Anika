package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

public class LoginCucumber {
	
	WebDriver driver;
	
	//location of web elements using BY class
	By username = By.id("username");
	By password = By.id("password");
	By submit = By.id("submit");
	By invalidUsernameMessageElement = By.xpath("//*[@id=\"error\"]");
	By invalidPasswordMessageElement = By.xpath("//*[@id=\"error\"]");
	
	//constructor to initialize driver 
	public LoginCucumber (WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	
	
	//methods for each elements 
	
	public void setUsername(String usernameValue) {
		driver.findElement(username).sendKeys(usernameValue);
		
	}
	
	public void setPassword(String passwordValue) {
		driver.findElement(password).sendKeys(passwordValue);
	
		
		
	}
	
	
	public void submitClick() {
		driver.findElement(submit).click();
	
	}
	
	
	
	public String getInvalidUsernameMessage() {
		
		String invalidUsernameMessage = driver.findElement(invalidUsernameMessageElement).getText();
		
		return invalidUsernameMessage;
		
	}
	
	public String getInvalidPasswordMessage() {
		
		String invalidPasswordMessage = driver.findElement(invalidPasswordMessageElement).getText();

		return invalidPasswordMessage;
		
	}
	
	


}
