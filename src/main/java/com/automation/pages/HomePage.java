package com.automation.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HomePage extends BasePage {

    @FindBy(css = ".logo img")
    private WebElement logo;

    public boolean isLogoDisplayed() {
        log.info("Checking if home page logo is displayed");
        return isDisplayed(logo);
    }
}