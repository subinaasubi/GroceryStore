package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class Dashboard {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Home']")
	WebElement homeTab;
    @FindBy(xpath = "(//p[contains(text(),'Manage Expense')])[1]")
    WebElement manageExpense;
    @FindBy(xpath = "(//p[text()='Manage Users'])[1]")
    WebElement manageUsers;
    
    public String manageExpenseVerification() {
    	return gu.getElementText(manageExpense);
    }
    
    public String manageUsersVerification() {
         return gu.getElementText(manageUsers);   
    }
    
    public String homeTabStyleProperty() {
    	String color=gu.stylePropertyValidation(homeTab,"background-color");
    	return color;
    }
}
