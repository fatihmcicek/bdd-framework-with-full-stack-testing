package com.automation.steps;

import com.automation.config.ConfigReader;
import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class HomePageSteps {
    private final HomePage homePage;

    public HomePageSteps() {
        this.homePage = new HomePage();
    }

    @When("I navigate to the Automation Exercise website")
    public void iNavigateToTheAutomationExerciseWebsite() {
        homePage.navigateToUrl(ConfigReader.getBaseUrl());
    }

    @Then("I should see the home page")
    public void iShouldSeeTheHomePage() {
        Assert.assertTrue(homePage.isLogoDisplayed(), "Home page logo is not displayed!");
    }
}