package elementRepository;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocation {
	int count;
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageLocation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//body/div[1]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[9]/a[1]")
	WebElement manageLocation;
	//@FindBy(tagName="//tbody/tr[1]/td[5]")
	//WebElement statusColumn;
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement stateDropdown;
    @FindBy(xpath = "//tbody/tr[1]/td[6]/a[1]")
    WebElement editButton;
    
    public int getActiveStatus() {
    	gu.clickOnElement(manageLocation);
    	List<WebElement>statusColumn=driver.findElements(By.xpath("//tbody/tr/td[5]"));
    	for(int i=0;i<statusColumn.size();i++) {
    		if(statusColumn.get(i).getText().equals("Active")) {
    			count++;
    		}
    	}
    	return count;
    }
    
  public String editlocation() {
	  gu.clickOnElement(manageLocation);
	  gu.clickOnElement(editButton);
	  gu.selectFuncbyViText(stateDropdown, "Belfast");
	  return gu.getFirstSelectedOption(stateDropdown);
  }
    
    
}
