package elementRepository;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageOrders {
	int count=0;
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public ManageOrders(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}

	@FindBy(xpath = "(//a[@class=' nav-link'])[2]")
	WebElement manageOrders;
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[1]/i[1]")
	WebElement searchBar;
	@FindBy(xpath = "//select[@id='pt']")
	WebElement paymentModeDropDown;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtn;
	//@FindBy(tagName = "//td[5]")
	//	WebElement paymentModeColumn;
	@FindBy(xpath = "//body[1]/div[1]/div[1]/section[1]")
	WebElement table;
	@FindBy(xpath = "//select[@id='st']")
	WebElement status;
	@FindBy(xpath = "//input[@id='od']")
	WebElement orderId;
	@FindBy(xpath = "//tbody/tr/td[1]")
	WebElement tableOrderId;
	@FindBy(xpath = "//tbody/tr/td[5]")
	WebElement codPM;

	public boolean compareAllValuesOfColumn() {
		gu.clickOnElement(manageOrders);
		gu.clickOnElement(searchBar);
		gu.selectFuncbyindex(paymentModeDropDown, 2);
		gu.clickOnElement(searchBtn);
		gu.scrollToTheElement(table, driver);
		List<WebElement>paymentModeColumn=driver.findElements(By.tagName("//td[5]"));
		for(int i=0;i<paymentModeColumn.size();i++) {	
			if(paymentModeColumn.get(i).getText().equals("Bank")) {
				count++;
			}
		}
       if(count==paymentModeColumn.size())
    	   return true;
       else 
    	   return false;
	}	
	
	public int getStatusDropDownSize() {
		gu.clickOnElement(manageOrders);
		gu.clickOnElement(searchBar);
		return gu.sizeOfDropDown(status);
	}
	
	public String searchUsingOrderId() {
		gu.clickOnElement(manageOrders);
		gu.clickOnElement(searchBar);
		gu.sendText(orderId, "363");
		gu.scrollToTheElement(tableOrderId, driver);
		
		return gu.getElementText(tableOrderId);
		
	}
	
	public String getPaymentModeFromTable() {
	/*	gu.clickOnElement(manageOrders);
		gu.clickOnElement(searchBar);
		gu.sendText(orderId, "363");
		gu.scrollToTheElement(tableOrderId, driver);*/
		return gu.getElementText(codPM);
	}

}
