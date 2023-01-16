package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotifications;

public class PushNotificationsTestCases extends BaseClass{
	LoginPage lp;
	PushNotifications pn;
	
  @Test(priority = 1,description = "page title verification")
  public void verifyPushNotificationTitleDisplayedCorrectly() {
	  lp=new LoginPage(driver);
	  pn=new PushNotifications(driver);
	  lp.presteps();
	  
	  String actualTitle=pn.getPushNotificationPageTitle();
	  String expectedTitle=Constant.EXPECTED_TITLE_PUSH_NOTIFICATIONS;
	 Assert.assertEquals(actualTitle,expectedTitle,Constant.TITLE_ERROR);
  }
  
  @Test(priority = 2,description = "verify Title text box is mandatory")
  public void verifyTitleTextBoxHasMandatorySymbol() {
	  lp=new LoginPage(driver);
	  pn=new PushNotifications(driver);
	  lp.presteps();
	  
	  String actualColor=pn.validateTextBoxTitleMandatory();
	  String expectedColor=Constant.EXPECTED_CLR_OF_MANDATORY_SYMBOL ;
	  Assert.assertEquals(actualColor,expectedColor,Constant.STYLE_ERROR);
  }
  
  @Test(priority = 3,description = "Send Button Color Validation")
  public void verifyColorOfSendBtn() {
	  lp=new LoginPage(driver);
	  pn=new PushNotifications(driver);
	  lp.presteps();
	  
	  String sendBtnActualColor=pn.getColorOfSendButton();
	  String sendBtnExpectedColor=Constant.EXPECTED_SENDBTN_CLR;
	  Assert.assertEquals(sendBtnActualColor, sendBtnExpectedColor, Constant.STYLE_ERROR);
  }
  
  @Test(priority = 4,description = "Background color verification of alert box")
  public void verifyBackGroundColorOfAlertBox() {
	  lp=new LoginPage(driver);
	  pn=new PushNotifications(driver);
	  lp.presteps();
	
	  String actualClrAlertBox=pn.getBackgroundColorOfAlertBox();
	  String expectedClrAlertBox=Constant.EXPECTED_CLR_ALRTBOX;
	  Assert.assertEquals(actualClrAlertBox, expectedClrAlertBox,Constant.STYLE_ERROR);
  }
  
  @Test(priority = 5,description = "alert message verification")
  public void verifyTheAlertMessageDisplayed()  {
	  lp=new LoginPage(driver);
	  pn=new PushNotifications(driver);
	  lp.presteps();
	  
	  boolean actualAlertMsg=pn.isAlertBoxDisplayed();
	  
	  Assert.assertTrue(actualAlertMsg,Constant.ALERT_MSG_ERROR);
  }
  
}
