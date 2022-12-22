package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileHandling;
import utilities.GeneralUtilities;

public class ManageProduct {
    WebDriver driver;
    GeneralUtilities gu=new GeneralUtilities();
    FileHandling fh=new FileHandling();
    
    public ManageProduct(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements( driver,this);
    }
    
    @FindBy(xpath = "//p[contains(text(),'Manage Product')]")
    WebElement manageProdSideBar;
    @FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[1]")
    WebElement newProductBtn;
    @FindBy(xpath = "//input[@id='main_img']")
    WebElement chooseFileImg;
    @FindBy(xpath = "//input[@value='Veg']")
    WebElement vegRadioBtn;
    @FindBy(xpath = "(//input[@name='stock'])[1]")
    WebElement stockYesRadioBtn;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@id='imagePreview']")
    WebElement imagePreview;
    
    public void enterProductDetails() throws AWTException, InterruptedException {
    	gu.clickOnElement(manageProdSideBar);
    	gu.clickToTheElement(newProductBtn,driver);
    	gu.scrollToTheElement(chooseFileImg, driver);
    	gu.mediumDelay(2000);
    	String filePath= System.getProperty("user.dir") +"\\src\\main\\resources\\Images\\Curry-Powder.png";
    	fh.fileUpload(filePath,chooseFileImg,driver);
    }
    
   
    
    public boolean isImageSelected() throws AWTException, InterruptedException {
    	enterProductDetails();
    	gu.mediumDelay(2000);
    	return gu.isElementDisplayed(imagePreview);
    }
    
    public boolean isRadioBtnSelected() {
    	gu.clickOnElement(manageProdSideBar);
    	gu.clickToTheElement(newProductBtn, driver);
    	return gu.isElementSelected(vegRadioBtn);
    }
    
    public boolean isStockYesRadioBtnSelected() {
    	gu.clickOnElement(manageProdSideBar);
    	gu.clickToTheElement(newProductBtn, driver);
    	return gu.isElementSelected(stockYesRadioBtn);
    }
    
    public String getColorOfSaveBtn() {
    	gu.clickOnElement(manageProdSideBar);
    	gu.clickToTheElement(newProductBtn, driver);
    	gu.scrollToTheElement(saveBtn, driver);
    	return gu.stylePropertyValidation(saveBtn, "color");
    }
}
