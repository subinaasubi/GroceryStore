package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobileSlider;

public class MobileSliderTestCases extends BaseClass{

	LoginPage lp;
	MobileSlider ms;

	@Test(priority = 1,description = "Mobile Slider validation",groups = {"SmokeTest"})
	public void verifyMobileSliderTitleIsDisplayedCorrectly()  {
		lp=new LoginPage(driver);
		ms=new MobileSlider(driver);
		lp.presteps();

		String actualTitle=ms.getMobileSliderTitle();
		String expectedTitle=Constant.expectedTitleMobileSlider;
		Assert.assertEquals(actualTitle,expectedTitle,Constant.titleError);
	}

	@Test(priority = 2,description = "image displayed")
	public void verifyTheImageIsDisplayed() {
		lp=new LoginPage(driver);
		ms=new MobileSlider(driver);
		lp.presteps();

		boolean actualImgDisp=ms.isImageDisplayed();
		Assert.assertTrue(actualImgDisp);
	}

	@Test(priority = 3,description = "check the status of item")
	public void verifyTheStatusOfItem() {
		lp=new LoginPage(driver);
		ms=new MobileSlider(driver);
		lp.presteps();

		String actualStatus=ms.getStatus();

		String expectedStatus=Constant.expectedStatus_item;
		Assert.assertEquals(actualStatus,expectedStatus,Constant.status_item_Error);
	}
}
