package com.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.qa.base.ProjectSpecificationMethods;

public class SearchHotelPage extends ProjectSpecificationMethods{
	WebDriver driver;
	// Constructor to initialize elements

	public SearchHotelPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this); // Important: Initializes @FindBy elements

		// Page elements declared with @FindBy annotation

	}
	@FindBy(css= "a[href='SearchHotel.php']")
	WebElement searchHotelHeaderMenu;
	
	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logOutHeaderMenu;
	
	
	@FindBy(id="location")
	 WebElement location;
	
	@FindBy(id="hotels")
	WebElement hotels;
	
	@FindBy(id="room_type")
	 WebElement room_type;
	
	@FindBy(id="room_nos")
 WebElement room_nos;
	
	@FindBy(id="datepick_in")
	 WebElement datepick_checkin;
	
	@FindBy(id="datepick_out")
	 WebElement datepick_checkout;
	
	@FindBy(id="adult_room")
	 WebElement adult_per_room;
	
	@FindBy(id="child_room")
	 WebElement child_per_room;
	
	@FindBy(id="Submit")
	 WebElement SearchButton;
	
	@FindBy(id="Reset")
	 WebElement ResetButton;
	
	@FindBy(className="welcome_menu")
 WebElement welcome_text;
	
	@FindBy(id="checkin_span")
 WebElement checkin_span_error;
	@FindBy(id="checkout_span")
	 WebElement checkout_span_error;


