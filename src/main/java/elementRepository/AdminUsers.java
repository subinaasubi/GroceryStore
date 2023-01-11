package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomDataGenerationUtility;
import utilities.Synchronisation;

public class AdminUsers {

	 WebDriver driver;
	 GeneralUtilities gu=new GeneralUtilities();
	 Synchronisation sy=new Synchronisation();
	 
	 public AdminUsers(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(xpath = "(//p[text()='Admin Users'])[1]")
		WebElement adminUsers;

		@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
		WebElement newBtn;

		@FindBy(xpath = "//input[@id='username']")
		WebElement usernameInputBox;

		@FindBy(xpath = "//input[@id='password']")
		WebElement passwordInputBox;

		@FindBy(xpath = "//select[@id='user_type']")
		WebElement userTypeDropdown;

		@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
		WebElement saveBtn;

		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
		WebElement successAlert;

		@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
		WebElement failAlert;

		public String verifyAdminProfileWithFaker() {
			//gu.scrollToTheElement(adminUsers, driver);
			
			gu.clickOnElement(adminUsers);
			sy.elementClickable(driver, "//a[@class='btn btn-rounded btn-danger']");
			gu.clickToTheElement(newBtn, driver);
			String name= RandomDataGenerationUtility.getFName();
			gu.sendText(usernameInputBox, name);
			String password = RandomDataGenerationUtility.getPassword();
			gu.sendText(passwordInputBox, password);
			gu.selectFuncbyViText(userTypeDropdown, "Admin");
			gu.clickOnElement(saveBtn);
			return gu.getElementText(successAlert);
		}

		public String verifyAdminProfileAlreadyExists() {
			gu.scrollToTheElement(adminUsers, driver);
			gu.clickToTheElement(adminUsers, driver);
			gu.clickToTheElement(newBtn, driver);
			gu.sendText(usernameInputBox, "Admin");
			gu.sendText(passwordInputBox, "Admin");
			gu.selectFuncbyViText(userTypeDropdown, "Admin");
			gu.clickOnElement(saveBtn);
			return gu.getElementText(failAlert);
		}


}
