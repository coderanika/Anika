package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmodel.ConfirmationCucumber;
import pageobjectmodel.Login;
import pageobjectmodel.LoginCucumber;

public class LoginSteps {

		WebDriver driver=new ChromeDriver();
		
	
	@Given("open browser")
	public void open_browser() {
	driver.get("https://www.google.com/");
	}
	@And("I open login page")
	public void i_open_login_page() {
	driver.get("https://practicetestautomation.com/practice-test-login/"); 
	}
	@When("I enter my username")
	public void i_enter_my_username() {
	WebElement user= driver.findElement(By.id("username"));
	user.sendKeys("student");
	}
	@And("I enter my password")
	public void i_enter_my_password() {
	WebElement pass= driver.findElement(By.id("password"));
	pass.sendKeys("Password123");
	}
	
	
	@When("I should click submit")
	public void i_should_click_submit() {
		WebElement logged=driver.findElement(By.id("submit"));
		logged.click();
	}
	
	
	@Then("I should get confirmation message")
	public void i_should_get_confirmation_message() {
		ConfirmationCucumber cf = new ConfirmationCucumber(driver);
		Assert.assertEquals("Congratulations student. You successfully logged in!", cf.getSuccessMessage());
	   
	}
	
	
	@When("I enter invalid username")
	public void i_enter_invalid_username() {
		WebElement user= driver.findElement(By.id("username"));
		user.sendKeys("incorrectUser");	
	    
	}
	@When("I enter validpassword")
	public void i_enter_validpassword() {
		WebElement pass= driver.findElement(By.id("password"));
		pass.sendKeys("Password123");
	    	}
	
	@Then("I should get invalid username message")
	public void i_should_get_invalid_username_message() {
		LoginCucumber lg = new LoginCucumber(driver);
		Assert.assertEquals("Your username is invalid!", lg.getInvalidUsernameMessage());
	   
	    
	}
	
	@When("I enter valid username")
	public void i_enter_valid_username() {
		WebElement user= driver.findElement(By.id("username"));
		user.sendKeys("student");	
	}
	@When("I enter invalid password")
	public void i_enter_invalid_password() {
		WebElement pass= driver.findElement(By.id("password"));
		pass.sendKeys("incorrectPassword123");
	}
	
	
	@Then("I should get invalid password message")
	public void i_should_get_invalid_password_message() {
		LoginCucumber lg = new LoginCucumber(driver);
		Assert.assertEquals("Your password is invalid!", lg.getInvalidPasswordMessage());
	   
	}

	
	
	
	
	
	
	
	
	
	
	
}
