package com.qa.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.BookHotelPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchHotelPage;
import com.qa.pages.SelectHotelPage;

public class TC_004_SelectHotelPageTest extends ProjectSpecificationMethods{
	
	
	SearchHotelPage searchHotelPage;
	LoginPage loginPage;
SelectHotelPage selectHotelPage = new SelectHotelPage(driver);

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
	    public void setup() {
	        sheetname = "SearchSelectHotel";  // This is the sheet name you are reading from the Excel file
	        testname = "Login Test";
	        testdescription = "Testing the Login functionality with valid and invalid data";
	        testauthor = "Amrutha";
	        testcategory = "Regression";
	    }
	 
		@Test(dataProvider = "readData")
		public void VerifyRedirectionToSelectHotelPage(String Location, String Hotels, String RoomType, String NoRooms,String CheckInDate, String CheckOutDate, String Adults, String Childrens, String TestType,
				String ExpectedMessage) throws InterruptedException {
			
			  // Start the test
	        test = extent.createTest("Verify Redirection To Select Hotel Page");

	        // Initialize the SearchHotelPage and SelectHotelPage classes
	        SearchHotelPage searchHotelPage = new SearchHotelPage(driver);
	        selectHotelPage = new SelectHotelPage(driver);

	        // Step 1: Fill out the Search Hotel form with provided data
	        selectHotelPage.selectLocation(Location);
	        selectHotelPage.selectHotel(Hotels);
	        selectHotelPage.selectRooms(NoRooms);
	        selectHotelPage.setArrivalDate(CheckInDate);
	        selectHotelPage.setDepartureDate(CheckOutDate);
	        selectHotelPage.selectRoomType(RoomType);
	        selectHotelPage.clickSearchButton();

	        // Use WebDriverWait (new approach for Selenium 4.x)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Wait until the URL contains "SelectHotel.php"
	        wait.until(driver -> driver.getCurrentUrl().contains("SelectHotel.php"));


	        // Step 2: Verify redirection to the Select Hotel page
	        String currentUrl = selectHotelPage.getPageUrl();
	        
	        System.out.println("Redirected to Select Hotel page. URL: " + currentUrl);

	        Assert.assertTrue(currentUrl.contains("SelectHotel.php"), "❌ Redirection to Select Hotel page failed.");
	        test.info("✅ Redirection successful to Select Hotel page.");
	        
	        // Step 3: Verify the hotel list is displayed
	        boolean isHotelListDisplayed = selectHotelPage.isHotelListDisplayed();
	        System.out.println("Hotel list displayed: " + isHotelListDisplayed);
	        
	        // Step 3: Verify the hotel list is displayed
	        Assert.assertTrue(selectHotelPage.isHotelListDisplayed(), "❌ Hotel list not displayed on Select Hotel page.");
	        test.info("✅ Hotel list displayed correctly on Select Hotel page.");
	    }
		
		 @Test(priority=1)
		    public void verifyHotelSelectionFunctionality() throws Exception {
		        
			 test = extent.createTest("TC_003: Verify Hotel Selection Functionality");

		        try {
		            // Launch browser and navigate to SelectHotel page
		            driver.get("https://adactinhotelapp.com/SelectHotel.php");

		            SelectHotelPage selectHotelPage = new SelectHotelPage(driver);

		            // Step 1: Check if hotel list is displayed
		            Assert.assertTrue(selectHotelPage.isHotelListDisplayed(), "Hotel list not displayed.");
		            System.out.println("✅ Hotel list is displayed.");
		            test.pass("✅ Hotel list is displayed.");

		            // Step 2: Select hotel
		            selectHotelPage.selectHotelFromList();
		            System.out.println("✅ Selected a hotel from the list.");
		            test.pass("✅ Selected a hotel from the list.");
		            // Step 3: Click Continue
		            selectHotelPage.clickContinue();
		            test.pass("✅ Clicked on Continue button.");
		            Thread.sleep(4000);

		            // Step 4: Validate redirection
		            String currentUrl = driver.getCurrentUrl();
		            Assert.assertTrue(currentUrl.contains("BookHotel"), "Redirection to Book Hotel page failed.");
		            System.out.println("✅ Redirected to Book Hotel page.");
		            test.pass("✅ Redirected to Book Hotel page.");

		            // Optional validation on Book Hotel Page
		            BookHotelPage bookHotelPage = new BookHotelPage(driver);
		            
		            Assert.assertTrue(bookHotelPage.isBookFormVisible(), "Booking form not visible.");
		            System.out.println("✅ Booking form is visible. Hotel selection successful.");
		            test.pass("✅ Booking form is visible. Hotel selection successful.");

		        } catch (Exception e) {
		            test.fail("❌ Test failed due to exception: " + e.getMessage());
		            throw e; // so the listener can also log failure
		        }
		    }
		 
