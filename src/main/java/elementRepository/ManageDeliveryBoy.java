package elementRepository;

//import java.util.concurrent.Flow.Publisher;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public  ManageDeliveryBoy(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//p[contains(text(),'Manage Delivery Boy')]")
	WebElement manageDeliveryBoy;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement showPassword;
	@FindBy(css = "body.sidebar-mini.layout-fixed:nth-child(2) div.wrapper:nth-child(1) div.content-wrapper:nth-child(4) section.content div.col-sm-12:nth-child(1) > a.btn.btn-rounded.btn-danger:nth-child(1)")
	WebElement newBtn;
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[2]")	
	WebElement searchBtn;
	@FindBy(xpath = "//input[@id='name']")
	WebElement nameTxtBox;
    @FindBy(xpath = "//input[@id='email']")
    WebElement eMailTxtBox;
    @FindBy(xpath = "//input[@id='phone']")
    WebElement phNoTxtBox;
    @FindBy(xpath = "//textarea[@id='address']")
    WebElement addressTxtBox;
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameTxtBox;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordTxtBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successAlert;
    @FindBy(xpath = "//tbody/tr[1]/td[8]/a[2]")
    WebElement deleteBtn;
    @FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]")
    WebElement deleteSuccessAlert;
	
	public String toolTipValidation() throws InterruptedException {
		gu.clickOnElement(manageDeliveryBoy);
		gu.mediumDelay(3000);
		String toolTip= gu.toolTip(showPassword);
		return toolTip;
	}

	public String newButtonStyle() throws InterruptedException {
		gu.clickOnElement(manageDeliveryBoy);
		gu.mediumDelay(3000);
		String style=gu.stylePropertyValidation(newBtn, "border-color");
		return style;
	}

	public boolean searchBtnValidation() {
		gu.clickOnElement(manageDeliveryBoy);
		gu.clickOnElement(searchBtn);
		return gu.isEnabled(searchBtn);
	}
	
	public void enterDeliveryBoyInformations() {
		gu.clickOnElement(manageDeliveryBoy);
		gu.clickOnElement(newBtn);
		gu.sendText(nameTxtBox, "Arun");
		gu.sendText(eMailTxtBox, "delvryboy123@gmail.com");
		gu.sendText(phNoTxtBox, "987654321");
		gu.sendText(addressTxtBox, "delviry boy address");
		gu.clearText(userNameTxtBox);
		gu.sendText(userNameTxtBox, "delvryboy12");
		gu.scrollToTheElement(saveBtn, driver);
		gu.clearText(passwordTxtBox);
		gu.sendText(passwordTxtBox, "delvryboy45");
		gu.clickToTheElement(saveBtn,driver);
	}
	
	public boolean isSuccessMessageDisplayed() {
		enterDeliveryBoyInformations();
		return gu.isElementDisplayed(successAlert);
	}
	
	public boolean isdeliveryBoyDeleted()  {
		gu.clickOnElement(manageDeliveryBoy);
		
		gu.clickOnElement(deleteBtn);
		driver.switchTo().alert().accept();
		return gu.isElementDisplayed(deleteSuccessAlert);
		
	}
     
}
