package utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Screenshotcapture {
	public void Screenshotcapturefunc(WebDriver driver, String name) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);

		File f1 = new File(System.getProperty("user.dir") + "\\ScreenShots");
		if (!f1.exists()) {
			f1.mkdirs();
		}

		File finalDestination = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + name + ".png");
		FileHandler.copy(screenShot, finalDestination);
	}

}
