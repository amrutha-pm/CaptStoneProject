package com.qa.tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.BookingConfirmationPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchHotelPage;

public class TC_006_BookingConfirmationTest extends ProjectSpecificationMethods{
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
		driver.get("https://adactinhotelapp.com/BookingConfirm.php");

	}

	@BeforeTest
	public void setup() {
		sheetname = "BookHotel"; // This is the sheet name you are reading from the Excel file
		testname = "confirmation page Test";
		testdescription = "Testing the booking confirmation page functionality with valid and invalid data";
		testauthor = "Amrutha";
		testcategory = "Regression";
	}
	@Test(priority=1)
public void verifyOrderIdgeneratedOrNot() {
	driver.get("https://adactinhotelapp.com/BookingConfirm.php");
	
	
		
}
	@Test(priority=2)
	public void verifyMyItineraryNavigation() {
	    test = extent.createTest("Verify My Itinerary redirects to Booked Itinerary page");
BookingConfirmationPage bookingConfirm = new BookingConfirmationPage(driver);

	    // Assuming you are already logged in and on the Booking Confirmation Page
	    try {
	        // Click on "My Itinerary" link
	     
	       bookingConfirm.clickMyItenaryButton();

	        // Wait for page to load
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.urlContains("BookedItinerary.php"));

	        // Assert the URL
	        String expectedUrlPart = "BookedItinerary.php";
	        String actualUrl = driver.getCurrentUrl();
	        Assert.assertTrue(actualUrl.contains(expectedUrlPart), "❌ My Itinerary did not navigate to the correct page.");

	        test.pass("✅ My Itinerary redirected successfully to Booked Itinerary page.");

	    } catch (Exception e) {
	        test.fail("❌ Exception occurred: " + e.getMessage());
	        throw e;
	    }
	}

}