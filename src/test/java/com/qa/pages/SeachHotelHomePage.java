package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.ProjectSpecificationMethods;

public class SeachHotelHomePage extends ProjectSpecificationMethods{

	WebDriver driver;
	// Constructor to initialize elements

	public SeachHotelHomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // Important: Initializes @FindBy elements

		// Page elements declared with @FindBy annotation

	}

	@FindBy(xpath="//td[@class=\"welcome_menu\"][1]")
	WebElement welcomeMenuText;
	
	@FindBy(xpath = "//a[normalize-space()='Search Hotel']")
	WebElement searchHotelHeaderMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Booked Itinerary']")
	WebElement bookedItineraryHeaderMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	WebElement changePasswordHeaderMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logOutHeaderMenu;
	
    @FindBy(xpath="//img[@alt='AdactIn Group']")
    WebElement logo;

    @FindBy(name="username_show")
    WebElement userNameShow;
    
    
 // ✅ Add methods to interact with these elements

    public boolean isSearchHotelMenuVisible() {
        return searchHotelHeaderMenu.isDisplayed();
    }

    public boolean isLogoutVisible() {
        return logOutHeaderMenu.isDisplayed();
    }

    public void clickLogout() {
        logOutHeaderMenu.click();
    }
}
