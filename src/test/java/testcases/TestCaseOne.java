package testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BrowserConfiguration;
import pageobjectmodel.Confirmation;
import pageobjectmodel.Login;
import utilities.FileIO;

public class TestCaseOne {
	
	WebDriver driver;
	
	//Beforetest will execute once before all the test methods and beforemethod will execute before every test method
	@BeforeMethod
    public void test() throws IOException {
		 
		 if(FileIO.FileInputOutput("browserType").equalsIgnoreCase("chrome")) {
		 driver = BrowserConfiguration.getChoromeDriver();
		 driver.get("https://practicetestautomation.com/practice-test-login/");  }
    }
	
    //tests will run in alphabetical order
	// but if i give priority then it will run based on the priority 0 is the 1st priority then it increases
	// if i give "enabled" = false then it skips that test
    @Test(priority = 0)
    public void testCaseCorrectInfo() throws InterruptedException {
    	
      
    	Login login = new Login(driver);
    	Thread.sleep(1000);
    	login.setUsername("student");
    	Thread.sleep(1000);
    	login.setPassword("Password123");
    	Thread.sleep(1000);
    	login.submitClick(); 
    	
    	String expectedText = "Congratulations student. You successfully logged in!";  	
    	Confirmation c = new Confirmation(driver);
    	assertEquals(c.getSuccessMessage(),expectedText);
    	System.out.println(expectedText);
    }
    
    // "dependsonMethods" keyword will be used to create dependency for one dependency to another
    // here this test case will run after the test case => testCaseCorrectInfo
    @Test(dependsOnMethods = "testCaseCorrectInfo")
    public void testCaseIncorrectUID() throws InterruptedException {
    	
    	Login login = new Login(driver);
    	login.setUsername("incorrectUser");
    	Thread.sleep(1000);
    	login.setPassword("Password123");
    	Thread.sleep(1000);
    	login.submitClick(); 
    	
    	String expectedText = "Your username is invalid!";
    	assertEquals(login.getInvalidUsernameMessage(),expectedText);
    	
    }
    
    @Test(priority = 0, enabled = false)
    public void testCaseIncorrectPassword() throws InterruptedException {
    	
    	Login login = new Login(driver);
    	login.setUsername("student");
    	Thread.sleep(1000);
    	login.setPassword("incorrectPassword");
    	Thread.sleep(1000);
    	login.submitClick(); 
    	
    	String expectedText = "Your password is invalid!";
    	assertEquals(login.getInvalidUsernameMessage(),expectedText);
    	
    }
    
    
    
}
