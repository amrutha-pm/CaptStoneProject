package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.LoginPage;
import com.qa.pages.SeachHotelHomePage;
import com.qa.pages.SearchHotelPage;

public class TC_001_SearchHotelHomePage extends ProjectSpecificationMethods{

	  @BeforeTest
	    public void setup() {
	        sheetname = "Login";  // This is the sheet name you are reading from the Excel file
	        testname = "Login Test";
	        testdescription = "Testing the Login functionality with valid and invalid data";
	        testauthor = "Amrutha";
	        testcategory = "Regression";
	    }
	  // Constructor to initialize the LoginPage
	    public  TC_001_SearchHotelHomePage() {
	    	System.out.println("TC_001:LoginPage testcases are executing ");
	    LoginPage    loginPage = new LoginPage(driver); // Pass the driver to LoginPage
	    loginPage.login("amruthapm", "Google123");
	    }  
	  
	    @Test
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
