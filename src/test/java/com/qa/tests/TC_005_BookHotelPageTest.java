package com.qa.tests;

import java.time.Duration;

import org.openqa.selenium.By;
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

public class TC_005_BookHotelPageTest extends ProjectSpecificationMethods {

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
	public void setup() {
		sheetname = "BookHotel"; // This is the sheet name you are reading from the Excel file
		testname = "Login Test";
		testdescription = "Testing the Login functionality with valid and invalid data";
		testauthor = "Amrutha";
		testcategory = "Regression";
	}

	@Test(dataProvider = "readData")
	public void verifySuccessfulBookingWithValidData( String firstName, String lastName,String address,String creditCardNo,String cardType,String Month,String Year,String cvv) throws Exception {
		test = extent.createTest("Verify Successful Hotel Booking with Valid Data");
driver.get("https://adactinhotelapp.com/SelectHotel.php");
		try {

			SelectHotelPage selectHotelPage = new SelectHotelPage(driver);

			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement radioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("radiobutton_1")));
			radioBtn.click();

			// Use direct interaction with WebElements
			//selectHotelPage.selectHotelRadioButton_0.click(); // Selecting the first hotel
			//selectHotelPage.clickContinue().click(); // Clicking Continue button
			selectHotelPage.clickContinue();

			BookHotelPage bookHotelPage = new BookHotelPage(driver);
			Thread.sleep(4000);

			bookHotelPage.enterFirstName(firstName);
			bookHotelPage.enterLastName(lastName);
			bookHotelPage.enterBillingAddress(address);
			bookHotelPage.enterCreditCardNumber(creditCardNo);
			bookHotelPage.selectCreditCardType(cardType);
			//bookHotelPage.enterExpiryDate(expiryDate);
			bookHotelPage.selectMonth(Month);
			bookHotelPage.selectYear(Year);
			bookHotelPage.enterCVV(cvv);

			
			
			// Step 3: Submit the form
			bookHotelPage.clickBookNowButton();
			Thread.sleep(6000);

			// Step 4: Wait and verify booking confirmation
			// ConfirmationPage confirmationPage = new ConfirmationPage(driver);
			// boolean isConfirmed = confirmationPage.isBookingConfirmed();
			String expectedUrl = "https://adactinhotelapp.com/BookingConfirm.php";
			String actualUrl = driver.getCurrentUrl();
			Assert.assertEquals(actualUrl, expectedUrl, "❌ Booking was not successful.");
			test.pass("✅ Booking completed successfully and confirmation displayed.");

		} catch (Exception e) {
			test.fail("❌ Exception occurred: " + e.getMessage());
			System.out.println("❌ Test failed: " + e.getMessage());
			throw e;
		}
	}

}