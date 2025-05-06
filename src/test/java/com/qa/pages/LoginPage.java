package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods{

    WebDriver driver;
    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Important: Initializes @FindBy elements
    
        // Page elements declared with @FindBy annotation
    
    }
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    
    // ✅ Reusable login method
    public LoginPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
		return null;
    }
  
  

    // Method to enter the username
    
    public void enterUsername(String username) {
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    // Method to click the login button
    public void clickLoginButton() {
        loginButton.click();
    }

    // Method to check if the login button is visible
    public boolean isLoginButtonVisible() {
        return loginButton.isDisplayed();
    }
    
    
    
}
