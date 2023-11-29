package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.BaseUI;

public class Pagefactory extends BaseUI {

	WebDriver driver;

	@FindBy(id = "username") // friver.findElement (By.id("username"));
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "submit")
	private WebElement submit;
	@FindBy(xpath = "//*[@id=\"error\"]")
	private WebElement invalidUsernameMessageElement;
	@FindBy(xpath = "//*[@id=\"error\"]")
	private WebElement invalidPasswordMessageElement;

	// constructor to initialize driver
	public Pagefactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// methods for each elements

	public void setUsername(String usernameValue) {
		username.sendKeys(usernameValue);
		logger.log(Status.INFO, "Entered username");
	}

	public void setPassword(String passwordValue) {
		password.sendKeys(passwordValue);
		logger.log(Status.INFO, "setPassword");

	}

	public void submitClick() {
		submit.click();
		logger.log(Status.INFO, "Clicked on submit button");
	}

	public String getInvalidUsernameMessage() {

		// String invalidUsernameMessage =
		// driver.findElement(invalidUsernameMessageElement).getText();
		String invalidUsernameMessage = invalidPasswordMessageElement.getText();
		logger.log(Status.INFO, "invalid User name message");
		return invalidUsernameMessage;

	}

	public String getInvalidPasswordMessage() {
		String invalidPasswordMessage = invalidUsernameMessageElement.getText();
		// String invalidPasswordMessage =
		// driver.findElement(invalidPasswordMessageElement).getText();
		logger.log(Status.INFO, "invalid password message");
		return invalidPasswordMessage;

	}

}
