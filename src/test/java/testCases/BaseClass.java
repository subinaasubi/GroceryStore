package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Screenshotcapture;

public class BaseClass {
	WebDriver driver;

	public static Properties prop;
	Screenshotcapture sc;


	public static void testBasic() throws IOException {
		prop =new Properties();
		FileInputStream fileIo=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\Config.properties");
		prop.load(fileIo);
		
		
	}

	@Parameters("Browser")
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String browser) throws IOException {
		if(browser.equals("chrome")) {
			testBasic();
			System.setProperty(prop.getProperty("chromeBrowserDriver"), System.getProperty("user.dir")+prop.getProperty("chromeDriverPath"));
			driver=new ChromeDriver(); 
		}
		
		else if(browser.equals("firefox")) {
			testBasic();
			System.setProperty(prop.getProperty("firefoxBrowserDriver"), System.getProperty("user.dir")+prop.getProperty("firefoxDriverPath"));
			driver=new FirefoxDriver(); 
		}
		
		else {
			testBasic();
			System.setProperty(prop.getProperty("edgeDriver"), System.getProperty("user.dir")+prop.getProperty("edgeDriverPath"));
			driver=new EdgeDriver(); 
		}
		
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod(alwaysRun = true)

	public void afterMethod(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == iTestResult.FAILURE) {
			sc = new Screenshotcapture();
			sc.Screenshotcapturefunc(driver, iTestResult.getName());

	}

		driver.close();
	}

}



