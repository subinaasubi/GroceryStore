package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Monitor.Guard;

import constants.Constant;
import elementRepository.Dashboard;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;

public class ManageDeliveryBoyTestCases extends BaseClass{

	LoginPage lP;
	ManageDeliveryBoy mDB;

	@Test(priority = 1,description = "tool tip validation",groups = {"SmokeTest"})
	public void verifyToolTipTextIsDisplayedCorrectly() throws InterruptedException {
		lP=new LoginPage(driver);
		lP.presteps();
		mDB=new ManageDeliveryBoy(driver);

		String actualToolTipTxt=mDB.toolTipValidation();
		String expectedToolTipTxt=Constant.EXPECTEDSHOWDETAIL_STRING;
		Assert.assertEquals(actualToolTipTxt , expectedToolTipTxt,Constant.toolTip_txt_error);
	}

	@Test(priority = 2,description = "new button styleproperty validation",groups = {"SanityTest"})
	public void verifyTheStyleOfNewBtn() throws InterruptedException {
		lP=new LoginPage(driver);
		lP.presteps();
		mDB=new ManageDeliveryBoy(driver);
		String actualborderclr=mDB.newButtonStyle();
		String expectedborderclr=Constant.newbtn_Clr_Ppty;
		Assert.assertEquals(actualborderclr,expectedborderclr,Constant.STYLE_ERROR);
	}

	@Test(priority = 3,description = "search button validation",groups = {"RegressionTest"})
	public void verifySearchButtonIsClickable() {
		lP=new LoginPage(driver);
		lP.presteps();
		mDB=new ManageDeliveryBoy(driver);
		boolean actualClickable=mDB.searchBtnValidation();
		Assert.assertTrue(actualClickable);
	}

	@Test(priority = 4,description = "successfull registration of delivery boy")
	public void verifySuccessfullRegistrationOfDeliveryBoy() {
		lP=new LoginPage(driver);
		lP.presteps();
		mDB=new ManageDeliveryBoy(driver);
		boolean actualSuccessAlert=mDB.isSuccessMessageDisplayed();
		Assert.assertTrue(actualSuccessAlert);
	}
	
	@Test(priority = 5,description = "successfull deletion of delivery boy")
	public void verifySuccessfullDeletionOfDeliveryBoy() {
		lP=new LoginPage(driver);
		lP.presteps();
		mDB=new ManageDeliveryBoy(driver);
		boolean actualDeleteAlert=mDB.isdeliveryBoyDeleted();
		Assert.assertTrue(actualDeleteAlert);
	}
}
