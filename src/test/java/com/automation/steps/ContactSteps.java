package com.automation.steps;

import com.automation.pages.ContactPage;
import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class ContactSteps {
    private final ContactPage contactPage;

    public ContactSteps() {
        this.contactPage = new ContactPage();
    }

    @When("I click on Contact Us button")
    public void iClickOnContactUsButton() {
        contactPage.clickContactUsButton();
    }

    @When("I enter contact name {string}")
    public void iEnterContactName(String name) {
        contactPage.enterName(name);
    }

    @And("I enter contact email {string}")
    public void iEnterContactEmail(String email) {
        contactPage.enterEmail(email);
    }

    @And("I enter contact subject {string}")
    public void iEnterContactSubject(String subject) {
        contactPage.enterSubject(subject);
    }

    @And("I enter contact message {string}")
    public void iEnterContactMessage(String message) {
        contactPage.enterMessage(message);
    }

    @And("I click Submit button on contact form")
    public void iClickSubmitButtonOnContactForm() {
        contactPage.clickSubmit();
    }

    @And("I click OK on popup")
    public void iClickOKOnPopup() {
        contactPage.acceptAlert();
    }

    @Then("I should see success message {string}")
    public void iShouldSeeSuccessMessage(String expectedMessage) {
        Assert.assertEquals(contactPage.getSuccessMessage(), expectedMessage,
                "Success message does not match");
    }

    @Then("I should be redirected to home page")
    public void iShouldBeRedirectedToHomePage() {
        Assert.assertTrue(new HomePage().isLogoDisplayed(),
                "Not redirected to home page");
    }
}