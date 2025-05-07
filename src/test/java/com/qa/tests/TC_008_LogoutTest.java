package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.ProjectSpecificationMethods;
import com.qa.pages.LoginPage;
import com.qa.pages.LogoutPage;

public class TC_008_LogoutTest extends ProjectSpecificationMethods{
	 LoginPage loginPage;
	    LogoutPage logoutPage;

	    @BeforeMethod
	    public void setUp() {
	        loginPage = new LoginPage(driver);
	        driver.get("https://adactinhotelapp.com/"); // Adactin app base URL

	        // Login
	        loginPage.enterUsername("amruthapm");
	        loginPage.enterPassword("Google123");
	        loginPage.clickLoginButton();
	    }

	    @Test
	    public void verifyLogoutFunctionality() {
	        test = extent.createTest("Verify Logout Functionality");
LogoutPage logoutPage = new LogoutPage(driver);
	        try {
	            // Step 1: Click Logout
	            logoutPage.LogoutButton.click();
	            logoutPage = new LogoutPage(driver);

	            // Step 2: Verify success message
	            String successMessage = logoutPage.getSuccessMessage();
	            if (successMessage.contains("You have successfully logged out")) {
	                test.pass("✅ Logout message displayed: " + successMessage);
	                System.out.println("✅ Logout message displayed: " + successMessage);
	            } else {
	                test.fail("❌ Logout message not found!");
	                System.out.println("❌ Logout message not found!");
	                Assert.fail("Logout message not found!");
	            }

	            // Step 3: Verify "Login again" link
	            if (logoutPage.getLoginAgainLink().isDisplayed()) {
	                test.pass("✅ 'Login again' link is displayed.");
	                System.out.println("✅ 'Login again' link is displayed.");
	            } else {
	                test.fail("❌ 'Login again' link is not displayed.");
	                System.out.println("❌ 'Login again' link is not displayed.");
	                Assert.fail("'Login again' link is not displayed.");
	            }

	        } catch (Exception e) {
	            test.fail("❌ Exception occurred during logout test: " + e.getMessage());
	            System.out.println("❌ Exception: " + e.getMessage());
	            throw e;
	        }
	    }
	}