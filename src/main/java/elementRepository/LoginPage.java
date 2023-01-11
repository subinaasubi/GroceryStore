package elementRepository;

import java.util.List;

import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;
//import org.testng.Assert;
import utilities.Synchronisation;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	ExcelRead er;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileName;

	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement verificationOfRememberCheckBox;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement incorrectAlert;

	public void getUserName(String username) {
		gu.sendText(userName ,username);
	}

	public void getPassWord(String password1) {
		gu.sendText(password,password1);
	}

	public void clickSignin() {
	   gu.clickOnElement(signin);
	}

	
 	public String profileVerification() {
		return gu.getElementText(profileName);
	}

 	public boolean isAlertDisplayed() {
 		return incorrectAlert.isDisplayed();
 	}
 	
	public String styleProperty() {
		String color=gu.stylePropertyValidation(profileName, "color");
		return color;
	}	
	
	public boolean rememberMeCheckBoxValidation() {
		return gu.isElementSelected(rememberCheckBox);
	}
	
	public void presteps() {
		getUserName("admin");
		getPassWord("admin");
		clickSignin();
	}

    public List<String> getLoginDetails(){
    	er=new ExcelRead();
    	List<String>exceList= er.readDataFromExcel("Sheet1");
    	return exceList;
    } 
    
    public void excelSteps(String un,String pass) {
    	gu.sendText(userName, un);
    	gu.sendText(password, pass);
    }

}
