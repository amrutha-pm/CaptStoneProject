package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.LoginPage;
import com.qa.pages.SeachHotelHomePage;
import com.qa.pages.SearchHotelPage;

public class TC_002_SearchHotelHomePage extends ProjectSpecificationMethods{
	 LoginPage loginPage;

	 @BeforeMethod
	    public void setUp() {
	        loginPage = new LoginPage(driver);
	        driver.get("https://adactinhotelapp.com/"); // Adactin app base URL

	        // Login
	        loginPage.enterUsername("amruthapm");
	        loginPage.enterPassword("Google123");
	        loginPage.clickLoginButton();
	    }
	  @BeforeTest
	    public void setup() {
	        sheetname = "Login";  // This is the sheet name you are reading from the Excel file
	        testname = "homepage Test";
	        testdescription = "Testing the homepage functionality with valid and invalid data";
	        testauthor = "Amrutha";
	        testcategory = "Regression";
	    }

	    @Test(priority=1)
	    public void verifySearchHotelMenuDisplayedAfterLogin() {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.enterUsername("amruthapm");
	        loginPage.enterPassword("Google123");
	        loginPage.clickLoginButton();

	        SearchHotelPage searchPage = new SearchHotelPage(driver);
	        Assert.assertTrue(searchPage.isSearchHotelMenuVisible(), "Search Hotel menu is not visible.");
	        System.out.println("✅ Search Hotel menu is displayed after login.");
	    }


}
