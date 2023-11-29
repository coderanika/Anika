package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfiguration {
	
	

	public static WebDriver getChoromeDriver() {
		
		WebDriver driver = new ChromeDriver();
		
		return driver;
	}
	
	
	public static WebDriver getEdgeDriver() {
		
		WebDriver driver = new EdgeDriver();
		
		return driver;
	}
	
public static WebDriver getFireFoxDriver() {
		
		WebDriver driver = new FirefoxDriver();
		
		return driver;
	}

}