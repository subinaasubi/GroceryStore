package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocation;

public class ManageLocationTestCases extends BaseClass{
	LoginPage lP;
	ManageLocation ml;
	
  @Test(priority=1,description = "Validating count of 'Active' status")
  public void verifyTheNumberOfActiveStatus() {
	  lP=new LoginPage(driver);
		lP.presteps();
		ml=new ManageLocation(driver);
		
		int actualCount=ml.getActiveStatus();
	    int expectedCount=ml.finalCount;
	    Assert.assertEquals(actualCount, expectedCount,Constant.COUNT_ERROR);
  }
  
  @Test(priority = 2,description = "edit location and validate selected state")
  public void verifyTheSelectedState() {
	  lP=new LoginPage(driver);
		lP.presteps();
		ml=new ManageLocation(driver);
		
		String actualState=ml.editlocation();
		String expectedState="Belfast";
		Assert.assertEquals(actualState, expectedState, Constant.DROPDOWN_ERROR);
  }
}
