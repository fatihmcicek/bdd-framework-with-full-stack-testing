package com.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class TestCasesPage extends BasePage {

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(css = "div.panel-heading")
    private WebElement testCasesHeading;

    public void clickTestCasesButton() {
        log.info("Clicking on Test Cases button");
        click(testCasesButton);
    }

    public String getTestCasesHeadingText() {
        log.info("Getting Test Cases heading text");
        return getText(testCasesHeading);
    }

    public boolean isOnTestCasesPage() {
        log.info("Verifying if user is on Test Cases page");
        return isDisplayed(testCasesHeading);
    }
}