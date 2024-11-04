package com.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class LoginPage extends BasePage {

    @FindBy(css = "a[href='/login']")
    private WebElement loginLink;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(css = ".login-form h2")
    private WebElement loginFormHeader;

    @FindBy(css = ".login-form p")
    private WebElement errorMessage;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAsText;

    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]/b")
    private WebElement loggedInUsername;

    public void clickLoginLink() {
        click(loginLink);
    }

    public void enterLoginEmail(String email) {
        sendKeys(loginEmailInput, email);
    }

    public void enterLoginPassword(String password) {
        sendKeys(loginPasswordInput, password);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void clickLogoutButton() {
        click(logoutButton);
    }

    public String getLoginFormHeader() {
        return getText(loginFormHeader);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }

    public boolean isLoggedInMessageDisplayed() {
        return isDisplayed(loggedInAsText);
    }

    public String getLoggedInUsername() {
        return getText(loggedInUsername);
    }

    public void login(String email, String password) {
        enterLoginEmail(email);
        enterLoginPassword(password);
        clickLoginButton();
    }

    public boolean isOnLoginPage() {
        return isDisplayed(loginFormHeader);
    }
}