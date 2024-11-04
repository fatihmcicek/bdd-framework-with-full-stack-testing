package com.automation.steps;

import com.automation.context.TestContext;
import com.automation.pages.RegisterPage;
import com.automation.utils.Helper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

import java.util.Map;

@Log4j2
public class RegisterSteps {
    private final RegisterPage registerPage;
    private final Helper helper;
    private final TestContext testContext;

    public RegisterSteps(TestContext testContext) {
        this.registerPage = new RegisterPage();
        this.helper = new Helper();
        this.testContext = testContext;
        log.debug("RegisterSteps initialized with TestContext: {}", testContext);
    }

    @When("I click on Signup Login button")
    public void iClickOnSignupLoginButton() {
        registerPage.clickSignupLoginButton();
    }

    @Then("I should see {string} text")
    public void iShouldSeeText(String expectedText) {
        if (expectedText.equals("ENTER ACCOUNT INFORMATION")) {
            Assert.assertEquals(registerPage.getEnterAccountInfoMessage(), expectedText);
        } else if (expectedText.equals("ACCOUNT CREATED!")) {
            Assert.assertEquals(registerPage.getAccountCreatedMessage(), expectedText);
        }
    }

    @When("I enter name {string}")
    public void iEnterName(String name) {
        registerPage.enterName(name);
    }

    @And("I enter email address for registration")
    public void iEnterEmailAddressForRegistration() {
        String email = helper.generateRandomEmail();
        log.info("Generated email for registration: {}", email);
        testContext.setRegisteredEmail(email);
        registerPage.enterEmail(email);
    }

    @And("I click Signup button")
    public void iClickSignupButton() {
        registerPage.clickSignupButton();
    }

    @When("I fill account details")
    public void iFillAccountDetails(DataTable dataTable) {
        Map<String, String> accountDetails = dataTable.asMap(String.class, String.class);

        registerPage.selectTitle(accountDetails.get("Title"));
        registerPage.enterPassword(accountDetails.get("Password"));
        registerPage.selectDateOfBirth(
                accountDetails.get("Day of birth"),
                accountDetails.get("Month of birth"),
                accountDetails.get("Year of birth")
        );
    }

    @And("I select newsletter subscription")
    public void iSelectNewsletterSubscription() {
        registerPage.selectNewsletter();
    }

    @And("I select special offers")
    public void iSelectSpecialOffers() {
        registerPage.selectSpecialOffers();
    }

    @And("I fill address details")
    public void iFillAddressDetails(DataTable dataTable) {
        Map<String, String> addressDetails = dataTable.asMap(String.class, String.class);

        registerPage.fillAddressDetails(
                addressDetails.get("First name"),
                addressDetails.get("Last name"),
                addressDetails.get("Company"),
                addressDetails.get("Address"),
                addressDetails.get("Address2"),
                addressDetails.get("Country"),
                addressDetails.get("State"),
                addressDetails.get("City"),
                addressDetails.get("Zipcode"),
                addressDetails.get("Mobile number")
        );
    }

    @And("I click Create Account button")
    public void iClickCreateAccountButton() {
        registerPage.clickCreateAccountButton();
    }

    @When("I click Continue button")
    public void iClickContinueButton() {
        registerPage.clickContinueButton();
    }

    @And("I click Delete Account button")
    public void iClickDeleteAccountButton() {
        registerPage.clickDeleteAccountButton();
    }
}