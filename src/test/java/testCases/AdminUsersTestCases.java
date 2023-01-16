package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.AdminUsers;
import elementRepository.LoginPage;

public class AdminUsersTestCases extends BaseClass {

	LoginPage lp;
	AdminUsers au;

	@Test(priority = 1, description = "validating a user profile already exists while using faker class")
	public void validateAdminProfileWithFaker()   {
		lp = new LoginPage(driver);
		lp.presteps();
		au = new AdminUsers(driver);
		
		boolean actualAlert = au.verifyAdminProfileWithFaker();
		Assert.assertTrue(actualAlert, Constant.ALERT_MSG_ERROR);
	}

	@Test(priority = 2, description = "validating a user profile already exists")
	public void validateAdminProfileAlreadyExists()  {
		lp = new LoginPage(driver);
		lp.presteps();
		au = new AdminUsers(driver);
		String actualAlert = au.verifyAdminProfileAlreadyExists();
		
		String expectedAlert = Constant.EXPECTED_USER_ADMIN_ALERT;
		Assert.assertNotEquals(actualAlert, expectedAlert, Constant.ALERT_MSG_ERROR);
	}

}