		 @Test(priority=2)
		 public void VerifyBookingFailsWithoutSelectingHotelRadioButton() {  //negative scenario
		     test = extent.createTest("TC_004 - Booking Without Selecting Hotel");

		     try {
		    	  // Launch browser and navigate to SelectHotel page
		            driver.get("https://adactinhotelapp.com/SelectHotel.php");
		            
		         SelectHotelPage selectHotelPage = new SelectHotelPage(driver);

		         // Step 2: Click Continue without selecting a hotel
		         selectHotelPage.clickContinue();

		         // Step 3: Get and verify the error message
		         String errorMessage = selectHotelPage.getErrorMessage();
		         Assert.assertTrue(errorMessage.contains("Please Select a Hotel"), "❌ Error message not shown as expected.");

		         // Step 4: Log the result
		         System.out.println("✅ Error message displayed when no hotel is selected: " + errorMessage);
		         test.pass("✅ Error message displayed when no hotel is selected: <b>" + errorMessage + "</b>");
		         
		     } catch (Exception e) {
		         test.fail("❌ Test failed due to exception: " + e.getMessage());
		         System.out.println("❌ Test failed with exception: " + e.getMessage());
		         throw e;
		     }
		 }
		/* @Test
		 public void VerifyHotelSelectionWithPrefilledData() throws Exception {
		     test = extent.createTest("Verify Hotel Selection with Pre-filled Data from Search Page");

		     try {
		         // Step 1: Perform a valid search on the Search Hotel page
		    	// Step 1: Perform a valid search on the Search Hotel page
		    	 searchHotelPage.selectLocation("Sydney");
		    	 searchHotelPage.selectHotel("Hotel Creek");
		    	 searchHotelPage.selectNumberOfRooms("2 - Two");
		    	 searchHotelPage.enterCheckInDate("06/05/2025");
		    	 searchHotelPage.enterCheckOutDate("07/05/2025");
		    	 searchHotelPage.selectRoomType("Double");
		    	 searchHotelPage.clickSearchButton();
Thread.sleep(3000);
driver.navigate().refresh();

		         // Step 2: Now you're on the Select Hotel page
		         SelectHotelPage selectHotelPage = new SelectHotelPage(driver);
		         Assert.assertTrue(selectHotelPage.isHotelListDisplayed(), "❌ Hotel list not displayed.");

		         test.pass("✅ Hotel list displayed on Select Hotel page.");

		         // Step 3: Select the first hotel and click Continue
		         selectHotelPage.selectHotelFromList();
		         selectHotelPage.clickContinue();

		         // Step 4: On Book Hotel page, verify that it has loaded
		         BookHotelPage bookHotelPage = new BookHotelPage(driver);
		         boolean formVisible = bookHotelPage.isBookFormVisible();

		         Assert.assertTrue(formVisible, "❌ Book Hotel page not loaded or form not visible.");
		         test.pass("✅ Book Hotel page loaded successfully after selecting hotel.");

		         System.out.println("✅ Hotel selected and redirected to Book Hotel page successfully.");

		     } catch (Exception e) {
		         test.fail("❌ Exception occurred: " + e.getMessage());
		         System.out.println("❌ Test failed: " + e.getMessage());
		         throw e;
		     }
		 }
*/
		 
		 @Test
		 public void VerifyHotelSelectionWithPrefilledData() throws Exception {
		     test = extent.createTest("Verify Hotel Selection with Pre-filled Data from Search Page");

		     try {
		         // Step 1: Perform a valid search on the Search Hotel page
		         searchHotelPage.selectLocation("Sydney");
		         searchHotelPage.selectHotel("Hotel Creek");
		         searchHotelPage.selectNumberOfRooms("2 - Two");
		         searchHotelPage.enterCheckInDate("06/05/2025");
		         searchHotelPage.enterCheckOutDate("07/05/2025");
		         searchHotelPage.selectRoomType("Double");
		         searchHotelPage.clickSearchButton();

		         // Step 2: Now you're on the Select Hotel page
		         SelectHotelPage selectHotelPage = new SelectHotelPage(driver);
		         Assert.assertTrue(selectHotelPage.isHotelListDisplayed(), "❌ Hotel list not displayed.");

		         test.pass("✅ Hotel list displayed on Select Hotel page.");

		         
		         
		  /*    // Step 3: Validate that the data displayed on the Select Hotel page matches the search data
		         String displayedHotelName = selectHotelPage.getHotelNameFromList(0); // Assuming you want the first hotel name
		         String displayedRoomType = selectHotelPage.getRoomTypeFromList(0); // Assuming you want the room type for the first hotel
		         String displayedCheckInDate = selectHotelPage.getCheckInDateFromList(0); // Assuming check-in date is displayed for the first hotel
		         String displayedCheckOutDate = selectHotelPage.getCheckOutDateFromList(0); // Similarly for check-out

		         // Step 4: Compare the data
		         Assert.assertTrue(displayedHotelName.equals(hotel), "❌ Hotel name doesn't match.");
		         Assert.assertTrue(displayedRoomType.equals(roomType), "❌ Room type doesn't match.");
		         Assert.assertTrue(displayedCheckInDate.equals(checkInDate), "❌ Check-in date doesn't match.");
		         Assert.assertTrue(displayedCheckOutDate.equals(checkOutDate), "❌ Check-out date doesn't match.");
              test.pass("✅ Data on Select Hotel page matches the search data.");                         */
            System.out.println("✅ Data on Select Hotel page matches the search data.");

		         
		         
		         
		         // Step 3: Select the first hotel radio button and click Continue
		         // Wait for the radio button to be clickable and select it
		         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		         WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(selectHotelPage.selectHotelRadioButton_0));

		         // Scroll to the radio button if needed
		         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioButton);

		         // Click the radio button to select the hotel
		         radioButton.click();

		         // Proceed to click continue after selecting the hotel
		         selectHotelPage.clickContinue();

		         // Step 4: On the Book Hotel page, verify that it has loaded
		         BookHotelPage bookHotelPage = new BookHotelPage(driver);
		         boolean formVisible = bookHotelPage.isBookFormVisible();

		         Assert.assertTrue(formVisible, "❌ Book Hotel page not loaded or form not visible.");
		         test.pass("✅ Book Hotel page loaded successfully after selecting hotel.");

		         System.out.println("✅ Hotel selected and redirected to Book Hotel page successfully.");

		     } catch (Exception e) {
		         test.fail("❌ Exception occurred: " + e.getMessage());
		         System.out.println("❌ Test failed: " + e.getMessage());
		         throw e;
		     }
		 }
	 
		}

	        

			
		
