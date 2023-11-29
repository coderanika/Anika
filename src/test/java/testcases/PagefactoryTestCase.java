
package testcases;

	import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseUI;
import base.BrowserConfiguration;
import pageobjectmodel.Confirmation;
import pageobjectmodel.Pagefactory;
import utilities.ExcelHandling;
import utilities.FileIO;

	@Listeners(utilities.Listeners.class)
	public class PagefactoryTestCase extends BaseUI{

		WebDriver driver;
		String data[][];

		@BeforeMethod
		public void test() throws IOException {

			if (FileIO.FileInputOutput("browserType").equalsIgnoreCase("chrome")) {
				driver = BrowserConfiguration.getChoromeDriver();
				setDriver(driver); //Set the driver in BASEUI class
				driver.get("https://practicetestautomation.com/practice-test-login/");
			}
		}

		@DataProvider(name = "testdata")
		public Object[][] testdata() throws IOException {
			data = ExcelHandling.excelData();
			return data;
		}

		@Test(dataProvider = "testdata")
		public void testCaseArray(String username, String password) throws InterruptedException {

			Pagefactory lg = new Pagefactory(driver);
			Confirmation cf = new Confirmation(driver);
			Thread.sleep(1000);
			lg.setUsername(username);
			Thread.sleep(1000);
			lg.setPassword(password);
			Thread.sleep(1000);
			lg.submitClick();

			if (username.equals("student") && password.equals("Password123")) {

				Assert.assertEquals("Congratulations student. You successfully logged in!", cf.getSuccessMessage());

			} else if (username.equals("incorrectUser") && password.equals("Password123")) {

				Assert.assertEquals("Your username is invalid!", lg.getInvalidUsernameMessage());

			} else if (username.equals("student") && password.equals("incorrectPassword")) {

				Assert.assertEquals("Your password is invalid!", lg.getInvalidPasswordMessage());

			}	
			
			
				


		}
		
		
		
		
		
		
		
		
		
	}
	    

		
		
		
	

