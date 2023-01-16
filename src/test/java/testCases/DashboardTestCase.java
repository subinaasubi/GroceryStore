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

    @Test(priority = 1,description = "verify the title 'Manage Expence' is displayed correctly")
    public void verifyManageExpenseIsDisplayedCorrectly() {
    	lP=new LoginPage(driver);
    	db=new Dashboard(driver);
    	lP.presteps();
    	String expectedManageExpense=Constant.EXPECTEDMANAGE_EXPENCE;
    	String actualManageExpense=db.manageExpenseVerification();
    	Assert.assertEquals(actualManageExpense, expectedManageExpense,Constant.TEXTERROR);
    }
    
    @Test(priority = 2,description = "verify Manage Users is displayed correctly")
    public void verifyManageUsersIsDisplayedCorrectly() {
    	db=new Dashboard(driver);
    	lP=new LoginPage(driver);
    	lP.presteps();
    	String expectedManageUsers=Constant.EXPECTEDMANAGEUSERS;
    	String actualManageUsers=db.manageUsersVerification();
    	Assert.assertEquals(actualManageUsers,expectedManageUsers,Constant.TEXTERROR);
    }

	@Test(priority = 3,description = "verify the background color of home tab")
	public void verifyTheBackGroundClrPptyOfHomeTab() {
		db=new Dashboard(driver);
		lP=new LoginPage(driver);
    	lP.presteps();
    	String actualBackgroundclr=db.homeTabStyleProperty();
    	String expectedBackgroundclr=Constant.HOME_BACKGROUND_CLR_PPTY;
    	Assert.assertEquals(actualBackgroundclr, expectedBackgroundclr,Constant.STYLE_ERROR);
	}
}
