package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotifications {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public PushNotifications(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath = "//p[contains(text(),'Push Notifications')]")
	WebElement pushNotifications;
	@FindBy(xpath = "//input[@id='title']")
	WebElement titleTxtBox;
	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionTxtBox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendBtn;
	@FindBy (xpath="//body/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]")
	WebElement alertMessageBox;
	@FindBy(xpath = "(//span[@class='error'])[1]")
	WebElement titleMandatory;
	
	public String getPushNotificationPageTitle() {
		gu.clickOnElement(pushNotifications);
		return gu.getPageTitle(driver);
	}
	
	public String validateTextBoxTitleMandatory() {
		gu.clickOnElement(pushNotifications);
		String style=gu.stylePropertyValidation(titleMandatory, "color");
		return style;
	}
	
	public String getColorOfSendButton() {
		gu.clickOnElement(pushNotifications);
		String sendBtnStyle=gu.stylePropertyValidation(sendBtn,"color");
		return sendBtnStyle;
	}
	
	public void enterPushNotificationInformations() {
		gu.clickOnElement(pushNotifications);
		gu.sendText(titleTxtBox,"hai");
		gu.sendText(descriptionTxtBox, "hello");
		gu.clickOnElement(sendBtn);
	}
	
	public String getBackgroundColorOfAlertBox() {
		enterPushNotificationInformations();
		String alertBoxBackgrndClr=gu.stylePropertyValidation(alertMessageBox,"background");
		return alertBoxBackgrndClr;
	}
	
	public boolean isAlertBoxDisplayed() {
		enterPushNotificationInformations();
		
		return gu.isElementDisplayed(alertMessageBox);
	}

}
