package com.qa.tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchHotelPage;

public class TC_003_SearchHotelTest extends ProjectSpecificationMethods {

	SearchHotelPage searchHotelPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		loginPage = new LoginPage(driver);
		searchHotelPage = new SearchHotelPage(driver);

		// Login before test
		loginPage.enterUsername("amruthapm");
		loginPage.enterPassword("Google123");
		loginPage.clickLoginButton();
	}

	@BeforeTest
	public void setup() throws InterruptedException {

		sheetname = "SearchHotel"; // This is the sheet name you are reading from the Excel file
		testname = "Login Test";
		testdescription = "Testing the Login functionality with valid and invalid data";
		testauthor = "Amrutha";
		testcategory = "Regression";

	}

	@Test(priority = 1)

	public void verifySearchHotelMenuNaviagtion() throws InterruptedException {

		// LoginPage loginPage = new LoginPage(driver);
		searchHotelPage = new SearchHotelPage(driver);

		// Perform login once before all tests
		System.out.println("🔐 Logging in before running tests...");
		/*
		 * try { loginPage.enterUsername("amruthapm");
		 * loginPage.enterPassword("Google123"); loginPage.clickLoginButton();
		 * 
		 * // Use WebDriverWait to wait for the page title to confirm login is
		 * successful WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.titleContains("Adactin.com - Search Hotel"));
		 */
		System.out.println("✅ Successfully logged in.");
		// } catch (Exception e) {
		// System.out.println("❌ Login failed: " + e.getMessage());
		// throw new RuntimeException("❌ Login failed: " + e.getMessage(), e);

		// e.printStackTrace();
		// }
		// Capture the actual page title after login attempt

		// Thread.sleep(4000);
		searchHotelPage = new SearchHotelPage(driver);

		// Click on 'Search Hotel' header menu
		searchHotelPage.clickSearchHotelHeaderMenu();

		// Assert that the page or section is displayed
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Adactin.com - Search Hotel", "Navigation to Search Hotel page failed.");
		Thread.sleep(3000);
		System.out.println("✅ Navigation to 'Search Hotel' page was successful.");
	}

	@Test(priority = 2)
	public void verifySearchHotelFormElementsPresence() {
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		System.out.println("✅ Verifying visibility of Search Hotel form elements...");

		Assert.assertTrue(searchHotelPage.isLocationDropdownDisplayed(), "❌ Location dropdown is not visible.");
		Assert.assertTrue(searchHotelPage.isHotelDropdownDisplayed(), "❌ Hotels dropdown is not visible.");
		Assert.assertTrue(searchHotelPage.isRoomTypeDropdownDisplayed(), "❌ Room Type dropdown is not visible.");
		Assert.assertTrue(searchHotelPage.isRoomNoDropdownDisplayed(), "❌ Number of Rooms dropdown is not visible.");
		Assert.assertTrue(searchHotelPage.isCheckInDateDisplayed(), "❌ Check-In Date field is not visible.");
		Assert.assertTrue(searchHotelPage.isCheckOutDateDisplayed(), "❌ Check-Out Date field is not visible.");
		Assert.assertTrue(searchHotelPage.isAdultPerRoomDisplayed(), "❌ Adults per Room dropdown is not visible.");
		Assert.assertTrue(searchHotelPage.isChildPerRoomDisplayed(), "❌ Children per Room dropdown is not visible.");
		Assert.assertTrue(searchHotelPage.isSearchButtonDisplayed(), "❌ Submit button is not visible.");

		System.out.println("✅ All form elements on the Search Hotel page are present and visible.");
	}

	/*
	 * @Test(priority=3) public void verifyFieldDefaultValues() { SearchHotelPage
	 * searchHotelPage = new SearchHotelPage(driver);
	 * 
	 * System.out.println("🔍 Verifying default values in Search Hotel form...");
	 * 
	 * Assert.assertEquals(searchHotelPage.getSelectedLocations(),
	 * "- Select Location -", "❌ Default Location not as expected.");
	 * Assert.assertEquals(searchHotelPage.getSelectedHotel(), "- Select Hotel -",
	 * "❌ Default Hotel not as expected.");
	 * Assert.assertEquals(searchHotelPage.getSelectedRoomType(),
	 * "- Select Room Type -", "❌ Default Room Type not as expected.");
	 * Assert.assertEquals(searchHotelPage.getSelectedRoomNos(), "1 - One",
	 * "❌ Default Number of Rooms not as expected.");
	 * Assert.assertEquals(searchHotelPage.getSelectedAdultRoom(), "1 - One",
	 * "❌ Default Adults per Room not as expected.");
	 * Assert.assertEquals(searchHotelPage.getSelectedChildRoom(), "0 - None",
	 * "❌ Default Children per Room not as expected.");
	 * 
	 * String checkIn = searchHotelPage.getCheckInDate(); String checkOut =
	 * searchHotelPage.getCheckOutDate();
	 * 
	 * Assert.assertFalse(checkIn.isEmpty(), "❌ Check-in date is empty.");
	 * Assert.assertFalse(checkOut.isEmpty(), "❌ Check-out date is empty.");
	 * 
	 * System.out.
	 * println("✅ All default values on Search Hotel form are as expected."); }
	 */
	@Test(priority = 3)
	public void verifyFieldDefaultValues() {
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		// Start the test in Extent Reports
		test = extent.createTest("verifyFieldDefaultValues");

		// Console Output
		System.out.println("🔍 Verifying default values in Search Hotel form...");

		// Log to Extent Report
		test.info("🔍 Verifying default values in Search Hotel form...");

		// Assertions and logging for each field in console and Extent Report
		String location = searchHotelPage.getSelectedLocations();
		String hotel = searchHotelPage.getSelectedHotel();
		String roomType = searchHotelPage.getSelectedRoomType();
		String roomNos = searchHotelPage.getSelectedRoomNos();
		String adultRoom = searchHotelPage.getSelectedAdultRoom();
		String childRoom = searchHotelPage.getSelectedChildRoom();
		String checkIn = searchHotelPage.getCheckInDate();
		String checkOut = searchHotelPage.getCheckOutDate();

		// Console logging and Extent Report logging
		Assert.assertEquals(location, "- Select Location -", "❌ Default Location not as expected.");
		test.info("Default Location: " + location);

		Assert.assertEquals(hotel, "- Select Hotel -", "❌ Default Hotel not as expected.");
		test.info("Default Hotel: " + hotel);

		Assert.assertEquals(roomType, "- Select Room Type -", "❌ Default Room Type not as expected.");
		test.info("Default Room Type: " + roomType);

		Assert.assertEquals(roomNos, "1 - One", "❌ Default Number of Rooms not as expected.");
		test.info("Default Number of Rooms: " + roomNos);

		Assert.assertEquals(adultRoom, "1 - One", "❌ Default Adults per Room not as expected.");
		test.info("Default Adults per Room: " + adultRoom);

		Assert.assertEquals(childRoom, "0 - None", "❌ Default Children per Room not as expected.");
		test.info("Default Children per Room: " + childRoom);

		// Check-in and Check-out date checks
		Assert.assertFalse(checkIn.isEmpty(), "❌ Check-in date is empty.");
		test.info("Check-in Date: " + checkIn);

		Assert.assertFalse(checkOut.isEmpty(), "❌ Check-out date is empty.");
		test.info("Check-out Date: " + checkOut);

		// If all assertions pass
		System.out.println("✅ All default values on Search Hotel form are as expected.");
		test.pass("✅ All default values on Search Hotel form are as expected.");
	}

	@Test(priority = 4)
	public void verifyMandatoryFieldAsterisks() {
		/*
		 * loginPage = new LoginPage(driver); searchHotelPage = new
		 * SearchHotelPage(driver);
		 * 
		 * // Login steps loginPage.enterUsername("amruthapm");
		 * loginPage.enterPassword("Google123"); loginPage.clickLoginButton();
		 */
		// Wait or navigate to the Search Hotel page if needed
		searchHotelPage.clickSearchHotelHeaderMenu();

		System.out.println("🔍 Verifying mandatory field asterisks...");

		// Run assertions on each field
		Assert.assertTrue(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.locationLabel),
				"❌ 'Location' field is not marked as mandatory.");
		Assert.assertTrue(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.numberOfRoomsLabel),
				"❌ 'Number of Rooms' field is not marked as mandatory.");
		Assert.assertTrue(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.checkInDateLabel),
				"❌ 'Check In Date' field is not marked as mandatory.");
		Assert.assertTrue(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.checkOutDateLabel),
				"❌ 'Check Out Date' field is not marked as mandatory.");
		Assert.assertTrue(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.adultsPerRoomLabel),
				"❌ 'Adults per Room' field is not marked as mandatory.");
		Assert.assertTrue(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.childPerRoomLabel),
				"❌ 'Adults per Room' field is not marked as mandatory.");
		Assert.assertFalse(searchHotelPage.isFieldMarkedWithAsterisk(searchHotelPage.HotelsLabel),
				"❌ 'Hotels' field should NOT be marked as mandatory.");

		System.out.println("✅ All mandatory fields have been successfully verified.");
	}

	@Test(priority = 5)
	public void testLocationDropdown() {

		// Verify the Location dropdown is displayed

		boolean isDisplayed = searchHotelPage.isLocationDropdownDisplayed();
		Assert.assertTrue(isDisplayed, "❌ Location dropdown should be visible but it's not.");

		System.out.println("✅ Location dropdown is displayed correctly on the Search Hotel page.");

		// Get the count of dropdown options
		int optionCount = searchHotelPage.getLocationDropdownOptionCount();
		System.out.println("Number of options in Location dropdown: " + optionCount);

		// Test selecting the 3rd location (index 2)
		searchHotelPage.selectLocationByIndex(2);
		String selectedLocation = searchHotelPage.getSelectedLocation();
		System.out.println("Selected location: " + selectedLocation);

		// Verify if the selected location is the expected one (3rd option from the
		// list)
		Assert.assertNotEquals(selectedLocation, "- Select Location -", "❌ Default location is selected.");

		// Optionally, verify the exact location you expect to be selected
		// For example, if you expect the 3rd location to be "New York":
		// Assert.assertEquals(selectedLocation, "New York", "❌ The wrong location was
		// selected.");
	}

	@Test(priority = 6)
	public void verifyLocationDropdownPlaceholderValue() {
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		String selectedValue = searchHotelPage.getLocationDropdownSelectedValue();

		// Expected placeholder value as seen on the UI
		String expectedPlaceholder = "- Select Location -";

		System.out.println("Selected value in dropdown: " + selectedValue);

		Assert.assertEquals(selectedValue.trim(), expectedPlaceholder,
				"❌ Placeholder value for Location dropdown does not match.");

		System.out.println("✅ Placeholder value for Location dropdown verified successfully.");
	}

	@Test(priority = 7)
	public void verifyTotalNumberOfHotelsInDropdown() {
		// Initialize the SearchHotelPage object
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		// Get the total number of hotels in the dropdown
		int totalHotels = searchHotelPage.getTotalNumberOfHotels();
		System.out.println("Total Hotels in the dropdown: " + totalHotels);
		test.info("Total Hotels in the dropdown: " + totalHotels);

		// Assert the total number of hotels (you can replace this with the actual
		// number if you know it)
		int expectedHotels = 5; // Replace with the actual expected number
		try {
			Assert.assertEquals(totalHotels, expectedHotels, "❌ The total number of hotels is incorrect.");
			test.pass("The total number of hotels is as expected.");
			System.out.println();
		} catch (AssertionError e) {
			test.fail("The total number of hotels is incorrect: " + e.getMessage());
			throw e;

		}
	}

	@Test(priority = 8)
	public void verifyHotelDropdownOptions() {
		// Initialize the SearchHotelPage object
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		// Get the list of available hotel options in the dropdown
		List<String> dropdownOptions = searchHotelPage.getHotelDropdownOptions();

		// Print the available options
		System.out.println("Available Hotels in Dropdown:");
		for (String option : dropdownOptions) {
			System.out.println(option);
		}

		// Assert that the dropdown has options
		try {
			Assert.assertFalse(dropdownOptions.isEmpty(), "❌ No options available in the hotel dropdown.");
			test.pass("Hotel dropdown has available options.");
		} catch (AssertionError e) {
			test.fail("No options available in the hotel dropdown: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 9)
	public void verifyHotelDropdownOptionsDisplayAndSelectability() {
		// Initialize the SearchHotelPage object
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		// Verify that all dropdown options are displayed and selectable
		boolean allItemsSelectable = searchHotelPage.areAllHotelsDisplayedAndSelectable();
		try {
			Assert.assertTrue(allItemsSelectable, "❌ Not all hotel options are displayed or selectable.");
			test.pass("All hotel options are displayed and selectable.");
		} catch (AssertionError e) {
			test.fail("Not all hotel options are displayed or selectable: " + e.getMessage());
			throw e;
		}
	}

	/*
	 * @Test(priority = 10) public void verifySelectedHotelValue() { SearchHotelPage
	 * searchHotelPage = new SearchHotelPage(driver); test =
	 * extent.createTest("verifySelectedHotelValue");
	 * 
	 * // Locate the dropdown and click it WebElement hotelDropdown =
	 * driver.findElement(By.id("hotels")); Select select = new
	 * Select(hotelDropdown);
	 * 
	 * // Get the options and ensure at least 2 exist List<WebElement> options =
	 * select.getOptions(); if (options.size() < 2) { test.
	 * fail("❌ Not enough options in the hotel dropdown to select the second one.");
	 * Assert.fail("Not enough hotel options."); }
	 * 
	 * // Select the second option (index 1) String expectedHotel =
	 * options.get(1).getText(); select.selectByIndex(1);
	 * test.info("Selected hotel from dropdown: " + expectedHotel);
	 * 
	 * // Fetch the selected option String selectedHotel = new
	 * Select(driver.findElement(By.id("hotels"))).getFirstSelectedOption().getText(
	 * ); System.out.println("Selected hotel after selection: " + selectedHotel);
	 * 
	 * // Assert try { Assert.assertEquals(selectedHotel, expectedHotel,
	 * "❌ Selected hotel value is incorrect.");
	 * test.pass("✅ Selected hotel value is correct: " + selectedHotel); } catch
	 * (AssertionError e) { test.fail("❌ Selected hotel value is incorrect: " +
	 * e.getMessage()); throw e; } }
	 * 
	 */

	@Test(priority = 10)
	public void verifySelectedHotelValue() {
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
		test = extent.createTest("verifySelectedHotelValue");

		Select select = new Select(searchHotelPage.hotelDropdown); // Use Page Object

		// Get all options in the dropdown
		List<WebElement> options = select.getOptions();

		// Ensure at least 2 options are available to select the second one
		if (options.size() < 2) {
			String message = "❌ Not enough options in the hotel dropdown to select the second one.";
			test.fail(message);
			Assert.fail(message);
		}

		// Select the second hotel
		String expectedHotel = options.get(1).getText();
		select.selectByIndex(1);
		test.info("Selected hotel from dropdown: " + expectedHotel);

		// Verify the selected hotel
		String selectedHotel = select.getFirstSelectedOption().getText();
		System.out.println("Selected hotel after selection: " + selectedHotel);

		try {
			Assert.assertEquals(selectedHotel, expectedHotel, "❌ Selected hotel value is incorrect.");
			test.pass("✅ Selected hotel value is correct: " + selectedHotel);
		} catch (AssertionError e) {
			test.fail("❌ Selected hotel value is incorrect: " + e.getMessage());
			throw e;

		}
	}

	@Test(priority = 11)
	public void verifyRoomTypeDropdownIsPresent() throws InterruptedException {
		test = extent.createTest("verifyRoomTypeDropdownIsPresent");
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver); // Assuming this is your page class
		WebElement roomTypeDropdown = searchHotelPage.roomTypeDropdown;

		try {

			Assert.assertTrue(roomTypeDropdown.isDisplayed(), "❌ Room Type dropdown is not displayed.");
			searchHotelPage.clickRoomTypeDropDownList();
			Thread.sleep(2000);
			test.pass("✅ Room Type dropdown is displayed.");
			System.out.println("✅ Room Type dropdown is displayed.");

		} catch (NoSuchElementException e) {
			test.fail("❌ Room Type dropdown element not found.");
			throw e;
		}
	}

	@Test(priority = 12)
	public void verifySelectedRoomTypeDropdown() {
		// Initialize the SearchHotelPage object
		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		// Start the test in Extent Reports
		test = extent.createTest("verifyRoomTypeDropdownInteractionWithActions");

		// Step 1: Wait for the Room Type dropdown to be displayed (handle dynamic
		// loading)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement roomTypeDropdownElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("room_type"))); // Corrected locator here

		// Step 2: Verify that the Room Type dropdown is displayed
		Assert.assertTrue(roomTypeDropdownElement.isDisplayed(), "❌ Room Type dropdown is not displayed");

		// Step 3: Use Actions to click on the Room Type dropdown to open it
		Actions actions = new Actions(driver);
		actions.moveToElement(roomTypeDropdownElement).click().perform();

		// Step 4: Wait for the "Deluxe Room" option to be visible and clickable
		// WebElement deluxeRoomOption =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'Deluxe')]")));
		Select select = new Select(driver.findElement(By.id("room_type")));
		select.selectByVisibleText("Deluxe");

		// Step 5: Select the "Deluxe Room" option
		// deluxeRoomOption.click();

		// Step 6: Verify the selected room type
		String selectedRoomType = searchHotelPage.getSelectedRoomType();
		try {
			Assert.assertEquals(selectedRoomType, "Deluxe", "❌ The selected room type is incorrect");
			test.pass("✅ The selected room type is correct: " + selectedRoomType);
			System.out.println("✅ The selected room type is correct: " + selectedRoomType);
		} catch (AssertionError e) {
			test.fail("❌ The selected room type is incorrect: " + e.getMessage());
			throw e; // Re-throw the assertion to mark the test as failed
		}

		// Print the result to console and report
		System.out.println("✅ Room Type dropdown interaction passed.");
		test.pass("✅ Room Type dropdown interaction passed.");
	}

	@Test(priority = 13)
	public void selectRoomTypeAndVerify() {
		test = extent.createTest("selectRoomTypeAndVerify");

		Select select = new Select(driver.findElement(By.id("room_type")));
		select.selectByVisibleText("Super Deluxe");

		String selected = select.getFirstSelectedOption().getText();

		try {
			Assert.assertEquals(selected, "Deluxe", "❌ Failed to select 'Deluxe' room type.");
			test.pass("✅ 'Deluxe' room type selected successfully.");
			System.out.println("✅ The selected room type is: " + selected); // Printing the selected value

		} catch (AssertionError e) {
			test.fail("❌ Room Type selection failed: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 14)
	public void verifyAllRoomTypesListed() {
		// Start the test in Extent Reports
		test = extent.createTest("verifyAllRoomTypesListed");

		// Expected room types to be listed in the dropdown
		List<String> expectedRoomTypes = Arrays.asList("- Select Room Type -", "Standard", "Double", "Deluxe",
				"Super Deluxe");

		// Get all available room types from the dropdown using the method in
		// SearchHotelPage
		List<String> actualRoomTypes = searchHotelPage.getRoomTypesFromDropdown();

		// Verify that the room types match the expected list
		try {
			Assert.assertTrue(actualRoomTypes.containsAll(expectedRoomTypes),
					"❌ Some expected room types are missing.");
			test.pass("✅ All expected room types are listed correctly.");

			// Optionally print the actual room types for debugging
			System.out.println("✅ Room types listed in dropdown: " + actualRoomTypes);
		} catch (AssertionError e) {
			test.fail("❌ Room types mismatch: " + e.getMessage());
			throw e;
		}
	}

	@Test(priority = 15)
	public void verifyCheckInDateDisplayedClickedAndHeld() {
		test = extent.createTest("verifyCheckInDateDisplayedClickedAndHeld");

		SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

		try {
			// Verify if the Check-in Date field is displayed
			Assert.assertTrue(searchHotelPage.isCheckInDateDisplayed(), "❌ Check-in Date field is not displayed.");
			test.pass("✅ Check-in Date field is displayed.");
			System.out.println("✅ Check-in Date field is displayed.");

			// Get the Check-in Date field WebElement using the getter method
			WebElement checkInDateField = searchHotelPage.getCheckInDateField();

			// Create an Actions object to simulate the click and hold
			Actions actions = new Actions(driver);

			// Click and hold on the Check-in Date field for 1 second
			actions.clickAndHold(checkInDateField).perform();
			System.out.println("✅ Clicked and holding the Check-in Date field.");

			// Wait for 1 second while holding the click
			Thread.sleep(4000); // Wait for 1 second (1000 milliseconds)

			// Release the click after 1 second
			actions.release().perform();
			System.out.println("✅ Released the Check-in Date field after holding it for 1 second.");

			// Continue with any further actions...

		} catch (NoSuchElementException e) {
			test.fail("❌ Check-in Date field not found.");
			throw e;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 16)
	public void selectValidCheckInDate() {
		// Valid date (future date)
		String validDate = "2025-05-07";

		// Enter the date and verify that no error is shown
		searchHotelPage.enterCheckInDate(validDate);

		// Assuming the success confirmation or proceeding to the next page happens here
		// You could check if the date was accepted, e.g., checking if the confirmation
		// contains the correct date
		Assert.assertFalse(searchHotelPage.getErrorMessage().contains("Invalid date"),
				"❌ Check-in date should be valid.");
		System.out.println("✅ Valid check-in date selected: " + validDate);
	}
	
	
	/*@Test(priority = 18)
	public void VerifyTOselectPastCheckInDate() throws Exception {
	    test = extent.createTest("Verify Error for Past Check-In Date");

	    SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

	    try {
	        // Fill all mandatory fields
	        searchHotelPage.selectLocation("Sydney");
	        searchHotelPage.selectHotel("Hotel Sunshine");
	        searchHotelPage.selectRoomType("Deluxe");
	        searchHotelPage.selectNumberOfRooms("1 - One");
	        searchHotelPage.enterCheckInDate("2020-05-07"); // Past date
	        searchHotelPage.enterCheckOutDate("2025-05-10"); // Future date
	        searchHotelPage.selectAdultsPerRoom("2 - Two");
	        searchHotelPage.selectChildrenPerRoom("1 - One");

	        test.info("Filled all mandatory fields with valid data and invalid check-in date.");
	        System.out.println("✅ Filled all mandatory fields with valid data and invalid check-in date.");

	        // Capture current URL before clicking search
	        String currentUrlBefore = driver.getCurrentUrl();

	        // Submit the form
	        searchHotelPage.clickSearchButton();

	        // Wait briefly for validation to trigger
	        Thread.sleep(2000);

	        // Check if redirected
	        String currentUrlAfter = driver.getCurrentUrl();

	        if (!currentUrlAfter.equals(currentUrlBefore)) {
	            System.out.println("❌ Redirection occurred even with invalid check-in date.");
	            System.out.println("Expected URL: " + currentUrlBefore);
	            System.out.println("Actual URL: " + currentUrlAfter);
	            test.fail("❌ Test Failed: Redirection occurred even with invalid check-in date.");
	        } else {
	            System.out.println("✅ User stayed on the same page (no redirection).");
	            test.pass("✅ User was not redirected with invalid check-in date.");
	        }

	        // Check for error message visibility
	        String errorMessage = searchHotelPage.getCheckInDateErrorMessage();

	        if (errorMessage.contains("Invalid check-in date")) {
	            System.out.println("✅ Error message displayed for past check-in date: " + errorMessage);
	            test.pass("✅ Correct error message displayed: " + errorMessage);
	        } else {
	            System.out.println("❌ Expected error message not displayed.");
	            test.fail("❌ Expected error message not displayed.");
	        }

	    } catch (AssertionError e) {
	        test.fail("❌ Validation failed: " + e.getMessage());
	        System.out.println("❌ Validation failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Test failed with exception: " + e.getMessage());
	        System.out.println("❌ Test failed with exception: " + e.getMessage());
	        throw e;
	    }
	}
*/
	
	@Test(priority = 18)
	public void VerifyTOselectPastCheckInDate() throws Exception {
	    test = extent.createTest("Verify Error for Past Check-In Date");

	    SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

	    try {
	        // Fill all mandatory fields
	        searchHotelPage.selectLocation("Sydney");
	        searchHotelPage.selectHotel("Hotel Sunshine");
	        searchHotelPage.selectRoomType("Deluxe");
	        searchHotelPage.selectNumberOfRooms("1 - One");
	        searchHotelPage.enterCheckInDate("2020-05-07"); // Past date
	        searchHotelPage.enterCheckOutDate("2025-05-10"); // Future date
	        searchHotelPage.selectAdultsPerRoom("2 - Two");
	        searchHotelPage.selectChildrenPerRoom("1 - One");

	        test.info("Filled all mandatory fields with valid data and invalid check-in date.");
	        System.out.println("✅ Filled all mandatory fields with valid data and invalid check-in date.");

	        // Capture current URL before clicking search
	        String currentUrlBefore = driver.getCurrentUrl();

	        // Submit the form
	        searchHotelPage.clickSearchButton();

	        // Wait briefly for validation to trigger
	        Thread.sleep(2000);

	        // Check if redirected
	        String currentUrlAfter = driver.getCurrentUrl();

	        if (!currentUrlAfter.equals(currentUrlBefore)) {
	            System.out.println("❌ Redirection occurred even with invalid check-in date.");
	            System.out.println("Expected URL: " + currentUrlBefore);
	            System.out.println("Actual URL: " + currentUrlAfter);
	            test.fail("❌ Test Failed: Redirection occurred even with invalid check-in date.");
	            Assert.fail("Test failed: User was redirected even with an invalid check-in date.");
	        } else {
	            System.out.println("✅ User stayed on the same page (no redirection).");
	            test.pass("✅ User was not redirected with invalid check-in date.");
	        }

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement errorMessageElement = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("checkin_span"))
			);
			String errorMessage = errorMessageElement.getText();

			if (errorMessage.contains("Invalid check-in date")) {
			    System.out.println("✅ Error message displayed: " + errorMessage);
			    test.pass("✅ Correct error message displayed: " + errorMessage);
			} else {
			    System.out.println("❌ Unexpected error message: " + errorMessage);
			    test.fail("❌ Unexpected error message: " + errorMessage);
			    Assert.fail("Incorrect error message content.");
			}

	    } catch (AssertionError e) {
	        test.fail("❌ Validation failed: " + e.getMessage());
	        System.out.println("❌ Validation failed: " + e.getMessage());
	        throw e;
	    } catch (Exception e) {
	        test.fail("❌ Test failed with exception: " + e.getMessage());
	        System.out.println("❌ Test failed with exception: " + e.getMessage());
	        throw e;
	    }
	}
	@Test(priority = 19)
	public void VerifyToSelectValidCheckInDate() throws Exception {
	    test = extent.createTest("Verify Valid Check-In and Check-Out Dates");

	    SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

	    try {
	        // Fill mandatory fields with valid future dates
	        searchHotelPage.selectLocation("Sydney");
	        searchHotelPage.selectHotel("Hotel Sunshine");
	        searchHotelPage.selectRoomType("Deluxe");
	        searchHotelPage.selectNumberOfRooms("1 - One");
	        searchHotelPage.enterCheckInDate("2025-05-10"); // Valid future date
	        searchHotelPage.enterCheckOutDate("2025-05-12"); // After check-in
	        searchHotelPage.selectAdultsPerRoom("2 - Two");
	        searchHotelPage.selectChildrenPerRoom("1 - One");

	        test.info("Filled all mandatory fields with valid dates.");
	        System.out.println("✅ Filled all mandatory fields with valid check-in and check-out dates.");

	        // Capture current URL before clicking search
	        String currentUrlBefore = driver.getCurrentUrl();

	        // Submit the form
	        searchHotelPage.clickSearchButton();

	        // Wait for redirection
	        Thread.sleep(2000);
	        String currentUrlAfter = driver.getCurrentUrl();

	        if (!currentUrlAfter.equals(currentUrlBefore) && currentUrlAfter.contains("SelectHotel")) {
	            System.out.println("✅ User redirected to next page with valid dates.");
	            test.pass("✅ Successfully redirected to SelectHotel page.");
	        } else {
	            System.out.println("❌ User was not redirected even with valid dates.");
	            test.fail("❌ Redirection failed with valid check-in date.");
	            Assert.fail("No redirection occurred with valid check-in date.");
	        }

	    } catch (Exception e) {
	        test.fail("❌ Test failed due to exception: " + e.getMessage());
	        System.out.println("❌ Test failed with exception: " + e.getMessage());
	        throw e;
	    }
	}
	@Test(priority = 20)
	public void verifyCheckOutDateDisplayedClickedAndHeld() {
	    test = extent.createTest("Verify Check-Out Date Field is Displayed, Clicked and Held");

	    SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

	    try {
	        // Check if check-out field is visible
	        if (!searchHotelPage.isCheckOutDateDisplayed()) {
	            test.fail("❌ Check-out Date field is not displayed.");
	            Assert.fail("❌ Check-out Date field is not displayed.");
	        }

	        test.pass("✅ Check-out Date field is displayed.");
	        System.out.println("✅ Check-out Date field is displayed.");

	        // Perform click-and-hold
	        WebElement checkOutDateField = searchHotelPage.getCheckOutDateField();
	        Actions actions = new Actions(driver);

	        actions.clickAndHold(checkOutDateField).perform();
	        System.out.println("✅ Clicked and holding the Check-out Date field.");

	        // Hold the click for 1 second
	        Thread.sleep(1000);

	        // Release the click
	        actions.release().perform();
	        System.out.println("✅ Released the Check-out Date field after holding it for 1 second.");

	        test.pass("✅ Successfully clicked and held the Check-out Date field.");

	    } catch (NoSuchElementException e) {
	        test.fail("❌ Check-out Date field not found.");
	        System.out.println("❌ Check-out Date field not found.");
	        throw e;
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	@Test(priority = 21)
	public void verifyErrorForPastCheckOutDate() throws Exception {
	    test = extent.createTest("Verify Error for Past Check-Out Date");

	    SearchHotelPage searchHotelPage = new SearchHotelPage(driver);

	    try {
	        // Fill all mandatory fields with invalid check-out date
	        searchHotelPage.selectLocation("Sydney");
	        searchHotelPage.selectHotel("Hotel Sunshine");
	        searchHotelPage.selectRoomType("Deluxe");
	        searchHotelPage.selectNumberOfRooms("1 - One");
	        searchHotelPage.enterCheckInDate("2025-05-10");
	        searchHotelPage.enterCheckOutDate("2025-05-05"); // Past relative to check-in
	        searchHotelPage.selectAdultsPerRoom("2 - Two");
	        searchHotelPage.selectChildrenPerRoom("1 - One");

	        test.info("Entered valid check-in and invalid (past) check-out date.");

	        // Capture current URL before clicking search
	        String currentUrlBefore = driver.getCurrentUrl();
	        searchHotelPage.clickSearchButton();
	        Thread.sleep(2000); // Give time for validation

	        // Capture URL after clicking
	        String currentUrlAfter = driver.getCurrentUrl();
	        if (!currentUrlAfter.equals(currentUrlBefore)) {
	            System.out.println("❌ Redirected even with invalid check-out date.");
	            test.fail("❌ Redirected even with invalid check-out date.");
	        } else {
	            System.out.println("✅ User not redirected with invalid check-out date.");
	            test.pass("✅ User not redirected with invalid check-out date.");
	        }

	        // Wait and verify error message
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement errorMessageElement = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(By.id("checkout_span"))
			);

			String errorMessageText = errorMessageElement.getText();
			System.out.println("✅ Error message found: " + errorMessageText);

			if (errorMessageText.contains("Invalid check-out date")) {
			    test.pass("✅ Correct error message displayed: " + errorMessageText);
			} else {
			    test.fail("❌ Error message displayed but text is incorrect: " + errorMessageText);
			}

	    } catch (Exception e) {
	        test.fail("❌ Test failed due to exception: " + e.getMessage());
	        throw e;
	    }
	}

}