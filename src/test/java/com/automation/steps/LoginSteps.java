package com.automation.steps;

import com.automation.context.TestContext;
import com.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class LoginSteps {
    private final LoginPage loginPage;
    private final TestContext testContext;

    public LoginSteps(TestContext testContext) {
        this.loginPage = new LoginPage();
        this.testContext = testContext;
        log.debug("LoginSteps initialized with TestContext: {}", testContext);
    }

    @When("I enter login email {string}")
    public void iEnterLoginEmail(String email) {
        log.info("Entering login email: {}", email);
        loginPage.enterLoginEmail(email);
    }

    @And("I enter login password {string}")
    public void iEnterLoginPassword(String password) {
        log.info("Entering login password");
        loginPage.enterLoginPassword(password);
    }

    @When("I enter login email from registered credentials")
    public void iEnterLoginEmailFromRegisteredCredentials() {
        String email = testContext.getRegisteredEmail();
        log.info("Using registered email: {}", email);
        loginPage.enterLoginEmail(email);
    }

    @And("I enter login password from registered credentials")
    public void iEnterLoginPasswordFromRegisteredCredentials() {
        String password = testContext.getRegisteredPassword();
        log.info("Using registered password");
        loginPage.enterLoginPassword(password);
    }

    @And("I click login button")
    public void iClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @When("I click logout button")
    public void iClickLogoutButton() {
        loginPage.clickLogoutButton();
    }

    @Then("I should see username {string} displayed")
    public void iShouldSeeUsernameDisplayed(String username) {
        Assert.assertEquals(loginPage.getLoggedInUsername(), username,
                "Username mismatch!");
    }

    @Then("I should be navigated to login page")
    public void iShouldBeNavigatedToLoginPage() {
        Assert.assertTrue(loginPage.isOnLoginPage(),
                "Not navigated to login page!");
    }

    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String errorMessage) {
        Assert.assertEquals(loginPage.getErrorMessage(), errorMessage,
                "Error message mismatch!");
    }
}