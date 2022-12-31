package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class GeneralUtilities {
	static Faker faker;
	
	public String getElementText(WebElement element) {
		String text=element.getText();
		return text;
	}
   
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void sendText(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
	
	public String stylePropertyValidation(WebElement element,String propertyType) {
		return element.getCssValue(propertyType);
	}
	
	public String toolTip(WebElement element) {
		return element.getAttribute("title");
	}
	
	public void mediumDelay(int x) throws InterruptedException {
		Thread.sleep(x);
	}

	public boolean isEnabled(WebElement element) {
		return element.isEnabled();
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}
	
	public void scrollToTheElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public void clickToTheElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	public void dragandDrop(WebElement source, WebElement destination, WebDriver driver) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}

	public void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void alertHandlingdismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String alerttext(WebDriver driver) {
		return (driver.switchTo().alert().getText());
	}

	public void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	public void selectFuncbyValue(WebElement element, String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);
	}
	
	public void selectFuncbyViText(WebElement element, String visisbletext) {
		Select select1 = new Select(element);
		select1.selectByVisibleText(visisbletext);

	}
	
public String getFirstSelectedOption(WebElement element) {
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}

public int sizeOfDropDown(WebElement element) {
	Select select1 = new Select(element);
	List<WebElement>listOfElements=select1.getOptions(); 
	return listOfElements.size();
}

public void randomUserNames(WebElement element) {
	faker=new Faker();
	String userName=faker.name().username();
	element.sendKeys(userName);
}
	
}
