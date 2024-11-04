package com.automation.steps;

import com.automation.config.DriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        log.info("Starting scenario: {}", scenario.getName());
        DriverConfig.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        WebDriver driver = DriverConfig.getDriver();

        if (scenario.isFailed() && driver != null) {
            log.info("Scenario failed, taking screenshot");
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Screenshot");
            } catch (Exception e) {
                log.error("Failed to take screenshot: {}", e.getMessage());
            }
        }

        log.info("Finishing scenario: {}", scenario.getName());
        DriverConfig.quitDriver();
    }
}