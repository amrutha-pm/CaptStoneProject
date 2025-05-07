package com.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectHotelPage {
	  WebDriver driver;
	  
	  // Locators for elements on the Select Hotel page
	  
	  @FindBy(xpath="//input[starts-with(@id, 'radiobutton_')]")  //4 radiobuttons list
	    WebElement hotelLists;
	  
	  @FindBy(xpath="(//input[@id='hotel_name_0'])[1]")     //strong[normalize-space()='Hotel Name']
	    WebElement hotelName;
	  
	  @FindBy(xpath="//input[@id='radiobutton_1']")  //first element
	    WebElement selectHotelRadioButton;
	  @FindBy(xpath="//input[@id='radiobutton_0']")  //first element
	public
	    WebElement selectHotelRadioButton_0;
	  
	  @FindBy(id="continue")
	    WebElement continueButton;
	  
	  @FindBy(xpath="//*[@id=\"radiobutton_span\"]")
	  WebElement errorMessageText;  //Please Select a Hotel
	 
	// In SelectHotelPage.java

	  @FindBy(xpath = "//input[contains(@id,'radiobutton')]//following::strong[normalize-space()]")
	  List<WebElement> hotelNames;

	  public String getHotelNameFromList(int index) {
	      // Ensure the index is within bounds of the hotel list
	      if (index >= 0 && index < hotelNames.size()) {
	          return hotelNames.get(index).getText();
	      } else {
	          return null; // Or throw an exception depending on your preference
	      }
	  }

	  
	  public String getErrorMessage() {
		    return errorMessageText.getText().trim();
		}
	  // Method to check if hotel list is displayed
	    public boolean isHotelListDisplayed() {
	        try {
	         //   WebElement hotelListElement = driver.findElement(hotelLists);
	            return hotelLists.isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }    

	
	 // Method to select a specific hotel by name
	    public void selectHotelFromListByName() {
	        hotelName.click();
	    }
	    public void selectHotelFromList() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    	WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("radiobutton_1")));
	    	

	        if (selectHotelRadioButton.isDisplayed() && selectHotelRadioButton.isEnabled()) {
	            selectHotelRadioButton.click();
	        } else {
	            throw new IllegalStateException("❌ Select hotel radio button is not available to click.");
	        }
	    }

	    
	    
	    // Method to click the Continue button after selecting a hotel
	    public void clickContinue() {
	        continueButton.click();
	    }
	    
	    // Method to verify redirection to the Select Hotel page
	    public String getPageUrl() {
	        return driver.getCurrentUrl();
	    }
	    
	    
	  
	  
	    // Constructor to initialize elements
	    public SelectHotelPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  // Important: Initializes @FindBy elements
	    
	        // Page elements declared with @FindBy annotation
	    
	    }
	 // Locators for the elements on the Search Hotel page
	    @FindBy(id="location")
	    WebElement locationDropdown;
	    
	    @FindBy(id="hotels")
	    WebElement hotelDropdown;
	    
	    
	    
	    @FindBy(id="datepick_in")
	    WebElement checkInDateField;
	    
	    @FindBy(id="datepick_out")
	    WebElement checkOutDateField;
	    
	    @FindBy(id="room_nos")
	    WebElement roomsDropdown;
	    
	    
	    
	    @FindBy(id="room_type")
	    WebElement roomTypeDropdown;
	    
	    
	    
	    @FindBy(id="Submit")
	    WebElement submitButton;

	
	    // Methods to interact with elements on the page

	    public void selectLocation(String location) {
	       locationDropdown.sendKeys(location);
	    }

	    public void selectHotel(String hotel) {
	        hotelDropdown.sendKeys(hotel);
	    }

	    public void selectRooms(String rooms) {
	        roomsDropdown.sendKeys(rooms);
	    }

	    public void setArrivalDate(String date) {
	        checkInDateField.sendKeys(date);
	    }

	    public void setDepartureDate(String date) {
	        checkOutDateField.sendKeys(date);
	    }

	    public void selectRoomType(String roomType) {
	        roomTypeDropdown.sendKeys(roomType);
	    }

	    public void clickSearchButton() {
	        submitButton.click();
	    }

	    // Method to perform the search
	    public void searchHotel(String location, String hotel, String rooms, String checkInDateField, String checkOutDateField, String roomType) {
	        selectLocation(location);
	        selectHotel(hotel);
	        selectRooms(rooms);
	        setArrivalDate(checkInDateField);
	        setDepartureDate(checkOutDateField);
	        selectRoomType(roomType);
	        clickSearchButton();
	    }


		public WebElement getContinueButton() {
			// TODO Auto-generated method stub
			submitButton.click();
			return null;
		}
	}