/*
@FindBy(xpath = "//td[contains(text(), 'Children per Room') and '*']")
WebElement  childPerRoomLabel;
@FindBy(xpath = "//*[@id=\"search_form\"]/table/tbody/tr[3]/td[1]")
WebElement  HotelsLabel;
*/
	
	@FindBy(xpath = "//td[contains(text(), 'Location')]")
	public
	WebElement locationLabel;

	@FindBy(xpath = "//td[contains(text(), 'Number of Rooms')]")
	public
	WebElement numberOfRoomsLabel;

	@FindBy(xpath = "//td[contains(text(), 'Check In Date')]")
	public
	WebElement checkInDateLabel;

	@FindBy(xpath = "//td[contains(text(), 'Check Out Date')]")
	public
	WebElement checkOutDateLabel;

	@FindBy(xpath = "//td[contains(text(), 'Adults per Room')]")
	public
	WebElement adultsPerRoomLabel;

	
	@FindBy(xpath = "//td[contains(text(), 'Children per Room')]")
	public
	WebElement  childPerRoomLabel;   
	
	@FindBy(xpath = "//td[contains(text(), 'Hotels')]")
	public
	WebElement  HotelsLabel;
	

	public WebElement getCheckin_span_error() {
		return checkin_span_error;
	}
	
	public WebElement getCheckout_span_error() {
		return checkout_span_error;
	}
	public WebElement getWelcome_text() {
		return welcome_text;
	}
	
	
	//Room Type Dropdown Handling
	// Locator for Room Type dropdown
  //  private By roomTypeDropdown = By.id("room_type");

    @FindBy(id="room_type")
    public 
    WebElement roomTypeDropdown;
	
	
	// ✅ Add methods to interact with these elements

    public boolean isSearchHotelMenuVisible() {
        return searchHotelHeaderMenu.isDisplayed();
    }
    
    //public boolean isLocationDropdownDisplayed() {
      //  return location.isDisplayed();
   // }

    public boolean isHotelDropdownDisplayed() {
        return hotels.isDisplayed();
    }

 /*   public boolean isRoomTypeDropdownDisplayed() {
        return room_type.isDisplayed();
    }*/

    public boolean isRoomNoDropdownDisplayed() {
        return room_nos.isDisplayed();
    }

    public boolean isCheckInDateDisplayed() {
        return datepick_checkin.isDisplayed();
    }

    public boolean isCheckOutDateDisplayed() {
        return datepick_checkout.isDisplayed();
    }

    public boolean isAdultPerRoomDisplayed() {
        return adult_per_room.isDisplayed();
    }

    public boolean isChildPerRoomDisplayed() {
        return child_per_room.isDisplayed();
    }

    public boolean isSearchButtonDisplayed() {
        return SearchButton.isDisplayed();
    }

    
    @FindBy(id="hotels")
    public 
    WebElement hotelDropdown;
    //private By hotelDropdown = By.id("hotel");
    
    @FindBy(xpath = "//*[@id=\"hotels\"]/option[3]")
    WebElement HotelSunshine;
    
    @FindBy(xpath = "//*[@id=\"datepick_in\"]")
    WebElement checkInDateField;
    
    @FindBy(xpath ="//*[@id=\"datepick_out\"]")
    WebElement checkOutDateField;
    
    @FindBy(id = "checkin_span")
    WebElement checkInDateErrorMessage;

    @FindBy(id = "checkout_span")////*[@id="checkout_span"]
    WebElement checkOutDateErrorMessage;
    
 // Method to click on 'Search Hotel' menu item
  
    public void clickSearchHotelHeaderMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchHotelHeaderMenu));
        searchHotelHeaderMenu.click();
    }


    public boolean isFieldMarkedWithAsterisk(WebElement labelTd) {
        try {
            String labelText = labelTd.getText().trim();
            System.out.println("Label found: " + labelText); // Optional: debug
            return labelText.contains("*");
        } catch (Exception e) {
            System.out.println("Error checking label: " + e.getMessage());
            return false;
        }
    }



    public void assertMandatoryFields() {
        System.out.println("🔍 Verifying mandatory fields...");

        Assert.assertTrue(isFieldMarkedWithAsterisk(locationLabel), "❌ 'Location' field is not marked as mandatory.");
        Assert.assertTrue(isFieldMarkedWithAsterisk(numberOfRoomsLabel), "❌ 'Number of Rooms' field is not marked as mandatory.");
        Assert.assertTrue(isFieldMarkedWithAsterisk(checkInDateLabel), "❌ 'Check In Date' field is not marked as mandatory.");
        Assert.assertTrue(isFieldMarkedWithAsterisk(checkOutDateLabel), "❌ 'Check Out Date' field is not marked as mandatory.");
        Assert.assertTrue(isFieldMarkedWithAsterisk(adultsPerRoomLabel), "❌ 'Adults per Room' field is not marked as mandatory.");
        Assert.assertTrue(isFieldMarkedWithAsterisk(childPerRoomLabel), "❌ 'Adults per Room' field is not marked as mandatory.");
        Assert.assertFalse(isFieldMarkedWithAsterisk(HotelsLabel), "❌ 'Hotels' field should NOT be marked as mandatory.");


        System.out.println("✅ All mandatory fields have been successfully verified.");
    }

    @FindBy(id = "location")
    WebElement locationDropdown;

 // Method to get all options from the Location dropdown
    public int getLocationDropdownOptionCount() {
        Select dropdown = new Select(locationDropdown);
        return dropdown.getOptions().size();  // Returns the number of options in the dropdown
    }
    
    
 // Method to select a location by its index
    public void selectLocationByIndex(int index) {
        Select dropdown = new Select(locationDropdown);
        dropdown.selectByIndex(index);  // Selects the option by index
    }
    
    
 // Method to get the currently selected location
    public String getSelectedLocation() {
        Select dropdown = new Select(locationDropdown);
        return dropdown.getFirstSelectedOption().getText();  // Gets the selected option's text
    }
    
    // Method to check if the Location dropdown is displayed
    public boolean isLocationDropdownDisplayed() {
        return locationDropdown.isDisplayed();
    }
    

 // Returns the selected/default value of the Location dropdown
 public String getLocationDropdownSelectedValue() {
     Select locationDropdown = new Select(location);
     return locationDropdown.getFirstSelectedOption().getText();
 }

 
 public String getSelectedLocations() {
	    return new Select(location).getFirstSelectedOption().getText();
	}

	public String getSelectedHotel() {
	    return new Select(hotels).getFirstSelectedOption().getText();
	}

	/*public String getSelectedRoomType() {
	    return new Select(room_type).getFirstSelectedOption().getText();
	}*/

	public String getSelectedRoomNos() {
	    return new Select(room_nos).getFirstSelectedOption().getText();
	}

	public String getCheckInDate() {
	    return datepick_checkin.getAttribute("value");
	}

	public String getCheckOutDate() {
	    return datepick_checkout.getAttribute("value");
	}

	public String getSelectedAdultRoom() {
	    return new Select(adult_per_room).getFirstSelectedOption().getText();
	}

	public String getSelectedChildRoom() {
	    return new Select(child_per_room).getFirstSelectedOption().getText();
	}

	 // Method to get the list of hotel options in the dropdown
	public List<String> getHotelDropdownOptions() {
	    List<String> optionsList = new ArrayList<>();
	    Select select = new Select(hotelDropdown); // Directly use hotelDropdown WebElement

	    // Get all options in the dropdown
	    for (WebElement option : select.getOptions()) {
	        optionsList.add(option.getText());
	    }

	    return optionsList;
	}

    // Method to get the total number of hotels in the dropdown
	public int getTotalNumberOfHotels() {
	    Select select = new Select(hotelDropdown); // Directly use hotelDropdown WebElement
	    return select.getOptions().size(); // Get the total number of options
	}


	public boolean areAllHotelsDisplayedAndSelectable() {
	    Select select = new Select(hotelDropdown); // Directly use hotelDropdown WebElement

	    for (WebElement option : select.getOptions()) {
	        if (!option.isDisplayed() || !option.isEnabled()) {
	            return false; // If any option is not displayed or selectable, return false
	        }
	    }

	    return true; // All options are displayed and selectable
	}
	public String getSelectedHotels() {
	    Select select = new Select(hotelDropdown); // Directly use hotelDropdown WebElement
	    return select.getFirstSelectedOption().getText(); // Get the text of the first selected option
	}


    // Method to select a hotel from the dropdown
	public void selectHotel(String hotelName) {
	    Select select = new Select(hotelDropdown); // Directly use hotelDropdown WebElement
	    select.selectByVisibleText(hotelName); // Select the hotel by visible text
	}

    public void selectHotelByName(String hotelName) {
        Select hotelDropdown = new Select(driver.findElement(By.id("hotels")));
        hotelDropdown.selectByVisibleText(hotelName);
    }

  /*  public String getSelectedHotel() {
        Select hotelDropdown = new Select(driver.findElement(By.id("hotels")));
        return hotelDropdown.getFirstSelectedOption().getText().trim();
    }
*/
    /**
     * Get default selected room type option.
     */
    public String getSelectedRoomType() {
        Select select = new Select(roomTypeDropdown);
        return select.getFirstSelectedOption().getText();
    }

 
     // Method to fetch all room types from the room type dropdown.
    
    public  List<String> getRoomTypesFromDropdown() {
        // Find the dropdown element using its ID
        Select select = new Select(driver.findElement(By.id("room_type")));

        // Get all the options available in the dropdown
        List<WebElement> options = select.getOptions();

        // Create a list to store the room types
        List<String> roomTypes = new ArrayList<>();

        // Loop through the options and add each option's text to the list
        for (WebElement option : options) {
            roomTypes.add(option.getText().trim());
        }

        // Return the list of room types
        return roomTypes;
    }


    /**
     * Select room type by visible text.
     */
    public void selectRoomType(String roomType) {
        Select select = new Select(roomTypeDropdown);
        select.selectByVisibleText(roomType);
    }

    /**
     * Check if the Room Type dropdown is displayed.
     */
    public boolean isRoomTypeDropdownDisplayed() {
        try {
            return roomTypeDropdown.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
public void clickRoomTypeDropDownList() {
	roomTypeDropdown.click();

}
//Method to get the Check-in Date field (returns WebElement)
public WebElement getCheckInDateField() {
    return checkInDateField;
}


	public void enterCheckInDate(String validDate) throws InterruptedException {
	    checkInDateField.clear();   
	    // Clear any existing value
	    Thread.sleep(1000);
	    checkInDateField.sendKeys(validDate);   // Enter the new date
	}

	public String getErrorMessage() {
	    return checkInDateErrorMessage.getText().trim();
	}

	public void clickSearchButton() {
	    SearchButton.click();
	}
	 // Methods to interact with the page
    public void selectLocation(String location) {
        new Select(locationDropdown).selectByVisibleText(location);
    }

 /*   public void selectHotel(String hotel) {
        new Select(hotelDropdown).selectByVisibleText(hotel);
    }
*/
 /*   public void selectRoomType(String type) {
        new Select(roomTypeDropdown).selectByVisibleText(type);
    }
*/
    public void selectNumberOfRooms(String value) {
        new Select(room_nos).selectByVisibleText(value);
    }

    

    public void enterCheckOutDate(String date) throws InterruptedException {
        checkOutDateField.clear();
        Thread.sleep(1000);
        checkOutDateField.sendKeys(date);
    }


    
    public void selectAdultsPerRoom(String value) {
        new Select(adult_per_room).selectByVisibleText(value);
    }
    public void selectChildrenPerRoom(String value) {
        new Select(child_per_room).selectByVisibleText(value);
    }
    public String getCheckInDateErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement errorMessageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("checkin_span"))
            );
            return errorMessageElement.getText().trim();
        } catch (TimeoutException e) {
            System.out.println("❌ Error message element not found within timeout.");
            return "";
        } catch (NoSuchElementException e) {
            System.out.println("❌ Error message element not found.");
            return "";
        }
    }

 // Method to get the error message text (if any)
    public String getCheckOutDateErrorMessage() {
        return checkOutDateErrorMessage.getText();
    }
    public WebElement getCheckOutDateField() {
        return checkOutDateField;
    }

    @FindBy(id = "hotels")
    WebElement hotelsDropdown;
    @FindBy(id = "room_nos")
    WebElement noRoomsDropdown;

    @FindBy(id = "adult_room")
    WebElement adultsDropdown;
    @FindBy(id = "child_room")
    WebElement childrensDropdown;

  
    // Method to enter search details
    public void enterSearchDetails(String location, String hotels, String roomType, String noRooms,
                                   String checkInDate, String checkOutDate, String adults, String childrens) throws InterruptedException {

    	datepick_checkin.clear();
    	datepick_checkout.clear();
        if (location != null && !location.trim().isEmpty()) {
            new Select(locationDropdown).selectByVisibleText(location);
        }

        if (hotels != null && !hotels.trim().isEmpty()) {
            new Select(hotelsDropdown).selectByVisibleText(hotels);
        }

        if (roomType != null && !roomType.trim().isEmpty()) {
            new Select(roomTypeDropdown).selectByVisibleText(roomType);
        }

        if (noRooms != null && !noRooms.trim().isEmpty()) {
            new Select(noRoomsDropdown).selectByVisibleText(noRooms);
        }

        if (checkInDate != null && !checkInDate.trim().isEmpty()) {
            enterCheckInDate(checkInDate);
        }

        if (checkOutDate != null && !checkOutDate.trim().isEmpty()) {
            enterCheckOutDate(checkOutDate);
        }

        if (adults != null && !adults.trim().isEmpty()) {
            new Select(adultsDropdown).selectByVisibleText(adults);
        }

        if (childrens != null && !childrens.trim().isEmpty()) {
            new Select(childrensDropdown).selectByVisibleText(childrens);
        }
    }

	public void clickReset() {
		// TODO Auto-generated method stub
		ResetButton.click();
	}
	

  /*  // Reusable methods to enter dates
    public void enterCheckInDate(String date) {   //already mentioned above
        checkInDateField.clear();
        checkInDateField.sendKeys(date);
    }

  /*  public void enterCheckOutDate(String date) {  //already mentioned above
        checkOutDateField.clear();
        checkOutDateField.sendKeys(date);
    }*/

/*    // Submit the search form
    public void clickSearchButton() {  //already mentioned above
        searchButton.click();
    } */
    
}