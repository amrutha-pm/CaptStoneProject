package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.ProjectSpecificationMethods;

public class LogoutPage extends ProjectSpecificationMethods{
    WebDriver driver;
    // Constructor to initialize elements
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Important: Initializes @FindBy elements
    
        // Page elements declared with @FindBy annotation
    
    }
    @FindBy(css = "(a[href='Logout.php'])")
	public
    WebElement LogoutButton;
    
	    @FindBy(className = "reg_success")
	    private WebElement regSuccessText;

	    @FindBy(xpath = "//a[contains(text(),'Click here to login again')]")
	    private WebElement loginAgainLink;

	    // Getter methods

	    public WebElement getRegSuccessText() {
	        return regSuccessText;
	    }

	    public WebElement getLoginAgainLink() {
	        return loginAgainLink;
	    }

	    // Convenience method to retrieve success message
	    public String getSuccessMessage() {
	        return regSuccessText.getText();
	    }

	    // Click the "login again" link
	    public void clickLoginAgain() {
	        loginAgainLink.click();
	    }
	

}
