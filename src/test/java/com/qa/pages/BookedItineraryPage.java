package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.ProjectSpecificationMethods;

public class BookedItineraryPage extends ProjectSpecificationMethods{
	  WebDriver driver;
	    // Constructor to initialize elements
	    public BookedItineraryPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  // Important: Initializes @FindBy elements
	    
	        // Page elements declared with @FindBy annotation
	    
	    }
	    @FindBy(id = "username")
	    WebElement usernameField;

}
