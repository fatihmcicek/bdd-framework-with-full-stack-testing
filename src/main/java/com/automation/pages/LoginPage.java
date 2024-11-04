package com.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(css = "a[href='/login']")
    private WebElement loginLink;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement emailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement passwordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(css = ".login-form h2")
    private WebElement loginFormHeader;

    @FindBy(css = ".login-form p")
    private WebElement errorMessage;

    @FindBy(css = "a:contains('Logged in as')")
    private WebElement loggedInText;

    public void clickLoginLink() {
        log.info("Clicking on Login link");
        click(loginLink);
    }

    public void enterEmail(String email) {
        log.info("Entering email: {}", email);
        sendKeys(emailInput, email);
    }

    public void enterPassword(String password) {
        log.info("Entering password");
        sendKeys(passwordInput, password);
    }

    public void clickLoginButton() {
        log.info("Clicking on Login button");
        click(loginButton);
    }

    public boolean isUserLoggedIn() {
        log.info("Checking if user is logged in");
        return isDisplayed(logoutButton);
    }

    public String getErrorMessage() {
        log.info("Getting error message");
        return getText(errorMessage);
    }

    public boolean isLoggedInMessageDisplayed() {
        log.info("Checking if 'Logged in as' message is displayed");
        return isDisplayed(loggedInText);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}