package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.ProjectSpecificationMethods;

public class BookingConfirmationPage extends ProjectSpecificationMethods{

	   WebDriver driver;
	    // Constructor to initialize elements
	    public BookingConfirmationPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  // Important: Initializes @FindBy elements
	    
	        // Page elements declared with @FindBy annotation
	    
	    }
	    @FindBy(id = "username")
	    WebElement usernameField;

	    @FindBy(id="my_itinerary")
	    WebElement myItenary;

	    @FindBy(id="search_hotel")
	    WebElement searchHotel;

	    
	    @FindBy(id="logout")
	    WebElement LogoutButton;

public void clickMyItenaryButton() {
myItenary.click();

}
public void SearchHotelButton() {
	searchHotel.click();
}

public void LogoutClick() 
{
	LogoutButton.click();
}

public boolean LogoutIsDisplayed() {
return LogoutButton.isDisplayed();

}

public boolean ismyItenaryDisplayed() {
	return myItenary.isDisplayed();
	
}
}