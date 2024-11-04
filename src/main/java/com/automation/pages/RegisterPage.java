package com.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class RegisterPage extends BasePage {

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement nameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "#id_gender1")
    private WebElement titleMrRadio;

    @FindBy(css = "#password")
    private WebElement passwordInput;

    @FindBy(css = "#days")
    private WebElement daysDropdown;

    @FindBy(css = "#months")
    private WebElement monthsDropdown;

    @FindBy(css = "#years")
    private WebElement yearsDropdown;

    @FindBy(css = "#newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(css = "#optin")
    private WebElement specialOffersCheckbox;

    @FindBy(css = "#first_name")
    private WebElement firstNameInput;

    @FindBy(css = "#last_name")
    private WebElement lastNameInput;

    @FindBy(css = "#company")
    private WebElement companyInput;

    @FindBy(css = "#address1")
    private WebElement address1Input;

    @FindBy(css = "#address2")
    private WebElement address2Input;

    @FindBy(css = "#country")
    private WebElement countryDropdown;

    @FindBy(css = "#state")
    private WebElement stateInput;

    @FindBy(css = "#city")
    private WebElement cityInput;

    @FindBy(css = "#zipcode")
    private WebElement zipcodeInput;

    @FindBy(css = "#mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(css = "a[href='/delete_account']")
    private WebElement deleteAccountButton;

    @FindBy(css = ".btn-primary")
    private WebElement continueButton;

    @FindBy(xpath = "//b[text()='Account Created!']")
    private WebElement accountCreatedMessage;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    private WebElement enterAccountInfoMessage;

    public void clickSignupLoginButton() {
        click(signupLoginButton);
    }

    public void enterName(String name) {
        sendKeys(nameInput, name);
    }

    public void enterEmail(String email) {
        sendKeys(emailInput, email);
    }

    public void clickSignupButton() {
        click(signupButton);
    }

    public void selectTitle(String title) {
        if (title.equalsIgnoreCase("Mr")) {
            click(titleMrRadio);
        }
    }

    public void enterPassword(String password) {
        sendKeys(passwordInput, password);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        new Select(daysDropdown).selectByVisibleText(day);
        new Select(monthsDropdown).selectByVisibleText(month);
        new Select(yearsDropdown).selectByVisibleText(year);
    }

    public void selectNewsletter() {
        if (!newsletterCheckbox.isSelected()) {
            click(newsletterCheckbox);
        }
    }

    public void selectSpecialOffers() {
        if (!specialOffersCheckbox.isSelected()) {
            click(specialOffersCheckbox);
        }
    }

    public void fillAddressDetails(String firstName, String lastName, String company,
                                   String address1, String address2, String country,
                                   String state, String city, String zipcode,
                                   String mobileNumber) {
        sendKeys(firstNameInput, firstName);
        sendKeys(lastNameInput, lastName);
        sendKeys(companyInput, company);
        sendKeys(address1Input, address1);
        sendKeys(address2Input, address2);
        new Select(countryDropdown).selectByVisibleText(country);
        sendKeys(stateInput, state);
        sendKeys(cityInput, city);
        sendKeys(zipcodeInput, zipcode);
        sendKeys(mobileNumberInput, mobileNumber);
    }

    public void clickCreateAccountButton() {
        click(createAccountButton);
    }

    public void clickDeleteAccountButton() {
        click(deleteAccountButton);
    }

    public void clickContinueButton() {
        click(continueButton);
    }

    public String getAccountCreatedMessage() {
        return getText(accountCreatedMessage);
    }

    public String getEnterAccountInfoMessage() {
        return getText(enterAccountInfoMessage);
    }

    public boolean isAccountCreatedMessageDisplayed() {
        return isDisplayed(accountCreatedMessage);
    }
}