package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;

public class LoginTestCase extends BaseClass{
 
	LoginPage lP;
	
	@Test
	public void verifyLoggedUsers() {
		lP=new LoginPage(driver);
		lP.presteps();
		String expectedProfileName=Constant.expectedProfileName;
		String actualProfileName=lP.profileVerification();
	    Assert.assertEquals(actualProfileName,expectedProfileName,Constant.loginError);
	}
	
	@Test
	public void profileNameStyleValidation() {
		lP=new LoginPage(driver);
		lP.presteps();
		
		String profileColor=lP.styleProperty();
		String expectedProfileColor=Constant.admin_Clr_Ppty;
		Assert.assertEquals(profileColor, expectedProfileColor,Constant.STYLE_ERROR);
	}
	
	@DataProvider(name = "data")
	public Object[][] getUserData(){
		return new Object[][] {
			{ "admin", "admin" }, 
			{ "admin54", "admin" }, 
			{ "admin4", "admin4" },
			{"admin","admin2"},
		};
	}
	
	@Test(description = "Login using dataprovider",dataProvider = "data")
	public void verifyLoggedUsersWithDataProvider(String userName,String Password) {
		lP=new LoginPage(driver);
		lP.getUserName(userName);
		lP.getPassWord(Password);
		lP.clickSignin();
		String expectedProfileName=Constant.expectedProfileName;
		String actualProfileName=lP.profileVerification();
	    Assert.assertEquals(actualProfileName,expectedProfileName,Constant.loginError);
	}
	
	@Test(description = "Remember Me checkbox Validation")
	public void verifyRememberMeCheckBoxIsSelected() {
		lP=new LoginPage(driver);
		lP.getUserName("admin");
		lP.getPassWord("admin");
		
		boolean expectedStatus=false;
		boolean actualStatus=lP.rememberMeCheckBoxValidation();
	    Assert.assertEquals(actualStatus,expectedStatus,Constant.CHECKBOX_ERROR);
	}
}
