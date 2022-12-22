package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.Dashboard;
import elementRepository.LoginPage;

public class DashboardTestCase extends BaseClass{
    
	Dashboard db;
	LoginPage lP;

    @Test
    public void verifyManageExpenseIsDisplayedCorrectly() {
    	lP=new LoginPage(driver);
    	db=new Dashboard(driver);
    	lP.presteps();
    	String expectedManageExpense=Constant.expectedManageExpense;
    	String actualManageExpense=db.manageExpenseVerification();
    	Assert.assertEquals(actualManageExpense, expectedManageExpense,Constant.textError);
    }
    
    @Test
    public void verifyManageUsersIsDisplayedCorrectly() {
    	db=new Dashboard(driver);
    	lP=new LoginPage(driver);
    	lP.presteps();
    	String expectedManageUsers=Constant.expectedManageUsers;
    	String actualManageUsers=db.manageUsersVerification();
    	Assert.assertEquals(actualManageUsers,expectedManageUsers,Constant.textError);
    }

	@Test
	public void homeTabStyleValidation() {
		db=new Dashboard(driver);
		lP=new LoginPage(driver);
    	lP.presteps();
    	String actualBackgroundclr=db.homeTabStyleProperty();
    	String expectedBackgroundclr=Constant.home_background_Clr_Ppty;
    	Assert.assertEquals(actualBackgroundclr, expectedBackgroundclr,Constant.STYLE_ERROR);
	}
}
