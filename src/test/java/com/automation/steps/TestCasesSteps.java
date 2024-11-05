package com.automation.steps;

import com.automation.pages.TestCasesPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;

@Log4j2
public class TestCasesSteps {
    private final TestCasesPage testCasesPage;

    public TestCasesSteps() {
        this.testCasesPage = new TestCasesPage();
    }

    @When("I click on Test Cases button")
    public void iClickOnTestCasesButton() {
        testCasesPage.clickTestCasesButton();
    }

    @Then("I should be navigated to test cases page")
    public void iShouldBeNavigatedToTestCasesPage() {
        Assert.assertTrue(testCasesPage.isOnTestCasesPage(),
                "User is not on Test Cases page");
    }

    @And("I should see {string} heading text")
    public void iShouldSeeHeadingText(String expectedText) {
        Assert.assertEquals(testCasesPage.getTestCasesHeadingText(), expectedText,
                "Test Cases heading text does not match");
    }
}