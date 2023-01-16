package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;

public class ManageProductTestCases extends BaseClass{
	LoginPage lp;
	ManageProduct mp;
	
  @Test(priority = 1,description = "verify image file is choosen", retryAnalyzer = retryTest.RetryAnalyzer.class)
  public void verifyTheImageFileIsSelected() throws AWTException, InterruptedException {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mp=new ManageProduct(driver);
	  	
	  	boolean actualImageUploaded=mp.isImageSelected();
	   	Assert.assertTrue(actualImageUploaded,Constant.UPLOAD_ERROR);
  }
  
  @Test(priority = 2,description = "verify veg radio button is selected")
  public void verifyTheVegRadioButtonIsSelected() {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mp=new ManageProduct(driver);
	  	
	  	boolean actualVegRadioBtn=mp.isRadioBtnSelected();
	  	Assert.assertTrue(actualVegRadioBtn,Constant.RADIO_BTN_ERROR);
  }
  
  @Test(priority = 3,description = "verify Stock yes radio button is selected")
  public void verifyTheStockRadioBtnIsSelected() {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mp=new ManageProduct(driver);
	  	
	  	boolean actualStockYesRadioBtn=mp.isStockYesRadioBtnSelected();
	  	Assert.assertTrue(actualStockYesRadioBtn,Constant.RADIO_BTN_ERROR);
  }
  
  @Test(priority = 4,description = "font color validation of Save button")
  public void verifyTheColorOfStyleBtn() {
	  lp=new LoginPage(driver);
	  	lp.presteps();
	  	mp=new ManageProduct(driver);
	  	
	  	String actualSaveBtnClr=mp.getColorOfSaveBtn();
	    String expectedSaveBtnClr=Constant.EXPECTED_CLR_SAVEBTN_MP;
	    Assert.assertEquals(actualSaveBtnClr, expectedSaveBtnClr,Constant.STYLE_ERROR);
  }
}
