package com.automation.steps;

import com.automation.config.ConfigReader;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class LoginSteps {
    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        loginPage.navigateToUrl(ConfigReader.getBaseUrl());
    }

    @And("I navigate to login page")
    public void iNavigateToLoginPage() {
        loginPage.clickLoginLink();
    }

    @When("I enter valid email {string}")
    public void iEnterValidEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("I enter valid password {string}")
    public void iEnterValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in!");
    }

    @And("I should see {string} message")
    public void iShouldSeeMessage(String message) {
        Assert.assertTrue(loginPage.isLoggedInMessageDisplayed(),
                "Logged in message is not displayed!");
    }

    @When("I enter invalid email {string}")
    public void iEnterInvalidEmail(String email) {
        loginPage.enterEmail(email);
    }

    @And("I enter invalid password {string}")
    public void iEnterInvalidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String errorMessage) {
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage,
                "Error message does not match!");
    }
}