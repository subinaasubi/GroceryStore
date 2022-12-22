package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSlider {
   WebDriver driver;
   GeneralUtilities gu=new GeneralUtilities();
   
   public MobileSlider(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements(driver,this);
   }
   
   @FindBy(xpath ="//p[contains(text(),'Mobile Slider')]")
   WebElement mobileSlider;
   @FindBy(xpath = "//h1[contains(text(),'List Mobile Sliders')]")
   WebElement mobileSliderTitle;
   @FindBy(xpath = "//tbody/tr[1]/td[1]/img[1]")
   WebElement imagedisplayed;
   @FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]/span[1]")
   WebElement status;
   
   public String getMobileSliderTitle()  {
	   gu.clickOnElement(mobileSlider);
	 
	   return gu.getPageTitle(driver);
   }
   
   public boolean isImageDisplayed() {
	   gu.clickOnElement(mobileSlider);
	   return gu.isElementDisplayed(imagedisplayed);
   }
   
   public String getStatus() {
	   gu.clickOnElement(mobileSlider);
	   return gu.getElementText(status);
   }
   
}
