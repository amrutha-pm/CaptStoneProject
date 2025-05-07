package com.qa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.LoginPage;
import com.qa.pages.SearchHotelPage;

public class TC_007_BookedItenaryTest extends ProjectSpecificationMethods{
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
		testname = "BookItenary Test";
		testdescription = "Testing the Booking history and features functionality with valid and invalid data";
		testauthor = "Amrutha";
		testcategory = "Regression";
	}

}
