package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.ProjectSpecificationMethods;

public class BookHotelPage extends ProjectSpecificationMethods{

	
	   WebDriver driver;
	   
	   @FindBy(id="book_hotel_form")
	    WebElement bookHotelForm;
	   
	   
	   @FindBy(xpath="//a[normalize-space()='Back']")
	    WebElement backButton;
	   
	    @FindBy(id = "first_name")
	    WebElement firstNameField;

	    @FindBy(id = "last_name")
	    WebElement lastNameField;

	    @FindBy(id = "address")
	    WebElement billingAddressField;

	    @FindBy(id = "cc_num")
	    WebElement creditCardNumberField;

	    @FindBy(id = "cc_type")
	    WebElement creditCardTypeDropdown;

	    @FindBy(id = "cc_exp_month")
	    WebElement expiryMonthDropdown;

	    @FindBy(id = "cc_exp_year")
	    WebElement expiryYearDropdown;

	    @FindBy(id = "cc_cvv")
	    WebElement cvvField;

	    @FindBy(id = "book_now")
	    WebElement bookNowButton;

	    @FindBy(id = "error_message")
	    WebElement errorMessage;
	   
	    @FindBy(id = "continue")
	    WebElement continueSubmitButton;
	    @FindBy(xpath="//*[@id=\"cc_exp_month\"]")
	    WebElement month;
	    
	    @FindBy(xpath="//*[@id=\"cc_exp_year\"]")
	    WebElement year;
	    
	    // Constructor to initialize elements
	    public BookHotelPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);  // Important: Initializes @FindBy elements
	   	    
	    }
	  
		public boolean isBookFormVisible() {
			return bookHotelForm.isDisplayed();
		}
		
public void backToSearchPage() {
	backButton.click();
}
public boolean isBookHotemFormVisible() {
	return bookHotelForm.isDisplayed();
}


public void enterFirstName(String firstName) {
    firstNameField.sendKeys(firstName);
}

public void enterLastName(String lastName) {
    lastNameField.sendKeys(lastName);
}

public void enterBillingAddress(String address) {
    billingAddressField.sendKeys(address);
}

public void enterCreditCardNumber(String creditCardNumber) {
    creditCardNumberField.sendKeys(creditCardNumber);
}

public void selectCreditCardType(String creditCardType) {
    creditCardTypeDropdown.sendKeys(creditCardType);
}

public void enterExpiryDate(String expiryDate) {
    String[] date = expiryDate.split("/");
    expiryMonthDropdown.sendKeys(date[0]); // Month
    expiryYearDropdown.sendKeys(date[1]); // Year
}

public void enterCVV(String cvv) {
    cvvField.sendKeys(cvv);
}

public void clickBookNowButton() {
    bookNowButton.click();
}
public void selectMonth(String value) {
    Select select = new Select(month);
    select.selectByVisibleText(value); // e.g., "January"
}

public void selectYear(String value) {
    Select select = new Select(year);
    select.selectByVisibleText(value); // e.g., "2025"
}

// Method to get the error message
public String getErrorMessage() {
    return errorMessage.getText();
}

@FindBy(xpath = "//input[@id='radiobutton_0']")
public WebElement selectHotelRadioButton_0;

@FindBy(id = "continue")
private WebElement continueButton;

public WebElement clickContinueButton() {
    return continueButton;
}

}

