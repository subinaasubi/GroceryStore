package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderUtility {
	public static void main(String args[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement date = driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.click();
		Thread.sleep(2000);
		WebElement month = driver.findElement(By.cssSelector("span.ui-datepicker-month"));
		System.out.println(month.getText());
		WebElement previous = driver.findElement(By.xpath("//span[contains(text(),'Prev')]"));
		/*
		 * while(!month.getText().contains("October")) { previous.click(); }
		 */
		// Thread.sleep(2000);

		while (!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().contains("October")) {
			// driver.findElement(By.xpath("//span[@class='ui-icon
			// ui-icon-circle-triangle-e']")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Prev')]")).click();
		}

		int count = driver.findElements(By.className("ui-state-default")).size();
		System.out.println(count);

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("ui-state-default")).get(i).getText();
			if (text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("ui-state-default")).get(i).click();
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
