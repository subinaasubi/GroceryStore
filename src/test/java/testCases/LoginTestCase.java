package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;

public class LoginTestCase extends BaseClass{
 
	LoginPage lP;
	List<String>loginList;
	
	@Test(priority = 1,description = "Direct Login and Profile verification")
	public void verifyLoggedUsers() {
		lP=new LoginPage(driver);
		lP.presteps();
		String expectedProfileName=Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName=lP.profileVerification();
	    Assert.assertEquals(actualProfileName,expectedProfileName,Constant.LOGIN_ERROR);
	}
	
		
	@Test(priority = 2,description = "verify background color of admin")
	public void profileNameStyleValidation() {
		lP=new LoginPage(driver);
		lP.presteps();
		
		String profileColor=lP.styleProperty();
		String expectedProfileColor=Constant.ADMIN_CLR_PPTY;
		Assert.assertEquals(profileColor, expectedProfileColor,Constant.STYLE_ERROR);
	}
	
	
	@DataProvider(name = "data")
	public Object[][] getUserData(){
		return new Object[][] {
			{ "admin54", "admin" }, 
			{ "admin4", "admin4" },
			{"admin","admin2"},
		};
	}
	
	@Test(priority = 3, description = "UnSuccessfull Login using dataprovider",dataProvider = "data")
	public void verifyLoggedUsersWithDataProvider(String userName,String Password) {
		lP=new LoginPage(driver);
		lP.getUserName(userName);
		lP.getPassWord(Password);
		lP.clickSignin();
	    boolean actualProfileName=lP.isAlertDisplayed();
	    Assert.assertTrue(actualProfileName,Constant.LOGIN_ERROR);
	}
	
	@Test(priority = 4, description = "verify whether Remember Me checkbox is selected")
	public void verifyRememberMeCheckBoxIsSelected() {
		lP=new LoginPage(driver);
		lP.getUserName("admin");
		lP.getPassWord("admin");
		
		boolean expectedStatus=false;
		boolean actualStatus=lP.rememberMeCheckBoxValidation();
	    Assert.assertEquals(actualStatus,expectedStatus,Constant.CHECKBOX_ERROR);
	}
	
	@Test(priority = 5,description = "Login using excel sheet", retryAnalyzer = retryTest.RetryAnalyzer.class)
	public void excelReadLogin() {
		lP=new LoginPage(driver);
		loginList=lP.getLoginDetails();
		lP.excelSteps(loginList.get(0), loginList.get(1)); 
		String expectedProfileName=Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName=lP.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}
}
