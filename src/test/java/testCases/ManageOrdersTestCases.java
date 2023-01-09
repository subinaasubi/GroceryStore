package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrders;

public class ManageOrdersTestCases extends BaseClass{
	LoginPage lp;
	ManageOrders mo;
	
  @Test(priority = 1,description = "verify value of column payment mode")
  public void verifyThevaluesOfColumnpaymentModeIsBank() {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mo=new ManageOrders(driver);
	  	
	  	boolean actualComparisonResult=mo.compareAllValuesOfColumn();
	   	Assert.assertTrue(actualComparisonResult);
  }
  
  @Test(priority = 2,description = "status drop down size")
  public void verifyTheSizeOfStatusDropdown() {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mo=new ManageOrders(driver);
	  	
	  	int actualSize=mo.getStatusDropDownSize();
	  	int expectedSize=Constant.EXPECTED_STATUS_DRPDWN_SIZE;
	  	Assert.assertEquals(actualSize, expectedSize,Constant.SIZE_ERROR);
  }
  
  @Test(priority = 3,description = "search with orderid and validate orderid and paymnt mode")
  public void verifyOrderIdAndModeOfPayment() {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mo=new ManageOrders(driver);
	  	
	  	String actualOrderId=(String) mo.searchUsingOrderId();
	  	String expectedOrderId=mo.firstOrder;
	  	SoftAssert softAssert=new SoftAssert();
	  	softAssert.assertEquals(actualOrderId, expectedOrderId,Constant.ORDERID_ERROR);
	  	String actualPaymntMode=mo.getPaymentModeFromTable();
	  	String expectedPaymntMode=mo.paymntM;
	  	softAssert.assertEquals(actualPaymntMode, expectedPaymntMode,Constant.textError);
	  	softAssert.assertAll();
  }
}
